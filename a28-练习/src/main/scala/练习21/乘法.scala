package 练习21

trait 乘数T1 {
  def 乘1(t2: 乘数T2, t3: 乘数T3): 积
}
trait 乘数T2 {
  def 乘2(t3: 乘数T3, t1: 乘数T1): 积
}
trait 乘数T3 {
  def 乘3(t1: 乘数T1, t2: 乘数T2): 积
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
class 乘数T3Positive(tail: 乘数T3, head: Any) extends 乘数T3 {
  override def 乘3(t1: 乘数T1, t2: 乘数T2): 积 = new 积Positive(tail.乘3(t1, t2), head)
}
class 乘数T3Zero(val tail: () => 乘数T3) extends 乘数T3 {
  lazy val tail1                         = tail()
  override def 乘3(t1: 乘数T1, t2: 乘数T2): 积 = t2.乘2(tail1, t1)
}

trait 积 {
  def length: Int
}
class 积Positive(tail: 积, head: Any) extends 积 {
  override def length: Int      = tail.length + 1
  override def toString: String = s"(${tail}, ${head})"
}
class 积Zero extends 积 {
  override def length: Int      = 0
  override def toString: String = "积Zero"
}
