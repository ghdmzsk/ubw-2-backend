import scala.language.higherKinds

trait 大海 {
  type 海水 <: HList
  def 海水: 海水

  def 归墟: Guixu

  type 差距 <: Chaju
  def 差距: 差距

  type Add[I] <: 大海
  def add[I](i: I): 大海

}

class 大海Zero[HH <: Chaju](override val 差距: HH) extends 大海 {
  self =>
  override type 海水 = HNil
  override def 海水: HNil = HNil

  override def 归墟: Guixu = Guixu

  override type 差距 = HH

  override type Add[I] = 灌水的大海[HH#M[I, HNil], HH#Next]
  override def add[I](i: I): 灌水的大海[HH#M[I, HNil], HH#Next] = new 灌水的大海(差距.tran(海水, i), 差距.tranGuixu(归墟, i), 差距.next)

  override def toString = "HNil"
}

class 灌水的大海[PP <: HList, HH <: Chaju](override val 海水: PP, override val 归墟: Guixu, override val 差距: HH) extends 大海 {
  self =>
  override type 海水 = PP
  override type 差距 = HH

  override type Add[I] = 灌水的大海[HH#M[I, PP], HH#Next]
  override def add[I](i: I): 灌水的大海[HH#M[I, PP], HH#Next] = new 灌水的大海(差距.tran(海水, i), 差距.tranGuixu(归墟, i), 差距.next)

  override def toString = 海水.toString
}
