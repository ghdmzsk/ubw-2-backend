package a65.测试

object Runner2 {

  def number1gen(n: Int): Number1 = n match {
    case n1 if n1 > 0 => new Number1S(number1gen(n1 - 1))
    case 0            => Number1T
  }

  def 乘数(n: Int): (Number2, Number2) = {
    def gen(n1: Int, zero: => Number2): Number2 = n1 match {
      case n2 if n2 > 0 => Number2S(() => gen(n2 - 1, zero))
      case 0            => zero
    }
    lazy val number2s: Number2 = gen(n, number2t)
    lazy val number2t: Number2 = Number2T(() => number2s)
    (number2s, number2t)
  }

  def 除数(n: Int): (Number2, Number2) = {
    def gen(n1: Int, zero: => Number2): Number2 = n1 match {
      case n2 if n2 > 0 => Number2T(() => gen(n2 - 1, zero))
      case 0            => zero
    }
    lazy val number2t: Number2 = gen(n, number2s)
    lazy val number2s: Number2 = Number2S(() => number2t)
    (number2t, number2s)
  }

  def count(number1: Number1): Int = number1 match {
    case s: Number1S => count(s.tail) + 1
    case Number1T    => 0
  }

  def main(arr: Array[String]): Unit = {
    {
      val number1                        = number1gen(256)
      val (number2Positive, number2Zero) = 除数(4)
      val result: Number1                = Log.longNumber(number1, number2Positive)
      val result1                        = Log.log(4, 256)
      println(count(result) == result1)
    }
  }

}
