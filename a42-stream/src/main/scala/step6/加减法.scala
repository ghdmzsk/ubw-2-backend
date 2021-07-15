package step6

case class Item(name: String)

trait Result
case class ResultP(tail: Result, item: Item) extends Result {
  override def toString: String = s"($tail, ${item.name})"
}
case object ResultZero extends Result {
  override def toString: String = "Zero"
}

trait Number1L {
  def 被索取(tree: 欠左法半树): Result
  def 被左法索取(tree: 向左法): Result
}
case class Number1PL(tail: Number1L, item: Item) extends Number1L {
  override def 被索取(tree: 欠左法半树): Result = tree.接受索取回馈(tail, item)
  override def 被左法索取(f: 向左法): Result    = f.左侧数反馈(tail, item)
}
case object Nubmer1ZeroL extends Number1L {
  override def 被索取(tree: 欠左法半树): Result = tree.没有索取回馈
  override def 被左法索取(f: 向左法): Result    = f.左侧数无反馈
}

trait Number1R {
  def 被索取(tree: 欠右法半树): Result
  def 被右法索取(tree: 向右法): Result
}
case class Number1PR(tail: Number1R, item: Item) extends Number1R {
  override def 被索取(tree: 欠右法半树): Result = tree.接受索取回馈(tail, item)
  override def 被右法索取(f: 向右法): Result    = f.右侧数反馈(tail, item)
}
case object Nubmer1ZeroR extends Number1R {
  override def 被索取(tree: 欠右法半树): Result = tree.没有索取回馈
  override def 被右法索取(f: 向右法): Result    = f.右侧数无反馈
}

trait 白树 {
  def 向右获取(f: 向右法): Result
  def 向左获取(f: 向左法): Result
}
case class 双白树(left: Number1L, right: Number1R) extends 白树 {
  override def 向右获取(f: 向右法): Result = right.被索取(剩下左法半树(f = f, left = left))
  override def 向左获取(f: 向左法): Result = left.被索取(剩下右法半树(f = f, right = right))
}

trait 欠左法半树 {
  def 接受索取回馈(number1: Number1L, item: Item): Result
  def 没有索取回馈: Result
}

trait 欠右法半树 {
  def 接受索取回馈(number1: Number1R, item: Item): Result
  def 没有索取回馈: Result
}

case class 剩下左法半树(f: 向右法, left: Number1L) extends 欠右法半树 {
  def 接受索取回馈(number1: Number1R, item: Item): Result = f.右侧反馈(双白树(left = left, right = number1), item)
  def 没有索取回馈: Result                                = f.右侧没有反馈(左侧数 = left)
}
case class 剩下右法半树(f: 向左法, right: Number1R) extends 欠左法半树 {
  def 接受索取回馈(number1: Number1L, item: Item): Result = f.左侧反馈(双白树(left = number1, right = right), item)
  def 没有索取回馈: Result                                = f.左侧没有反馈(右侧数 = right)
}

trait 向左法 {
  def 左侧反馈(tree: 白树, item: Item): Result
  def 左侧没有反馈(右侧数: Number1R): Result

  def 左侧数反馈(左侧数: Number1L, item: Item): Result
  def 左侧数无反馈: Result
}
trait 向右法 {
  def 右侧反馈(tree: 白树, item: Item): Result
  def 右侧没有反馈(左侧数: Number1L): Result

  def 右侧数反馈(右侧数: Number1R, item: Item): Result
  def 右侧数无反馈: Result
}

case object 加法 extends 向左法 with 向右法 {
  override def 右侧反馈(tree: 白树, item: Item): Result = ResultP(tree.向右获取(加法), item)
  override def 右侧没有反馈(左侧数: Number1L): Result      = 左侧数.被左法索取(加法)
  override def 左侧反馈(tree: 白树, item: Item): Result = ResultP(tree.向左获取(加法), item)
  override def 左侧没有反馈(右侧数: Number1R): Result      = 右侧数.被右法索取(加法)

  override def 右侧数反馈(右侧数: Number1R, item: Item): Result = ResultP(右侧数.被右法索取(加法), item)
  override def 右侧数无反馈: Result                           = ResultZero
  override def 左侧数反馈(左侧数: Number1L, item: Item): Result = ResultP(左侧数.被左法索取(加法), item)
  override def 左侧数无反馈: Result                           = ResultZero
}

case object 减法 extends 向右法 with 向左法 {
  override def 右侧反馈(tree: 白树, item: Item): Result = tree.向左获取(有暂存减法(item))
  override def 右侧没有反馈(左侧数: Number1L): Result      = 左侧数.被左法索取(减法)
  override def 左侧反馈(tree: 白树, item: Item): Result = ResultP(tree.向右获取(减法), item)
  override def 左侧没有反馈(右侧数: Number1R): Result      = ResultZero

  override def 右侧数反馈(右侧数: Number1R, item: Item): Result = ResultZero
  override def 右侧数无反馈: Result                           = ResultZero
  override def 左侧数反馈(左侧数: Number1L, item: Item): Result = ResultP(左侧数.被左法索取(加法), item)
  override def 左侧数无反馈: Result                           = ResultZero
}
case class 有暂存减法(item: Item) extends 向左法 {
  override def 左侧反馈(tree: 白树, item: Item): Result = tree.向右获取(减法)
  override def 左侧没有反馈(右侧数: Number1R): Result      = ResultZero

  override def 左侧数反馈(左侧数: Number1L, item: Item): Result = ResultP(左侧数.被左法索取(减法), item)
  override def 左侧数无反馈: Result                           = ResultZero
}

object Number {
  def count(b: 白树, f: 向右法): Result = b.向右获取(f)
}
