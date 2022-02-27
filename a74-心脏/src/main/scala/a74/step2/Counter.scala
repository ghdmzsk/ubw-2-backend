package a74.step2

trait Number1
case class Number1S(tail: Number1, head: Number2) extends Number1
case class Number1T(tail: () => Number2)          extends Number1

trait Number2
case class Number2S(tail: Number2, head: Number1) extends Number2
case class Number2T(tail: () => Number1)          extends Number2
