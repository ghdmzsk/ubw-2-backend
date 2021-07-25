package step1

case class Item(name: String)

trait Result
case class ResultP(tail: Result, head: Item) extends Result {
  override def toString: String = s"(${tail}, ${head.name})"
}
case object ResultO extends Result {
  override def toString: String = "Zero"
}

trait NumL {
  def methodR(num: NumR): Result
}
trait NumR {
  def methodL(num: NumL, item: Item): Result
}

trait 被加数 extends NumL
case class 被加数P(tail: 被加数, head: Item) extends 被加数 {
  override def methodR(num: NumR): Result = num.methodL(tail, head)
}
case object 被加数O extends 被加数 {
  override def methodR(num: NumR): Result = ResultO
}
trait 加数 extends NumR
case class 加数P(tail: 加数, head: Item) extends 加数 {
  override def methodL(num: NumL, item: Item): Result = ResultP(tail.methodL(num, item), head)
}
// 如果是 case object，允许 this，因为在 type projection 没有出现构造行为。
case object 加数O extends 加数 {
  override def methodL(num: NumL, item: Item): Result = ResultP(num.methodR(加数O), item)
}

trait 被减数 extends NumL
case class 被减数P(tail: 被减数, head: Item) extends 被减数 {
  override def methodR(num: NumR): Result = num.methodL(tail, head)
}
case object 被减数O extends 被减数 {
  override def methodR(num: NumR): Result = ResultO
}
trait 减数 extends NumR
case class 减数P(tail: 减数, head: Item) extends 减数 {
  override def methodL(num: NumL, item: Item): Result = num.methodR(tail)
}
case object 减数O extends 减数 {
  override def methodL(num: NumL, item: Item): Result = ResultP(num.methodR(减数O), item)
}

trait 被乘数 extends NumL
case class 被乘数P(tail: 被乘数, head: Item) extends 被乘数 {
  override def methodR(num: NumR): Result = num.methodL(tail, head)
}
case object 被乘数O extends 被乘数 {
  override def methodR(num: NumR): Result = ResultO
}
trait 乘数 extends NumR
case class 乘数P(tail: 乘数, head: Item) extends 乘数 {
  override def methodL(num: NumL, item: Item): Result = ResultP(tail.methodL(num, item), head)
}
case class 乘数O(tail: () => 乘数) extends 乘数 {
  override def methodL(num: NumL, item: Item): Result = num.methodR(tail())
}

trait 被除数 extends NumL

case class 被除数P(tail: 被除数, head: Item) extends 被除数 {
  override def methodR(num: NumR): Result = num.methodL(tail, head)
}
case object 被除数O extends 被除数 {
  override def methodR(num: NumR): Result = ResultO
}
trait 除数 extends NumR
case class 除数P(tail: 除数, head: Item) extends 除数 {
  override def methodL(num: NumL, item: Item): Result = num.methodR(tail)
}
case class 除数O(tail: () => 除数) extends 除数 {
  override def methodL(num: NumL, item: Item): Result = ResultP(tail().methodL(num, item), item)
}
