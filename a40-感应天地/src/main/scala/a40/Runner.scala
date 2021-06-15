package a40

import scala.annotation.tailrec

object Runner {

  case class Number2Item1(tail: Number2) extends Number2Positive {
    override def method2(number1: Number1, number2: Number2): Number3 = Number3Positive(
      tail.method2(number1, Number2Item1(Number2Item1(Number2Item1(Number2Item1(number2)))))
    )
  }
  val number2 = Number2Item1(Number2Item1(Number2Item1(Number2Zero)))

  val number1_1 = Number1Positive(Number1Zero)
  val number1_2 = Number1Positive(Number1Positive(Number1Zero))
  val number1_3 = Number1Positive(Number1Positive(Number1Positive(Number1Zero)))
  val number1_4 = Number1Positive(Number1Positive(Number1Positive(Number1Positive(Number1Zero))))
  val number1_5 = Number1Positive(Number1Positive(Number1Positive(Number1Positive(Number1Positive(Number1Zero)))))

  val numberValue1 = Number2Zero

  def valueFormInt(n: Int): Number2 = {
    @tailrec
    def fromInt(n1: Int, num2: Number2): Number2 = {
      n1 match {
        case n2 if n2 > 0 => fromInt(n2 - 1, Number2Item2(num2))
        case 0            => num2
      }
    }
    case class Number2Item2(tail: Number2) extends Number2Positive {
      override def method2(number1: Number1, number2: Number2): Number3 = Number3Positive(
        tail.method2(number1, fromInt(n, number2))
      )
    }
    fromInt(n - 1, Number2Zero)
  }

  def main(arr: Array[String]): Unit = {
    println(Number1Zero.method1(number2).length) // 1
    println(number1_1.method1(number2).length)   // 4
    println(number1_2.method1(number2).length)   // 16
    println(number1_3.method1(number2).length)   // 64
    println(number1_4.method1(number2).length)   // 256
    println(number1_5.method1(number2).length)   // 1024

    println("=" * 10)

    println(Number1Zero.method1(numberValue1).length) // 1
    println(number1_1.method1(numberValue1).length)   // 1
    println(number1_2.method1(numberValue1).length)   // 1
    println(number1_3.method1(numberValue1).length)   // 1
    println(number1_4.method1(numberValue1).length)   // 1
    println(number1_5.method1(numberValue1).length)   // 1

    println("=" * 10)

    println(number1_3.method1(valueFormInt(56)).length) // 175616
  }

}
