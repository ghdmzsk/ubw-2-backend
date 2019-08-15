import scala.language.higherKinds

trait 柴 {

  type 首
  type 尾 <: 柴

  def 首: 首
  def 尾: 尾

  type 当前阻燃物 <: 阻燃物
  def 当前阻燃物: 当前阻燃物

}

class 一块柴[S, T <: 柴, R <: 阻燃物](override val 首: S, override val 尾: T, override val 当前阻燃物: R) extends 柴 {
  override type 首     = S
  override type 尾     = T
  override type 当前阻燃物 = R
}
