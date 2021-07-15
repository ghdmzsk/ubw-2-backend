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

case class BlackTree(left: Number1, f: 法, right: Number1) extends 黑树 {
  override def 计算: Result = f.计算(双白树(left = left, right = right))
}

trait 白树 {
  def 向右获取(tree: 法): Result
}
case class 双白树(left: Number1, right: Number1) extends 白树 {
  override def 向右获取(tree: 法): Result = 
}

trait 法 {
  def 计算(tree: 白树): Result
}