package step2

case class Item(name: String)

trait 数 {
  def 向左走(number: 数): Result
  def 向右走(number: 数): Result
  def 向左计算: Result
  def 向右计算: Result
}

trait Result
case class ResultPositive(value: Result) extends Result
case object ResultZero                   extends Result

trait PlusNumber extends 数 {
  override def 向左走(大壳: 数): Result
  override def 向右走(大壳: 数): Result
  override def 向左计算: Result
  override def 向右计算: Result
}
case class PlusNumberPositive(tail: PlusNumber, head: Item) extends PlusNumber {
  override def 向左走(大壳: 数): Result = 大壳.向右走(tail)
  override def 向右走(大壳: 数): Result = 大壳.向右走(PlusNumberPositive(tail, head))
  override def 向左计算: Result       = ResultPositive(tail.向左计算)
  override def 向右计算: Result       = ResultPositive(tail.向右计算)
}
case object PlusNumberZero extends PlusNumber {
  override def 向左走(大壳: 数): Result = 大壳.向左计算
  override def 向右走(大壳: 数): Result = 大壳.向右计算
  override def 向左计算: Result       = ResultZero
  override def 向右计算: Result       = ResultZero
}

/*trait MinusNumber extends 数 {
  override def 正向(number: 数): Result
  override def 逆向(number: 数): Result
  override def 计算: Result
}
case class MinusNumberPositive(tail: MinusNumber) extends MinusNumber {
  override def 正向(number: 数): Result = number.交缠(tail)
  override def 逆向(number: 数): Result = number.相冲(tail)
  override def 计算: Result            = ResultZero
}
case object MinusNumberZero extends MinusNumber {
  override def 正向(number: 数): Result = number.独自
  override def 逆向(number: 数): Result = number.独自
  override def 计算: Result            = ResultZero
}*/

trait 主动消耗 extends 数
case class 主动消耗Positive(主动消耗Tail: 数, 计算数: 数) extends 主动消耗 {
  override def 向左走(被动消耗: 数): Result = 计算数.向左走(都套大壳(被动消耗, 主动消耗Tail))
  override def 向右走(被动消耗: 数): Result = 计算数.向右走(都套大壳(被动消耗, 主动消耗Tail))
  override def 向左计算: Result         = 向左走(被动消耗Zero)
  override def 向右计算: Result         = 向右走(被动消耗Zero)
}
case object 主动消耗Zero extends 主动消耗 {
  override def 向左走(被动消耗: 数): Result = 被动消耗.向左计算
  override def 向右走(被动消耗: 数): Result = ResultPositive(被动消耗.向左计算)
  override def 向左计算: Result         = ResultZero
  override def 向右计算: Result         = ResultZero
}

trait 被动消耗 extends 数
case class 被动消耗Positive(被动消耗Tail: 数, 计算数: 数) extends 被动消耗 {
  override def 向左走(主动消耗: 数): Result = 计算数.向左走(都套大壳(被动消耗Tail, 主动消耗))
  override def 向右走(主动消耗: 数): Result = 计算数.向右走(都套大壳(被动消耗Tail, 主动消耗))
  override def 向左计算: Result         = 向左走(主动消耗Zero)
  override def 向右计算: Result         = 向右走(主动消耗Zero)
}
case object 被动消耗Zero extends 被动消耗 {
  override def 向左走(主动消耗: 数): Result = 主动消耗.向右计算
  override def 向右走(主动消耗: 数): Result = 主动消耗.向右计算
  override def 向左计算: Result         = ResultZero
  override def 向右计算: Result         = ResultZero
}

trait 大壳 extends 数
case class 都套大壳(被动消耗: 数, 主动消耗: 数) extends 大壳 {
  override def 向左走(number: 数): Result = 被动消耗.向左走(主动消耗Positive(主动消耗, number))
  override def 向右走(number: 数): Result = 主动消耗.向右走(被动消耗Positive(被动消耗, number))
  override def 向左计算: Result           = 被动消耗.向左走(主动消耗)
  override def 向右计算: Result           = 主动消耗.向右走(被动消耗)
}
