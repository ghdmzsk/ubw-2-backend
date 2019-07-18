trait HList {

  type Head
  def head: Head

  type Tail <: HList
  def tail: Tail

  type Add[T] <: HList
  def add[T](i: T): Add[T]

}

class 路 extends HList {
  self =>

  override type Head = 路
  override def head: 路 = self

  override type Tail = 路
  override def tail = self

  override type Add[T] = AppendYuan[T, 路]
  override def add[T](i: T): AppendYuan[T, 路] = new AppendYuan(i, self)

}

object 路 extends 路

class AppendYuan[HH, TT <: HList](override val head: HH, override val tail: TT) extends HList {
  self =>

  override type Head = HH
  override type Tail = TT

  override type Add[T] = AppendYuan[T, AppendYuan[HH, TT]]
  override def add[T](i: T): AppendYuan[T, AppendYuan[HH, TT]] = new AppendYuan(i, self)

}
