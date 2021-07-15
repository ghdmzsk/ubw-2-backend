package step6

case class Item(name: String)

trait Result
case class ResultPositive(tail: Result, item: Item) {
  override def toString: String = s"($tail, $item)"
}
case object ResultZero {
  override def toString: String = "Zero"
}

trait Number1 {
  def 被索取(tree: 法半树): Result
}
case class Number1Positive(tail: Number1, item: Item) extends Number1 {
  override def 被索取(tree: 法半树): Result = tree.接受索取回馈(tail, item)
}
case object Nubmer1Zero extends Number1 {
  override def 被索取(tree: 法半树): Result = tree.没有索取回馈
}

trait 黑树 {
  def 计算: Result
}

case class BlackTree(left: Number1, f: 法, right: Number1) extends 黑树 {
  override def 计算: Result = f.右侧请求(双白树(left = left, right = right))
}

trait 白树 {
  def 向右获取(f: 法): Result
}
case class 双白树(left: Number1, right: Number1) extends 白树 {
  override def 向右获取(f: 法): Result = right.被索取(左法半树(f = f, left = left))
}
case class 左白树(left: Number1) extends 白树 {
  override def 向右获取(f: 法): Result = left.被索取(左法半树(f = f, left = left))
}

trait 法半树 {
  def 接受索取回馈(number1: Number1, item: Item): Result
  def 没有索取回馈: Result
}
case class 左法半树(f: 法, left: Number1) exntends 法半树 {
  def 接受索取回馈(number1: Number1, item: Item): Result = f.右侧反馈(双白树(left = left, right = number1), item)
  def 没有索取回馈: Result = f.右侧没有反馈(左白树(left = left))
}
case class 只有法半树(f: 法) exntends 法半树 {
  def 接受索取回馈(number1: Number1, item: Item): Result = ResultPositive(f.计算(左白树(left = left)), item)
  def 没有索取回馈: Result = ResultZero
}

trait 法 {
  def 右侧请求(tree: 白树): Result
  def 右侧反馈(tree: 白树, item: Item): Result
  def 右侧没有反馈(tree: 白树): Result
  def 左侧请求(tree: 白树): Result
  def 左侧反馈(tree: 白树, item: Item): Result
  def 左侧没有反馈(tree: 白树): Result
}

case object 加法 {
  def 右侧请求(tree: 白树): Result
  def 右侧反馈(tree: 白树, item: Item): Result
  def 右侧没有反馈(tree: 白树): Result
  def 左侧请求(tree: 白树): Result
  def 左侧反馈(tree: 白树, item: Item): Result
  def 左侧没有反馈(tree: 白树): Result
}