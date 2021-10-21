package a65.测试4

trait Number1 {
  def method1(number2: Number2): Number1
  def method3(number2: Number2): Number1
}
class Number1S(tail: Number1) {
  def method1(number2: Number2): Number1 = number2.method2(tail)
}
case class Number1SA(tail: Number1) extends Number1S(tail) with Number1 {
  override def method3(number2: Number2): Number1 = Number1SA(number2.method2(tail).method3(number2))
}
case object Number1TA extends Number1 {
  override def method1(number2: Number2): Number1 = Number1TA
  override def method3(number2: Number2): Number1 = Number1TA
}
case class Number1SB(tail: Number1) extends Number1S(tail) with Number1 {
  override def method3(number2: Number2): Number1 = tail.method3(number2).method1(number2)
}
case object Number1TB extends Number1 {
  override def method1(number2: Number2): Number1 = Number1TB
  override def method3(number2: Number2): Number1 = Number1SB(Number1TB)
}

trait Number2 {
  def method2(number1: Number1): Number1
}
case class Number2SA(tail: () => Number2) extends Number2 {
  override def method2(number1: Number1): Number1 = Number1SA(tail().method2(number1))
}
case class Number2SB(tail: () => Number2) extends Number2 {
  override def method2(number1: Number1): Number1 = Number1SB(tail().method2(number1))
}
case class Number2T(tail: () => Number2) extends Number2 {
  override def method2(number1: Number1): Number1 = number1.method1(tail())
  def method4(number1: Number1): Number1          = number1.method1(tail()).method3(tail())
}

object MathCount {

  def pow(底数: Int, 指数: Int): Int = {
    var result = 1
    def innerPow(di: Int): Unit = {
      if (di > 0) {
        result *= 底数
        innerPow(di - 1)
      }
    }
    innerPow(指数)
    result
  }

  def log(底数: Int, 真数: Int): Int = {
    var result = 0
    def innerLog(di: Int): Unit = {
      if (di <= 真数) {
        result += 1
        innerLog(di * 底数)
      }
    }
    innerLog(底数)
    result
  }

}
