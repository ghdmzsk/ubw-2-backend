import scala.language.higherKinds

trait 天地 {

  type 首
  type 尾 <: 天地

  def 首: 首
  def 尾: 尾

  type 初始化[T] <: 天地
  def 初始化[T](t: T): 初始化[T]

  type 运行[T] <: 天地
  def 运行[T](t: T): 运行[T]

}

class 天地星辰流动[H, T <: 天地](override val 首: H, override val 尾: T) extends 天地 {
  self =>

  override type 首 = H
  override type 尾 = T

  override type 初始化[T1] = 天地星辰流动[T1, 天地星辰流动[H, T]]
  override def 初始化[T1](t: T1): 天地星辰流动[T1, 天地星辰流动[H, T]] = new 天地星辰流动(t, self)

  override type 运行[T1] = 天地星辰流动[T1, T#运行[H]]
  override def 运行[T1](t: T1): 天地星辰流动[T1, T#运行[H]] = new 天地星辰流动[T1, T#运行[H]](t, 尾.运行(首))

}

class 五彩石 extends 天地 {
  self =>

  override type 首 = 五彩石
  override type 尾 = 五彩石

  override def 首: 五彩石 = self
  override def 尾: 五彩石 = self

  override type 初始化[T] = 天地星辰流动[T, 五彩石]
  override def 初始化[T](t: T): 天地星辰流动[T, 五彩石] = new 天地星辰流动(t, self)

  override type 运行[T] = 五彩石
  override def 运行[T](t: T): 五彩石 = self

}

object 五彩石 {
  val value: 五彩石 = new 五彩石
}
