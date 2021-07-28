package step3

trait 正法 extends NumR {
  def tail: NumR
  def head: Item
  override def methodL(num: NumL, item: Item): Result = ResultP(tail.methodL(num, item), head)
}
object 正法 {
  def apply(tail: => NumR, head: Item): NumR = {
    def tail1 = tail
    val head1 = head
    new 正法 {
      override def tail: NumR = tail1
      override def head: Item = head1
    }
  }
}
