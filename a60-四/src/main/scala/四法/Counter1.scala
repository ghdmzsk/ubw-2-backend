package 四法

trait P1Num1
case class P1Num1S(tail: P1Num1) extends P1Num1
case object P1Num1T              extends P1Num1

trait P1Num2 {
  def method1(num1: P1Num1): P1Num1
}
case class P1Num2S(tail: P1Num2) extends P1Num2 {
  override def method1(num1: P1Num1): P1Num1 = P1Num1S(tail.method1(num1))
}
case object P1Num2T extends P1Num2 {
  override def method1(num1: P1Num1): P1Num1 = num1
}
