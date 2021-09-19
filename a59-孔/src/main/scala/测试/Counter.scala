package 测试

trait Number1 {
  def method1(number2: Number2): Result
}
case class Number1S(tail: Number1) extends Number1 {
  override def method1(number2: Number2): Result = number2.method2(tail)
}
case class Number1T(tail: () => Number1) extends Number1 {
  override def method1(number2: Number2): Result = {
    val a1 = Number1T(tail)
    val a2 = number2
    a2
    ResultT
    // 要和不要更高一阶法之间
    // 如果要，必然正无穷，如果不要，必然只有两阶
    // 所以是介于轮和 HList 的数据结构，不能构成双轮
    // 介于

  }
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
