package step7

case class Item(name: String)

trait Result
case class ResultP(tail: Result, item: Item) extends Result {
  override def toString: String = s"($tail, ${item.name})"
}
case object ResultZero extends Result {
  override def toString: String = "Zero"
}

trait NumLeft {
  def 左被索取(cTree: CTree): Result
}
case class NumLeftP(tail: NumLeft, head: Item) extends NumLeft {
  override def 左被索取(cTree: CTree): Result = cTree.左数反馈元素(tail, head)
}
case object NumLeftZero extends NumLeft {
  override def 左被索取(cTree: CTree): Result = cTree.左数结束反馈
}

trait NumRight {
  def 右被索取(cTree: CTree): Result
}
case class NumRightP(tail: NumRight, head: Item) extends NumRight {
  def 右被索取(cTree: CTree): Result = cTree.右数反馈元素(tail, head)
}
case object NumRightZero extends NumRight {
  def 右被索取(cTree: CTree): Result = cTree.右数结束反馈
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
  def 向上反馈元素(method: Method, item: Item): Result
  def 向左获取(method: Method): Result
}
case class LTreeRTreeB(left: ATree, right: ATree, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result               = right.被索取(LTreeC(left = left, method = method, sub = sub))
  override def 向上反馈元素(method: Method, item: Item): Result = sub.右树反馈元素(LTreeRTreeA(left = left, method = method, right = right), item)
  override def 向左获取(method: Method): Result               = left.被索取(RTreeC(right = right, method = method, sub = sub))
}
case class LNumRTreeB(left: NumLeft, right: ATree, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result               = right.被索取(LNumC(left = left, method = method, sub = sub))
  override def 向上反馈元素(method: Method, item: Item): Result = sub.右树反馈元素(LNumRTreeA(left = left, method = method, right = right), item)
  override def 向左获取(method: Method): Result               = left.左被索取(RTreeC(right = right, method = method, sub = sub))
}
case class LTreeRNumB(left: ATree, right: NumRight, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result               = right.右被索取(LTreeC(left = left, method = method, sub = sub))
  override def 向上反馈元素(method: Method, item: Item): Result = sub.右树反馈元素(LTreeRNumA(left = left, method = method, right = right), item)
  override def 向左获取(method: Method): Result               = left.被索取(RNumC(right = right, method = method, sub = sub))
}
case class LNumRNumB(left: NumLeft, right: NumRight, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result               = right.右被索取(LNumC(left = left, method = method, sub = sub))
  override def 向上反馈元素(method: Method, item: Item): Result = sub.右树反馈元素(LNumRNumA(left = left, method = method, right = right), item)
  override def 向左获取(method: Method): Result               = ResultZero
}
case class LTreeB(left: ATree, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result               = ResultZero
  override def 向上反馈元素(method: Method, item: Item): Result = ResultZero
  override def 向左获取(method: Method): Result               = ResultZero
}
case class LNumB(left: NumLeft, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result               = ResultZero
  override def 向上反馈元素(method: Method, item: Item): Result = ResultZero
  override def 向左获取(method: Method): Result               = ResultZero
}
case class RNumB(right: NumRight, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result               = right.右被索取(RNumMethodC(method = method, sub = sub))
  override def 向上反馈元素(method: Method, item: Item): Result = sub.右树反馈元素(RNumA(method = method, right = right), item)
  override def 向左获取(method: Method): Result               = ResultZero
}
case class RTreeB(right: ATree, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result               = right.被索取(RTreeMethodC(method = method, sub = sub))
  override def 向上反馈元素(method: Method, item: Item): Result = sub.右树反馈元素(RTreeA(method = method, right = right), item)
  override def 向左获取(method: Method): Result               = ResultZero
}

trait CTree {
  def 数反馈元素(num: NumRight, item: Item): Result = ResultZero
  def 树反馈元素(aTree: ATree, item: Item): Result  = ResultZero
  def 数结束反馈: Result                            = ResultZero
  def 树结束反馈(aTree: ATree): Result              = ResultZero

  /*def 左数反馈元素(num: NumLeft, item: Item): Result = ResultZero
  def 左树反馈元素(aTree: ATree, item: Item): Result = ResultZero
  def 左数结束反馈: Result                           = ResultZero
  def 左树结束反馈(aTree: ATree): Result             = ResultZero*/
}

case class LTreeC(left: ATree, method: Method, sub: CTree) extends CTree {
  override def 数反馈元素(num: NumRight, item: Item): Result = method.右反馈元素(LTreeRNumB(left = left, right = num, sub = sub), item)
  override def 树反馈元素(aTree: ATree, item: Item): Result  = method.右反馈元素(LTreeRTreeB(left = left, right = aTree, sub = sub), item)
  override def 数结束反馈: Result                            = method.右结束反馈(LTreeB(left = left, sub = sub))
  override def 树结束反馈(aTree: ATree): Result              = method.右结束反馈(LTreeRTreeB(left = left, right = aTree, sub = sub))
}
case class LNumC(left: NumLeft, method: Method, sub: CTree) extends CTree {
  override def 数反馈元素(num: NumRight, item: Item): Result = ResultZero
  override def 树反馈元素(aTree: ATree, item: Item): Result  = ResultZero
  override def 数结束反馈: Result                            = ResultZero
  override def 树结束反馈(aTree: ATree): Result              = ResultZero
}
case class RNumMethodC(method: Method, sub: CTree) extends CTree {
  override def 数反馈元素(num: NumRight, item: Item): Result = ResultZero
  override def 树反馈元素(aTree: ATree, item: Item): Result  = ResultZero
  override def 数结束反馈: Result                            = ResultZero
  override def 树结束反馈(aTree: ATree): Result              = ResultZero
}
case class RTreeMethodC(method: Method, sub: CTree) extends CTree {
  override def 数反馈元素(num: NumRight, item: Item): Result = ResultZero
  override def 树反馈元素(aTree: ATree, item: Item): Result  = ResultZero
  override def 数结束反馈: Result                            = ResultZero
  override def 树结束反馈(aTree: ATree): Result              = ResultZero
}

case class RTreeC(right: ATree, method: Method, sub: CTree) extends CTree {
  override def 数反馈元素(num: NumLeft, item: Item): Result = method.左反馈元素(LTreeRNumB(left = left, right = num, sub = sub), item)
  override def 树反馈元素(aTree: ATree, item: Item): Result = method.左反馈元素(LTreeRTreeB(left = left, right = aTree, sub = sub), item)
  override def 数结束反馈: Result                           = method.左结束反馈(LTreeB(left = left, sub = sub))
  override def 树结束反馈(aTree: ATree): Result             = method.左结束反馈(LTreeRTreeB(left = left, right = aTree, sub = sub))
}
case class RNumC(right: NumRight, method: Method, sub: CTree) extends CTree {
  override def 数反馈元素(num: NumLeft, item: Item): Result = ResultZero
  override def 树反馈元素(aTree: ATree, item: Item): Result = ResultZero
  override def 数结束反馈: Result                           = ResultZero
  override def 树结束反馈(aTree: ATree): Result             = ResultZero
}

trait Method {
  def 计算(bTree: BTree): Result
  def 右反馈元素(bTree: BTree, item: Item): Result
  def 右结束反馈(bTree: BTree): Result
  def 左反馈元素(bTree: BTree, item: Item): Result
  def 左结束反馈(bTree: BTree): Result
}

object 加法 extends Method {
  override def 计算(bTree: BTree): Result                = bTree.向右获取(this)
  override def 右反馈元素(bTree: BTree, item: Item): Result = bTree.向上反馈元素(method = this, item)
  override def 右结束反馈(bTree: BTree): Result             = bTree.向左获取(this)
  override def 左反馈元素(bTree: BTree, item: Item): Result = bTree.向上反馈元素(method = this, item)
  override def 左结束反馈(bTree: BTree): Result             = bTree.向上结束反馈
}
