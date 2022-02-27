package a74.step1

object Runner {

  def main(arr: Array[String]): Unit = {
    lazy val number1: Number1 = Number1S(
      Number1S(Number1S(number1Zero, Number2S(number2Zero, Number1S(number1Zero, number2Zero))), number2Zero),
      Number2S(Number2S(number2Zero, number1Zero), Number1S(number1Zero, number2Zero))
    )

    lazy val number2: Number2 = Number2S(Number2S(Number2S(number2Zero, number1Zero), number1Zero), Number1S(number1Zero, number2Zero))

    lazy val number1Zero: Number1 = Number1T(() => number2)

    lazy val number2Zero: Number2 = Number2T(() => number1)

    println(number1)
  }

}
