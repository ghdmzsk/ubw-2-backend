package a65.加减乘除法

object Runner {

  def number1gen(n: Int): Number1 = n match {
    case n1 if n1 > 0 => Number1S(number1gen(n1 - 1))
    case 0            => Number1T
  }

  def 加数(n: Int): Number2 = n match {
    case n1 if n1 > 0 => Number2S(() => 加数(n1 - 1))
    case 0            => Number2U
  }

  def 减数(n: Int): Number2 = n match {
    case n1 if n1 > 0 => Number2T(() => 减数(n1 - 1))
    case 0            => Number2U
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
    case Number1S(tail) => count(tail) + 1
    case Number1T       => 0
  }

  def main(arr: Array[String]): Unit = {
    {
      val number1 = number1gen(25)
      val number2 = 加数(32)
      val result  = number2.method2(number1)
      assert(count(result) == 25 + 32)
    }
    {
      val number1 = number1gen(25)
      val number2 = 减数(32)
      val result  = number2.method2(number1)
      assert(count(result) == 0)
    }
    {
      val number1 = number1gen(25)
      val number2 = 减数(25)
      val result  = number2.method2(number1)
      assert(count(result) == 0)
    }
    {
      val number1 = number1gen(25)
      val number2 = 减数(24)
      val result  = number2.method2(number1)
      assert(count(result) == 25 - 24)
    }
    {
      val number1 = number1gen(28)
      val number2 = 减数(24)
      val result  = number2.method2(number1)
      assert(count(result) == 28 - 24)
    }
    {
      val number1                        = number1gen(28)
      val (number2Positive, number2Zero) = 乘数(24)
      val result                         = number2Zero.method2(number1)
      assert(count(result) == 28 * 24)
    }
    {
      val number1                        = number1gen(28)
      val (number2Positive, number2Zero) = 乘数(24)
      val result                         = number1.method1(number2Positive)
      assert(count(result) == 28 * 24)
    }
    {
      val number1                        = number1gen(28 * 24 + 3)
      val (number2Positive, number2Zero) = 除数(24)
      val result                         = number2Positive.method2(number1)
      assert(count(result) == 28)
    }
    {
      val number1                        = number1gen(28 * 24)
      val (number2Positive, number2Zero) = 除数(24)
      val result                         = number2Positive.method2(number1)
      assert(count(result) == 28)
    }
    {
      val number1                        = number1gen(28 * 24 + 3)
      val (number2Positive, number2Zero) = 除数(24)
      val result                         = number1.method1(number2Zero)
      assert(count(result) == 29)
    }
    {
      val number1                        = number1gen(28 * 24)
      val (number2Positive, number2Zero) = 除数(24)
      val result                         = number1.method1(number2Zero)
      assert(count(result) == 28)
    }
  }

}
