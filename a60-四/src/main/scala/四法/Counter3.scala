package 四法

trait P3Num1 {
  def method2(num3: P3Num2): Result
}
case class P3Num1S(tail: P3Num1) extends P3Num1 {
  override def method2(num3: P3Num2): Result = num3.method1(tail)
}
case object P3Num1T extends P3Num1 {
  override def method2(num3: P3Num2): Result = ResultT
}

trait P3Num2 {
  def method1(num3: P3Num1): Result
}
case class P3Num2S(tail: P3Num2) extends P3Num2 {
  override def method1(num3: P3Num1): Result = ResultS(tail.method1(num3))
}
case class P3Num2T(tail: () => P3Num2) extends P3Num2 {
  override def method1(num3: P3Num1): Result = num3.method2(tail())
}

trait Result
case class ResultS(tail: Result) extends Result
case object ResultT              extends Result
