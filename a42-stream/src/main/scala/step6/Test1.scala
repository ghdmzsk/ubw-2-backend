case class Item(name: String)

trait Result
case class ResultPositive(tail: Result, item: Item) {
  override def toString: String = s"($tail, $item)"
}
case object ResultZero {
  override def toString: String = "Zero"
}

trait Number1
case class Number1Positive(tail: Number1, item: Item) extends Number1
case object Nubmer1Zero extends Number1

trait 黑树 {
  def 计算: Result
}

trait 白树 {
  def 向右获取(tree: 法): Result
}

trait 法 {
  def 计算(tree: 白树): Result
}