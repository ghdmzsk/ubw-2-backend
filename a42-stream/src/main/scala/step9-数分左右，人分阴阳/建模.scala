package step9

case class Item(name: String)

trait Result
case class ResultP(tail: Result, item: Item) extends Result {
  override def toString: String = s"($tail, ${item.name})"
}
case object ResultZero extends Result {
  override def toString: String = "Zero"
}

trait NumLP {
  def countRP(num: NumRP, item: Item): Result
}

trait NumLO {
  def countRO: Result
}

trait NumRP {
  def countLP(num: NumLO): Result
}

trait NumRO {
  def countLO: Result
}

trait 被加数 extends NumLO

case class 被加数P(tail: 被加数, head: Item) extends 被加数 {
  override def countRO: Result = ResultP(tail.countRO, head)
}

case object 被加数O extends 被加数 {
  override def countRO: Result = ResultZero
}

trait 加数 extends NumRP with NumRO

case class 加数P(tail: 加数, head: Item) extends 加数 {
  override def countLP(num: NumLO): Result = ResultP(tail.countLP(num), head)
  override def countLO: Result             = ResultP(tail.countLO, head)
}

case object 加数O extends 加数 {
  override def countLP(num: NumLO): Result = num.countRO
  override def countLO: Result             = ResultZero
}
