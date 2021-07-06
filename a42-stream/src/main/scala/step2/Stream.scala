package step2

case class Item(name: String)

trait Number {
  def next(reverseNumber: ReverseNumber, item: Item): Result
}

trait ReverseNumber {
  def reverse(number: Number): Result
}

trait Result
case class ResultPositive(tail: Result, head: Item) extends Result
case object ResultZero                              extends Result

trait PlusNumber extends ReverseNumber
case class PlusNumberPositive(tail: PlusNumber, head: Item) extends PlusNumber {
  override def reverse(number: Number): Result = ResultZero
}
case object PlusNumberZero extends PlusNumber {
  override def reverse(number: Number): Result = ResultZero
}
