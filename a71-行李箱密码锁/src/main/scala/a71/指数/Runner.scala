package a71.指数

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
      i1 <- 1 to 5
      i2 <- 2 to 5
    } {
      val result    = number1FromInt(i1).method1(number2FromInt(i2 - 1))
      val numResult = count(result)
      println(s"$i2 ^ $i1 = $numResult")
      assert(numResult == MathCount.pow(底数 = i2, 指数 = i1))

    }
  }

  object MathCount {

    def pow(底数: Int, 指数: Int): Int = {
      var result = 1
      def innerPow(di: Int): Unit = {
        if (di > 0) {
          result *= 底数
          innerPow(di - 1)
        }
      }
      innerPow(指数)
      result
    }

    def log(底数: Int, 真数: Int): Int = {
      var result = 0
      def innerLog(di: Int): Unit = {
        if (di <= 真数) {
          result += 1
          innerLog(di * 底数)
        }
      }
      innerLog(底数)
      result
    }

  }

}
