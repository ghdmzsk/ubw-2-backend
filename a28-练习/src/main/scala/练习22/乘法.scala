package 练习22

trait 乘数T1 {
  def 乘1(t2: 乘数T2, t3: 乘数T3): 积
}
object 乘数T1 {
  def fromInt(n: Int): 乘数T1 = n match {
    case n1 if n1 > 1 => new 乘数T1Positive(fromInt(n1 - 1))
    case 1            => new 乘数T1One
  }
}
trait 乘数T2 {
  def 乘2(t3: 乘数T3, t1: 乘数T1): 积
}
object 乘数T2 {
  def fromInt(n: Int): 乘数T2 = {
    def fromIntImpl(n1: Int, one: () => 乘数T2): 乘数T2 = n1 match {
      case n2 if n2 > 1 => new 乘数T2Positive(fromIntImpl(n2 - 1, one))
      case 1            => new 乘数T2One(one)
    }
    lazy val n3: 乘数T2 = fromIntImpl(n, () => n3)
    n3
  }
}
trait 乘数T3 {
  def 乘3(t1: 乘数T1, t2: 乘数T2): 积
}
object 乘数T3 {
  def fromInt(n: Int): 乘数T3 = {
    def fromIntImpl(n1: Int, one: () => 乘数T3): 乘数T3 = n1 match {
      case n2 if n2 > 0 => new 乘数T3Positive(fromIntImpl(n2 - 1, one))
      case 0            => new 乘数T3Zero(one)
    }
    lazy val n3: 乘数T3 = fromIntImpl(n, () => n3)
    n3
  }
}

class 乘数T1Positive(tail: 乘数T1) extends 乘数T1 {
  override def 乘1(t2: 乘数T2, t3: 乘数T3): 积 = t3.乘3(tail, t2)
}
class 乘数T1One extends 乘数T1 {
  override def 乘1(t2: 乘数T2, t3: 乘数T3): 积 = new 积Zero
}
class 乘数T2Positive(tail: 乘数T2) extends 乘数T2 {
  override def 乘2(t3: 乘数T3, t1: 乘数T1): 积 = t3.乘3(t1, tail)
}
class 乘数T2One(tail: () => 乘数T2) extends 乘数T2 {
  lazy val tail1                         = tail()
  override def 乘2(t3: 乘数T3, t1: 乘数T1): 积 = t1.乘1(tail1, t3)
}
class 乘数T3Positive(tail: 乘数T3) extends 乘数T3 {
  override def 乘3(t1: 乘数T1, t2: 乘数T2): 积 = new 积Positive(tail.乘3(t1, t2))
}
class 乘数T3Zero(tail: () => 乘数T3) extends 乘数T3 {
  lazy val tail1                         = tail()
  override def 乘3(t1: 乘数T1, t2: 乘数T2): 积 = t2.乘2(tail1, t1)
}

trait 积 {
  def length: Int = 1
}
class 积Positive(val tail: 积) extends 积 {
  override def length: Int = tail.length + 1
}
class 积Zero extends 积 {
  override def length: Int = 0
}
