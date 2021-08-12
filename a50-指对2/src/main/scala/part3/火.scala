package part3

trait 火 extends NumR {
  def tail: NumR
  override def methodL(num: NumL): Result = ResultP(tail.methodL(num))
}
object 火 {
  def apply(tail1: => NumR): NumR = new 火 {
    override def tail: NumR = tail1
  }
}
