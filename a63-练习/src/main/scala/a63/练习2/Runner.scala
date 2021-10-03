package a63.练习2

object Runner {

  def main(arr: Array[String]): Unit = {
    {
      val number1 =
        Number1S(Number1S(Number1S(Number1S(Number1S(Number1S(Number1S(Number1S(Number1S(Number1T(), 1), 2), 3), 4), 5), 6), 7), 8), 9)
      val number2 = Number2S(Number2S(Number2S(Number2T(), 10), 11), 12)
      assert(number2.method2(number1) == Number1S(Number1S(Number1S(Number1S(Number1S(Number1S(Number1T(), 1), 2), 3), 4), 5), 6))
      println(number2.method2(number1))
    }
    {
      val number1 = Number1S(Number1S(Number1S(Number1S(Number1T(), 1), 2), 3), 4)
      val number2 = Number2S(Number2S(Number2S(Number2T(), 1), 2), 3)
      assert(number2.method2(number1) == Number1S(Number1T(), 1))
      println(number2.method2(number1))
    }
    {
      val number1 = Number1S(Number1S(Number1S(Number1S(Number1T(), 1), 2), 3), 4)
      val number2 = Number2S(Number2S(Number2S(Number2S(Number2S(Number2S(Number2S(Number2T(), 1), 2), 3), 4), 5), 6), 7)
      assert(number2.method2(number1) == Number1T())
      println(number2.method2(number1))
    }
  }

}
