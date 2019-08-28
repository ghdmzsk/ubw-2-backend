import scala.language.higherKinds

trait 火苗 {

  type 尾 <: 火苗
  def 尾: 尾

  type 增加 <: 火苗
  def 增加: 增加

  type 叠加[I <: 火苗] <: 火苗
  def 叠加[I <: 火苗](i: I): 叠加[I]

  type 叠减[I <: 燃料] <: 燃料
  def 叠减[I <: 燃料](i: I): 叠减[I]

  type flatMap[I <: 燃料] <: 火苗
  def flatMap[I <: 燃料](i: I): flatMap[I]

}

class 小火苗[T <: 火苗](override val 尾: T) extends 火苗 {
  self =>

  override type 尾 = T

  override type 增加 = 小火苗[小火苗[T]]
  override def 增加: 小火苗[小火苗[T]] = new 小火苗(self)

  override type 叠加[I <: 火苗] = 小火苗[尾#叠加[I]]
  override def 叠加[I <: 火苗](i: I): 小火苗[尾#叠加[I]] = new 小火苗(尾.叠加(i))

  override type 叠减[I <: 燃料] = 尾#叠减[I]#尾
  override def 叠减[I <: 燃料](i: I): 尾#叠减[I]#尾 = 尾.叠减(i).尾

  override type flatMap[I <: 燃料] = I#当前火苗#叠加[T#flatMap[I#尾]]
  override def flatMap[I <: 燃料](i: I): I#当前火苗#叠加[T#flatMap[I#尾]] = i.当前火苗.叠加(尾.flatMap(i.尾))

}

class 零火苗 extends 火苗 {
  self =>

  override type 尾 = 零火苗
  override def 尾: 零火苗 = 零火苗.零火苗

  override type 增加 = 小火苗[零火苗]
  override def 增加: 小火苗[零火苗] = new 小火苗(self)

  override type 叠加[I <: 火苗] = I
  override def 叠加[I <: 火苗](i: I): I = i

  override type 叠减[I <: 燃料] = I
  override def 叠减[I <: 燃料](i: I): I = i

  override type flatMap[I <: 燃料] = 零火苗
  override def flatMap[I <: 燃料](i: I): 零火苗 = 零火苗.零火苗

}

object 零火苗 {
  val 零火苗: 零火苗 = new 零火苗
}

class 单位火苗 extends 小火苗[零火苗](零火苗.零火苗)

object 单位火苗 {
  val 单位火苗: 单位火苗 = new 单位火苗
}
