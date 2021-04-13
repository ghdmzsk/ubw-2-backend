package 练习20

trait 乘数T1 {
  type 乘1[T2 <: 乘数T2, T3 <: 乘数T3] <: 积
  def 乘1[T2 <: 乘数T2, T3 <: 乘数T3](t2: T2, t3: T3): 乘1[T2, T3]
  def length: Int
}
trait 乘数T2 {
  type 乘2[T3 <: 乘数T3, T1 <: 乘数T1] <: 积
  def 乘2[T3 <: 乘数T3, T1 <: 乘数T1](t3: T3, t1: T1): 乘2[T3, T1]
  def length: Int
}
trait 乘数T3 {
  type 乘3[T1 <: 乘数T1, T2 <: 乘数T2] <: 积
  def 乘3[T1 <: 乘数T1, T2 <: 乘数T2](t1: T1, t2: T2): 乘3[T1, T2]
  def length: Int
}

class 乘数T1Positive[Tail <: 乘数T1](val tail: Tail) extends 乘数T1 {
  override type 乘1[T2 <: 乘数T2, T3 <: 乘数T3] = T3#乘3[Tail, T2]
  override def 乘1[T2 <: 乘数T2, T3 <: 乘数T3](t2: T2, t3: T3): T3#乘3[Tail, T2] = t3.乘3(tail, t2)
  override def length: Int                                                 = tail.length + 1
}
class 乘数T1One extends 乘数T1 {
  override type 乘1[T2 <: 乘数T2, T3 <: 乘数T3] = 积Zero
  override def 乘1[T2 <: 乘数T2, T3 <: 乘数T3](t2: T2, t3: T3): 积Zero = new 积Zero
  override val length: Int                                       = 1
}
class 乘数T2Positive[Tail <: 乘数T2](val tail: Tail) extends 乘数T2 {
  override type 乘2[T3 <: 乘数T3, T1 <: 乘数T1] = T3#乘3[T1, Tail]
  override def 乘2[T3 <: 乘数T3, T1 <: 乘数T1](t3: T3, t1: T1): T3#乘3[T1, Tail] = t3.乘3(t1, tail)
  override def length: Int                                                 = tail.length + 1
}
class 乘数T2One[Tail <: 乘数T2](val tail1: () => Tail) extends 乘数T2 {
  lazy val tail = tail1()
  override type 乘2[T3 <: 乘数T3, T1 <: 乘数T1] = T1#乘1[Tail, T3]
  override def 乘2[T3 <: 乘数T3, T1 <: 乘数T1](t3: T3, t1: T1): T1#乘1[Tail, T3] = t1.乘1(tail, t3)
  override val length: Int                                                 = 1
}
class 乘数T3Positive[Tail <: 乘数T3, Head](val tail: Tail, val head: Head) extends 乘数T3 {
  override type 乘3[T1 <: 乘数T1, T2 <: 乘数T2] = 积Positive[Tail#乘3[T1, T2], Head]
  override def 乘3[T1 <: 乘数T1, T2 <: 乘数T2](t1: T1, t2: T2): 积Positive[Tail#乘3[T1, T2], Head] = new 积Positive(tail.乘3(t1, t2), head)
  override def length: Int                                                                  = tail.length + 1
}
class 乘数T3Zero[Tail <: 乘数T3](val tail1: () => Tail) extends 乘数T3 {
  lazy val tail = tail1()
  override type 乘3[T1 <: 乘数T1, T2 <: 乘数T2] = T2#乘2[Tail, T1]
  override def 乘3[T1 <: 乘数T1, T2 <: 乘数T2](t1: T1, t2: T2): T2#乘2[Tail, T1] = t2.乘2(tail, t1)
  override val length: Int                                                 = 0
}

trait 积 {
  def length: Int
  def toList: List[Any]
}
class 积Positive[Tail <: 积, Head](tail: 积, head: Head) extends 积 {
  override def length: Int       = tail.length + 1
  override def toList: List[Any] = head :: tail.toList
  override def toString: String  = toList.mkString("(", ", ", ")")
}
class 积Zero extends 积 {
  override val length: Int       = 0
  override def toList: List[Any] = List.empty
}
