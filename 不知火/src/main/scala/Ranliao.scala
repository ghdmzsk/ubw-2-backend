import scala.language.higherKinds

trait 燃料 {

  type 当前火苗 <: 火苗
  type 尾 <: 燃料

  def 当前火苗: 当前火苗
  def 尾: 尾

  type 初始化[T <: 火苗] <: 燃料
  def 初始化[T <: 火苗](t: T): 初始化[T]

  type 屏障 <: 燃料
  def 屏障: 屏障

}

class 普通燃料[R <: 火苗, U <: 燃料](override val 当前火苗: R, override val 尾: U) extends 燃料 {
  self =>

  override type 尾    = U
  override type 当前火苗 = R

  override type 初始化[T <: 火苗] = 普通燃料[T, 普通燃料[R, U]]
  override def 初始化[T <: 火苗](t: T): 普通燃料[T, 普通燃料[R, U]] = new 普通燃料(t, self)

  override type 屏障 = 燃烧屏障[普通燃料[R, U]]
  override def 屏障: 燃烧屏障[普通燃料[R, U]] = new 燃烧屏障(self)

}

class 初始燃料 extends 燃料 {
  self =>

  override type 尾    = 初始燃料
  override type 当前火苗 = 单位火苗

  override def 当前火苗: 单位火苗 = 单位火苗.单位火苗
  override def 尾: 初始燃料    = self

  override type 初始化[T <: 火苗] = 普通燃料[T, 初始燃料]
  override def 初始化[T <: 火苗](t: T): 普通燃料[T, 初始燃料] = new 普通燃料(t, self)

  override type 屏障 = 燃烧屏障[初始燃料]
  override def 屏障: 燃烧屏障[初始燃料] = new 燃烧屏障(self)

}

object 初始燃料 {
  val 初始燃料: 初始燃料 = new 初始燃料
}
