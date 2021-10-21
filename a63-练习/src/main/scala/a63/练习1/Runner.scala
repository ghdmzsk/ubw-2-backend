package a63.练习1

object Runner {

  def main(arr: Array[String]): Unit = {
    {
      val number1 = Number1S(Number1S(Number1S(Number1S(Number1S(Number1T(), 1), 2), 3), 4), 5)
      val number2 = Number2S(Number2S(Number2S(Number2S(Number2T(), 6), 7), 8), 9)
      println(number2.method1(number1))
    }
  }

}
