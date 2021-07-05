package step1

case class Item(name: String)

trait Number {
  def next(stream: Stream, reverseStream: ReverseStream, item: Item): Number2
}

trait ReverseNumber {
  def reverse(stream: Stream, reverseStream: ReverseStream): Number2
}

trait Number2
case class Number2Positive(tail: Number2, head: Item) extends Number2 {
  override def toString: String = s"(${tail}, ${head.name})"
}
case object Number2Zero extends Number2 {
  override def toString: String = "Zero"
}

trait FirstNumber extends ReverseNumber {
  override def reverse(stream: Stream, reverseStream: ReverseStream): Number2
}
case class FirstNumberPositive(tail: FirstNumber, head: Item) extends FirstNumber {
  override def reverse(stream: Stream, reverseStream: ReverseStream): Number2 = stream.next(ReverseStreamPositive(reverseStream, tail), head)
}
case object FirstNumberZero extends FirstNumber {
  override def reverse(stream: Stream, reverseStream: ReverseStream): Number2 = reverseStream.reverse(stream)
}

trait PlusNumber extends ReverseNumber {
  override def reverse(stream: Stream, reverseStream: ReverseStream): Number2
}
case class PlusNumberPositive(tail: PlusNumber, head: Item) extends PlusNumber {
  override def reverse(stream: Stream, reverseStream: ReverseStream): Number2 = stream.next(ReverseStreamPositive(reverseStream, tail), head)
}
case object PlusNumberZero extends PlusNumber {
  override def reverse(stream: Stream, reverseStream: ReverseStream): Number2 = reverseStream.reverse(stream)
}

trait MinusNumber extends Number with ReverseNumber {
  override def next(stream: Stream, reverseStream: ReverseStream, item: Item): Number2
  override def reverse(stream: Stream, reverseStream: ReverseStream): Number2
}
case class MinusNumberPositive(tail: MinusNumber) extends Number with MinusNumber {
  override def next(stream: Stream, reverseStream: ReverseStream, item: Item): Number2 = reverseStream.reverse(StreamPositive(stream, tail))
  override def reverse(stream: Stream, reverseStream: ReverseStream): Number2          = reverseStream.reverse(StreamPositive(stream, MinusNumberPositive(tail)))
}
case object MinusNumberZero extends Number with MinusNumber {
  override def next(stream: Stream, reverseStream: ReverseStream, item: Item): Number2 = stream.next(reverseStream, item)
  override def reverse(stream: Stream, reverseStream: ReverseStream): Number2          = reverseStream.reverse(stream)
}

trait Stream {
  def next(reverseStream: ReverseStream, item: Item): Number2
}
case class StreamPositive(tail: Stream, number1: Number) extends Stream {
  override def next(reverseStream: ReverseStream, item: Item): Number2 = number1.next(tail, reverseStream, item)
}
case object StreamZero extends Stream {
  override def next(reverseStream: ReverseStream, item: Item): Number2 = Number2Positive(reverseStream.reverse(StreamZero), item)
}

trait ReverseStream {
  def reverse(stream: Stream): Number2
}
case class ReverseStreamPositive(tail: ReverseStream, number1: ReverseNumber) extends ReverseStream {
  override def reverse(stream: Stream): Number2 = number1.reverse(stream, tail)
  def run: Number2                              = reverse(StreamZero)
}
case object ReverseStreamZero extends ReverseStream {
  override def reverse(stream: Stream): Number2 = Number2Zero
}
