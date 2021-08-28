package part3

trait 风 extends NumR {
  def tail: NumR
  override def methodL(num: NumL): Result = tail.methodL(num.入队(左正(左终结)))
}
object 风 {
  def apply(tail1: => NumR): NumR = new 风 {
    override def tail: NumR = tail1
  }
}
