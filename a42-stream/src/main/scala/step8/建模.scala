package step8

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
  override def 被索取(cTree: CTree): Result = {
    Tagger.update(0)
    cTree.反馈元素(tail, head)
  }
}
case object NumZero extends Num {
  override def 被索取(cTree: CTree): Result = {
    Tagger.update(1)
    cTree.数结束反馈
  }
}

case class LRA(left: Num, method: Method, right: Num) extends Num {
  override def 被索取(cTree: CTree): Result = {
    Tagger.update(2)
    method.计算(LRB(left = left, right = right, sub = cTree))
  }
}
case class LA(left: Num, method: Method) extends Num {
  override def 被索取(cTree: CTree): Result = {
    Tagger.update(3)
    method.计算(LB(left = left, sub = cTree))
  }
}
case class RA(method: Method, right: Num) extends Num {
  override def 被索取(cTree: CTree): Result = {
    Tagger.update(4)
    method.计算(RB(right = right, sub = cTree))
  }
}

trait BTree {
  def 向右获取(method: MethodRight): Result
  def 向上反馈元素(method: Method, item: Item): Result
  def 向上结束反馈(method: Method): Result
  def 向左获取(method: MethodLeft): Result
}
case class LRB(left: Num, right: Num, sub: CTree) extends BTree {
  override def 向右获取(method: MethodRight): Result = {
    Tagger.update(5)
    right.被索取(LC(left = left, method = method, sub = sub))
  }
  override def 向上反馈元素(method: Method, item: Item): Result = {
    Tagger.update(6)
    sub.反馈元素(LRA(left = left, method = method, right = right), item)
  }
  override def 向上结束反馈(method: Method): Result = {
    Tagger.update(7)
    sub.树结束反馈(LRA(left = left, method = method, right = right))
  }
  override def 向左获取(method: MethodLeft): Result = {
    Tagger.update(8)
    left.被索取(RC(right = right, method = method, sub = sub))
  }
}
case class LB(left: Num, sub: CTree) extends BTree {
  override def 向右获取(method: MethodRight): Result = {
    Tagger.update(9)
    method.右结束反馈(this)
  }
  override def 向上反馈元素(method: Method, item: Item): Result = {
    Tagger.update(10)
    sub.反馈元素(LA(left = left, method = method), item)
  }
  override def 向上结束反馈(method: Method): Result = {
    Tagger.update(11)
    sub.树结束反馈(LA(left = left, method = method))
  }
  override def 向左获取(method: MethodLeft): Result = {
    Tagger.update(12)
    left.被索取(HasLeftMethodC(method = method, sub = sub))
  }
}
case class RB(right: Num, sub: CTree) extends BTree {
  override def 向右获取(method: MethodRight): Result = {
    Tagger.update(13)
    right.被索取(HasRightMethodC(method = method, sub = sub))
  }
  override def 向上反馈元素(method: Method, item: Item): Result = {
    Tagger.update(14)
    sub.反馈元素(RA(method = method, right = right), item)
  }
  override def 向上结束反馈(method: Method): Result = {
    Tagger.update(15)
    sub.树结束反馈(RA(method = method, right = right))
  }
  override def 向左获取(method: MethodLeft): Result = {
    Tagger.update(16)
    method.左结束反馈(this)
  }
}

trait CTree {
  def 反馈元素(num: Num, item: Item): Result
  def 数结束反馈: Result
  def 树结束反馈(aTree: Num): Result
}

case class LC(left: Num, method: MethodRight, sub: CTree) extends CTree {
  override def 反馈元素(num: Num, item: Item): Result = {
    Tagger.update(17)
    method.右反馈元素(LRB(left = left, right = num, sub = sub), item)
  }
  override def 数结束反馈: Result = {
    Tagger.update(18)
    method.右结束反馈(LB(left = left, sub = sub))
  }
  override def 树结束反馈(aTree: Num): Result = {
    Tagger.update(19)
    method.右结束反馈(LRB(left = left, right = aTree, sub = sub))
  }
}
case class HasRightMethodC(method: MethodRight, sub: CTree) extends CTree {
  override def 反馈元素(num: Num, item: Item): Result = {
    Tagger.update(20)
    method.右反馈元素(RB(right = num, sub = sub), item)
  }
  override def 数结束反馈: Result = {
    Tagger.update(21)
    sub.数结束反馈
  }
  override def 树结束反馈(aTree: Num): Result = {
    Tagger.update(22)
    method.右结束反馈(RB(right = aTree, sub = sub))
  }
}
case class RC(right: Num, method: MethodLeft, sub: CTree) extends CTree {
  override def 反馈元素(num: Num, item: Item): Result = {
    Tagger.update(23)
    method.左反馈元素(LRB(left = num, right = right, sub = sub), item)
  }
  override def 数结束反馈: Result = {
    Tagger.update(24)
    method.左结束反馈(RB(right = right, sub = sub))
  }
  override def 树结束反馈(aTree: Num): Result = {
    Tagger.update(25)
    method.左结束反馈(LRB(left = aTree, right = right, sub = sub))
  }
}
case class HasLeftMethodC(method: MethodLeft, sub: CTree) extends CTree {
  override def 反馈元素(num: Num, item: Item): Result = {
    Tagger.update(26)
    method.左反馈元素(LB(left = num, sub = sub), item)
  }
  override def 数结束反馈: Result = {
    Tagger.update(27)
    sub.数结束反馈
  }
  override def 树结束反馈(aTree: Num): Result = {
    Tagger.update(28)
    method.左结束反馈(LB(left = aTree, sub = sub))
  }
}

object CTreeZero extends CTree {
  override def 反馈元素(num: Num, item: Item): Result = {
    Tagger.update(29)
    ResultP(num.被索取(CTreeZero), item)
  }
  override def 数结束反馈: Result = {
    Tagger.update(30)
    ResultZero
  }
  override def 树结束反馈(aTree: Num): Result = {
    Tagger.update(31)
    aTree.被索取(CTreeZero)
  }
}

trait Method {
  def 计算(bTree: BTree): Result
}

trait MethodLeft {
  def 左反馈元素(bTree: BTree, item: Item): Result
  def 左结束反馈(bTree: BTree): Result
}

trait MethodRight {
  def 右反馈元素(bTree: BTree, item: Item): Result
  def 右结束反馈(bTree: BTree): Result
}

object Number {
  def count(aTree: Num): Result = aTree.被索取(CTreeZero)
}
