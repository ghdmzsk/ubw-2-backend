package a65.测试3

object Runner4 {

  def number1A(n: Int): Number1 = n match {
    case n1 if n1 > 0 => Number1SA(number1A(n1 - 1))
    case 0            => Number1TA
  }
  def number1B(n: Int): Number1 = n match {
    case n1 if n1 > 0 => Number1SB(number1B(n1 - 1))
    case 0            => Number1TB
  }

  def number2A(n: Int): (Number2T, Number2SA) = {
    def gen(n1: Int, zero: => Number2SA): Number2T = n1 match {
      case n2 if n2 > 1 => Number2T(() => gen(n2 - 1, zero))
      case 1            => Number2T(() => zero)
    }
    lazy val number2t: Number2T   = gen(n, number2sa)
    lazy val number2sa: Number2SA = Number2SA(() => number2t)
    (number2t, number2sa)
  }
  def number2B(n: Int): (Number2SB, Number2T) = {
    def gen(n1: Int, zero: => Number2T): Number2SB = n1 match {
      case n2 if n2 > 1 => Number2SB(() => gen(n2 - 1, zero))
      case 1            => Number2SB(() => zero)
    }
    lazy val number2sb: Number2SB = gen(n, number2t)
    lazy val number2t: Number2T   = Number2T(() => number2sb)
    (number2sb, number2t)
  }
  def count(number1: Number1): Int = number1 match {
    case Number1SA(tail) => count(tail) + 1
    case Number1SB(tail) => count(tail) + 1
    case _               => 0
  }

  def main(arr: Array[String]): Unit = {
    for {
      i <- 1 to 2000
      n <- 2 to 80
    } {
      val result1                        = MathCount.log(n, i)
      val number1                        = number1A(i)
      val (number2Positive, number2Zero) = number2A(n)
      val result2                        = number2Positive.method4(number1)
      assert(result1 + 1 == count(result2))
    }
    for {
      i <- 1 to 8
      n <- 1 to 5
    } {
      val result1                        = MathCount.pow(n, i)
      val number1                        = number1B(i)
      val (number2Positive, number2Zero) = number2B(n)
      val result2                        = number1.method3(number2Positive)
      assert(result1 == count(result2))
    }
  }

}
