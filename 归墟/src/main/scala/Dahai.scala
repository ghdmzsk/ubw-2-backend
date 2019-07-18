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

  override type Add[I] = HH#M[I, 大海Zero[HH]]
  override def add[I](i: I): HH#M[I, 大海Zero[HH]] = 差距.tran(self: 大海Zero[HH], i)

  override def toString = "HNil"
}

class 灌水的大海[HH <: HList, II <: Chaju](override val 海水: HH, override val 归墟: Guixu, override val 差距: II) extends 大海 {
  self =>
  override type 海水 = HH
  override type 差距 = II

  override type Add[I] = II#M[I, 灌水的大海[HH, II]]
  override def add[I](i: I): II#M[I, 灌水的大海[HH, II]] = 差距.tran(self, i)

  override def toString = 海水.toString
}
