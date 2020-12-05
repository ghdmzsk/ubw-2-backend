trait HListYuan {

  type Head
  def head: Head

  type C <: Convert
  def c: C

  type Tail <: HListYuan
  def tail: Tail

  type Add[T] <: HListYuan
  def add[T](i: T): Add[T]

}

class YueyuanZero extends HListYuan {
  self =>

  override type Head = YueyuanZero
  override def head: YueyuanZero = self

  override type C = ReverseYQ
  override def c: ReverseYQ = ReverseYQ

  override type Tail = YueyuanZero
  override def tail: YueyuanZero = self

  override type Add[T] = AppendYuan[T, YueyuanZero]
  override def add[T](i: T): AppendYuan[T, YueyuanZero] = new AppendYuan(i, self)

}

object YueyuanZero extends YueyuanZero

class AppendYuan[HH, TT <: HListYuan](override val head: HH, override val tail: TT) extends HListYuan {
  self =>

  override type Head = HH
  override type Tail = TT

  override type C = CloneYQ
  override val c: CloneYQ = CloneYQ

  override type Add[T] = AppendYuan[T, AppendYuan[HH, TT]]
  override def add[T](i: T): AppendYuan[T, AppendYuan[HH, TT]] = new AppendYuan(i, self)

}
