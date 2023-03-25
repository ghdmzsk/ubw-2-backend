package a74.step1

object Runner {

  lazy val number1Zero: Number1 = Number1T(() => number1Zero)
  lazy val number2Zero: Number2 = Number2T(() => number2Zero)

  def gen1(n: Int): Number1 = if (n > 0) Number1S(gen1(n - 1)) else number1Zero
  def countNum1(num: Number1): Int = num match
    case Number1S(tail) => countNum1(tail) + 1
    case Number1T(_)    => 0

  def gen2_1(n: Int): Number2 = if (n > 0) Number2S(gen2_1(n - 1)) else number2Zero
  def countNum2_1(num: Number2): Int = num match
    case Number2S(tail) => countNum2_1(tail) + 1
    case Number2T(_)    => 0

  def countNum3(num: Number3): Int = num match
    case Number3S(tail) => countNum3(tail) + 1
    case Number3T       => 0

  def main(arr: Array[String]): Unit = {
    for {
      i1 <- 1 to 20
      i2 <- 1 to 20
    } {
      val num1   = gen1(i1)
      val num2   = gen2_1(i2)
      val num3   = num2.method2(num1)
      val num4   = num1.method1(num2)
      val count1 = countNum1(num1)
      val count2 = countNum2_1(num2)
      val count3 = countNum3(num3)
      val count4 = countNum3(num4)
      assert(count1 == i1)
      assert(count2 == i2)
      assert(count3 == i1 + i2 + 1)
      assert(count4 == i1 + i2)
    }
  }

}
