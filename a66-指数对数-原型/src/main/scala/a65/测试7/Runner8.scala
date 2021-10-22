package a65.测试7

object Runner8 {

  def 加数被加数(n: Int): Number1 = {
    lazy val number1s: Number1 = Number1S(() => number1s)
    n match {
      case n1 if n1 > 0 => Number1T(() => 加数被加数(n1 - 1))
      case 0            => number1s
    }
  }
  def 被减数(n: Int): Number1 = {
    lazy val number1u: Number1 = Number1U(() => number1u)
    n match {
      case n1 if n1 > 0 => Number1S(() => 被减数(n1 - 1))
      case 0            => number1u
    }
  }
  def 减数(n: Int): Number1 = {
    lazy val number1v: Number1 = Number1V(() => number1v)
    n match {
      case n1 if n1 > 0 => Number1S(() => 减数(n1 - 1))
      case 0            => number1v
    }
  }
  def 被乘数被除数(n: Int): Number1 = {
    lazy val number1u: Number1 = Number1U(() => number1u)
    n match {
      case n1 if n1 > 0 => Number1S(() => 被乘数被除数(n1 - 1))
      case 0            => number1u
    }
  }
  def 乘数(n: Int): (Number1, Number1) = {
    def gen(n1: Int, zero: => Number1): Number1 = n1 match {
      case n2 if n2 > 0 => Number1T(() => gen(n2 - 1, zero))
      case 0            => zero
    }
    lazy val number2t: Number1 = gen(n, number2s)
    lazy val number2s: Number1 = Number1S(() => number2t)
    (number2t, number2s)
  }
  def 除数(n: Int): (Number1, Number1) = {
    def gen(n1: Int, zero: => Number1): Number1 = n1 match {
      case n2 if n2 > 0 => Number1S(() => gen(n2 - 1, zero))
      case 0            => zero
    }
    lazy val number2s: Number1 = gen(n, number2t)
    lazy val number2t: Number1 = Number1T(() => number2s)
    (number2s, number2t)
  }

  def count(number3: () => Number3): Int = {
    val result =
      try {
        Option(number3())
      } catch {
        case e: StackOverflowError =>
          Option.empty
      }
    result match {
      case Some(Number3S(tail)) => count(tail) + 1
      case None                 => 0
    }
  }

  def main(arr: Array[String]): Unit = {
    {
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } {
        val number1 = 加数被加数(i1)
        val number2 = 加数被加数(i2)
        def result1 = number1.method1(number2)
        assert(count(() => result1) == i1 + i2)
      }
    }
    {
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } {
        val number1 = 被减数(i1)
        val number2 = 减数(i2)
        def result1 = number1.method1(number2)
        val result2 = if (i1 - i2 >= 0) i1 - i2 else 0
        assert(count(() => result1) == result2)
      }
    }
    {
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } {
        val number1                        = 被乘数被除数(i1)
        val (number2Positive, number2Zero) = 乘数(i2)
        def result1                        = number1.method1(number2Positive)
        def result2                        = number2Zero.method1(number1)
        assert(count(() => result1) == i1 * i2)
        assert(count(() => result2) == i1 * i2)
      }
    }
    {
      for {
        i1 <- 0 to 5
        i2 <- 1 to 20
        i3 <- 0 to i2 - 1
      } {
        val number1                        = 被乘数被除数(i1 * i2 + i3)
        val (number2Positive, number2Zero) = 除数(i2)
        def result1                        = number1.method1(number2Zero)
        def result2                        = number2Positive.method1(number1)
        val result3                        = if (i3 == 0) i1 else i1 + 1
        assert(count(() => result1) == result3)
        assert(count(() => result2) == i1)
      }
    }
  }

}
