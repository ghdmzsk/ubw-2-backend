package step2

case class Item(name: String)

trait 数 {
  def 正向(number: 数): Result
  def 逆向(number: 数): Result
  def 计算: Result
}

trait Result
case class ResultPositive(value: Result) extends Result
case object ResultZero                   extends Result

trait PlusNumber extends 数 {
  override def 正向(number: 数): Result
  override def 逆向(number: 数): Result
  override def 计算: Result
}
case class PlusNumberPositive(tail: PlusNumber, head: Item) extends PlusNumber {
  override def 正向(number: 数): Result = number.交缠(tail)
  override def 逆向(number: 数): Result = ResultPositive(number.相冲(tail))
  override def 计算: Result            = ResultPositive(tail.计算)
}
case object PlusNumberZero extends PlusNumber {
  override def 正向(number: 数): Result = number.独自
  override def 逆向(number: 数): Result = number.独自
  override def 计算: Result            = ResultZero
}

trait MinusNumber extends 数 {
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
}

trait 主动消耗 extends 数
case class 主动消耗Positive(tail: 主动消耗, head: 数) extends 主动消耗 {
  override def 正向(number: 数): Result = ResultZero
  override def 逆向(number: 数): Result = ResultZero
  override def 计算: Result            = ResultZero
}
case object 主动消耗Zero extends 主动消耗 {
  override def 正向(number: 数): Result = ResultZero
  override def 逆向(number: 数): Result = ResultZero
  override def 计算: Result            = ResultZero
}

trait 被动消耗 extends 数
case class 被动消耗Positive(tail: 被动消耗, head: 数) extends 被动消耗 {
  override def 正向(number: 数): Result = ResultZero
  override def 逆向(number: 数): Result = ResultZero
  override def 计算: Result            = ResultZero
}
case object 被动消耗Zero extends 被动消耗 {
  override def 正向(number: 数): Result = ResultZero
  override def 逆向(number: 数): Result = ResultZero
  override def 计算: Result            = ResultZero
}
