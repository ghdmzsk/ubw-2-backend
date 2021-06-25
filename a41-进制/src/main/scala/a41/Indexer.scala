package a41

trait Number8 {
  def method9(number1: Number1): Item
}
trait Number9 {
  def method11(number11: Number11, number2: Number2): Item
}
trait Number10 {
  def method12(number2: Number2): Item
}
trait Number11 {
  def method13(number5: Number5): Item
}

trait Number12 {
  self: Number9 =>
  def _0 = Number9Middle0(this)
  def _1 = Number9Middle1(this)
  def _2 = Number9Middle2(this)

  def _0_th = Number8P0(this)
  def _1_th = Number8P1(this)
  def _2_th = Number8P2(this)
}

case class Number8P0(tail: Number9) extends Number8 {
  override def method9(number1: Number1): Item = number1 match {
    case Number1PSimple3(_, _, t) => tail.method11(Number11Bottom0, t)
  }
}
case class Number8P1(tail: Number9) extends Number8 {
  override def method9(number1: Number1): Item = number1 match {
    case Number1PSimple3(_, _, t) => tail.method11(Number11Bottom1, t)
  }
}
case class Number8P2(tail: Number9) extends Number8 {
  override def method9(number1: Number1): Item = number1 match {
    case Number1PSimple3(_, _, t) => tail.method11(Number11Bottom2, t)
  }
}

case class Number9Middle0(tail: Number9) extends Number9 with Number12 {
  override def method11(number11: Number11, number2: Number2): Item = number2 match {
    case Number2PDeep3(_, _, t) => tail.method11(Number11Middle0(number11), t)
  }
}
case class Number9Middle1(tail: Number9) extends Number9 with Number12 {
  override def method11(number11: Number11, number2: Number2): Item = number2 match {
    case Number2PDeep3(_, _, t) => tail.method11(Number11Middle1(number11), t)
  }
}
case class Number9Middle2(tail: Number9) extends Number9 with Number12 {
  override def method11(number11: Number11, number2: Number2): Item = number2 match {
    case Number2PDeep3(_, _, t) => tail.method11(Number11Middle2(number11), t)
  }
}

class Number9Bottom1 extends Number9 with Number12 {
  override def method11(tail: Number11, number2: Number2): Item = Number10P1(tail).method12(number2)
}
class Number9Bottom2 extends Number9 with Number12 {
  override def method11(tail: Number11, number2: Number2): Item = Number10P2(tail).method12(number2)
}

case class Number10P1(tail: Number11) extends Number10 {
  override def method12(number2: Number2): Item = number2 match {
    case Number2Zero0(t)        => tail.method13(t)
    case Number2Zero1(t, _)     => tail.method13(t)
    case Number2PDeep3(t, _, _) => tail.method13(t)
  }
}
case class Number10P2(tail: Number11) extends Number10 {
  override def method12(number2: Number2): Item = number2 match {
    case Number2Zero1(_, t)     => tail.method13(t)
    case Number2PDeep3(_, t, _) => tail.method13(t)
  }
}

case class Number11Middle0(tail: Number11) extends Number11 {
  override def method13(number5: Number5): Item = number5 match {
    case Number5Middle0(t)       => tail.method13(t)
    case Number5Middle1(t, _)    => tail.method13(t)
    case Number5Middle2(t, _, _) => tail.method13(t)
  }
}
case class Number11Middle1(tail: Number11) extends Number11 {
  override def method13(number5: Number5): Item = number5 match {
    case Number5Middle1(_, t)    => tail.method13(t)
    case Number5Middle2(_, t, _) => tail.method13(t)
  }
}
case class Number11Middle2(tail: Number11) extends Number11 {
  override def method13(number5: Number5): Item = number5 match {
    case Number5Middle2(_, _, t) => tail.method13(t)
  }
}

case object Number11Bottom0 extends Number11 {
  override def method13(number5: Number5): Item = number5 match {
    case Number5Bottom0(t)       => t
    case Number5Bottom1(t, _)    => t
    case Number5Bottom2(t, _, _) => t
  }
}
case object Number11Bottom1 extends Number11 {
  override def method13(number5: Number5): Item = number5 match {
    case Number5Bottom1(_, t)    => t
    case Number5Bottom2(_, t, _) => t
  }
}
case object Number11Bottom2 extends Number11 {
  override def method13(number5: Number5): Item = number5 match {
    case Number5Bottom2(_, _, t) => t
  }
}

case object _1_th extends Number8 {
  override def method9(number1: Number1): Item = number1 match {
    case Number1PSimple1(t1)       => t1
    case Number1PSimple2(t1, _)    => t1
    case Number1PSimple3(t1, _, _) => t1
  }
}

case object _2_th extends Number8 {
  override def method9(number1: Number1): Item = number1 match {
    case Number1PSimple2(_, t2)    => t2
    case Number1PSimple3(_, t2, _) => t2
  }
}

case object _1 extends Number9Bottom1
case object _2 extends Number9Bottom2
