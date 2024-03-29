package 除法

object Runner {

  def number1阳(n: Int): Number1 = {
    def gen(n1: Int, zero: => Number1): Number1 = n1 match {
      case n1 if n1 > 0 => Number1S(gen(n1 - 1, zero))
      case 0            => zero
    }
    lazy val num1: Number1 = gen(n, num2)
    lazy val num2: Number1 = Number1T(() => num1)
    num1
  }
  def number1阴(n: Int): Number1 = {
    def gen(n1: Int, zero: => Number1): Number1 = n1 match {
      case n1 if n1 > 0 => Number1S(gen(n1 - 1, zero))
      case 0            => zero
    }
    lazy val num1: Number1 = gen(n, num2)
    lazy val num2: Number1 = Number1T(() => num1)
    num2
  }
  def number2FromInt(n: Int): Number2 = n match {
    case n1 if n1 > 0 => Number2S(number2FromInt(n1 - 1))
    case 0            => Number2T
  }
  def count(num: Number3): Int = num match {
    case Number3S(tail) => count(tail) + 1
    case Number3T       => 0
  }

  def main(args: Array[String]): Unit = {
    val number1 = 5
    for (i <- 1 to number1 + 1000) {
      if (i % 5 == 0) {
        // 整除，上舍法和下舍法结果一样
        val r1 = count(number1阳(number1).method1(number2FromInt(i)))
        val r2 = count(number2FromInt(i).method2(number1阴(number1)))
        assert(r2 == r1)
        assert(r2 >= 1)
      } else {
        // 有余数，上舍法和下舍法结果差一
        val r1 = count(number1阳(number1).method1(number2FromInt(i)))
        val r2 = count(number2FromInt(i).method2(number1阴(number1)))
        assert(r2 - r1 == 1)
        assert(r2 >= 1)
      }
    }
  }
}
