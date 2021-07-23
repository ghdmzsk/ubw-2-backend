package step9

case class Item(name: String)

trait Result
case class ResultP(tail: Result, item: Item) extends Result {
  override def toString: String = s"($tail, ${item.name})"
}
case object ResultZero extends Result {
  override def toString: String = "Zero"
}

trait NumLeft {
  def 左被索取(cTree: LeftCTree, method: MethodLeft): Result
}
case class NumP(tail: NumLeft, head: Item) extends NumLeft {
  override def 左被索取(cTree: LeftCTree, method: MethodLeft): Result = cTree.反馈元素(tail, head)
}
case object NumLeftZero extends NumLeft {
  override def 左被索取(cTree: LeftCTree, method: MethodLeft): Result = cTree.数结束反馈
}

trait NumRight {
  def 右被索取(cTree: RightCTree, method: MethodRight): Result
}
case class NumP(tail: NumRight, head: Item) extends NumRight {
  override def 右被索取(cTree: RightCTree, method: MethodRight): Result = cTree.反馈元素(tail, head)
}
case object NumRightZero extends NumRight {
  override def 右被索取(cTree: RightCTree, method: MethodRight): Result = cTree.数结束反馈
}

case class NumLR(left: NumLeft, right: NumRight) extends NumLeft with NumRight {
  override def 左被索取(cTree: LeftCTree, method: MethodLeft): Result   = ResultZero
  override def 右被索取(cTree: RightCTree, method: MethodRight): Result = ResultZero
}
