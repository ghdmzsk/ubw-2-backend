package a38

case class Value(value: Int, literal: String)

trait Number1

case class Number3_1(tail: Number1) extends Number1
case class Number3_2(tail: Number1) extends Number1

case class Number4_Middle_1(tail: Number1) extends Number1
case class Number4_Middle_2(tail: Number1) extends Number1
case class Number4_Middle_3(tail: Number1) extends Number1

case object Number4_Bottom_1 extends Number1
case object Number4_Bottom_2 extends Number1
case object Number4_Bottom_3 extends Number1

object Number5 {

  def pow(i1: Int, i2: Int): Int = i2 match {
    case i3 if i3 > 1 => pow(i1, i3 - 1) * i1
    case 1            => i1
  }

  def value(num: Number1): Int = num match {
    case Number3_1(tail)        => pow(3, len(tail)) + value(tail)
    case Number3_2(tail)        => pow(3, len(tail)) * 2 + value(tail)
    case Number4_Middle_1(tail) => value(tail)
    case Number4_Middle_2(tail) => pow(3, len(tail)) + value(tail)
    case Number4_Middle_3(tail) => pow(3, len(tail)) * 2 + value(tail)
    case Number4_Bottom_1       => 0
    case Number4_Bottom_2       => 1
    case Number4_Bottom_3       => 2
  }

  def str(num: Number1): String = num match {
    case Number3_1(tail)        => s"1${str(tail)}"
    case Number3_2(tail)        => s"2${str(tail)}"
    case Number4_Middle_1(tail) => s"0${str(tail)}"
    case Number4_Middle_2(tail) => s"1${str(tail)}"
    case Number4_Middle_3(tail) => s"2${str(tail)}"
    case Number4_Bottom_1       => "0"
    case Number4_Bottom_2       => "1"
    case Number4_Bottom_3       => "2"
  }

  def len(num: Number1): Int = num match {
    case Number3_1(tail)        => len(tail) + 1
    case Number3_2(tail)        => len(tail) + 1
    case Number4_Middle_1(tail) => len(tail) + 1
    case Number4_Middle_2(tail) => len(tail) + 1
    case Number4_Middle_3(tail) => len(tail) + 1
    case Number4_Bottom_1       => 1
    case Number4_Bottom_2       => 1
    case Number4_Bottom_3       => 1
  }

  def method1(number1: Number1): Number1 = {
    number1 match {
      case Number3_1(tail) =>
        method1(tail) match {
          case Number3_1(tail) => Number3_2(tail)
          case i               => Number3_1(i)
        }
      case Number3_2(tail) =>
        method1(tail) match {
          case Number3_1(tail) => Number3_1(Number4_Middle_1(tail))
          case i               => Number3_2(i)
        }
      case Number4_Middle_1(tail) =>
        method1(tail) match {
          case Number3_1(tail) => Number4_Middle_2(tail)
          case i               => Number4_Middle_1(i)
        }
      case Number4_Middle_2(tail) =>
        method1(tail) match {
          case Number3_1(tail) => Number4_Middle_3(tail)
          case i               => Number4_Middle_2(i)
        }
      case Number4_Middle_3(tail) =>
        method1(tail) match {
          case Number3_1(tail) => Number3_1(Number4_Middle_1(tail))
          case i               => Number4_Middle_3(i)
        }
      case Number4_Bottom_1 => Number4_Bottom_2
      case Number4_Bottom_2 => Number4_Bottom_3
      case Number4_Bottom_3 => Number3_1(Number4_Bottom_1)
    }
  }

}
