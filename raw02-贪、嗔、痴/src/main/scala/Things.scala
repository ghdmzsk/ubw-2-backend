trait 事物表象 {
  type 首
  type 尾

  protected def 首: 首
  protected def 尾: 尾

  type 叠加顺境[T] <: 事物表象
  def 叠加顺境[T](t: T): 叠加顺境[T]

  type 叠加逆境[T] <: 逆境
  def 叠加逆境[T](t: T): 叠加逆境[T]

  type 叠加困境[T] <: 事物表象
  def 叠加困境[T](t: T): 叠加困境[T]

  type 推进事情 <: 事物表象
  def 推进事情: 推进事情

}

trait 逆境 extends 事物表象 {
  type 首
  type 尾

  protected def 首: 首
  protected def 尾: 尾

  type 叠加顺境[T] <: 事物表象
  def 叠加顺境[T](t: T): 叠加顺境[T]

  type 叠加逆境[T] <: 逆境
  def 叠加逆境[T](t: T): 叠加逆境[T]

  type 叠加困境[T] <: 事物表象
  def 叠加困境[T](t: T): 叠加困境[T]

  type 推进事情 <: 事物表象
  def 推进事情: 推进事情

  type 逆流而上[T] <: 逆境
  def 逆流而上[II](t: II): 逆流而上[II]

  type 推进逆境 <: 逆境
  def 推进逆境: 推进逆境

}

class 结果
object 结果 {
  val value = new 结果
}

class 事情结果 extends 事物表象 {
  self =>
  override type 首 = 结果
  override type 尾 = 事情结果

  override protected def 首: 结果   = 结果.value
  override protected def 尾: 事情结果 = self

  override type 叠加顺境[II] = 顺境[II, 事情结果]
  override def 叠加顺境[II](t: II): 顺境[II, 事情结果] = new 顺境(t, self)

  override type 叠加逆境[II] = 逆境开始[II, 事情结果]
  override def 叠加逆境[II](t: II): 逆境开始[II, 事情结果] = new 逆境开始(t, self)

  override type 叠加困境[T] = 困境1[T, 事情结果]
  override def 叠加困境[T](t: T): 困境1[T, 事情结果] = new 困境1(t, self)

  override type 推进事情 = 事情结果
  override def 推进事情: 推进事情 = self
}

object 事情结果 {
  val value: 事情结果 = new 事情结果
}

class 顺境[H, T <: 事物表象](override protected val 首: H, override protected val 尾: T) extends 事物表象 {
  self =>
  override type 首 = H
  override type 尾 = T

  override type 叠加顺境[II] = 顺境[II, 顺境[H, T]]
  override def 叠加顺境[II](t: II): 顺境[II, 顺境[H, T]] = new 顺境(t, self)

  override type 叠加逆境[II] = 逆境开始[II, 顺境[H, T]]
  override def 叠加逆境[II](t: II): 逆境开始[II, 顺境[H, T]] = new 逆境开始(t, self)

  override type 叠加困境[II] = 困境1[II, 顺境[H, T]]
  override def 叠加困境[II](t: II): 困境1[II, 顺境[H, T]] = new 困境1(t, self)

  override type 推进事情 = T
  override def 推进事情: T = 尾
}

class 逆境开始[H, T <: 事物表象](override protected val 首: H, override protected val 尾: T) extends 逆境 {
  self =>
  override type 首 = H
  override type 尾 = T

  override type 叠加顺境[II] = 顺境[II, 逆境开始[H, T]]
  override def 叠加顺境[II](t: II): 顺境[II, 逆境开始[H, T]] = new 顺境(t, self)

  override type 叠加逆境[II] = 逆境过程[II, 逆境开始[H, T]]
  override def 叠加逆境[II](t: II): 逆境过程[II, 逆境开始[H, T]] = new 逆境过程(t, self)

  override type 叠加困境[II] = 困境1[II, 逆境开始[H, T]]
  override def 叠加困境[II](t: II): 困境1[II, 逆境开始[H, T]] = new 困境1(t, self)

  override type 推进事情 = T
  override def 推进事情: T = 尾

  override type 逆流而上[II] = 逆境开始[H, T]
  override def 逆流而上[II](t: II): 逆境开始[H, T] = self

  override type 推进逆境 = 逆境开始[H, T]
  override def 推进逆境: 逆境开始[H, T] = self

}

class 逆境过程[H, T <: 逆境](override protected val 首: H, override protected val 尾: T) extends 逆境 {
  self =>
  override type 首 = H
  override type 尾 = T

  override type 叠加顺境[II] = 顺境[II, 逆境过程[H, T]]
  override def 叠加顺境[II](t: II): 顺境[II, 逆境过程[H, T]] = new 顺境(t, self)

  override type 叠加逆境[II] = 逆境过程[II, 逆境过程[H, T]]
  override def 叠加逆境[II](t: II): 逆境过程[II, 逆境过程[H, T]] = new 逆境过程(t, self)

  override type 叠加困境[II] = 困境1[II, 逆境过程[H, T]]
  override def 叠加困境[II](t: II): 困境1[II, 逆境过程[H, T]] = new 困境1(t, self)

  override type 推进事情 = 逆境过程[H, T]
  override def 推进事情: 逆境过程[H, T] = self

  override type 逆流而上[II] = 逆境过程[II, T#逆流而上[H]]
  override def 逆流而上[II](t: II): 逆境过程[II, T#逆流而上[H]] = new 逆境过程(t, 尾.逆流而上(首))

  override type 推进逆境 = T#逆流而上[H]
  override def 推进逆境: T#逆流而上[H] = 尾.逆流而上(首)
}

class 困境1[H, T <: 事物表象](override protected val 首: H, override protected val 尾: T) extends 事物表象 {
  self =>
  override type 首 = H
  override type 尾 = T

  override type 叠加顺境[II] = 顺境[II, 困境1[H, T]]
  override def 叠加顺境[II](t: II): 顺境[II, 困境1[H, T]] = new 顺境(t, self)

  override type 叠加逆境[II] = 逆境开始[II, 困境1[H, T]]
  override def 叠加逆境[II](t: II): 逆境开始[II, 困境1[H, T]] = new 逆境开始(t, self)

  override type 叠加困境[II] = 困境1[II, 困境1[H, T]]
  override def 叠加困境[II](t: II): 困境1[II, 困境1[H, T]] = new 困境1(t, self)

  override type 推进事情 = 困境1[H, T]
  override def 推进事情: 困境1[H, T] = self

  type 走出困境的方法 = T
  def 走出困境的方法: 走出困境的方法 = 尾
}
