package a71

object Runner {

  case class Number2TLength3(zero: Number2) extends Number2S(new Number2S(new Number2S(zero)))
  case class Number2TLength3ZPositive(tail: () => Number2, shuTail: () => Number2) extends Number2 {
    override def method2(number1: Number1): Number3 = shuTail().method2(number1)
  }

  def withTail(shuTail: => Number2): Number2 = {
    lazy val number2_1: Number2 = Number2TLength3(number2_2)
    lazy val number2_2: Number2 = Number2TLength3ZPositive(() => number2_1, () => shuTail)
    number2_1
  }

  case object Number2TLength3ZZero extends Number2 {
    override def method2(number1: Number1): Number3 = {
      lazy val number: Number2 = withTail(Number2TLength3ZZero)
      Number3S(number.method2(number1))
    }
  }

}
