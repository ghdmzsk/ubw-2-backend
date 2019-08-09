import scala.language.higherKinds

trait 肉 {
  type 热量 <: 肉
  def 热量: 热量
  type 需要热量 <: 肉
  def 需要热量: 肉
}

class 熟透的肉 extends 肉 {
  self =>
  override type 热量 = 熟透的肉
  override def 热量: 熟透的肉 = 熟透的肉.value

  override def toString: String = "熟透的肉"
  override type 需要热量 = 未熟的肉[熟透的肉]
  override def 需要热量: 未熟的肉[熟透的肉] = new 未熟的肉[熟透的肉](self)

}

object 熟透的肉 {
  val value = new 熟透的肉
}

class 未熟的肉[TT <: 肉](override val 热量: TT) extends 肉 {
  self =>
  override type 热量 = TT
  override def 需要热量: 未熟的肉[未熟的肉[TT]] = new 未熟的肉(self)
  override type 需要热量 = 未熟的肉[未熟的肉[TT]]

  override def toString: String = "未熟的肉" + ", " + 熟透的肉.toString
}
