package a69.test01

object Runner {

  def 被加数_被减数_被乘数_被除数(n: Int): Number1 = if (n > 0) Number1S(被加数_被减数_被乘数_被除数(n - 1)) else Number1T
  def 减数(n: Int): Number2              = if (n > 0) Number2T(() => 减数(n - 1)) else Number2U
  def 乘数_除数(number2s: Int, number2t: Int): (Number2, Number2) = {
    def gens(n2s: Int, zero: => Number2): Number2 = if (n2s > 0) Number2S(() => gens(n2s - 1, zero)) else zero
    def gent(n2t: Int, zero: => Number2): Number2 = if (n2t > 0) Number2T(() => gent(n2t - 1, zero)) else zero

    lazy val num2s: Number2 = gens(number2s, num2t)
    lazy val num2t: Number2 = gent(number2t, num2s)
    (num2s, num2t)
  }
  def count(n: Number1): Int = n match {
    case Number1S(tail) => count(tail) + 1
    case Number1T       => 0
  }

  def main(arr: Array[String]): Unit = {
    {
      val number1 = 被加数_被减数_被乘数_被除数(20)
      val number2 = 减数(10)
      val result1 = number1.method1(number2)
      val result2 = number2.method2(number1)
      val count1  = count(result1._1)
      val count2  = count(result2._1)
      println(count1)
      println(count2)
      println(result1._2)
      println(result2._2)
    }
    {
      val number1                        = 被加数_被减数_被乘数_被除数(25)
      val (number2Positive, number2Zero) = 乘数_除数(34, 1)
      val result1                        = number1.method1(number2Positive)
      val result2                        = number2Zero.method2(number1)
      val result_err_1                   = number1.method1(number2Zero)
      val result_err_2                   = number2Positive.method2(number1)
      val count1                         = count(result1._1)
      val count2                         = count(result2._1)
      val count_err_1                    = count(result_err_1._1)
      val count_err_2                    = count(result_err_2._1)
      println(count1)
      println(count2)
      println(count_err_1)
      println(count_err_2)
      println(result1._2)
      println(result2._2)
      println(result_err_1._2)
      println(result_err_2._2)
    }
    {
      val number1                        = 被加数_被减数_被乘数_被除数(80)
      val (number2Positive, number2Zero) = 乘数_除数(1, 10)
      val result1                        = number1.method1(number2Positive)
      val result2                        = number2Zero.method2(number1)
      val result_err_1                   = number1.method1(number2Zero)
      val result_err_2                   = number2Positive.method2(number1)
      val count1                         = count(result1._1)
      val count2                         = count(result2._1)
      val count_err_1                    = count(result_err_1._1)
      val count_err_2                    = count(result_err_2._1)
      println(count1)
      println(count2)
      println(count_err_1)
      println(count_err_2)
      println(result1._2)
      println(result2._2)
      println(result_err_1._2)
      println(result_err_2._2)
    }
  }

}
