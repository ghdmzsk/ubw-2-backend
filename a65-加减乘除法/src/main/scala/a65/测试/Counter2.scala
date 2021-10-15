package a65.测试

trait Number1 {
  def method1(number2: Number2): Number1
}
case class Number1S(tail: Number1) extends Number1 {
  override def method1(number2: Number2): Number1 = number2.method2(tail)
}
case object Number1T extends Number1 {
  override def method1(number2: Number2): Number1 = Number1T
}

trait Number2 {
  def method2(number1: Number1): Number1
}
case class Number2S(tail: () => Number2) extends Number2 {
  override def method2(number1: Number1): Number1 = Number1S(tail().method2(number1))
}
case class Number2T(tail: () => Number2) extends Number2 {
  override def method2(number1: Number1): Number1 = number1.method1(tail())
}

object Log {

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

  def longNumber(number1: Number1, number2: Number2): Number1 = {
    number2.method2(number1) match {
      case a: Number1S => Number1S(longNumber(a, number2))
      case Number1T    => Number1T
    }
  }

}
