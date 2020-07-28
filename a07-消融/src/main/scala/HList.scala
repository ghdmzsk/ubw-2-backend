package a05

trait 自然数 {

  type 后继[T] <: 自然数
  def 后继[T](item: T): 后继[T]

  type 加[T <: 自然数] <: 自然数
  def 加[T <: 自然数](item: T): 加[T]

  type 真的加[T <: 自然数] <: 自然数
  def 真的加[T <: 自然数](item: T): 真的加[T]

}

class 零 extends 自然数 {
  self =>

  override type 后继[T] = 正数[零, T]
  override def 后继[T](item: T): 正数[零, T] = new 正数(self, item)

  override type 加[T <: 自然数] = T
  override def 加[T <: 自然数](item: T): T = item

  override type 真的加[T <: 自然数] = T
  override def 真的加[T <: 自然数](item: T): T = item

  override def toString: String = "零"

}

object 零 {
  val value: 零 = new 零
}

class 正数[Tail <: 自然数, H](val tail: Tail, val head: H) extends 自然数 {
  self =>

  override type 后继[I] = 正数[正数[Tail, H], I]
  override def 后继[I](item: I): 正数[正数[Tail, H], I] = new 正数(self, item)

  override type 加[T <: 自然数] = Tail#加[T]#后继[H]
  override def 加[T <: 自然数](item: T): Tail#加[T]#后继[H] = tail.加(item).后继(head)

  override type 真的加[T <: 自然数] = T#加[正数[Tail, H]]
  override def 真的加[T <: 自然数](item: T): T#加[正数[Tail, H]] = item.加(self)

  override def toString: String = s"$tail :: $head"

}

trait 整数 {

  type 后继[T] <: 整数
  type 前驱[T] <: 整数

  def 后继[T](item: T): 后继[T]
  def 前驱[T](item: T): 前驱[T]

  type 正数加[P <: 自然数] <: 整数
  type 负数加[P <: 自然数] <: 整数

  def 正数加[P <: 自然数](item: P): 正数加[P]
  def 负数加[P <: 自然数](item: P): 负数加[P]

  type 加[T <: 整数] <: 整数
  def 加[T <: 整数](item: T): 加[T]

}

class 整数实现[T1 <: 自然数, T2 <: 自然数](val 负数部分: T1, val 正数部分: T2) extends 整数 { self =>

  type 负数部分 = T1
  type 正数部分 = T2

  override type 加[T <: 整数] = T#正数加[T2]#负数加[T1]
  override def 加[T <: 整数](item: T): T#正数加[T2]#负数加[T1] = item.正数加(正数部分).负数加(负数部分)

  override type 后继[T] = 整数实现[T1, 正数[T2, T]]
  override type 前驱[T] = 整数实现[正数[T1, T], T2]

  override def 后继[T](item: T): 整数实现[T1, 正数[T2, T]] = new 整数实现(负数部分 = 负数部分, 正数部分 = new 正数(正数部分, item))
  override def 前驱[T](item: T): 整数实现[正数[T1, T], T2] = new 整数实现(负数部分 = new 正数(负数部分, item), 正数部分 = 正数部分)

  override type 正数加[P <: 自然数] = 整数实现[T1, T2#真的加[P]]
  override type 负数加[P <: 自然数] = 整数实现[T1#真的加[P], T2]

  override def 正数加[P <: 自然数](item: P): 整数实现[T1, T2#真的加[P]] = new 整数实现(负数部分 = 负数部分, 正数部分 = 正数部分.真的加(item))
  override def 负数加[P <: 自然数](item: P): 整数实现[T1#真的加[P], T2] = new 整数实现(负数部分 = 负数部分.真的加(item), 正数部分 = 正数部分)

}

class 整数零 extends 整数 {

  override type 后继[T] = 整数实现[零, 正数[零, T]]
  override type 前驱[T] = 整数实现[正数[零, T], 零]

  override def 后继[T](item: T): 后继[T] = new 整数实现(零.value, 零.value.后继(item))
  override def 前驱[T](item: T): 前驱[T] = new 整数实现(零.value.后继(item), 零.value)

  override type 加[T <: 整数] = T
  override def 加[T <: 整数](item: T): T = item

  override type 正数加[P <: 自然数] = 整数实现[零, P]
  override type 负数加[P <: 自然数] = 整数实现[P, 零]

  override def 正数加[P <: 自然数](item: P): 整数实现[零, P] = new 整数实现(负数部分 = 零.value, 正数部分 = item)
  override def 负数加[P <: 自然数](item: P): 整数实现[P, 零] = new 整数实现(负数部分 = item, 正数部分 = 零.value)

}

// 非负整数就是自然数？笑话
/*class 非负整数[T2 <: 自然数](override val 正数部分: T2) extends 整数实现[零, T2](负数部分 = 零.value, 正数部分 = 正数部分) with 自然数 { self =>

  override type 后继[T] = 非负整数[T2#后继[T]]
  override def 后继[T](item: T): 非负整数[T2#后继[T]] = new 非负整数(正数部分 = 正数部分.后继(item))

  override type 加[T <: 自然数] = 非负整数[T2#加[T]]
  override def 加[T <: 自然数](item: T): 非负整数[T2#加[T]] = new 非负整数(正数部分 = 正数部分.加(item))

  override type 真的加[T <: 自然数] = 非负整数[T2#真的加[T]]
  override def 真的加[T <: 自然数](item: T): 非负整数[T2#真的加[T]] = new 非负整数(正数部分 = 正数部分.真的加(item))

  override type 加[T <: 整数] = T#正数加[T2]#负数加[T1]
  override def 加[T <: 整数](item: T): T#正数加[T2]#负数加[T1] = item.正数加(正数部分).负数加(负数部分)

  override def 后继[T](item: T): 整数实现[T1, 正数[T2, T]] = new 整数实现(负数部分 = 负数部分, 正数部分 = new 正数(正数部分, item))
  override def 前驱[T](item: T): 整数实现[正数[T1, T], T2] = new 整数实现(负数部分 = new 正数(负数部分, item), 正数部分 = 正数部分)

  override type 正数加[P <: 自然数] = 整数实现[T1, T2#真的加[P]]
  override type 负数加[P <: 自然数] = 整数实现[T1#真的加[P], T2]

  override def 正数加[P <: 自然数](item: P): 整数实现[T1, T2#真的加[P]] = new 整数实现(负数部分 = 负数部分, 正数部分 = 正数部分.真的加(item))
  override def 负数加[P <: 自然数](item: P): 整数实现[T1#真的加[P], T2] = new 整数实现(负数部分 = 负数部分.真的加(item), 正数部分 = 正数部分)

}*/
