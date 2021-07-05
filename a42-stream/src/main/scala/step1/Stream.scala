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
case class Number2Positive(tail: Number2, head: Item) extends Number2
case object Number2Zero extends Nubmer2

trait Number3 extends Number1 {
  override def send(item: Item): Number2
  override def end: Number2
}
case class Number3Positive(tail: Number3, head: Item) extends Number3 {
  override def send(item: Item): Number2
  override def end: Number2
}
case object Nubmer3Zero extends Number3 {
  override def send(item: Item): Number2
  override def end: Number2 = Number2Zero
}

trait Number4 extends Number1 {
  override def send(item: Item): Number2
  override def end: Number2
}
case class Number4Outter(tail: Number3, head: Item, next: Number1) extends Number4 {
  override def send(item: Item): Number2
  override def end: Number2
}
case class Number4Positive(tail: Number2, head: Item, next: Number2) extends Number4 {
  override def send(item: Item): Number2
  override def end: Number2
}
case class Number4Zero(next: Number2) extends Number4 {
  override def send(item: Item): Number2
  override def end: Number2
}

trait Monad1

trait Monad3 extends Monad1
case class Monad3Positive extends Monad3
case class Monad3Zero extends Monad3

println(new Number2 { })