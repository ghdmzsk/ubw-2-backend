package step7

case class Item(name: String)

trait Result
case class ResultP(tail: Result, item: Item) extends Result {
  override def toString: String = s"($tail, ${item.name})"
}
case object ResultZero extends Result {
  override def toString: String = "Zero"
}

trait Num {
  def 被索取(cTree: CTree): Result
}
case class NumP(tail: Num, head: Item) extends Num {
  override def 被索取(cTree: CTree): Result = cTree.数反馈元素(tail, head)
}
case object NumZero extends Num {
  override def 被索取(cTree: CTree): Result = cTree.数结束反馈
}

trait ATree {
  def 被索取(cTree: CTree): Result = ResultZero
}
case class LTreeRTreeA(left: ATree, method: Method, right: ATree) extends ATree {
  override def 被索取(cTree: CTree): Result = method.计算(LTreeRTreeB(left = left, right = right, sub = cTree))
}
case class LNumRTreeA(left: Num, method: Method, right: ATree) extends ATree {
  override def 被索取(cTree: CTree): Result = method.计算(LNumRTreeB(left = left, right = right, sub = cTree))
}
case class LTreeRNumA(left: ATree, method: Method, right: Num) extends ATree {
  override def 被索取(cTree: CTree): Result = method.计算(LTreeRNumB(left = left, right = right, sub = cTree))
}
case class LNumRNumA(left: Num, method: Method, right: Num) extends ATree {
  override def 被索取(cTree: CTree): Result = method.计算(LNumRNumB(left = left, right = right, sub = cTree))
}
case class LTreeA(left: ATree, method: Method) extends ATree {
  override def 被索取(cTree: CTree): Result = method.计算(LTreeB(left = left, sub = cTree))
}
case class LNumA(left: Num, method: Method) extends ATree {
  override def 被索取(cTree: CTree): Result = method.计算(LNumB(left = left, sub = cTree))
}
case class RNumA(method: Method, right: Num) extends ATree {
  override def 被索取(cTree: CTree): Result = method.计算(RNumB(right = right, sub = cTree))
}
case class RTreeA(method: Method, right: ATree) extends ATree {
  override def 被索取(cTree: CTree): Result = method.计算(RTreeB(right = right, sub = cTree))
}

trait BTree {
  def 向右获取(method: Method): Result
  def 向上反馈元素(method: Method, item: Item): Result
  def 向上结束反馈(method: Method): Result
  def 向左获取(method: Method): Result
}
case class LTreeRTreeB(left: ATree, right: ATree, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result               = right.被索取(LTreeC(left = left, method = method, sub = sub))
  override def 向上反馈元素(method: Method, item: Item): Result = sub.树反馈元素(LTreeRTreeA(left = left, method = method, right = right), item)
  override def 向上结束反馈(method: Method): Result             = sub.树结束反馈(LTreeRTreeA(left = left, method = method, right = right))
  override def 向左获取(method: Method): Result               = left.被索取(RTreeC(right = right, method = method, sub = sub))
}
case class LNumRTreeB(left: Num, right: ATree, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result               = right.被索取(LNumC(left = left, method = method, sub = sub))
  override def 向上反馈元素(method: Method, item: Item): Result = sub.树反馈元素(LNumRTreeA(left = left, method = method, right = right), item)
  override def 向上结束反馈(method: Method): Result             = sub.树结束反馈(LNumRTreeA(left = left, method = method, right = right))
  override def 向左获取(method: Method): Result               = left.被索取(RTreeC(right = right, method = method, sub = sub))
}
case class LTreeRNumB(left: ATree, right: Num, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result               = right.被索取(LTreeC(left = left, method = method, sub = sub))
  override def 向上反馈元素(method: Method, item: Item): Result = sub.树反馈元素(LTreeRNumA(left = left, method = method, right = right), item)
  override def 向上结束反馈(method: Method): Result             = sub.树结束反馈(LTreeRNumA(left = left, method = method, right = right))
  override def 向左获取(method: Method): Result               = left.被索取(RNumC(right = right, method = method, sub = sub))
}
case class LNumRNumB(left: Num, right: Num, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result               = right.被索取(LNumC(left = left, method = method, sub = sub))
  override def 向上反馈元素(method: Method, item: Item): Result = sub.树反馈元素(LNumRNumA(left = left, method = method, right = right), item)
  override def 向上结束反馈(method: Method): Result             = sub.树结束反馈(LNumRNumA(left = left, method = method, right = right))
  override def 向左获取(method: Method): Result               = left.被索取(RNumC(right = right, method = method, sub = sub))
}
case class LTreeB(left: ATree, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result               = method.右结束反馈(this)
  override def 向上反馈元素(method: Method, item: Item): Result = sub.树反馈元素(LTreeA(left = left, method = method), item)
  override def 向上结束反馈(method: Method): Result             = sub.树结束反馈(LTreeA(left = left, method = method))
  override def 向左获取(method: Method): Result               = left.被索取(HasLeftMethodC(method = method, sub = sub))
}
case class LNumB(left: Num, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result               = method.右结束反馈(this)
  override def 向上反馈元素(method: Method, item: Item): Result = sub.树反馈元素(LNumA(left = left, method = method), item)
  override def 向上结束反馈(method: Method): Result             = sub.树结束反馈(LNumA(left = left, method = method))
  override def 向左获取(method: Method): Result               = left.被索取(HasLeftMethodC(method = method, sub = sub))
}
case class RNumB(right: Num, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result               = right.被索取(HasRightMethodC(method = method, sub = sub))
  override def 向上反馈元素(method: Method, item: Item): Result = sub.树反馈元素(RNumA(method = method, right = right), item)
  override def 向上结束反馈(method: Method): Result             = sub.树结束反馈(RNumA(method = method, right = right))
  override def 向左获取(method: Method): Result               = method.左结束反馈(this)
}
case class RTreeB(right: ATree, sub: CTree) extends BTree {
  override def 向右获取(method: Method): Result               = right.被索取(HasRightMethodC(method = method, sub = sub))
  override def 向上反馈元素(method: Method, item: Item): Result = sub.树反馈元素(RTreeA(method = method, right = right), item)
  override def 向上结束反馈(method: Method): Result             = sub.树结束反馈(RTreeA(method = method, right = right))
  override def 向左获取(method: Method): Result               = method.左结束反馈(this)
}

trait CTree {
  def 数反馈元素(num: Num, item: Item): Result
  def 树反馈元素(aTree: ATree, item: Item): Result
  def 数结束反馈: Result
  def 树结束反馈(aTree: ATree): Result
}

object CTreeZero extends CTree {
  override def 数反馈元素(num: Num, item: Item): Result     = ResultP(num.被索取(CTreeZero), item)
  override def 树反馈元素(aTree: ATree, item: Item): Result = ResultP(aTree.被索取(CTreeZero), item)
  override def 数结束反馈: Result                           = ResultZero
  override def 树结束反馈(aTree: ATree): Result             = aTree.被索取(CTreeZero)
}

case class LTreeC(left: ATree, method: Method, sub: CTree) extends CTree {
  override def 数反馈元素(num: Num, item: Item): Result     = method.右反馈元素(LTreeRNumB(left = left, right = num, sub = sub), item)
  override def 树反馈元素(aTree: ATree, item: Item): Result = method.右反馈元素(LTreeRTreeB(left = left, right = aTree, sub = sub), item)
  override def 数结束反馈: Result                           = method.右结束反馈(LTreeB(left = left, sub = sub))
  override def 树结束反馈(aTree: ATree): Result             = method.右结束反馈(LTreeRTreeB(left = left, right = aTree, sub = sub))
}
case class LNumC(left: Num, method: Method, sub: CTree) extends CTree {
  override def 数反馈元素(num: Num, item: Item): Result     = method.右反馈元素(LNumRNumB(left = left, right = num, sub = sub), item)
  override def 树反馈元素(aTree: ATree, item: Item): Result = method.右反馈元素(LNumRTreeB(left = left, right = aTree, sub = sub), item)
  override def 数结束反馈: Result                           = method.右结束反馈(LNumB(left = left, sub = sub))
  override def 树结束反馈(aTree: ATree): Result             = method.右结束反馈(LNumRTreeB(left = left, right = aTree, sub = sub))
}
case class HasRightMethodC(method: Method, sub: CTree) extends CTree {
  override def 数反馈元素(num: Num, item: Item): Result     = method.右反馈元素(RNumB(right = num, sub = sub), item)
  override def 树反馈元素(aTree: ATree, item: Item): Result = method.右反馈元素(RTreeB(right = aTree, sub = sub), item)
  override def 数结束反馈: Result                           = sub.数结束反馈
  override def 树结束反馈(aTree: ATree): Result             = method.右结束反馈(RTreeB(right = aTree, sub = sub))
}

case class RTreeC(right: ATree, method: Method, sub: CTree) extends CTree {
  override def 数反馈元素(num: Num, item: Item): Result     = method.左反馈元素(LNumRTreeB(left = num, right = right, sub = sub), item)
  override def 树反馈元素(aTree: ATree, item: Item): Result = method.左反馈元素(LTreeRTreeB(left = aTree, right = right, sub = sub), item)
  override def 数结束反馈: Result                           = method.左结束反馈(RTreeB(right = right, sub = sub))
  override def 树结束反馈(aTree: ATree): Result             = method.左结束反馈(LTreeRTreeB(left = aTree, right = right, sub = sub))
}
case class RNumC(right: Num, method: Method, sub: CTree) extends CTree {
  override def 数反馈元素(num: Num, item: Item): Result     = method.左反馈元素(LNumRNumB(left = num, right = right, sub = sub), item)
  override def 树反馈元素(aTree: ATree, item: Item): Result = method.左反馈元素(LTreeRNumB(left = aTree, right = right, sub = sub), item)
  override def 数结束反馈: Result                           = method.左结束反馈(RNumB(right = right, sub = sub))
  override def 树结束反馈(aTree: ATree): Result             = method.左结束反馈(LTreeRNumB(left = aTree, right = right, sub = sub))
}
case class HasLeftMethodC(method: Method, sub: CTree) extends CTree {
  override def 数反馈元素(num: Num, item: Item): Result     = method.左反馈元素(LNumB(left = num, sub = sub), item)
  override def 树反馈元素(aTree: ATree, item: Item): Result = method.左反馈元素(LTreeB(left = aTree, sub = sub), item)
  override def 数结束反馈: Result                           = sub.数结束反馈
  override def 树结束反馈(aTree: ATree): Result             = method.左结束反馈(LTreeB(left = aTree, sub = sub))
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
  override def 左结束反馈(bTree: BTree): Result             = bTree.向上结束反馈(this)
}

object Number {
  def count(aTree: ATree): Result = aTree.被索取(CTreeZero)
}
