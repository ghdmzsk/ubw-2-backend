package a65.测试5

object Runner6 {

  def number1s(n: Int): Number1 = {
    lazy val taZero: Number1 = Number1T(() => taZero)
    n match {
      case n1 if n1 > 0 => Number1S(() => number1s(n1 - 1))
      case 0            => taZero
    }
  }
  def number1t(n: Int): Number1 = {
    lazy val ntZero: Number1 = Number1S(() => ntZero)
    n match {
      case n1 if n1 > 0 => Number1T(() => number1t(n1 - 1))
      case 0            => ntZero
    }
  }

  def number2s(n: Int): (Number2T, Number2SS) = {
    def gen(n1: Int, zero: => Number2SS): Number2T = n1 match {
      case n2 if n2 > 1 => Number2T(() => gen(n2 - 1, zero))
      case 1            => Number2T(() => zero)
    }
    lazy val number2t: Number2T   = gen(n, number2sa)
    lazy val number2sa: Number2SS = Number2SS(() => number2t)
    (number2t, number2sa)
  }
  def number2t(n: Int): (Number2ST, Number2T) = {
    def gen(n1: Int, zero: => Number2T): Number2ST = n1 match {
      case n2 if n2 > 1 => Number2ST(() => gen(n2 - 1, zero))
      case 1            => Number2ST(() => zero)
    }
    lazy val number2sb: Number2ST = gen(n, number2t)
    lazy val number2t: Number2T   = Number2T(() => number2sb)
    (number2sb, number2t)
  }
  def counts(number1: Number1): Int = try {
    number1 match {
      case Number1S(tail) => counts(tail()) + 1
      case Number1T(tail) => counts(tail())
      case _              => 0
    }
  } catch {
    case _: StackOverflowError => 0
  }
  def countt(number1: Number1): Int = try {
    number1 match {
      case Number1S(tail) => countt(tail())
      case Number1T(tail) => countt(tail()) + 1
      case _              => 0
    }
  } catch {
    case _: StackOverflowError => 0
  }

  def main(arr: Array[String]): Unit = {
    for {
      i <- 1 to 200
      n <- 3 to 3
    } {
      val result1                        = MathCount.log(n, i)
      val number1                        = number1s(i)
      val (number2Positive, number2Zero) = number2s(n)
      val result2                        = number1.method3(number2Positive)
      println(i, n, result1, counts(result2), result1 == counts(result2))
    }
    for {
      i <- 1 to 8
      n <- 1 to 5
    } {
      val result1                        = MathCount.pow(n, i)
      val number1                        = number1t(i)
      val (number2Positive, number2Zero) = number2t(n)
      val result2                        = number1.method3(number2Positive)
      println(i, n, result1, countt(result2), result1 == countt(result2))
    }
  }

}
