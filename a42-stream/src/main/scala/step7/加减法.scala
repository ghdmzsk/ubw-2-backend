package step7

case class Item(name: String)

trait Result
case class ResultP(tail: Result, item: Item) extends Result {
  override def toString: String = s"($tail, ${item.name})"
}
case object ResultZero extends Result {
  override def toString: String = "Zero"
}

trait NumLeft
case class NumLeftP(tail: NumLeft, head: Item) extends NumLeft
case object NumLeftZero                        extends NumLeft

trait NumRight {
  def 右被索取(cTree: CTree): Result
}
case class NumRightP(tail: NumRight, head: Item) extends NumRight {
  def 右被索取(cTree: CTree): Result = cTree.右数反馈元素(tail, head)
}
case object NumRightZero extends NumRight {
  def 右被索取(cTree: CTree): Result = cTree.右结束反馈
}

trait ATree {
  def 被索取(cTree: CTree): Result = ResultZero
}
case class LTreeRTreeA(left: ATree, method: Method, right: ATree) extends ATree {
  override def 被索取(cTree: CTree): Result = method.计算(LTreeRTreeB(left = left, right = right, sub = cTree))
}
case class LNumRTreeA(left: NumLeft, method: Method, right: ATree) extends ATree {
  override def 被索取(cTree: CTree): Result = method.计算(LNumRTreeB(left = left, right = right, sub = cTree))
}
case class LTreeRNumA(left: ATree, method: Method, right: NumRight) extends ATree {
  override def 被索取(cTree: CTree): Result = method.计算(LTreeRNumB(left = left, right = right, sub = cTree))
}
case class LNumRNumA(left: NumLeft, method: Method, right: NumRight) extends ATree {
  override def 被索取(cTree: CTree): Result = method.计算(LNumRNumB(left = left, right = right, sub = cTree))
}
case class LTreeA(left: ATree, method: Method) extends ATree {
  override def 被索取(cTree: CTree): Result = method.计算(LTreeB(left = left, sub = cTree))
}
case class LNumA(left: NumLeft, method: Method) extends ATree {
  override def 被索取(cTree: CTree): Result = method.计算(LNumB(left = left, sub = cTree))
}
case class RNumA(method: Method, right: NumRight) extends ATree {
  override def 被索取(cTree: CTree): Result = method.计算(RNumB(right = right, sub = cTree))
}
case class RTreeA(method: Method, right: ATree) extends ATree {
  override def 被索取(cTree: CTree): Result = method.计算(RTreeB(right = right, sub = cTree))
}

trait BTree {
  def 向右获取(method: Method): Result
  def 向上反馈元素(method: Method, item: Item): Result = ResultZero
}
case class LTreeRTreeB(left: ATree, right: ATree, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result               = right.被索取(LTreeC(left = left, method = method, sub = sub))
  override def 向上反馈元素(method: Method, item: Item): Result = sub.接收反馈(LTreeRTreeA(left = left, method = method, right = right), item)
}
case class LNumRTreeB(left: NumLeft, right: ATree, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result = right.被索取(LNumC(left = left, method = method, sub = sub))
}
case class LTreeRNumB(left: ATree, right: NumRight, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result = right.右被索取(LTreeC(left = left, method = method, sub = sub))
}
case class LNumRNumB(left: NumLeft, right: NumRight, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result = right.右被索取(LNumC(left = left, method = method, sub = sub))
}
case class LTreeB(left: ATree, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result = ResultZero
}
case class LNumB(left: NumLeft, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result = ResultZero
}
case class RNumB(right: NumRight, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result = right.右被索取(RNumMethodC(method = method, sub = sub))
}
case class RTreeB(right: ATree, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result = right.被索取(RTreeMethodC(method = method, sub = sub))
}

trait CTree {
  def 右数反馈元素(method: NumRight, item: Item): Result
  def 右树反馈元素(aTree: ATree, item: Item): Result
  def 接收反馈(aTree: ATree, item: Item): Result
  def 右结束反馈: Result
}
case class LTreeC(left: ATree, method: Method, sub: CTree) extends CTree {
  override def 右数反馈元素(num: NumRight, item: Item): Result = method.右反馈元素(LTreeRNumB(left = left, right = num, sub = sub), item)
  override def 右树反馈元素(aTree: ATree, item: Item): Result  = method.右反馈元素(LTreeRTreeB(left = left, right = aTree, sub = sub), item)
  override def 接收反馈(aTree: ATree, item: Item): Result    = ResultZero
  override def 右结束反馈: Result                             = ResultZero
}
case class LNumC(left: NumLeft, method: Method, sub: CTree) extends CTree {
  override def 右数反馈元素(num: NumRight, item: Item): Result = ResultZero
  override def 右树反馈元素(aTree: ATree, item: Item): Result  = ResultZero
  override def 接收反馈(aTree: ATree, item: Item): Result    = ResultZero
  override def 右结束反馈: Result                             = ResultZero
}
case class RNumMethodC(method: Method, sub: CTree) extends CTree {
  override def 右数反馈元素(num: NumRight, item: Item): Result = ResultZero
  override def 右树反馈元素(aTree: ATree, item: Item): Result  = ResultZero
  override def 接收反馈(aTree: ATree, item: Item): Result    = ResultZero
  override def 右结束反馈: Result                             = ResultZero
}
case class RTreeMethodC(method: Method, sub: CTree) extends CTree {
  override def 右数反馈元素(num: NumRight, item: Item): Result = ResultZero
  override def 右树反馈元素(aTree: ATree, item: Item): Result  = ResultZero
  override def 接收反馈(aTree: ATree, item: Item): Result    = ResultZero
  override def 右结束反馈: Result                             = ResultZero
}

trait Method {
  def 计算(bTree: BTree): Result
  def 右反馈元素(bTree: BTree, item: Item): Result
}

object 加法 extends Method {
  override def 计算(bTree: BTree): Result                = bTree.向右获取(this)
  override def 右反馈元素(bTree: BTree, item: Item): Result = bTree.向上反馈元素(method = this, item)
}
