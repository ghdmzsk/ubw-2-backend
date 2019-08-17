import scala.language.higherKinds

class 燃烧屏障[U <: 燃料](override val 尾: U) extends 燃料 {
  self =>
  override val 当前火苗: 零火苗 = 零火苗.零火苗
  override type 尾    = U
  override type 当前火苗 = 零火苗

  override type 初始化[T <: 火苗] = 普通燃料[T, 燃烧屏障[U]]
  override def 初始化[T <: 火苗](t: T): 普通燃料[T, 燃烧屏障[U]] = new 普通燃料(t, self)
  override type 屏障 = 燃烧屏障[燃烧屏障[U]]
  override def 屏障: 燃烧屏障[燃烧屏障[U]] = new 燃烧屏障(self)
}
