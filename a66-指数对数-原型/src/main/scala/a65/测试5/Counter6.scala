package a65.测试5

trait Number1 {
  def method1(number2: Number2): Number1
  def method3(number2: Number2): Number1
}
case class Number1S(tail: () => Number1) extends Number1 {
  override def method1(number2: Number2): Number1 = {
    println("66" * 100)
    number2.method2(tail())
  }
  override def method3(number2: Number2): Number1 = {
    println("55" * 100)
    Number1S(() => number2.method2(tail()).method3(number2))
  }
}
case class Number1T(tail: () => Number1) extends Number1 {
  override def method1(number2: Number2): Number1 = {
    println("44" * 100)
    lazy val number1s: Number1 = Number1S(() => number1t)
    lazy val number1t: Number1 = Number1T(() => number1s)
    number1t
    Number1T(() => tail().method1(number2))
    lazy val number1t2: Number1 = Number1T(() => number1t2)
    number1t2
    Number1T(() => tail().method1(number2))
  }
  override def method3(number2: Number2): Number1 = {
    println("33" * 100)
    number2.method2(tail().method3(number2))
  }
}

trait Number2 {
  def method2(number1: Number1): Number1
}
case class Number2S(tail: () => Number2) extends Number2 {
  override def method2(number1: Number1): Number1 = Number1S(() => tail().method2(number1))
}
case class Number2T(tail: () => Number2) extends Number2 {
  override def method2(number1: Number1): Number1 = {
    println("22" * 100)
    number1.method1(tail())
  }
  def method4(number1: Number1): Number1 = {
    println("11" * 100)
    number1.method1(tail()).method3(tail())
  }
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
