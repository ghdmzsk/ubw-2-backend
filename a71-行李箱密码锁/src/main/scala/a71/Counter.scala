package a71

trait Number1 {
  def method1(number2: Number2): Number3
}
case class Number1S(tail: Number1) extends Number1 {
  override def method1(number2: Number2): Number3 = Number3T
}
case object Number1T extends Number1 {
  override def method1(number2: Number2): Number3 = Number3T
}

trait Number2
case class Number2S(tail: Number2)                                       extends Number2
case class Number2T(tailCurrent: () => Number2, tailNext: () => Number2) extends Number2
case class Number2Zero(genTail: () => Number2)                           extends Number2

trait Number3
case class Number3S(tail: Number3) extends Number3
case object Number3T               extends Number3
