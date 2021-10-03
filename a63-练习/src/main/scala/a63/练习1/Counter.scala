package a63.练习1

trait Number1[T]
case class Number1S[T](tail: Number1[T], head: T) extends Number1[T]
case class Number1T[T]()                          extends Number1[T]

trait Number2[T] {
  def method1(number1: Number1[T]): Number1[T]
}
case class Number2S[T](tail: Number2[T], head: T) extends Number2[T] {
  def method1(number1: Number1[T]): Number1[T] = Number1S(tail.method1(number1), head)
}
case class Number2T[T]() extends Number2[T] {
  def method1(number1: Number1[T]): Number1[T] = number1
}
