package 四法

trait P4Num1 {
  def method2(num4: P4Num2): Result
}
case class P4Num1S(tail: P4Num1) extends P4Num1 {
  override def method2(num4: P4Num2): Result = num4.method1(tail)
}
case object P4Num1T extends P4Num1 {
  override def method2(num4: P4Num2): Result = ResultT
}

trait P4Num2 {
  def method1(num4: P4Num1): Result
}
case class P4Num2T(tail: P4Num2) extends P4Num2 {
  override def method1(num4: P4Num1): Result = num4.method2(tail)
}
case class P4Num2S(tail: () => P4Num2) extends P4Num2 {
  override def method1(num4: P4Num1): Result = ResultS(tail().method1(num4))
}
