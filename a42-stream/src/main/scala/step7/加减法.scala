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
  def 右被索取(cTree: CTree): Result = cTree.右反馈元素(tail, head)
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
}
case class LTreeRTreeB(left: ATree, right: ATree, sub: CTree) extends BTree {
  def 向右获取(method: Method): Result = right.被索取(LTreeC(left = left, method = method, sub = sub))
}
case class LNumRTreeB(left: NumLeft, right: ATree, sub: CTree) extends BTree {
  def 向右获取(method: Method): Result = right.被索取(LNumC(left = left, method = method, sub = sub))
}
case class LTreeRNumB(left: ATree, right: NumRight, sub: CTree) extends BTree {
  def 向右获取(method: Method): Result = right.右被索取(LTreeC(left = left, method = method, sub = sub))
}
case class LNumRNumB(left: NumLeft, right: NumRight, sub: CTree) extends BTree {
  def 向右获取(method: Method): Result = right.右被索取(LNumC(left = left, method = method, sub = sub))
}
case class LTreeB(left: ATree, sub: CTree) extends BTree {
  def 向右获取(method: Method): Result = sub.结束反馈上层(LTreeA(left = left, method = method))
}
case class LNumB(left: NumLeft, sub: CTree) extends BTree {
  def 向右获取(method: Method): Result = sub.结束反馈上层(LNumA(left = left, method = method))
}
case class RNumB(right: NumRight, sub: CTree) extends BTree {
  def 向右获取(method: Method): Result = right.右被索取(RNumMethodC(method = method, sub = sub))
}
case class RTreeB(right: ATree, sub: CTree) extends BTree {
  def 向右获取(method: Method): Result = right.被索取(RTreeMethodC(method = method, sub = sub))
}

trait CTree {
  def 右反馈元素(method: NumRight, item: Item): Result
  def 反馈上层(aTree: ATree, item: Item): Result
  def 结束反馈上层(aTree: ATree): Result
  def 右结束反馈: Result
}
case class LTreeC(left: ATree, method: Method, sub: CTree) extends CTree {
  override def 右反馈元素(num: NumRight, item: Item): Result = sub.反馈上层(LTreeRNumA(left = left, method = method, right = num), item)
  override def 反馈上层(aTree: ATree, item: Item): Result   = sub.反馈上层(LTreeRTreeA(left = left, method = method, right = aTree), item)
  override def 结束反馈上层(aTree: ATree): Result             = sub.结束反馈上层(LTreeRTreeA(left = left, method = method, right = aTree))
  override def 右结束反馈: Result                            = sub.结束反馈上层(LTreeA(left = left, method = method))
}
case class LNumC(left: NumLeft, method: Method, sub: CTree) extends CTree {
  override def 右反馈元素(num: NumRight, item: Item): Result = sub.反馈上层(LNumRNumA(left = left, method = method, right = num), item)
  override def 反馈上层(aTree: ATree, item: Item): Result   = sub.反馈上层(LNumRTreeA(left = left, method = method, right = aTree), item)
  override def 结束反馈上层(aTree: ATree): Result             = sub.结束反馈上层(LNumRTreeA(left = left, method = method, right = aTree))
  override def 右结束反馈: Result                            = sub.结束反馈上层(LNumA(left = left, method = method))
}
case class RNumMethodC(method: Method, sub: CTree) extends CTree {
  override def 右反馈元素(num: NumRight, item: Item): Result = sub.反馈上层(RNumA(method = method, right = num), item)
  override def 反馈上层(aTree: ATree, item: Item): Result   = sub.反馈上层(RTreeA(method = method, right = aTree), item) // ×
  override def 结束反馈上层(aTree: ATree): Result             = sub.结束反馈上层(RTreeA(method = method, right = aTree))
  override def 右结束反馈: Result                            = sub.右结束反馈                                              // ×
}
case class RTreeMethodC(method: Method, sub: CTree) extends CTree {
  override def 右反馈元素(num: NumRight, item: Item): Result = sub.反馈上层(RNumA(method = method, right = num), item)
  override def 反馈上层(aTree: ATree, item: Item): Result   = sub.反馈上层(RTreeA(method = method, right = aTree), item) // ×
  override def 结束反馈上层(aTree: ATree): Result             = sub.结束反馈上层(RTreeA(method = method, right = aTree))
  override def 右结束反馈: Result                            = sub.右结束反馈                                              // ×
}

trait Method {
  def 计算(bTree: BTree): Result
}

object 加法 extends Method {
  override def 计算(bTree: BTree): Result = bTree.向右获取(this)
}
