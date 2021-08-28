package step1

object Runner extends App {

  val number1            = Num1P(Num1P(Num1P(Num1P(Num1P(Num1Zero)))))
  lazy val number2: Num2 = Num2P(Num2P(Num2P(number3)))
  lazy val number3       = Num2Zero(() => number2)
  lazy val number4: Num3 = Num3P(Num3P(Num3P(Num3P(Num3P(Num3P(Num3P(number5)))))))
  lazy val number5       = Num3Zero(() => number4)
  lazy val number6: Num4 = Num4P(Num4P(number7, Item("01")), Item("02"))
  lazy val number7       = Num4Zero(() => number6)

  assert(number1.method1(number2, number4, number6).length == 5 * 3 * 7 * 2)

  def numf1(n: Int): Num1 = n match {
    case n1 if n1 > 0 => Num1P(numf1(n1 - 1))
    case 0            => Num1Zero
  }

  def numf2(n: Int): Num2 = {
    def num2(n1: Int, tail: Num2): Num2 = n1 match {
      case n2: Int if n2 > 0 => Num2P(num2(n2 - 1, tail))
      case 0                 => tail
    }
    lazy val num21: Num2 = num2(n, num22)
    lazy val num22       = Num2Zero(() => num21)
    num21
  }

  def numf3(n: Int): Num3 = {
    def num3(n1: Int, tail: Num3): Num3 = n1 match {
      case n2: Int if n2 > 0 => Num3P(num3(n2 - 1, tail))
      case 0                 => tail
    }
    lazy val num31: Num3 = num3(n, num32)
    lazy val num32       = Num3Zero(() => num31)
    num31
  }

  def numf4(n: Int): Num4 = {
    def num4(n1: Int, tail: Num4): Num4 = n1 match {
      case n2: Int if n2 > 0 => Num4P(num4(n2 - 1, tail), Item(s"$n2"))
      case 0                 => tail
    }
    lazy val num41: Num4 = num4(n, num42)
    lazy val num42       = Num4Zero(() => num41)
    num41
  }

  var i: Long = 0
  for {
    i1 <- 0 to 10
    i2 <- 0 to 12
    i3 <- 0 to 10
    i4 <- 0 to 12
  } {
    val num1     = numf1(i1)
    val num2     = numf2(i2)
    val num3     = numf3(i3)
    val num4     = numf4(i4)
    val numleft  = num1.method1(num2, num3, num4).length
    val numright = i1 * i2 * i3 * i4
    assert(numleft == numright)
    i += 1
  }
  println(s"检验了 $i 个结果")

}
