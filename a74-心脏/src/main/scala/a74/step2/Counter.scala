package a74.step2

import scala.annotation.tailrec

trait Number1[-S, +T]
case class Number1S[-S, +T](tail: Number1[S, T], head: Number2[T, S]) extends Number1[S, T]
case class Number1T[-S, +T](tail: S => T)                             extends Number1[S, T]

trait Number2[+S, -T]
case class Number2S[+S, -T](tail: Number2[S, T], head: Number1[T, S]) extends Number2[S, T]
case class Number2T[+S, -T](tail: T => S)                             extends Number2[S, T]

trait Number3[-S, +T] {
  def func(s: S): T
}
case class Number3S[-S, +T, A](head: S => A, tail: Number3[A, T]) extends Number3[S, T] {
  override def func(s: S): T = tail.func(head(s))
}
case object Number3T extends Number3[Nothing, Any] {
  def func(s: Nothing): Any = s
}

object Number3 {
  def exec[S, T](number3: Number3[S, T]): S => T = s => execImpl(s, number3)

  @tailrec
  def execImpl[S, T](s: S, number3: Number3[S, T]): T = {
    number3 match {
      case Number3S(head, tail) => execImpl(head(s), tail)
      case b @ Number3T         => b.func(s)
    }
  }
}
