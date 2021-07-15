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
  def 被索取(cTree: CTree): Result = cTree.反馈元素(tail, head)
}
case object NumZero extends Num {
  def 被索取(cTree: CTree): Result = cTree.结束反馈
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
case class LNumRNumA(left: Num, method: Method, right: Num) extends ATree

case class LTreeA(left: ATree, method: Method)  extends ATree
case class LNumA(left: Num, method: Method)     extends ATree
case class RNumA(method: Method, right: Num)    extends ATree
case class RTreeA(method: Method, right: ATree) extends ATree

trait BTree {
  def 向右获取(method: Method): Result
}
case class LTreeRTreeB(left: ATree, right: ATree, sub: CTree) extends BTree {
  def 向右获取(method: Method): Result = right.被索取(LTreeC(left = left, method = method, sub = sub))
}
case class LNumRTreeB(left: Num, right: ATree, sub: CTree) extends BTree {
  def 向右获取(method: Method): Result = right.被索取(LNumC(left = left, method = method, sub = sub))
}
case class LTreeRNumB(left: ATree, right: Num, sub: CTree) extends BTree {
  def 向右获取(method: Method): Result = right.被索取(LTreeC(left = left, method = method, sub = sub))
}

trait CTree {
  def 反馈元素(method: Num, item: Item): Result
  def 反馈上层(aTree: ATree, item: Item): Result
  def 结束反馈上层(aTree: ATree): Result
  def 结束反馈: Result
}
case class LTreeC(left: ATree, method: Method, sub: CTree) extends CTree {
  override def 反馈元素(num: Num, item: Item): Result     = sub.反馈上层(LTreeRNumA(left = left, method = method, right = num), item)
  override def 反馈上层(aTree: ATree, item: Item): Result = sub.反馈上层(LTreeRTreeA(left = left, method = method, right = aTree), item)
  override def 结束反馈上层(aTree: ATree): Result           = sub.结束反馈上层(LTreeRTreeA(left = left, method = method, right = aTree))
  override def 结束反馈: Result                           = sub.结束反馈上层(LTreeA(left = left, method = method))
}
case class LNumC(left: Num, method: Method, sub: CTree) extends CTree {
  override def 反馈元素(num: Num, item: Item): Result     = sub.反馈上层(LNumRNumA(left = left, method = method, right = num), item)
  override def 反馈上层(aTree: ATree, item: Item): Result = sub.反馈上层(LNumRTreeA(left = left, method = method, right = aTree), item)
  override def 结束反馈上层(aTree: ATree): Result           = sub.结束反馈上层(LNumRTreeA(left = left, method = method, right = aTree))
  override def 结束反馈: Result                           = sub.结束反馈上层(LNumA(left = left, method = method))
}

trait Method {
  def 计算(bTree: BTree): Result
}

object 加法 extends Method {
  override def 计算(bTree: BTree): Result = bTree.向右获取(this)
}
