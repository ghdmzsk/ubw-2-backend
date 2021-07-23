package step8

object 加法 extends Method {
  override def 计算(bTree: BTree): Result = {
    Tagger.update(32)
    bTree.向右获取(加法右)
  }
}

object 加法左 extends MethodLeft {
  override def 左反馈元素(bTree: BTree, item: Item): Result = {
    Tagger.update(33)
    bTree.向上反馈元素(method = 加法, item)
  }
  override def 左结束反馈(bTree: BTree): Result = {
    Tagger.update(34)
    bTree.向上结束反馈(加法)
  }
}

object 加法右 extends MethodRight {
  override def 右反馈元素(bTree: BTree, item: Item): Result = {
    Tagger.update(35)
    bTree.向上反馈元素(method = 加法, item)
  }
  override def 右结束反馈(bTree: BTree): Result = {
    Tagger.update(36)
    bTree.向左获取(加法左)
  }
}
