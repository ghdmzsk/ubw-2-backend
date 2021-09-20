package 四法

trait P5Num1 {
  def method2(num5: P5Num2): Result
}
case class P5Num1S(tail: P5Num1) extends P5Num1 {
  override def method2(num5: P5Num2): Result = num5.method1(tail)
}
case class P5Num1T(tail: P5Num1) extends P5Num1 {
  override def method2(num5: P5Num2): Result = tail.method2(num5)
}

trait P5Num2 {
  def method1(num5: P5Num1): Result
}
case class P5Num2T(tail: P5Num2) extends P5Num2 {
  override def method1(num5: P5Num1): Result = num5.method2(tail)
}
case class P5Num2S(tail: () => P5Num2) extends P5Num2 {
  override def method1(num5: P5Num1): Result = ResultS(tail().method1(num5))
}
