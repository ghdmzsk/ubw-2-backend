package 四法

trait P2Num1 {
  def method2(num2: P2Num2): P2Num1
}
case class P2Num1S(tail: P2Num1) extends P2Num1 {
  override def method2(num2: P2Num2): P2Num1 = num2.method1(tail)
}
case object P2Num1T extends P2Num1 {
  override def method2(num2: P2Num2): P2Num1 = P2Num1T
}

trait P2Num2 {
  def method1(num1: P2Num1): P2Num1
}
case class P2Num2S(tail: P2Num2) extends P2Num2 {
  override def method1(num1: P2Num1): P2Num1 = num1.method2(tail)
}
case object P2Num2T extends P2Num2 {
  override def method1(num1: P2Num1): P2Num1 = num1
}
