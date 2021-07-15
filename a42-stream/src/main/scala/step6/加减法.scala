package step6

case class Item(name: String)

trait Result
case class ResultP(tail: Result, item: Item) extends Result {
  override def toString: String = s"($tail, ${item.name})"
}
case object ResultZero extends Result {
  override def toString: String = "Zero"
}

trait Number1 {
  def 被索取(tree: 法半树): Result
}
case class Number1P(tail: Number1, item: Item) extends Number1 {
  override def 被索取(tree: 法半树): Result = tree.接受索取回馈(tail, item)
}
case object Nubmer1Zero extends Number1 {
  override def 被索取(tree: 法半树): Result = tree.没有索取回馈
}

trait 白树 {
  def 向右获取(f: 向右法): Result
  def 向左获取(f: 向左法): Result
}
case class 双白树(left: Number1, right: Number1) extends 白树 {
  override def 向右获取(f: 向右法): Result = right.被索取(剩下左法半树(f = f, left = left))
  override def 向左获取(f: 向左法): Result = left.被索取(剩下右法半树(f = f, right = right))
}
case class 左白树(left: Number1) extends 白树 {
  override def 向右获取(f: 向右法): Result = f.右侧没有反馈(this)
  override def 向左获取(f: 向左法): Result = left.被索取(右空法半树(f = f))
}
case class 右白树(right: Number1) extends 白树 {
  override def 向右获取(f: 向右法): Result = right.被索取(左空法半树(f = f))
  override def 向左获取(f: 向左法): Result = f.左侧没有反馈(this)
}
case object 空树 extends 白树 {
  override def 向右获取(f: 向右法): Result = f.右侧没有反馈(空树)
  override def 向左获取(f: 向左法): Result = f.左侧没有反馈(空树)
}

trait 法半树 {
  def 接受索取回馈(number1: Number1, item: Item): Result
  def 没有索取回馈: Result
}
case class 剩下左法半树(f: 向右法, left: Number1) extends 法半树 {
  def 接受索取回馈(number1: Number1, item: Item): Result = f.右侧反馈(双白树(left = left, right = number1), item)
  def 没有索取回馈: Result                               = f.右侧没有反馈(左白树(left = left))
}
case class 剩下右法半树(f: 向左法, right: Number1) extends 法半树 {
  def 接受索取回馈(number1: Number1, item: Item): Result = f.左侧反馈(双白树(left = number1, right = right), item)
  def 没有索取回馈: Result                               = f.左侧没有反馈(右白树(right = right))
}
case class 左空法半树(f: 向右法) extends 法半树 {
  def 接受索取回馈(number1: Number1, item: Item): Result = f.右侧反馈(右白树(right = number1), item)
  def 没有索取回馈: Result                               = f.右侧没有反馈(空树)
}
case class 右空法半树(f: 向左法) extends 法半树 {
  def 接受索取回馈(number1: Number1, item: Item): Result = f.左侧反馈(左白树(left = number1), item)
  def 没有索取回馈: Result                               = f.左侧没有反馈(空树)
}

trait 向左法 {
  def 左侧反馈(tree: 白树, item: Item): Result
  def 左侧没有反馈(tree: 白树): Result
}
trait 向右法 {
  def 右侧反馈(tree: 白树, item: Item): Result
  def 右侧没有反馈(tree: 白树): Result
}

case object 加法 extends 向左法 with 向右法 {
  override def 右侧反馈(tree: 白树, item: Item): Result = ResultP(tree.向右获取(加法), item)
  override def 右侧没有反馈(tree: 白树): Result           = tree.向左获取(加法)
  override def 左侧反馈(tree: 白树, item: Item): Result = ResultP(tree.向左获取(加法), item)
  override def 左侧没有反馈(tree: 白树): Result           = ResultZero
}

case object 减法 extends 向右法 with 向左法 {
  override def 右侧反馈(tree: 白树, item: Item): Result = tree.向左获取(有暂存减法(item))
  override def 右侧没有反馈(tree: 白树): Result           = tree.向左获取(减法)
  override def 左侧反馈(tree: 白树, item: Item): Result = ResultP(tree.向右获取(减法), item)
  override def 左侧没有反馈(tree: 白树): Result           = ResultZero
}
case class 有暂存减法(item: Item) extends 向左法 {
  override def 左侧反馈(tree: 白树, item: Item): Result = tree.向右获取(减法)
  override def 左侧没有反馈(tree: 白树): Result           = ResultZero
}

object Number {
  def count(b: 白树, f: 向右法): Result = b.向右获取(f)
}
