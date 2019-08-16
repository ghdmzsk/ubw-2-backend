import scala.language.higherKinds

trait 阻燃物 {

  type 尾 <: 阻燃物

  def 尾: 尾

  type 消失[T <: 柴] <: 柴
  def 消失[T <: 柴](t: T): 消失[T]

}

class 一般阻燃物[T <: 阻燃物](override val 尾: T) extends 阻燃物 {
  self =>

  override type 尾 = T

  override type 消失[T <: 柴] = 一块柴[T#尾, T#当前阻燃物#尾]
  override def 消失[T <: 柴](t: T): 一块柴[T#尾, T#当前阻燃物#尾] = new 一块柴(t.尾, t.当前阻燃物.尾)

}

class 初始阻燃物 extends 阻燃物 {
  self =>

  override type 尾 = 初始阻燃物
  override def 尾: 初始阻燃物 = self

  override type 消失[T <: 柴] = T#尾
  override def 消失[T <: 柴](t: T): T#尾 = t.尾

}

object 初始阻燃物 {
  val value: 初始阻燃物 = new 初始阻燃物
}
