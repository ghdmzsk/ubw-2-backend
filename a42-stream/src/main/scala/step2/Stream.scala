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
  override def reverse(number: Number): Result = number.next(tail, head)
}
case object PlusNumberZero extends PlusNumber {
  override def reverse(number: Number): Result = ResultZero
}

trait LinkNumber extends Number
case class LinkNumberPositive(tail: LinkNumber, head: Number) extends LinkNumber {
  override def next(reverseNumber: ReverseNumber, item: Item): Result = ResultZero
}
case object LinkNumberZero extends LinkNumber {
  override def next(reverseNumber: ReverseNumber, item: Item): Result = ResultZero
}

trait ReverseLinkNumber extends ReverseNumber
case class ReverseLinkNumberPositive(tail: ReverseLinkNumber, head: ReverseNumber) extends ReverseLinkNumber {
  override def reverse(number: Number): Result = ResultZero
}
case object ReverseLinkNumberZero extends ReverseLinkNumber {
  override def reverse(number: Number): Result = ResultZero
}
