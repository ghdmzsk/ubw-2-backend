package a67.练习

object Runner {

  def count(number2: () => Number2): Int = {
    val value =
      try {
        Option(number2())
      } catch {
        case _: StackOverflowError => Option.empty
      }
    value match {
      case Some(Number2S(v)) => count(v) + 1
      case None              => 0
    }
  }

  def 被加数加数(n: Long): Number1 = n match {
    case n1 if n1 > 0  => Number1T(() => 被加数加数(n1 - 1))
    case n1 if n1 <= 0 => Number1U(() => 被加数加数(n1 - 1))
  }
  def 被减数被乘数被除数(n: Long): Number1 = n match {
    case n1 if n1 > 0  => Number1U(() => 被减数被乘数被除数(n1 - 1))
    case n1 if n1 <= 0 => Number1S(() => 被减数被乘数被除数(n1 - 1))
  }
  def 减数(n: Long): Number1 = n match {
    case n1 if n1 > 0  => Number1U(() => 减数(n1 - 1))
    case n1 if n1 <= 0 => Number1V(() => 减数(n1 - 1))
  }
  def 乘数(n: Long): (Number1, Number1) = {
    def gen(n1: Long, zero: => Number1): Number1 = n1 match {
      case n2 if n2 > 0 => Number1T(() => gen(n2 - 1, zero))
      case 0            => zero
    }
    lazy val number1t: Number1 = gen(n, number1u)
    lazy val number1u: Number1 = Number1U(() => number1t)
    (number1t, number1u)
  }
  def 除数(n: Long): (Number1, Number1) = {
    def gen(n1: Long, zero: => Number1): Number1 = n1 match {
      case n2 if n2 > 0 => Number1U(() => gen(n2 - 1, zero))
      case 0            => zero
    }
    lazy val number1u: Number1 = gen(n, number1t)
    lazy val number1t: Number1 = Number1T(() => number1u)
    (number1u, number1t)
  }

  def main(arr: Array[String]): Unit = {
    for {
      i1 <- 0 to 20
      i2 <- 0 to 20
    } {
      val number1 = 被加数加数(i1)
      val number2 = 被加数加数(i2)

      {
        def number3 = number1.method1(number2)
        val count1  = count(() => number3)
        assert(count1 == i1 + i2)
      }
      {
        def number3 = number2.method1(number1)
        val count1  = count(() => number3)
        assert(count1 == i1 + i2)
      }
    }
    for {
      i1 <- 0 to 20
      i2 <- 0 to 20
    } {
      val number1 = 被减数被乘数被除数(i1)
      val number2 = 减数(i2)
      def number3 = number1.method1(number2)
      val count1  = count(() => number3)
      val count2  = if (i1 >= i2) i1 - i2 else 0
      assert(count1 == count2)
    }
    for {
      i1 <- 0 to 20
      i2 <- 0 to 20
    } {
      val number1                        = 被减数被乘数被除数(i1)
      val (number2Positive, number2Zero) = 乘数(i2)

      {
        def number3 = number1.method1(number2Positive)
        val count1  = count(() => number3)
        assert(count1 == i1 * i2)
      }
      {
        def number3 = number2Zero.method1(number1)
        val count1  = count(() => number3)
        assert(count1 == i1 * i2)
      }
    }
    for {
      i1 <- 0 to 5
      i2 <- 1 to 20
      i3 <- 0 to i2 - 1
    } {
      val number1                        = 被减数被乘数被除数(i1 * i2 + i3)
      val (number2Positive, number2Zero) = 除数(i2)

      {
        def number3 = number1.method1(number2Zero)
        val count1  = count(() => number3)
        val count2  = if (i3 > 0) i1 + 1 else i1
        assert(count1 == count2)
      }
      {
        def number3 = number2Positive.method1(number1)
        val count1  = count(() => number3)
        assert(count1 == i1)
      }
    }
  }

}
