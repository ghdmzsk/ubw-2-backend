package step5

case class Item(name: String)

trait 正法 {
  def 计算(tree: 白树): Result
  def 纯计算: Result
}

trait 逆法

case class 加法正(tail: 正法, head: Item) extends 正法 {
  override def 计算(tree: 白树): Result = tree.右计算(tail, head)
  override def 纯计算: Result          = ResultPositive(tail.纯计算, head)
}
case object 加法零 extends 正法 {
  override def 计算(tree: 白树): Result = tree.消去计算
  override def 纯计算: Result          = ResultZero
}

trait Result
case class ResultPositive(tail: Result, item: Item) extends Result {
  override def toString: String = s"($tail, ${item.name})"
}
case object ResultZero extends Result {
  override def toString: String = "Zero"
}

trait 黑树 {
  def 左计算(tree: 中层白树): Result = ResultZero
}

case class 黑左逆右正(left: 逆法, right: 正法) extends 黑树 {
  override def 左计算(tree: 中层白树): Result = right.计算(白左逆右正偏右(right = right, sub = tree))
}
case class 黑左逆右逆(left: 逆法, right: 逆法) extends 黑树
case class 黑左逆右树(left: 逆法, right: 黑树) extends 黑树
case class 黑左正右正(left: 正法, right: 正法) extends 黑树 {
  override def 左计算(tree: 中层白树): Result = left.计算(白左正右正偏右(right = right, sub = tree))
}
case class 黑左正右逆(left: 正法, right: 逆法) extends 黑树
case class 黑左正右树(left: 正法, right: 黑树) extends 黑树
case class 黑左树右正(left: 黑树, right: 正法) extends 黑树 {
  override def 左计算(tree: 中层白树): Result = left.左计算(白左树右正偏右(right = right, sub = tree))
}
case class 黑左树右逆(left: 黑树, right: 逆法) extends 黑树
case class 黑左树右树(left: 黑树, right: 黑树) extends 黑树

trait 白树 {
  def 右计算(f: 正法, item: Item): Result = ResultZero
  def 左计算(f: 逆法, item: Item): Result = ResultZero
  def 消去计算: Result                   = ResultZero
}

trait 中层白树 {
  def 右下计算(f: 黑树, item: Item): Result = ResultZero
  def 直上计算(f: 黑树, item: Item): Result = ResultZero
  def 消去计算正法(f: 正法): Result           = ResultZero
}

case object 中层白树零 extends 中层白树 {
  override def 右下计算(f: 黑树, item: Item): Result = ResultZero
  override def 直上计算(f: 黑树, item: Item): Result = ResultPositive(f.左计算(中层白树零), item)
  override def 消去计算正法(f: 正法): Result           = f.纯计算
}

case class 白左逆右正偏左(left: 逆法, sub: 中层白树) extends 白树
case class 白左正右正偏左(left: 正法, sub: 中层白树) extends 白树
case class 白左树右正偏左(left: 黑树, sub: 中层白树) extends 白树
case class 白左逆右逆偏左(left: 逆法, sub: 中层白树) extends 白树
case class 白左正右逆偏左(left: 正法, sub: 中层白树) extends 白树
case class 白左树右逆偏左(left: 黑树, sub: 中层白树) extends 白树
case class 白左逆右树偏左(left: 逆法, sub: 中层白树) extends 中层白树
case class 白左正右树偏左(left: 正法, sub: 中层白树) extends 中层白树
case class 白左树右树偏左(left: 黑树, sub: 中层白树) extends 中层白树

case class 白左逆右正偏右(right: 正法, sub: 中层白树) extends 白树 {
  123
}
case class 白左逆右逆偏右(right: 逆法, sub: 中层白树) extends 白树
case class 白左逆右树偏右(right: 黑树, sub: 中层白树) extends 白树
case class 白左正右逆偏右(right: 逆法, sub: 中层白树) extends 白树
case class 白左正右正偏右(right: 正法, sub: 中层白树) extends 白树 {
  override def 右计算(f: 正法, item: Item): Result = sub.直上计算(黑左正右正(left = f, right = right), item)
  override def 左计算(f: 逆法, item: Item): Result = ResultZero
  override def 消去计算: Result                   = sub.消去计算正法(right)
}
case class 白左正右树偏右(right: 黑树, sub: 中层白树) extends 白树
case class 白左树右逆偏右(right: 逆法, sub: 中层白树) extends 白树
case class 白左树右正偏右(right: 正法, sub: 中层白树) extends 中层白树 {
  override def 右下计算(f: 黑树, item: Item): Result = sub.直上计算(黑左树右正(left = f, right = right), item)
  override def 直上计算(f: 黑树, item: Item): Result = sub.直上计算(黑左树右正(left = f, right = right), item)
  override def 消去计算正法(f: 正法): Result           = f.计算(白左正右正偏右(right = right, sub = sub))
}
case class 白左树右树偏右(right: 黑树, sub: 中层白树) extends 白树

object Number {
  def count(f: 黑树): Result = f.左计算(中层白树零)
}
