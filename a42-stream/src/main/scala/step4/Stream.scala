package step4

case class Item(name: String)

trait 法 {
  def 向左走(b: 被动消耗, z: 主动消耗, item: Item): Result
  def 向左无害(b: 被动消耗, z: 主动消耗): Result
  def 向右走(b: 被动消耗, z: 主动消耗, item: Item): Result
  def 向右无害(b: 被动消耗, z: 主动消耗): Result
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
  override def 向左走(b: 被动消耗, z: 主动消耗, item: Item): Result
  override def 向左无害(b: 被动消耗, z: 主动消耗): Result
  override def 向右走(b: 被动消耗, z: 主动消耗, item: Item): Result
  override def 向右无害(b: 被动消耗, z: 主动消耗): Result
}
case class PlusNumberPositive(tail: PlusNumber, head: Item) extends PlusNumber {
  override def 向左走(b: 被动消耗, z: 主动消耗, item: Item): Result = z.向右无害(被动消耗正(b, tail))
  override def 向左无害(b: 被动消耗, z: 主动消耗): Result            = z.向右走(被动消耗正(b, tail), head)
  override def 向右走(b: 被动消耗, z: 主动消耗, item: Item): Result = z.向右走(被动消耗正(b, this), item)
  override def 向右无害(b: 被动消耗, z: 主动消耗): Result            = z.向右无害(被动消耗正(b, this))
  override def toString: String                          = s"加法正($tail, $head)"
}
case object PlusNumberZero extends PlusNumber {
  override def 向左走(b: 被动消耗, z: 主动消耗, item: Item): Result = b.向左走(z, item)
  override def 向左无害(b: 被动消耗, z: 主动消耗): Result            = b.向左无害(z)
  override def 向右走(b: 被动消耗, z: 主动消耗, item: Item): Result = z.向右走(b, item)
  override def 向右无害(b: 被动消耗, z: 主动消耗): Result            = z.向右无害(b)
  override def toString: String                          = "加零"
}

trait MinusNumber extends 法 {
  override def 向左走(b: 被动消耗, z: 主动消耗, item: Item): Result
  override def 向左无害(b: 被动消耗, z: 主动消耗): Result
  override def 向右走(b: 被动消耗, z: 主动消耗, item: Item): Result
  override def 向右无害(b: 被动消耗, z: 主动消耗): Result
}
case class MinusNumberPositive(tail: MinusNumber, head: Item) extends MinusNumber {
  override def 向左走(b: 被动消耗, z: 主动消耗, item: Item): Result = b.向左走(主动消耗正(z, this), item)
  override def 向左无害(b: 被动消耗, z: 主动消耗): Result            = b.向左无害(主动消耗正(z, this))
  override def 向右走(b: 被动消耗, z: 主动消耗, item: Item): Result = b.向左无害(主动消耗正(z, tail))
  override def 向右无害(b: 被动消耗, z: 主动消耗): Result            = b.向左走(主动消耗正(z, tail), head)
  override def toString: String                          = s"减正($tail)"
}
case object MinusNumberZero extends MinusNumber {
  override def 向左走(b: 被动消耗, z: 主动消耗, item: Item): Result = b.向左走(z, item)
  override def 向左无害(b: 被动消耗, z: 主动消耗): Result            = b.向左无害(z)
  override def 向右走(b: 被动消耗, z: 主动消耗, item: Item): Result = z.向右走(b, item)
  override def 向右无害(b: 被动消耗, z: 主动消耗): Result            = z.向右无害(b)
  override def toString: String                          = "减零"
}

case class 主动消耗正(tail: 主动消耗, 计算数: 法) extends 主动消耗 {
  override def 向右走(number: 被动消耗, item: Item): Result = 计算数.向右走(number, tail, item)
  override def 向右无害(number: 被动消耗): Result            = 计算数.向右无害(number, tail)
  override def 向右无害计算: Result                        = 计算数.向右无害(被动消耗零, tail)
  override def toString: String                      = s"主正($tail, $计算数)"
}
case object 主动消耗零 extends 主动消耗 {
  override def 向右走(number: 被动消耗, item: Item): Result = ResultPositive(number.向左无害计算, item)
  override def 向右无害(number: 被动消耗): Result            = number.向左无害计算
  override def 向右无害计算: Result                        = ResultZero
  override def toString: String                      = "主零"
}

case class 被动消耗正(tail: 被动消耗, 计算数: 法) extends 被动消耗 {
  override def 向左走(number: 主动消耗, item: Item): Result = 计算数.向左走(tail, number, item)
  override def 向左无害(number: 主动消耗): Result            = 计算数.向左无害(tail, number)
  override def 向左无害计算: Result                        = 计算数.向左无害(tail, 主动消耗零)
  override def toString: String                      = s"被正($tail, $计算数)"
}
case object 被动消耗零 extends 被动消耗 {
  override def 向左走(number: 主动消耗, item: Item): Result = number.向右无害计算
  override def 向左无害(number: 主动消耗): Result            = number.向右无害计算
  override def 向左无害计算: Result                        = ResultZero
  override def toString: String                      = "被零"
}
