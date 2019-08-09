import scala.language.higherKinds

trait 锅 {

  type 尾 <: 锅
  def 尾: 尾

  type 加肉[I <: 肉] <: 锅
  def 加肉[I <: 肉](i: I): 加肉[I]

  type 升温 <: 锅
  def 升温: 升温

}

class 没有肉的锅 extends 锅 {
  self =>

  override type 尾 = 没有肉的锅
  override def 尾: 没有肉的锅 = self

  type 加肉[I <: 肉] = 有肉的锅[I, 没有肉的锅]
  def 加肉[I <: 肉](i: I): 有肉的锅[I, 没有肉的锅] = new 有肉的锅[I, 没有肉的锅](i, self)

  override type 升温 = 没有肉的锅
  override def 升温: 没有肉的锅 = 没有肉的锅.value

  override def toString: String = "没有肉的锅"
}

object 没有肉的锅 {
  val value = new 没有肉的锅
}

class 有肉的锅[PP <: 肉, TT <: 锅](val 第一块肉: PP, override val 尾: TT) extends 锅 {
  self =>
  override type 尾 = TT

  type 加肉[I <: 肉] = 有肉的锅[I, 有肉的锅[PP, TT]]
  def 加肉[I <: 肉](i: I): 有肉的锅[I, 有肉的锅[PP, TT]] = new 有肉的锅[I, 有肉的锅[PP, TT]](i, self)

  override type 升温 = 有肉的锅[PP#热量, 尾#升温]
  override def 升温: 有肉的锅[PP#热量, 尾#升温] = new 有肉的锅[PP#热量, 尾#升温](第一块肉.热量,尾.升温)

  override def toString: String = 第一块肉.toString + ", " + 尾.toString
}
