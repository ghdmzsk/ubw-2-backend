case class Item(name: String)

trait Number1 {
  def next(monadA: Monad1, monadB: Monad1): Number2
  def reverse(monadA: Monad1, monadB: Monad1): Number2
}
case object Number1Zero {
  def next(monadA: Monad1, monadB: Monad1): Number2 = Number2Zero
  def reverse(monadA: Monad1, monadB: Monad1): Number2 = Number2Zero
}

trait Number2
case class Number2Positive(tail: Number2) extends Number2
case object Number2Zero extends Number2

trait Number4 extends Number1 {
  override def next(monadA: Monad1, monadB: Monad1): Number2 = Number2Zero
  override def reverse(monadA: Monad1, monadB: Monad1): Number2 = Number2Zero
}
case class Number4Positive(tail: Number2) extends Number4 {
  override def next(monadA: Monad1, monadB: Monad1): Number2 = Number2Zero
  override def reverse(monadA: Monad1, monadB: Monad1): Number2 = Number2Zero
}
case class Number4Zero(next: Number2) extends Number4 {
  override def next(monadA: Monad1, monadB: Monad1): Number2 = Number2Zero
  override def reverse(monadA: Monad1, monadB: Monad1): Number2 = Number2Zero
}

trait Monad1 {
  def next(monad4: Monad1): Number2
  def reverse(monad1: Monad1): Number2
}
case class Monad1Positive(tail: Monad1, number1: Number1) extends Monad1 {
  def next(monad1: Monad1): Number2 = number1.next(tail, monad1)
  def reverse(monad1: Monad1): Number2 = number1.reverse(monad1, tail)
}
case object Monad1Zero extends Monad1 {
  def next(monad1: Monad1): Number2 = Number2Positive(monad1.reverse(Monad1Zero))
  def reverse(monad1: Monad1): Number2 = monad1.next(Monad1Zero)
}

println(new Number2 { })