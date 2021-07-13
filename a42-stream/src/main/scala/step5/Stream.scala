package step5

case class Item(name: String)

trait 正法 {
  def 左计算(tree: 底层白树): Result
}

trait 零法 {
  def 左计算(tree: 中层白树): Result
}

case class 加法正(tail: 正法, head: Item) extends 正法 {
  override def 左计算(tree: 底层白树): Result = tree.右计算(tail, head)
}
case class 加法一(tail: 零法, head: Item) extends 正法 {
  override def 左计算(tree: 底层白树): Result = tree.右零计算(tail, head)
}
case object 加法零 extends 零法 {
  override def 左计算(tree: 中层白树): Result = tree.上计算
}

trait Result
case class ResultPositive(tail: Result, item: Item) extends Result
case object ResultZero                              extends Result

trait 黑树 {
  def 左计算(tree: 白树): Result = ResultZero
}

case class 黑左逆右正(left: 零法, right: 正法) extends 黑树 {
  override def 左计算(tree: 白树): Result = left.左计算(白左逆右正偏右(right = right, sub = tree))
}
case class 黑左逆右逆(left: 零法, right: 零法) extends 黑树
case class 黑左逆右树(left: 零法, right: 黑树) extends 黑树
case class 黑左正右正(left: 正法, right: 正法) extends 黑树 {
  override def 左计算(tree: 白树): Result = left.左计算(白左正右正偏右(right = right, sub = tree))
}
case class 黑左正右逆(left: 正法, right: 零法) extends 黑树
case class 黑左正右树(left: 正法, right: 黑树) extends 黑树
case class 黑左树右正(left: 黑树, right: 正法) extends 黑树 {
  override def 左计算(tree: 白树): Result = left.左计算(白左逆右正偏右(right = right, sub = tree))
}
case class 黑左树右逆(left: 黑树, right: 零法) extends 黑树
case class 黑左树右树(left: 黑树, right: 黑树) extends 黑树

trait 白树 {
  def 右计算(f: 正法, item: Item): Result = ResultZero
  def 上计算(f: 黑树, item: Item): Result = ResultZero
}

trait 底层白树 extends 白树 {
  def 右零计算(f: 零法, item: Item): Result = ResultZero
}

trait 中层白树 extends 白树 {
  def 消去计算: Result = ResultZero
}

case object 白树零 extends 白树

case class 白左逆右正偏左(left: 零法, sub: 中层白树) extends 白树
case class 白左逆右逆偏左(left: 零法, sub: 中层白树) extends 白树
case class 白左正右逆偏左(left: 正法, sub: 中层白树) extends 白树
case class 白左正右正偏左(left: 正法, sub: 中层白树) extends 白树
case class 白左树右逆偏左(left: 黑树, sub: 中层白树) extends 白树
case class 白左树右正偏左(left: 黑树, sub: 中层白树) extends 白树
case class 白左逆右树偏左(left: 零法, sub: 中层白树) extends 白树
case class 白左正右树偏左(left: 正法, sub: 中层白树) extends 白树
case class 白左树右树偏左(left: 黑树, sub: 中层白树) extends 白树

case class 白左逆右正偏右(right: 正法, sub: 中层白树) extends 白树 {
  123
}
case class 白左逆右逆偏右(right: 零法, sub: 中层白树) extends 白树
case class 白左正右逆偏右(right: 零法, sub: 中层白树) extends 白树
case class 白左正右正偏右(right: 正法, sub: 中层白树) extends 底层白树 {
  override def 右计算(f: 正法, item: Item): Result  = sub.上计算(黑左正右正(left = f, right = right), item)
  override def 上计算(f: 黑树, item: Item): Result  = ResultZero
  override def 右零计算(f: 零法, item: Item): Result = sub.上计算(黑左逆右正(left = f, right = right), item)
  override def 消去计算: Result                    = sub.合并计算(right)
}
case class 白左树右逆偏右(right: 零法, sub: 中层白树) extends 白树
case class 白左树右正偏右(right: 正法, sub: 中层白树) extends 中层白树 {
  override def 右计算(f: 正法, item: Item): Result = sub.上计算(黑左正右正(left = f, right = right), item = item)
  override def 上计算(f: 黑树, item: Item): Result = ResultZero
}
case class 白左逆右树偏右(right: 黑树, sub: 中层白树) extends 白树
case class 白左正右树偏右(right: 黑树, sub: 中层白树) extends 白树
case class 白左树右树偏右(right: 黑树, sub: 中层白树) extends 白树
