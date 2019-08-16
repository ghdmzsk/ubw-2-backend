import scala.language.higherKinds

trait 火苗 {

  type 尾 <: 火苗
  def 尾: 尾

  type 燃尽[I <: 柴] <: 柴
  def 燃尽[I <: 柴](i: I): 燃尽[I]

}

/*class 一块柴[T <: 柴, R <: 阻燃物](override val 尾: T, override val 当前阻燃物: R) extends 柴 {
  self =>

  override type 尾     = T
  override type 当前阻燃物 = R

  override type 燃烧 = R#消失[一块柴[T, R]]
  override def 燃烧: R#消失[一块柴[T, R]] = 当前阻燃物.消失(self)

}*/
