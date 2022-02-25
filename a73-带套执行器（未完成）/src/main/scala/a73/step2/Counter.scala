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