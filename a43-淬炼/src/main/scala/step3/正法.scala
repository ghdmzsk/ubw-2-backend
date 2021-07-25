package step3

class 正法(tail: () => NumR, head: Item) extends NumR {
  override def methodL(num: NumL, item: Item): Result = ResultP(tail().methodL(num, item), head)
}
object 正法 {
  def apply(tail: => NumR, head: Item): NumR = new 正法(() => tail, head)
}
