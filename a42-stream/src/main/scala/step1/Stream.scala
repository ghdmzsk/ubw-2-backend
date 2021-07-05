case class Item(name: String)

trait Number1 {
  def send(item: Item): Number2
  def end: Number2
}

trait Number2
case class Number2Positive(tail: Number2, head: Item) extends Number2
case class Number2Zero extends Nubmer2

trait Number3 extends Number1 {
  override def send(item: Item): Number2
  override def end: Number2
}
case class Number3Outter(tail: Number3, head: Item, next: Number1) extends Number3 {
  override def send(item: Item): Number2
  override def end: Number2
}
case class Number1Inner(tail: Number3, head: Item) extends Number3 {
  override def send(item: Item): Number2
  override def end: Number2
}
trait Nubmer1Zero extends Number1 {
  override def send(item: Item): Number2
  override def end: Number2
}

trait Number2
case object EndNumber2 extends Number2
case class Number2Positive(tail: Number2, head: Item, next: Number2) extends Number2 {
  def append = next.append(head)
  def end    = tail.append(head)
}
case class Number2Zero(next: Number2) extends Number2 {
  def append = next.end
  def end    = next.end
}

println(new Number2 { })