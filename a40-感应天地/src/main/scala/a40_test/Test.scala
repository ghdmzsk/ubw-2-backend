package a40_test

trait Number1 {
  def method1: Number7
}

trait Number2 {
  def method2(number4: Number4): Number7
}

trait Number3 {
  def method3: Number7
}

trait Number4 {
  def method4(number1: Number2): Number7
  def method5(number1: Number2): Number7
}

case class TopNumber0(tail: Number2) extends Number1 {
  override def method1: Number7 = tail.method2(YBottomNumber0)
}
case class TopNumber1(tail: Number2) extends Number1 {
  override def method1: Number7 = tail.method2(YBottomNumber1)
}
case class TopNumber2(tail: Number2) extends Number1 {
  override def method1: Number7 = tail.method2(YBottomNumber2)
}

case class MiddleNumber0(tail: Number2) extends Number2 {
  override def method2(number4: Number4): Number7 = tail.method2(YMiddleNumber0(number4))
}
case class MiddleNumber1(tail: Number2) extends Number2 {
  override def method2(number4: Number4): Number7 = tail.method2(YMiddleNumber1(number4))
}
case class MiddleNumber2(tail: Number2) extends Number2 {
  override def method2(number4: Number4): Number7 = tail.method2(YMiddleNumber2(number4))
}

case object BottomNumber0 extends Number2 {
  override def method2(number4: Number4): Number7 = YTopNumber2(number4).method3
}
case object BottomNumber1 extends Number2 {
  override def method2(number4: Number4): Number7 = YTopNumber0(number4).method3
}
case object BottomNumber2 extends Number2 {
  override def method2(number4: Number4): Number7 = YTopNumber1(number4).method3
}

case class YTopNumber0(tail: Number4) extends Number3 {
  override def method3: Number7 = tail.method4(BottomNumber0)
}
case class YTopNumber1(tail: Number4) extends Number3 {
  override def method3: Number7 = tail.method4(BottomNumber1)
}
case class YTopNumber2(tail: Number4) extends Number3 {
  override def method3: Number7 = tail.method5(BottomNumber2)
}

case class YMiddleNumber0(tail: Number4) extends Number4 {
  override def method4(number2: Number2): Number7 = tail.method4(MiddleNumber0(number2))
  override def method5(number2: Number2): Number7 = tail.method5(MiddleNumber2(number2))
}
case class YMiddleNumber1(tail: Number4) extends Number4 {
  override def method4(number2: Number2): Number7 = tail.method4(MiddleNumber1(number2))
  override def method5(number2: Number2): Number7 = tail.method4(MiddleNumber0(number2))
}
case class YMiddleNumber2(tail: Number4) extends Number4 {
  override def method4(number2: Number2): Number7 = tail.method4(MiddleNumber2(number2))
  override def method5(number2: Number2): Number7 = tail.method4(MiddleNumber1(number2))
}

case object YBottomNumber0 extends Number4 {
  override def method4(number2: Number2): Number7 = Number7Positive(TopNumber0(number2).method1)
  override def method5(number2: Number2): Number7 = Number7Zero
}
case object YBottomNumber1 extends Number4 {
  override def method4(number2: Number2): Number7 = Number7Positive(TopNumber1(number2).method1)
  override def method5(number2: Number2): Number7 = Number7Positive(TopNumber0(number2).method1)
}
case object YBottomNumber2 extends Number4 {
  override def method4(number2: Number2): Number7 = Number7Positive(TopNumber2(number2).method1)
  override def method5(number2: Number2): Number7 = Number7Positive(TopNumber1(number2).method1)
}

trait Number7 {
  def length: Int
}
case class Number7Positive(tail: Number7) extends Number7 {
  override def length: Int = tail.length + 1
}
case object Number7Zero extends Number7 {
  override def length: Int = 0
}
