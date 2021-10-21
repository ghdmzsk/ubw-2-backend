package a65.测试3

trait Number1 {
  def method1(number2: Number2): Number1
  def method3(number2: Number2): Number1
}
trait Number1S extends Number1 {
  def tail: Number1
  override def method1(number2: Number2): Number1 = number2.method2(tail)
}
// 对数（结果总是准确结果的后继）
case class Number1SA(override val tail: Number1) extends Number1S {
  override def method3(number2: Number2): Number1 = Number1SA(number2.method2(tail).method3(number2))
}
case object Number1TA extends Number1 {
  override def method1(number2: Number2): Number1 = Number1TA
  override def method3(number2: Number2): Number1 = Number1TA
}
// 指数
case class Number1SB(override val tail: Number1) extends Number1S {
  override def method3(number2: Number2): Number1 = tail.method3(number2).method1(number2)
}
case object Number1TB extends Number1 {
  override def method1(number2: Number2): Number1 = Number1TB
  // 指数这里是特例
  override def method3(number2: Number2): Number1 = Number1SB(Number1TB)
}

trait Number2 {
  def method2(number1: Number1): Number1
}
// 对数
case class Number2SA(tail: () => Number2) extends Number2 {
  override def method2(number1: Number1): Number1 = Number1SA(tail().method2(number1))
}
// 指数
case class Number2SB(tail: () => Number2) extends Number2 {
  override def method2(number1: Number1): Number1 = Number1SB(tail().method2(number1))
}
case class Number2T(tail: () => Number2) extends Number2 {
  override def method2(number1: Number1): Number1 = number1.method1(tail())
  // 仅有对数用到
  def method4(number1: Number1): Number1 = number1.method3(tail())
}
case object Number2U extends Number2 {
  override def method2(number1: Number1): Number1 = number1
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
