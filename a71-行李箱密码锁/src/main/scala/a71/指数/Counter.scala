package a71.指数

trait Number1 {
  def method1(number2: Number2): Number4
}
case class Number1S(tail: Number1) extends Number1 {
  override def method1(number2: Number2): Number4 = number2.method2(tail)
}
case object Number1T extends Number1 {
  override def method1(number2: Number2): Number4 = Number4T
}

trait Number2 {
  def method2(number1: Number1): Number4
}
case class Number2S(tail: Number2) extends Number2 {
  override def method2(number1: Number1): Number4 = number1.method1(tail)
}
case class Number2T(tailNext: () => Number2Bottom, genTailNext: Number2Bottom => Number2) extends Number2 {
  override def method2(number1: Number1): Number4 = tailNext().method3(number1, Number3T(genTailNext))
}

trait Number2Bottom {
  def method3(number1: Number1, number3: Number3): Number4
}
case class Number2SBottom(tail: Number2Bottom) extends Number2Bottom {
  override def method3(number1: Number1, number3: Number3): Number4 = Number4S(tail.method3(number1, number3))
}
case class Number2TBottom(tailNext: () => Number2Bottom, genTailNext: Number2Bottom => Number2Bottom) extends Number2Bottom {
  override def method3(number1: Number1, number3: Number3): Number4 = tailNext().method3(number1, Number3S(number3, genTailNext))
}
case class Number2Zero(genTail: () => Number2Bottom) extends Number2Bottom {
  override def method3(number1: Number1, number3: Number3): Number4 = number3.method3(number1, genTail())
}

trait Number3 {
  def method3(number1: Number1, number2b: Number2Bottom): Number4
}
case class Number3S(tail: Number3, genTailNext: Number2Bottom => Number2Bottom) extends Number3 {
  override def method3(number1: Number1, number2b: Number2Bottom): Number4 = tail.method3(number1, genTailNext(number2b))
}
case class Number3T(genTailNext: Number2Bottom => Number2) extends Number3 {
  override def method3(number1: Number1, number2b: Number2Bottom): Number4 = genTailNext(number2b).method2(number1)
}

trait Number4
case class Number4S(tail: Number4) extends Number4
case object Number4T               extends Number4
