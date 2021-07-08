package step2

case class Item(name: String)

trait 数 {
  def 向左走(number: 数): Result
  def 向右走(number: 数, item: Item): Result
  def 向左计算: Result
  def 向右计算(item: Item): Result
}

trait Result
case class ResultPositive(value: Result, item: Item) extends Result {
  override def toString: String = s"($value, $item)"
}
case object ResultZero extends Result {
  override def toString: String = "Zero"
}

trait PlusNumber extends 数 {
  override def 向左走(大壳: 数): Result
  override def 向右走(大壳: 数, item: Item): Result
  override def 向左计算: Result
  override def 向右计算(item: Item): Result
}
case class PlusNumberPositive(tail: PlusNumber, head: Item) extends PlusNumber {
  override def 向左走(大壳: 数): Result             = 大壳.向右走(tail, head)
  override def 向右走(大壳: 数, item: Item): Result = 大壳.向右走(PlusNumberPositive(tail, head), item)
  override def 向左计算: Result                   = ResultPositive(tail.向左计算, head)
  override def 向右计算(item: Item): Result       = ResultPositive(tail.向右计算(item), head)
}
case object PlusNumberZero extends PlusNumber {
  override def 向左走(大壳: 数): Result             = 大壳.向左计算
  override def 向右走(大壳: 数, item: Item): Result = 大壳.向右计算(item)
  override def 向左计算: Result                   = ResultZero
  override def 向右计算(item: Item): Result       = ResultPositive(ResultZero, item)
}

trait MinusNumber extends 数 {
  override def 向左走(大壳: 数): Result
  override def 向右走(大壳: 数, item: Item): Result
  override def 向左计算: Result
  override def 向右计算(item: Item): Result
}
case class MinusNumberPositive(tail: MinusNumber) extends MinusNumber {
  override def 向左走(大壳: 数): Result             = 大壳.向左走(MinusNumberPositive(tail))
  override def 向右走(大壳: 数, item: Item): Result = 大壳.向左走(tail)
  override def 向左计算: Result                   = tail.向左计算
  override def 向右计算(item: Item): Result       = tail.向右计算(item)
}
case object MinusNumberZero extends MinusNumber {
  override def 向左走(大壳: 数): Result             = 大壳.向左计算
  override def 向右走(大壳: 数, item: Item): Result = 大壳.向右计算(item)
  override def 向左计算: Result                   = ResultZero
  override def 向右计算(item: Item): Result       = ResultZero
}

trait 主动消耗 extends 数
case class 主动消耗Positive(主动消耗Tail: 数, 计算数: 数) extends 主动消耗 {
  override def 向左走(被动消耗: 数): Result             = 计算数.向左走(都套大壳(被动消耗, 主动消耗Tail))
  override def 向右走(被动消耗: 数, item: Item): Result = 计算数.向右走(都套大壳(被动消耗, 主动消耗Tail), item)
  override def 向左计算: Result                     = 计算数.向左走(都套大壳(被动消耗Zero, 主动消耗Tail))
  override def 向右计算(item: Item): Result         = 计算数.向右走(都套大壳(被动消耗Zero, 主动消耗Tail), item)
}
case object 主动消耗Zero extends 主动消耗 {
  override def 向左走(被动消耗: 数): Result             = 被动消耗.向左计算
  override def 向右走(被动消耗: 数, item: Item): Result = ResultPositive(被动消耗.向左计算, item)
  override def 向左计算: Result                     = ResultZero
  override def 向右计算(item: Item): Result         = ResultPositive(ResultZero, item)
}

trait 被动消耗 extends 数
case class 被动消耗Positive(被动消耗Tail: 数, 计算数: 数) extends 被动消耗 {
  override def 向左走(主动消耗: 数): Result             = 计算数.向左走(都套大壳(被动消耗Tail, 主动消耗))
  override def 向右走(主动消耗: 数, item: Item): Result = 计算数.向右走(都套大壳(被动消耗Tail, 主动消耗), item)
  override def 向左计算: Result                     = 计算数.向左走(都套大壳(被动消耗Tail, 主动消耗Zero))
  override def 向右计算(item: Item): Result         = 计算数.向右走(都套大壳(被动消耗Tail, 主动消耗Zero), item)
}
case object 被动消耗Zero extends 被动消耗 {
  override def 向左走(主动消耗: 数): Result             = 主动消耗.向左计算
  override def 向右走(主动消耗: 数, item: Item): Result = 主动消耗.向右计算(item)
  override def 向左计算: Result                     = ResultZero
  override def 向右计算(item: Item): Result         = ResultPositive(ResultZero, item)
}

trait 大壳 extends 数
case class 都套大壳(被动消耗: 数, 主动消耗: 数) extends 大壳 {
  override def 向左走(number: 数): Result             = 被动消耗.向左走(主动消耗Positive(主动消耗, number))
  override def 向右走(number: 数, item: Item): Result = 主动消耗.向右走(被动消耗Positive(被动消耗, number), item)
  override def 向左计算: Result                       = 被动消耗.向左走(主动消耗)
  override def 向右计算(item: Item): Result           = 主动消耗.向右走(被动消耗, item)
}
