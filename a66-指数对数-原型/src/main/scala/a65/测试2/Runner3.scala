package a65.测试2

object Runner3 {

  def number1gen(n: Int): Number1 = n match {
    case n1 if n1 > 0 => Number1S(number1gen(n1 - 1))
    case 0            => Number1T
  }

  def number3gen(n: Int): Number3 = n match {
    case n1 if n1 > 0 => new Number3S(number3gen(n1 - 1))
    case 0            => Number3T
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

  def 除数(n: Int): (Number2T, Number2S) = {
    def gen(n1: Int, zero: => Number2S): Number2T = n1 match {
      case n2 if n2 > 1 => Number2T(() => gen(n2 - 1, zero))
      case 1            => Number2T(() => zero)
    }
    lazy val number2t: Number2T = gen(n, number2s)
    lazy val number2s: Number2S = Number2S(() => number2t)
    (number2t, number2s)
  }

  def count(number1: Number1): Int = number1 match {
    case s: Number1S => count(s.tail) + 1
    case Number1T    => 0
  }

  def main(arr: Array[String]): Unit = {
    for {
      i <- 1 to 8
      n <- 1 to 5
    } yield {
      val number1                        = number3gen(n)
      val (number2Positive, number2Zero) = 乘数(i)
      val result: Number1                = number1.method3(number2Positive)
      val countResult                    = Pow.pow(i, n)
      assert(count(result) == countResult)
    }
    for {
      i <- 1 to 2000
      n <- 2 to 20
    } {
      val number1                        = number1gen(i)
      val (number2Positive, number2Zero) = 除数(n)
      val result: Number1                = number2Positive.method5(number1)
      val countResult                    = Pow.log(n, i)
      assert(count(result) == countResult + 1)
    }
  }

}
