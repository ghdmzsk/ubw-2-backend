package step3

case class Item(name: String)

trait 法 {
  def 向左走(number: 壳, item: Item): Result
  def 向左无害(number: 壳): Result
  def 向右走(number: 壳, item: Item): Result
  def 向右无害(number: 壳): Result
}

trait 壳 {
  def 向左走(number: 法, item: Item): Result
  def 向左无害(number: 法): Result
  def 向右走(number: 法, item: Item): Result
  def 向右无害(number: 法): Result
  def 向左计算(item: Item): Result
  def 向左无害计算: Result
  def 向右计算(item: Item): Result
  def 向右无害计算: Result
}

trait 主动消耗 {
  def 向右走(number: 被动消耗, item: Item): Result
  def 向右无害(number: 被动消耗): Result
  def 向右无害计算: Result
}

trait 被动消耗 {
  def 向左走(number: 主动消耗, item: Item): Result
  def 向左无害(number: 主动消耗): Result
  def 向左无害计算: Result
}

trait Result
case class ResultPositive(value: Result, item: Item) extends Result {
  override def toString: String = s"($value, $item)"
}
case object ResultZero extends Result {
  override def toString: String = "Zero"
}

trait PlusNumber extends 法 {
  override def 向左走(number: 壳, item: Item): Result
  override def 向左无害(number: 壳): Result
  override def 向右走(number: 壳, item: Item): Result
  override def 向右无害(number: 壳): Result
}
case class PlusNumberPositive(tail: PlusNumber, head: Item) extends PlusNumber {
  override def 向左走(number: 壳, item: Item): Result = number.向右无害(tail)
  override def 向左无害(number: 壳): Result            = number.向右走(tail, head)
  override def 向右走(number: 壳, item: Item): Result = number.向右走(this, item)
  override def 向右无害(number: 壳): Result            = number.向右无害(this)
  override def toString: String                   = s"加法正($tail, $head)"
}
case object PlusNumberZero extends PlusNumber {
  override def 向左走(number: 壳, item: Item): Result = number.向左计算(item)
  override def 向左无害(number: 壳): Result            = number.向左无害计算
  override def 向右走(number: 壳, item: Item): Result = number.向右计算(item)
  override def 向右无害(number: 壳): Result            = number.向右无害计算
  override def toString: String                   = "加零"
}

trait MinusNumber extends 法 {
  override def 向左走(number: 壳, item: Item): Result
  override def 向左无害(number: 壳): Result
  override def 向右走(number: 壳, item: Item): Result
  override def 向右无害(number: 壳): Result
}
case class MinusNumberPositive(tail: MinusNumber, head: Item) extends MinusNumber {
  override def 向左走(number: 壳, item: Item): Result = number.向左走(this, item)
  override def 向左无害(number: 壳): Result            = number.向左无害(this)
  override def 向右走(number: 壳, item: Item): Result = number.向左走(tail, head)
  override def 向右无害(number: 壳): Result            = number.向左无害(tail)
  override def toString: String                   = s"减正($tail)"
}
case object MinusNumberZero extends MinusNumber {
  override def 向左走(number: 壳, item: Item): Result = number.向左计算(item)
  override def 向左无害(number: 壳): Result            = number.向左无害计算
  override def 向右走(number: 壳, item: Item): Result = number.向右计算(item)
  override def 向右无害(number: 壳): Result            = number.向右无害计算
  override def toString: String                   = "减零"
}

case class 主动消耗正(tail: 主动消耗, 计算数: 法) extends 主动消耗 {
  override def 向右走(number: 被动消耗, item: Item): Result = 计算数.向右走(都套大壳(number, tail), item)
  override def 向右无害(number: 被动消耗): Result            = 计算数.向右无害(都套大壳(number, tail))
  override def 向右无害计算: Result                        = 计算数.向右无害(都套大壳(被动消耗零, tail))
  override def toString: String                      = s"主正($tail, $计算数)"
}
case object 主动消耗零 extends 主动消耗 {
  override def 向右走(number: 被动消耗, item: Item): Result = ResultPositive(number.向左无害计算, item)
  override def 向右无害(number: 被动消耗): Result            = number.向左无害计算
  override def 向右无害计算: Result                        = ResultZero
  override def toString: String                      = "主零"
}

case class 被动消耗正(tail: 被动消耗, 计算数: 法) extends 被动消耗 {
  override def 向左走(number: 主动消耗, item: Item): Result = 计算数.向左走(都套大壳(tail, number), item)
  override def 向左无害(number: 主动消耗): Result            = 计算数.向左无害(都套大壳(tail, number))
  override def 向左无害计算: Result                        = 计算数.向左无害(都套大壳(tail, 主动消耗零))
  override def toString: String                      = s"被正($tail, $计算数)"
}
case object 被动消耗零 extends 被动消耗 {
  override def 向左走(number: 主动消耗, item: Item): Result = number.向右无害计算
  override def 向左无害(number: 主动消耗): Result            = number.向右无害计算
  override def 向左无害计算: Result                        = ResultZero
  override def toString: String                      = "被零"
}

case class 都套大壳(tailLeft: 被动消耗, tailRight: 主动消耗) extends 壳 {
  override def 向左走(number: 法, item: Item): Result = tailLeft.向左走(主动消耗正(tailRight, number), item)
  override def 向左无害(number: 法): Result            = tailLeft.向左无害(主动消耗正(tailRight, number))
  override def 向右走(number: 法, item: Item): Result = tailRight.向右走(被动消耗正(tailLeft, number), item)
  override def 向右无害(number: 法): Result            = tailRight.向右无害(被动消耗正(tailLeft, number))
  override def 向左计算(item: Item): Result           = tailLeft.向左走(tailRight, item)
  override def 向左无害计算: Result                     = tailLeft.向左无害(tailRight)
  override def 向右计算(item: Item): Result           = tailRight.向右走(tailLeft, item)
  override def 向右无害计算: Result                     = tailRight.向右无害(tailLeft)
  override def toString: String                   = s"壳($tailLeft, $tailRight)"
}
