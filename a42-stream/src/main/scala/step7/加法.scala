package step7

object 加法 extends Method with MethodLeft with MethodRight {
  override def 计算(bTree: BTree): Result                = bTree.向右获取(this)
  override def 右反馈元素(bTree: BTree, item: Item): Result = bTree.向上反馈元素(method = this, item)
  override def 右结束反馈(bTree: BTree): Result             = bTree.向左获取(this)
  override def 左反馈元素(bTree: BTree, item: Item): Result = bTree.向上反馈元素(method = this, item)
  override def 左结束反馈(bTree: BTree): Result             = bTree.向上结束反馈(this)
}
