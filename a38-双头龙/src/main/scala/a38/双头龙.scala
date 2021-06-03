package a38

trait Number1
trait Number2

case class Number3_1(tail: Number2) extends Number1
case class Number3_2(tail: Number2) extends Number1

case class Number4_Middle_1(tail: Number2)
case class Number4_Middle_2(tail: Number2)
case class Number4_Middle_3(tail: Number2)

case object Number4_Bottom_1
case object Number4_Bottom_2
case object Number4_Bottom_3