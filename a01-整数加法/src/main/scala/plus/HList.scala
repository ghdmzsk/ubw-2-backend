package plus

trait HList {

  type Head
  type Tail <: HList
  type Plus[T <: HList] <: HList
  type Add[N] <: HList
  type RePlus[P <: HList] <: HList

  def head: Head
  def tail: Tail
  def plus[T <: HList](h: T): Plus[T]
  def add[N](n: N): Add[N]
  def rePlus[T <: HList](h: T): RePlus[T]

}
