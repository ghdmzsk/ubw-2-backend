case class Item(name: String)

trait Number1 {
  def send(item: Item): Number2
  def end: Number2
}
case object Number1Zero {
  def send(item: Item): Number2
  def end: Number2
}

trait Number2
case class Number2Positive(tail: Number2) extends Number2
case object Number2Zero extends Nubmer2

trait Number4 extends Number1 {
  override def next(monad3: Monad3): Number2
  override def reverse(monad4: Monad4): Number2
}
case class Number4Positive(tail: Number2) extends Number4 {
  override def next(monad3: Monad3): Number2 = Number2Positive(tail.send)
  override def reverse(monad4: Monad4): Number2
}
case class Number4Zero(next: Number2) extends Number4 {
  override def next(monad3: Monad3): Number2
  override def reverse(monad4: Monad4): Number2
}

trait Monad1

trait Monad3 extends Monad1 {
  def next(monad4: Monad4): Number2
  def reverse(monad1: Monad1): Number2
}
case class Monad3Positive(tail: Monad1, number1: Number1) extends Monad3 {
  def next(monad4: Monad4): Number2 = number1.next(tail, monad4)
  def reverse(monad1: Monad1): Number2 = number.reverse(monad4, tail)
}
case class Monad3Zero extends Monad3 {
  def next(monad4: Monad4): Number2
  def reverse(monad1: Monad1): Number2
}

trait Monad4 extends Monad1 {
  def next(monad3: Monad3): Number2
}
case class Monad4Positive(tail: Monad1, number1: Number1) extends Monad4 {
  def next(monad3: Monad3): Number2
}
case class Monad4Zero extends Monad4 {
  def next(monad3: Monad3): Number2
}

println(new Number2 { })