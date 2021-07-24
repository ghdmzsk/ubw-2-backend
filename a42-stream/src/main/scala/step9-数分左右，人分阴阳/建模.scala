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
  def 左被索取(method: MethodLeft): Result
}
case class NumLeftP(tail: NumLeft, head: Item) extends NumLeft {
  override def 左被索取(method: MethodLeft): Result = method.接收反馈(tail, head)
}
case object NumLeftZero extends NumLeft {
  override def 左被索取(method: MethodLeft): Result = ResultZero
}

trait NumRight {
  def 右被索取(method: MethodRight): Result
}
case class NumRightP(tail: NumRight, head: Item) extends NumRight {
  override def 右被索取(method: MethodRight): Result = ResultZero
}
case object NumRightZero extends NumRight {
  override def 右被索取(method: MethodRight): Result = ResultZero
}

case class NumLTree (left: NumLeft)

trait MethodLeft {
  def 接收反馈(numLeft: NumLeft, item: Item): Result
}

object MethodL extends MethodLeft {
  override def 接收反馈(numLeft: NumLeft, item: Item): Result = ResultP(numLeft.左被索取(this), item)
}

trait MethodRight


