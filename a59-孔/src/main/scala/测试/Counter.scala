package 测试

trait Number1 {
  def method1(number2: Number2): Result
}
case class Number1S(tail: Number1) extends Number1 {
  override def method1(number2: Number2): Result = number2.method2(tail)
}
case object Number1T extends Number1 {
  override def method1(number2: Number2): Result = ResultS(无中生有(number2))
}

trait Number2 {
  def method2(number1: Number1): Result
}
case class Number2S(tail: Number2) extends Number2 {
  override def method2(number1: Number1): Result = ResultS(tail.method2(number1))
}
case class Number2T(tail: () => Number2) extends Number2 {
  override def method2(number1: Number1): Result = number1.method1(tail())
}

trait Result
case class ResultS(tail: Result) extends Result
case object ResultT              extends Result
