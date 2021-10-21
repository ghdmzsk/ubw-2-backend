package a63.练习2

trait Number1[T] {
  def method1(number2: Number2[T]): Number1[T]
}
case class Number1S[T](tail: Number1[T], head: T) extends Number1[T] {
  override def method1(number2: Number2[T]): Number1[T] = number2.method2(tail)
}
case class Number1T[T]() extends Number1[T] {
  override def method1(number2: Number2[T]): Number1[T] = Number1T()
}

trait Number2[T] {
  def method2(number1: Number1[T]): Number1[T]
}
case class Number2S[T](tail: Number2[T], head: T) extends Number2[T] {
  override def method2(number1: Number1[T]): Number1[T] = number1.method1(tail)
}
case class Number2T[T]() extends Number2[T] {
  override def method2(number1: Number1[T]): Number1[T] = number1
}
