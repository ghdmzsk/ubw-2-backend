import scala.language.higherKinds

trait 柴 {

  type 尾 <: 柴

  def 尾: 尾

  type 当前阻燃物 <: 阻燃物
  def 当前阻燃物: 当前阻燃物

  type 当前燃料 <: 燃料
  def 当前燃料: 当前燃料

  type 当前火苗 <: 火苗
  def 当前火苗: 当前火苗

}

class 一块柴[T <: 柴, R <: 阻燃物, S <: 燃料, H <: 火苗](override val 尾: T, override val 当前阻燃物: R, override val 当前燃料: S, override val 当前火苗: H) extends 柴 {
  self =>

  override type 尾     = T
  override type 当前阻燃物 = R
  override type 当前燃料  = S
  override type 当前火苗  = H

  /*override type 燃烧 = R#消失[一块柴[T, R,H]]
  override def 燃烧: R#消失[一块柴[T, R,H]] = 当前阻燃物.消失(self)*/

}
