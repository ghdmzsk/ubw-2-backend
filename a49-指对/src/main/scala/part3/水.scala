package part3

trait 水 extends NumR {
  def tail: NumR
  override def methodL(num: NumL): Result = num.methodR(tail)
}
object 水 {
  def apply(tail1: => NumR): NumR = new 水 {
    override def tail: NumR = tail1
  }
}
