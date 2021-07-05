package step1

case class Item(name: String)

trait Number1 {
  def produce(number2: Number2): Number1
}
case class Number1Positive(tail: Number1, head: Item) extends Number1 {
  override def produce(number2: Number2): Number1 = number2.append(head)
}
trait Nubmer1Zero extends Number1 {
  override def produce(number2: Number2): Number1 = number2.end
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
