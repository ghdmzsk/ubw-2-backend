package a40_test

trait Number1 {
  def method1: Number1
}

case class TopNumber0(tail: Number1) extends Number1 {
  override def method1: Number1
}
case class TopNumber1(tail: Number1) extends Number1 {
  override def method1: Number1
}
case class TopNumber2(tail: Number1) extends Number1 {
  override def method1: Number1
}

case class MiddleNumber0(tail: Number1) extends Number1 {
  override def method1: Number1
}
case class MiddleNumber1(tail: Number1) extends Number1 {
  override def method1: Number1
}
case class MiddleNumber2(tail: Number1) extends Number1 {
  override def method1: Number1
}

case object BottomNumber0 extends Number1 {
  override def method1: Number1
}
case object BottomNumber1 extends Number1 {
  override def method1: Number1
}
case object BottomNumber2 extends Number1 {
  override def method1: Number1
}

trait Number2 {
  def length: Int
}
case class Number2Positive(tail: Number2) extends Number2 {
  override def length: Int = tail.length + 1
}
case object NumberZero extends Number2 {
  override def length: Int = 0
}
