package step3

trait 逆法 extends NumR {
  def tail: NumR
  override def methodL(num: NumL, item: Item): Result = num.methodR(tail)
}
object 逆法 {
  def apply(tail: => NumR): NumR = {
    def tail1 = tail
    new 逆法 {
      override def tail: NumR = tail1
    }
  }
}
