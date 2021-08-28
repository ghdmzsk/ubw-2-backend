package part3

trait 风 extends NumR {
  def tail: NumR
  override def methodL(num: NumL): Result = {
    Utils.appendLeft(num, 左正(null))
    tail.methodL(num)
  }
}
object 风 {
  def apply(tail1: => NumR): NumR = new 风 {
    override def tail: NumR = tail1
  }
}
