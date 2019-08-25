import scala.language.higherKinds

trait 缘 {

  type 当前火苗 <: 火苗
  def 当前火苗: 当前火苗

  type 尾 <: 缘
  def 尾: 尾

  type 初始化[X <: 火苗] <: 缘
  def 初始化[X <: 火苗](x: X): 初始化[X]

}

class 叠加缘分[T <: 火苗, I <: 缘](override val 当前火苗: T, override val 尾: I) extends 缘 {
  self =>

  override type 当前火苗 = T
  override type 尾    = I

  override type 初始化[X <: 火苗] = 叠加缘分[X, 叠加缘分[T, I]]
  override def 初始化[X <: 火苗](x: X): 叠加缘分[X, 叠加缘分[T, I]] = new 叠加缘分(x, self)

}

class 缘尽 extends 缘 {
  self =>

  override type 当前火苗 = 零火苗
  override def 当前火苗: 零火苗 = 零火苗.零火苗

  override type 尾 = 缘尽
  override def 尾: 缘尽 = self

  override type 初始化[X <: 火苗] = 叠加缘分[X, 缘尽]
  override def 初始化[X <: 火苗](x: X): 叠加缘分[X, 缘尽] = new 叠加缘分(x, self)

}

object 缘尽 {
  val 缘尽: 缘尽 = new 缘尽
}
