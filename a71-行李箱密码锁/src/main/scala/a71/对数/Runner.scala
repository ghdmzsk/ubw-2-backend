package a71.对数

import a71.MathCount

object Runner {

  def number2FromInt(num: Int): Number2 = {
    lazy val genTailNext1: Number2Bottom => Number2 = num2 => {
      def number2(n: Int, zero: => Number2): Number2 = if (n > 0) Number2S(number2(n - 1, zero)) else zero
      lazy val n2Zero: Number2                       = Number2T(tailNext = () => num2, genTailNext = genTailNext1)
      number2(num, n2Zero)
    }

    lazy val genTailNext2: Number2Bottom => Number2Bottom = num2 => {
      def number2(n: Int, zero: => Number2Bottom): Number2Bottom = if (n > 0) Number2SBottom(number2(n - 1, zero)) else zero
      lazy val n2Zero: Number2Bottom                             = Number2TBottom(tailNext = () => num2, genTailNext = genTailNext2)
      number2(num, n2Zero)
    }

    lazy val numZero: Number2Bottom = Number2Zero(() => genTailNext2(numZero))
    genTailNext1(numZero)
  }

  def number1FromInt(num: Int): Number1 = if (num > 0) Number1S(number1FromInt(num - 1)) else Number1T
  def count(number: Number4): Int = number match {
    case Number4S(tail) => count(tail) + 1
    case Number4T       => 0
  }

  def main(arr: Array[String]): Unit = {
    for {
      i1 <- 0 to 600
      i2 <- 2 to 20
    } {
      val result    = number1FromInt(i1).method1(number2FromInt(i2 - 1))
      val numResult = count(result)
      assert(numResult == MathCount.log(底数 = i2, 真数 = i1))
    }
  }

}
