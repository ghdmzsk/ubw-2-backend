package a62.减法

object Runner {
  def number1gen(n: Int): Number1 = n match {
    case n1 if n1 > 0 => Number1S(number1gen(n1 - 1))
    case 0            => Number1T
  }
  def number2gen(n: Int): Number2 = n match {
    case n2 if n2 > 0 => Number2S(number2gen(n2 - 1))
    case 0            => Number2T
  }
  def count(number1: Number1): Int = number1 match {
    case Number1S(tail) => count(tail) + 1
    case Number1T       => 0
  }

  def main(arr: Array[String]): Unit = {
    {
      val number1 = number1gen(159448)
      val number2 = number2gen(345)
      assert(count(number2.method2(number1)) == 159448 - 345)
    }
  }
}
