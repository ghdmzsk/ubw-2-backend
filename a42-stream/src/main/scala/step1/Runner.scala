package step1

object Runner extends App {

  val number1 = FirstNumberPositive(FirstNumberPositive(FirstNumberPositive(FirstNumberZero)))
  val number2 = Number4Positive(Number4Positive(Number4Positive(Number4Positive(Number4Zero))))

  val count = StreamPositive(StreamPositive(StreamPositive(StreamPositive(StreamZero, number1), number2), number2), number2)

  println(count.run)

}
