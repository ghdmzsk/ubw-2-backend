import scala.language.higherKinds

trait 阻燃物 {

  type 尾 <: 阻燃物

  def 尾: 尾

  type 消失[T <: 柴] <: 柴
  def 消失[T <: 柴](t: T): 消失[T]

  type 初始化 <: 阻燃物
  def 初始化: 初始化

}

class 一般阻燃物[T <: 阻燃物](override val 尾: T) extends 阻燃物 {
  self =>

  override type 尾 = T

  override type 消失[T <: 柴] = 一块柴[T#尾, T#当前阻燃物#尾, T#当前燃料, T#当前火苗]
  override def 消失[T <: 柴](t: T): 一块柴[T#尾, T#当前阻燃物#尾, T#当前燃料, T#当前火苗] = new 一块柴(t.尾, t.当前阻燃物.尾, t.当前燃料, t.当前火苗)

  override type 初始化 = 一般阻燃物[一般阻燃物[T]]
  override def 初始化: 一般阻燃物[一般阻燃物[T]] = new 一般阻燃物(self)

}

class 燃烧中 extends 阻燃物 {
  self =>

  override type 尾 = 燃烧中
  override def 尾: 燃烧中 = self

  override type 消失[T <: 柴] = T#尾
  override def 消失[T <: 柴](t: T): T#尾 = t.尾

  override type 初始化 = 一般阻燃物[燃烧中]
  override def 初始化: 一般阻燃物[燃烧中] = new 一般阻燃物(self)

}

object 燃烧中 {
  val value: 燃烧中 = new 燃烧中
}
