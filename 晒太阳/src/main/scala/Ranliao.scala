import scala.language.higherKinds

trait 燃料 {

  type 当前火苗 <: 火苗
  type 尾 <: 燃料

  def 当前火苗: 当前火苗
  def 尾: 尾

  type 初始化[T <: 火苗] <: 燃料
  def 初始化[T <: 火苗](t: T): 初始化[T]

  type flatMap[I <: 燃料] <: 燃料
  def flatMap[I <: 燃料](i: I): flatMap[I]

  type 屏障 <: 燃料
  def 屏障: 屏障

}

class 燃烧屏障[U <: 燃料](override val 尾: U) extends 燃料 {
  self =>
  override val 当前火苗: 零火苗 = 零火苗.零火苗
  override type 尾    = U
  override type 当前火苗 = 零火苗

  override type 初始化[T <: 火苗] = 普通燃料[T, 燃烧屏障[U]]
  override def 初始化[T <: 火苗](t: T): 普通燃料[T, 燃烧屏障[U]] = new 普通燃料(t, self)

  override type flatMap[I <: 燃料] = 尾#flatMap[燃烧屏障[U]#初始化[当前火苗]]
  override def flatMap[I <: 燃料](i: I): 尾#flatMap[燃烧屏障[U]#初始化[当前火苗]] = 尾.flatMap(self.初始化(零火苗.零火苗))

  override type 屏障 = 燃烧屏障[燃烧屏障[U]]
  override def 屏障: 燃烧屏障[燃烧屏障[U]] = new 燃烧屏障(self)
}

class 普通燃料[R <: 火苗, U <: 燃料](override val 当前火苗: R, override val 尾: U) extends 燃料 {
  self =>

  override type 尾    = U
  override type 当前火苗 = R

  override type 初始化[T <: 火苗] = 普通燃料[T, 普通燃料[R, U]]
  override def 初始化[T <: 火苗](t: T): 普通燃料[T, 普通燃料[R, U]] = new 普通燃料(t, self)

  override type flatMap[I <: 燃料] = 尾#flatMap[I#初始化[当前火苗]]
  override def flatMap[I <: 燃料](i: I): 尾#flatMap[I#初始化[当前火苗]] = 尾.flatMap(i.初始化(当前火苗))

  override type 屏障 = 燃烧屏障[普通燃料[R, U]]
  override def 屏障: 燃烧屏障[普通燃料[R, U]] = new 燃烧屏障(self)

}

class 零燃料 extends 燃料 {
  self =>

  override type 尾    = 零燃料
  override type 当前火苗 = 零火苗

  override def 当前火苗: 零火苗 = 零火苗.零火苗
  override def 尾: 零燃料    = self

  override type 初始化[T <: 火苗] = 普通燃料[T, 零燃料]
  override def 初始化[T <: 火苗](t: T): 普通燃料[T, 零燃料] = new 普通燃料(t, self)

  override type flatMap[I <: 燃料] = I
  override def flatMap[I <: 燃料](i: I): I = i

  override type 屏障 = 燃烧屏障[零燃料]
  override def 屏障: 燃烧屏障[零燃料] = new 燃烧屏障(self)

}

object 零燃料 {
  val 零燃料: 零燃料 = new 零燃料
}