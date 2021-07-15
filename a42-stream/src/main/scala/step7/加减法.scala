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

trait NumRight
case class NumRightP(tail: NumRight, head: Item) extends NumRight
case object NumRightZero                         extends NumRight
