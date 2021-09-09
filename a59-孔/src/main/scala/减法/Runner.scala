package 减法

object Runner {

  def number1FromInt(n: Int): Number1 = n match {
    case n1 if n1 > 0 => Number1S(number1FromInt(n1 - 1))
    case 0            => Number1T
  }
  def number2FromInt(n: Int): Number2 = n match {
    case n1 if n1 > 0 => Number2S(number2FromInt(n1 - 1))
    case 0            => Number2T
  }
  def count(num: Number2): Int = num match {
    case Number2S(tail) => count(tail) + 1
    case Number2T       => 0
  }

  def main(args: Array[String]): Unit = {
    val number1 = 5
    for (i <- number1 + 1 to number1 + 100) {
      val r1 = count(number1FromInt(number1).method1(number2FromInt(i)))
      val r2 = count(number2FromInt(i).method2(number1FromInt(number1)))
      assert(r1 - r2 == 1)
      assert(r1 >= 1)
      assert(r2 >= 0)
    }
  }
}
