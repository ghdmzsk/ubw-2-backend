package step3

trait 微法 extends NumR {
  def tail: NumR
  override def methodL(num: NumL, item: Item): Result = tail.methodL(num, item)
}
object 微法 {
  def apply(tail: => NumR): NumR = {
    def tail1 = tail
    new 微法 {
      override def tail: NumR = tail1
    }
  }
}
