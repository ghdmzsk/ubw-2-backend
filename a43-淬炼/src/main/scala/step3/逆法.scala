package step3

class 逆法(tail: () => NumR) extends NumR {
  override def methodL(num: NumL, item: Item): Result = num.methodR(tail())
}
object 逆法 {
  def apply(tail: => NumR): NumR = new 逆法(() => tail)
}
