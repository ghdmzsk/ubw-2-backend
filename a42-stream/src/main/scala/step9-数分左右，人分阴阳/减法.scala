package step9

case object 减法 extends Method {
  override def 计算(bTree: BTree): Result = bTree.向左获取(减法尝试获取)
}
case object 减法尝试获取 extends MethodLeft {
  override def 左反馈元素(bTree: BTree, item: Item): Result = bTree.向右获取(附加减法有元素(item))
  override def 左结束反馈(bTree: BTree): Result             = bTree.向右获取(附加减法纯消耗)
}
case class 附加减法有元素(item: Item) extends MethodRight {
  override def 右反馈元素(bTree: BTree, item: Item): Result = bTree.向左获取(减法尝试获取)
  override def 右结束反馈(bTree: BTree): Result             = bTree.向上反馈元素(减法, item)
}
case object 附加减法纯消耗 extends MethodRight {
  override def 右反馈元素(bTree: BTree, item: Item): Result = bTree.向上结束反馈(减法)
  override def 右结束反馈(bTree: BTree): Result             = bTree.向上结束反馈(减法)
}
