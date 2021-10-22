package a65.测试6

object Runner7 {

  def number1s(n: Int): Number1 = {
    lazy val taZero: Number1 = Number1T(() => taZero)
    n match {
      case n1 if n1 > 0 => Number1S(() => number1s(n1 - 1))
      case 0            => taZero
    }
  }
  def number1t(n: Int): Number1 = {
    def gen(n1: Int, zero: => Number1): Number1 = n1 match {
      case n2 if n2 > 0 => Number1T(() => gen(n2 - 1, zero))
      case 0            => zero
    }
    lazy val number1t: Number1 = gen(n, taZero)
    lazy val taZero: Number1   = Number1S(() => number1t)
    number1t
  }

  def number2t(n: Int): (Number2T, Number2S) = {
    def gen(n1: Int, zero: => Number2): Number2T = n1 match {
      case n2 if n2 > 1 => Number2T(() => gen(n2 - 1, zero))
      case 1            => Number2T(() => zero)
    }
    lazy val number2t: Number2T = gen(n, number2s)
    lazy val number2s: Number2S = Number2S(() => number2t)
    (number2t, number2s)
  }
  def number2s(n: Int): Number2 = {
    def gen(n1: Int, zero: => Number2): Number2 = n1 match {
      case n2 if n2 > 0 => Number2S(() => gen(n2 - 1, zero))
      case 0            => zero
    }
    lazy val number2s: Number2 = gen(n, number2t)
    lazy val number2t: Number2 = Number2T(() => number2s)
    number2t
  }
  def counts(number1: Number1): Int = number1 match {
    case Number1S(tail) =>
      val num =
        try {
          counts(tail())
        } catch {
          case e: StackOverflowError => 0
        }
      num + 1
    case Number1T(tail) => 0
  }
  def countt(number1: Number1): Int = number1 match {
    case Number1S(tail) =>
      val num =
        try {
          countt(tail())
        } catch {
          case e: StackOverflowError => 0
        }
      num + 1
    case Number1T(tail) => 0
  }

  def main(arr: Array[String]): Unit = {
    for {
      i <- 1 to 40
      n <- 3 to 6
    } {
      val result1                        = MathCount.log(n, i)
      val number1                        = number1s(i).asInstanceOf[Number1S]
      val (number2Positive, number2Zero) = number2t(n)
      val result2                        = number1.method3(number2Positive.tail())
      val resultNum2                     = counts(result2)
      println(resultNum2 == result1, resultNum2 - 1 == result1, n, i, resultNum2, result1)
    }
    for {
      i <- 1 to 7
      n <- 1 to 4
    } {
      val result1         = MathCount.pow(n, i)
      val number1         = number1t(i)
      val number2Positive = number2s(n)
      val result2         = number1.method3(number2Positive)
      val resultNum2      = countt(result2)
      if (result1 != resultNum2) {
        println(n, i, resultNum2, result1)
      }
    }
  }

}
