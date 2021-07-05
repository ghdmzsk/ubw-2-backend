package step1

case class Item(name: String)

trait Number1 {
  def next(stream: Stream, reverseStream: ReverseStream): Number2
  def reverse(stream: Stream, reverseStream: ReverseStream): Number2
}

trait Number2
case class Number2Positive(tail: Number2) extends Number2
case object Number2Zero                   extends Number2

trait FirstNumber extends Number1 {
  override def next(stream: Stream, reverseStream: ReverseStream): Number2
  override def reverse(stream: Stream, reverseStream: ReverseStream): Number2
}
case class FirstNumberPositive(tail: FirstNumber) extends FirstNumber {
  override def next(stream: Stream, reverseStream: ReverseStream): Number2    = stream.next(ReverseStreamPositive(reverseStream, tail))
  override def reverse(stream: Stream, reverseStream: ReverseStream): Number2 = stream.next(ReverseStreamPositive(reverseStream, tail))
}
case object FirstNumberZero extends FirstNumber {
  override def next(stream: Stream, reverseStream: ReverseStream): Number2    = stream.next(reverseStream)
  override def reverse(stream: Stream, reverseStream: ReverseStream): Number2 = reverseStream.reverse(stream)
}

trait Number4 extends Number1 {
  override def next(stream: Stream, reverseStream: ReverseStream): Number2
  override def reverse(stream: Stream, reverseStream: ReverseStream): Number2
}
case class Number4Positive(tail: Number4) extends Number4 {
  override def next(stream: Stream, reverseStream: ReverseStream): Number2    = stream.next(ReverseStreamPositive(reverseStream, Number4Positive(tail)))
  override def reverse(stream: Stream, reverseStream: ReverseStream): Number2 = stream.next(ReverseStreamPositive(reverseStream, tail))
}
case object Number4Zero extends Number4 {
  override def next(stream: Stream, reverseStream: ReverseStream): Number2    = stream.next(reverseStream)
  override def reverse(stream: Stream, reverseStream: ReverseStream): Number2 = reverseStream.reverse(stream)
}

trait Stream {
  def next(reverseStream: ReverseStream): Number2
}
case class StreamPositive(tail: Stream, number1: Number1) extends Stream {
  def next(reverseStream: ReverseStream): Number2 = number1.next(tail, reverseStream)
  def run: Number2                                = number1.next(tail, ReverseStreamZero)
}
case object StreamZero extends Stream {
  def next(reverseStream: ReverseStream): Number2 = Number2Positive(reverseStream.reverse(StreamZero))
}

trait ReverseStream {
  def reverse(stream: Stream): Number2
}
case class ReverseStreamPositive(tail: ReverseStream, number1: Number1) extends ReverseStream {
  def reverse(stream: Stream): Number2 = number1.reverse(stream, tail)
}
case object ReverseStreamZero extends ReverseStream {
  def reverse(stream: Stream): Number2 = Number2Zero
}
