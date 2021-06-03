package a38

case class Value(value: Int, literal: String)

trait Number1 {
  def value: Value
}

case class Number3_1(tail: Number1) extends Number1 {
  override def value: Value = {
    val lit    = "1" + tail.value.literal
    val length = Number5.len(tail)
    Value(value = math.pow(3, length).toInt + tail.value.value, literal = lit)
  }
}
case class Number3_2(tail: Number1) extends Number1 {
  override def value: Value = {
    val lit    = "2" + tail.value.literal
    val length = Number5.len(tail)
    Value(value = math.pow(3, length).toInt * 2 + tail.value.value, literal = lit)
  }
}

case class Number4_Middle_1(tail: Number1) extends Number1 {
  override def value: Value = {
    val lit    = "0" + tail.value.literal
    val length = Number5.len(tail)
    Value(value = tail.value.value, literal = lit)
  }
}
case class Number4_Middle_2(tail: Number1) extends Number1 {
  override def value: Value = {
    val lit    = "1" + tail.value.literal
    val length = Number5.len(tail)
    Value(value = math.pow(3, length).toInt + tail.value.value, literal = lit)
  }
}
case class Number4_Middle_3(tail: Number1) extends Number1 {
  override def value: Value = {
    val lit    = "2" + tail.value.literal
    val length = Number5.len(tail)
    Value(value = math.pow(3, length).toInt * 2 + tail.value.value, literal = lit)
  }
}

case object Number4_Bottom_1 extends Number1 {
  override def value: Value = Value(value = 0, literal = "0")
}
case object Number4_Bottom_2 extends Number1 {
  override def value: Value = Value(value = 1, literal = "1")
}
case object Number4_Bottom_3 extends Number1 {
  override def value: Value = Value(value = 2, literal = "2")
}

object Number5 {
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
