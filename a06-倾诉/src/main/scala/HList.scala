package a05

trait 整数 {

  type 后继[T] <: 整数
  def 后继[T](item: T): 后继[T]

  type 加[T <: 整数] <: 整数
  def 加[T <: 整数](item: T): 加[T]

  type 真的加[T <: 整数] <: 整数
  def 真的加[T <: 整数](item: T): 真的加[T]

}

class 零 extends 整数 {
  self =>

  type 成对后继[T] = 负数[零, T]
  def 成对后继[T](item: T): 成对后继[T] = new 负数(self, item)

  override type 后继[T] = 正数[零, T]
  override def 后继[T](item: T): 正数[零, T] = new 正数(self, item)

  override type 加[T <: 整数] = T
  override def 加[T <: 整数](item: T): T = item

  override type 真的加[T <: 整数] = T
  override def 真的加[T <: 整数](item: T): T = item

  override def toString: String = "零"

}

object 零 {
  val value: 零 = new 零
}

class 正数[Tail <: 整数, H](val tail: Tail, val head: H) extends 整数 {
  self =>

  override type 后继[I] = 正数[正数[Tail, H], I]
  override def 后继[I](item: I): 正数[正数[Tail, H], I] = new 正数(self, item)

  override type 加[T <: 整数] = Tail#加[T]#后继[H]
  override def 加[T <: 整数](item: T): Tail#加[T]#后继[H] = tail.加(item).后继(head)

  override type 真的加[T <: 整数] = T#加[正数[Tail, H]]
  override def 真的加[T <: 整数](item: T): T#加[正数[Tail, H]] = item.加(self)

  override def toString: String = s"$tail :: $head"

}

class 负数[Tail <: 整数, H](val tail: Tail, val head: H) extends 整数 {
  self =>

  type 成对后继[T] = 负数[负数[Tail, H], T]
  def 成对后继[T](item: T): 成对后继[T] = new 负数(self, item)

  override type 后继[I] = Tail
  override def 后继[I](item: I): Tail = self.tail

  override type 加[T <: 整数] = Tail#加[T]#后继[H]
  override def 加[T <: 整数](item: T): Tail#加[T]#后继[H] = tail.加(item).后继(head)

  override type 真的加[T <: 整数] = T#加[负数[Tail, H]]
  override def 真的加[T <: 整数](item: T): T#加[负数[Tail, H]] = item.加(self)

  override def toString: String = s"$tail 反向 $head"

}
