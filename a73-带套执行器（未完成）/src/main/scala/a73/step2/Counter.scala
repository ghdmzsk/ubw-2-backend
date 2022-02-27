package a73.step2

trait Stream[+T]
case class PosotiveStream[+T](head: () => T, tail: () => Stream[T]) extends Stream[T]
case object ZeroStream extends Stream[Nothing]


object Stream {
  def unfold[S, A](s: S)(f: S => Option[(A, S)]): Stream[A] = f(s) match {
    case Some((a, next)) => PosotiveStream(() => a, () => unfold(next)(f))
    case None => ZeroStream
  }
}

trait Number1
case class Number1Positive(head: String, tail: Number1) extends Number1
case object Number1Zero extends Number1
case class Number1Some(override val head: String) extends Number1Positive(head, Number1Zero)

trait Number2
case class Number2Positive(flatMap: String => Number2) extends Number2
case class Number2Zero(pure: String) extends Number2
case class Number2Map(map: String => String) extends Number2Positive(t => Number2Zero(map(t)))

trait Number3
case class Number3S(head: Number2, tail: Number3) extends Number3
case class Number3T(head: Number2) extends Number3