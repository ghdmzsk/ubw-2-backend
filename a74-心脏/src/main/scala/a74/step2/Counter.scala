package a74.step2

trait Number1[S, T]
case class Number1S[S, T, A](tail: Number1[S, A], head: Number2[T, A]) extends Number1[S, T]
case class Number1T[S, T](tail: S => T, head: T => S)                  extends Number1[S, T]

trait Number2[S, T]
case class Number2S[S, T, A](tail: Number2[A, T], head: Number1[A, S]) extends Number2[S, T]
case class Number2T[S, T](tail: T => S, head: S => T)                  extends Number2[S, T]

object Number12 {

  /*def reverseNumber1[S, T](number1: Number1[S, T]): Number2[S, T] = number1 match {
    case Number1S(tail, head) => Number2S(head, tail)
    case Number1T(tail, head) => Number2T(head, tail)
  }

  def reverseNumber2[S, T](number2: Number2[S, T]): Number1[S, T] = number2 match {
    case Number2S(tail, head) => Number1S(head, tail)
    case Number2T(tail, head) => Number1T(head, tail)
  }*/

  def execNumber1[S, T](number1: Number1[S, T]): Number3[S, T] = number1 match {
    case Number1S(tail, head) => Number3S(execNumber1(tail), execNumber2(head))
    case Number1T(tail, _)    => Number3T(tail)
  }

  def execNumber2[S, T](number2: Number2[S, T]): Number3[T, S] = number2 match {
    case Number2S(tail, head) => Number3S(execNumber2(tail), execNumber1(head))
    case Number2T(tail, _)    => Number3T(tail)
  }

  def reverseExecNumber1[S, T](number1: Number1[S, T]): Number3[T, S] = number1 match {
    case Number1S(tail, head) => Number3S(reverseExecNumber2(head), reverseExecNumber1(tail))
    case Number1T(_, head)    => Number3T(head)
  }

  def reverseExecNumber2[S, T](number2: Number2[S, T]): Number3[S, T] = number2 match {
    case Number2S(tail, head) => Number3S(reverseExecNumber1(head), reverseExecNumber2(tail))
    case Number2T(_, head)    => Number3T(head)
  }

}

trait Number3[-S, +T] {
  def func(s: S): T
}
case class Number3S[-S, +T, A](head: Number3[S, A], tail: Number3[A, T]) extends Number3[S, T] {
  override def func(s: S): T = tail.func(head.func(s))
}
case class Number3T[S, T](tail: S => T) extends Number3[S, T] {
  def func(s: S): T = tail(s)
}
