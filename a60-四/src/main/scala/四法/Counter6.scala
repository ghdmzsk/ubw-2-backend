package 四法

trait P6Num1 {
  def method2(num6: P6Num2): Result
}
case class P6Num1S(tail: P6Num1) extends P6Num1 {
  override def method2(num6: P6Num2): Result = num6.method1(tail)
}
case class P6Num1T(tail: () => P6Num1) extends P6Num1 {
  override def method2(num6: P6Num2): Result = tail().method2(num6)
}

trait P6Num2 {
  def method1(num6: P6Num1): Result
}
case class P6Num2S(tail: P6Num2) extends P6Num2 {
  override def method1(num6: P6Num1): Result = num6.method2(tail)
}
case class P6Num2T(tail: () => P6Num2) extends P6Num2 {
  override def method1(num6: P6Num1): Result = ResultS(tail().method1(num6))
}
