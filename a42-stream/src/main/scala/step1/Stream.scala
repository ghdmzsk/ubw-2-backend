package step1

case class Item(name: String)

trait Number {
  def next(stream: Stream, reverseStream: ReverseStream, item: Item): Result
}

trait ReverseNumber {
  def reverse(stream: Stream, reverseStream: ReverseStream): Result
}

trait Result
case class ResultPositive(tail: Result, head: Item) extends Result {
  override def toString: String = s"(${tail}, ${head.name})"
}
case object ResultZero extends Result {
  override def toString: String = "Zero"
}

trait PlusNumber extends ReverseNumber {
  override def reverse(stream: Stream, reverseStream: ReverseStream): Result
}
case class PlusNumberPositive(tail: PlusNumber, head: Item) extends PlusNumber {
  override def reverse(stream: Stream, reverseStream: ReverseStream): Result = stream.next(ReverseStreamPositive(reverseStream, tail), head)
}
case object PlusNumberZero extends PlusNumber {
  override def reverse(stream: Stream, reverseStream: ReverseStream): Result = reverseStream.reverse(stream)
}

trait MinusNumber extends Number with ReverseNumber {
  override def next(stream: Stream, reverseStream: ReverseStream, item: Item): Result
  override def reverse(stream: Stream, reverseStream: ReverseStream): Result
}
case class MinusNumberPositive(tail: MinusNumber) extends Number with MinusNumber {
  override def next(stream: Stream, reverseStream: ReverseStream, item: Item): Result = reverseStream.reverse(StreamPositive(stream, tail))
  override def reverse(stream: Stream, reverseStream: ReverseStream): Result          = reverseStream.reverse(StreamPositive(stream, MinusNumberPositive(tail)))
}
case object MinusNumberZero extends Number with MinusNumber {
  override def next(stream: Stream, reverseStream: ReverseStream, item: Item): Result = stream.next(reverseStream, item)
  override def reverse(stream: Stream, reverseStream: ReverseStream): Result          = reverseStream.reverse(stream)
}

trait Stream {
  def next(reverseStream: ReverseStream, item: Item): Result
}
case class StreamPositive(tail: Stream, number: Number) extends Stream {
  override def next(reverseStream: ReverseStream, item: Item): Result = number.next(tail, reverseStream, item)
}
case object StreamZero extends Stream {
  override def next(reverseStream: ReverseStream, item: Item): Result = ResultPositive(reverseStream.reverse(StreamZero), item)
}

trait ReverseStream {
  def reverse(stream: Stream): Result
}
case class ReverseStreamPositive(tail: ReverseStream, reverseNumber: ReverseNumber) extends ReverseStream {
  override def reverse(stream: Stream): Result = reverseNumber.reverse(stream, tail)
  def run: Result                              = reverse(StreamZero)
}
case object ReverseStreamZero extends ReverseStream {
  override def reverse(stream: Stream): Result = ResultZero
}
