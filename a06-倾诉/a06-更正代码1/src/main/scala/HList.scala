package a06

trait 整数 {

  type 后继[T] <: 整数
  def 后继[T](item: T): 后继[T]

}

trait 非负整数 extends 整数 {
  self =>

  override type 后继[I] <: 非负整数
  override def 后继[I](item: I): 后继[I]

  type 加[T <: 非正整数] <: 整数
  def 加[T <: 非正整数](item: T): 加[T]

}

class 零 extends 非负整数 with 非正整数 {
  self =>

  override type 负一 = 负数[零]
  override def 负一: 负一 = new 负数(self)

  override type 后继[T] = 正数[零, T]
  override def 后继[T](item: T): 正数[零, T] = new 正数(self, item)

  override type 加[T <: 非正整数] = T
  override def 加[T <: 非正整数](item: T): T = item

  override type 真的加[T <: 非负整数] = T#加[零]
  override def 真的加[T <: 非负整数](item: T): T#加[零] = item.加(self)

  override def toString: String = "零"

}

object 零 {
  val value: 零 = new 零
}

class 正数[Tail <: 非负整数, H](val tail: Tail, val head: H) extends 非负整数 {
  self =>

  override type 后继[I] = 正数[正数[Tail, H], I]
  override def 后继[I](item: I): 正数[正数[Tail, H], I] = new 正数(self, item)

  override type 加[T <: 非正整数] = Tail#加[T]#后继[H]
  override def 加[T <: 非正整数](item: T): Tail#加[T]#后继[H] = tail.加(item).后继(head)

  override def toString: String = s"$tail :: $head"

}

trait 非正整数 extends 整数 {
  self =>

  type 负一 <: 非正整数
  def 负一: 负一

  override type 后继[I] <: 整数
  override def 后继[I](item: I): 后继[I]

  type 真的加[T <: 非负整数]
  def 真的加[T <: 非负整数](item: T): 真的加[T]

}

class 负数[Tail <: 非正整数](val tail: Tail) extends 非正整数 {
  self =>

  override type 负一 = 负数[负数[Tail]]
  override def 负一: 负一 = new 负数(self)

  override type 后继[I] = Tail
  override def 后继[I](item: I): Tail = self.tail

  override type 真的加[T <: 非负整数] = T#加[负数[Tail]]
  override def 真的加[T <: 非负整数](item: T): T#加[负数[Tail]] = item.加(self)

  override def toString: String = s"$tail 反向 item"

}
