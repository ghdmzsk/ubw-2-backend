package step1

case class Item(name: String)

trait Result {
  def length: Int
}
case class ResultP(tail: Result, head: Item) extends Result {
  override def length: Int = tail.length + 1
}
case object ResultO extends Result {
  override def length: Int = 0
}

trait Num1 {
  def method1(number2: Num2, number3: Num3, number4: Num4): Result
}
case class Num1P(tail: Num1) extends Num1 {
  override def method1(number2: Num2, number3: Num3, number4: Num4): Result = number2.method2(tail, number3, number4)
}
case object Num1Zero extends Num1 {
  override def method1(number2: Num2, number3: Num3, number4: Num4): Result = ResultO
}

trait Num2 {
  def method2(number1: Num1, number3: Num3, number4: Num4): Result
}
case class Num2P(tail: Num2) extends Num2 {
  override def method2(number1: Num1, number3: Num3, number4: Num4): Result = number3.method3(number1, tail, number4)
}
case class Num2Zero(tail: () => Num2) extends Num2 {
  override def method2(number1: Num1, number3: Num3, number4: Num4): Result = number1.method1(tail(), number3, number4)
}

trait Num3 {
  def method3(number1: Num1, number2: Num2, number4: Num4): Result
}
case class Num3P(tail: Num3) extends Num3 {
  override def method3(number1: Num1, number2: Num2, number4: Num4): Result = number4.method4(number1, number2, tail)
}
case class Num3Zero(tail: () => Num3) extends Num3 {
  override def method3(number1: Num1, number2: Num2, number4: Num4): Result = number2.method2(number1, tail(), number4)
}

trait Num4 {
  def method4(number1: Num1, number2: Num2, number3: Num3): Result
}
case class Num4P(tail: Num4, head: Item) extends Num4 {
  override def method4(number1: Num1, number2: Num2, number3: Num3): Result = ResultP(tail.method4(number1, number2, number3), head)
}
case class Num4Zero(tail: () => Num4) extends Num4 {
  override def method4(number1: Num1, number2: Num2, number3: Num3): Result = number3.method3(number1, number2, tail())
}
