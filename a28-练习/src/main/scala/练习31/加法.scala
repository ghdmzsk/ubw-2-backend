package 练习31

case class Item(name: String) {
  override def toString: String = name
}

trait Result
case class ResultP(tail: Result, head: Item) extends Result {
  println("result: " + head)
}
case object ResultO extends Result {
  println("result: " + this)
}

trait Plus {
  def plus(result: Result): Result
}
case class PlusP(tail: Plus, head: Item) extends Plus {
  def plus(result: Result): Result = {
    println("method: " + head)
    ResultP(tail.plus(result), head)
  }
}
case object PlusO extends Plus {
  def plus(result: Result): Result = result
}
