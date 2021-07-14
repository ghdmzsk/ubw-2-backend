package step2

case class Item(name: String)

trait 法 {
  def 向左走(number: 壳, 向左元素: Item): Result
  def 向左无害(number: 壳): Result
  def 向右走(number: 壳, 向右元素: Item): Result
  def 向右无害(number: 壳): Result
}

trait 壳 {
  def 向左走(number: 法, 向左元素: Item): Result
  def 向左无害(number: 法): Result
  def 向右走(number: 法, 向右元素: Item): Result
  def 向右无害(number: 法): Result
  def 向左计算(向左元素: Item): Result
  def 向左无害计算: Result
  def 向右计算(向右元素: Item): Result
  def 向右无害计算: Result
}

trait 主动消耗 {
  // def 向左走(number: 被动消耗, 向左元素: Item): Result
  // def 向左无害(number: 被动消耗): Result
  def 向右走(number: 被动消耗, 向右元素: Item): Result
  def 向右无害(number: 被动消耗): Result
  // def 向左计算(向左元素: Item): Result
  // def 向左无害计算: Result
  def 向右计算(向右元素: Item): Result
  def 向右无害计算: Result
}

trait 被动消耗 {
  def 向左走(number: 主动消耗, 向左元素: Item): Result
  def 向左无害(number: 主动消耗): Result
  // def 向右走(number: 主动消耗, 向右元素: Item): Result
  // def 向右无害(number: 主动消耗): Result
  def 向左计算(向左元素: Item): Result
  def 向左无害计算: Result
  // def 向右计算(向右元素: Item): Result
  // def 向右无害计算: Result
}

trait Result {
  override def toString: String = Result.toList(this).toString()
}
case class ResultPositive(value: Result, item: Item) extends Result {
  override def toString: String = s"($value, $item)"
}
case object ResultZero extends Result {
  override def toString: String = "Zero"
}

object Result {
  def toList(result: Result): Vector[Any] = result match {
    case ResultPositive(ResultPositive(value, item1), item2) => toList(value).appended(item1).appended(item2)
    case ResultPositive(value, item)                         => toList(value).appended(item)
    case ResultZero                                          => Vector.empty
  }
}

trait PlusNumber extends 法 {
  override def 向左走(大壳: 壳, 向左元素: Item): Result
  override def 向左无害(number: 壳): Result
  override def 向右走(大壳: 壳, 向右元素: Item): Result
  override def 向右无害(大壳: 壳): Result
}
case class PlusNumberPositive(tail: PlusNumber, head: Item) extends PlusNumber {
  override def 向左走(大壳: 壳, 向左元素: Item): Result = 大壳.向右无害(tail)
  override def 向左无害(大壳: 壳): Result            = 大壳.向右走(tail, head)
  override def 向右走(大壳: 壳, 向右元素: Item): Result = 大壳.向右走(PlusNumberPositive(tail, head), 向右元素)
  override def 向右无害(大壳: 壳): Result            = 大壳.向右走(tail, head)
  override def toString: String               = s"加法正($tail, $head)"
}
case object PlusNumberZero extends PlusNumber {
  override def 向左走(大壳: 壳, 向左元素: Item): Result = 大壳.向左计算(向左元素)
  override def 向左无害(大壳: 壳): Result            = 大壳.向左无害计算
  override def 向右走(大壳: 壳, 向右元素: Item): Result = 大壳.向右计算(向右元素)
  override def 向右无害(大壳: 壳): Result            = 大壳.向右无害计算
  override def toString: String               = s"加零"
}

trait MinusNumber extends 法 {
  override def 向左走(大壳: 壳, 向左元素: Item): Result
  override def 向左无害(number: 壳): Result
  override def 向右走(大壳: 壳, 向右元素: Item): Result
  override def 向右无害(大壳: 壳): Result
}
case class MinusNumberPositive(tail: MinusNumber, head: Item) extends MinusNumber {
  override def 向左走(大壳: 壳, 向左元素: Item): Result = 大壳.向左走(MinusNumberPositive(tail, head), 向左元素)
  override def 向左无害(大壳: 壳): Result            = 大壳.向左无害(MinusNumberPositive(tail, head))
  override def 向右走(大壳: 壳, 向右元素: Item): Result = {
    // println("减正向右走")
    // println(大壳)
    大壳.向左走(tail, head)
  }
  override def 向右无害(大壳: 壳): Result = {
    // println("减正向右无害")
    // println(大壳)
    大壳.向左无害(tail)
  }
  override def toString: String = s"减正($tail)"
}
case object MinusNumberZero extends MinusNumber {
  override def 向左走(大壳: 壳, 向左元素: Item): Result = 大壳.向左计算(向左元素)
  override def 向左无害(大壳: 壳): Result            = 大壳.向左无害计算
  override def 向右走(大壳: 壳, 向右元素: Item): Result = {
    // println("减零向右走")
    // println(大壳)
    大壳.向右计算(向右元素)
  }
  override def 向右无害(大壳: 壳): Result = {
    // println("减零向右无害")
    // println(大壳)
    大壳.向右无害计算
  }
  override def toString: String = "减零"
}

case class 主动消耗Positive(主动消耗Tail: 主动消耗, 计算数: 法) extends 主动消耗 {
  // override def 向左走(被动消耗: 被动消耗, 向左元素: Item): Result = 计算数.向左走(都套大壳(被动消耗, 主动消耗Tail), 向左元素)
  // override def 向左无害(被动消耗: 被动消耗): Result            = 计算数.向左无害(都套大壳(被动消耗, 主动消耗Tail))
  override def 向右走(被动消耗: 被动消耗, 向右元素: Item): Result = 计算数.向右走(都套大壳(被动消耗, 主动消耗Tail), 向右元素)
  override def 向右无害(被动消耗: 被动消耗): Result            = 计算数.向右无害(都套大壳(被动消耗, 主动消耗Tail))
  // override def 向左计算(向左元素: Item): Result            = 计算数.向左走(都套大壳(被动消耗Zero, 主动消耗Tail), 向左元素)
  // override def 向左无害计算: Result                      = 计算数.向左无害(都套大壳(被动消耗Zero, 主动消耗Tail))
  override def 向右计算(向右元素: Item): Result = {
    // println("向右计算：" + 主动消耗Tail)
    计算数.向右走(都套大壳(被动消耗Zero, 主动消耗Tail), 向右元素)
  }
  override def 向右无害计算: Result = {
    // println("向右无害计算：" + 主动消耗Tail)
    计算数.向右无害(都套大壳(被动消耗Zero, 主动消耗Tail))
  }
  override def toString: String = s"主正($主动消耗Tail, $计算数)"
}
case object 主动消耗Zero extends 主动消耗 {
  // override def 向左走(被动消耗: 被动消耗, 向左元素: Item): Result = 被动消耗.向左计算(向左元素)
  // override def 向左无害(被动消耗: 被动消耗): Result            = 被动消耗.向左无害计算
  override def 向右走(被动消耗: 被动消耗, 向右元素: Item): Result = ResultPositive(被动消耗.向左无害计算, 向右元素)
  override def 向右无害(被动消耗: 被动消耗): Result            = 被动消耗.向左无害计算
  // override def 向左计算(向左元素: Item): Result            = ResultZero
  // override def 向左无害计算: Result                      = ResultZero
  override def 向右计算(向右元素: Item): Result = ResultPositive(ResultZero, 向右元素)
  override def 向右无害计算: Result           = ResultZero
  override def toString: String         = s"主零"
}

case class 被动消耗Positive(被动消耗Tail: 被动消耗, 计算数: 法) extends 被动消耗 {
  override def 向左走(主动消耗: 主动消耗, 向左元素: Item): Result = {
    // println("向左走" + 主动消耗)
    计算数.向左走(都套大壳(被动消耗Tail, 主动消耗), 向左元素)
  }
  override def 向左无害(主动消耗: 主动消耗): Result = 计算数.向左无害(都套大壳(被动消耗Tail, 主动消耗))
  // override def 向右走(主动消耗: 主动消耗, 向右元素: Item): Result = 计算数.向右走(都套大壳(被动消耗Tail, 主动消耗), 向右元素)
  // override def 向右无害(主动消耗: 主动消耗): Result = 计算数.向右无害(都套大壳(被动消耗Tail, 主动消耗))
  override def 向左计算(向左元素: Item): Result = 计算数.向左走(都套大壳(被动消耗Tail, 主动消耗Zero), 向左元素)
  override def 向左无害计算: Result           = 计算数.向左无害(都套大壳(被动消耗Tail, 主动消耗Zero))
  // override def 向右计算(向右元素: Item): Result = 计算数.向右走(都套大壳(被动消耗Tail, 主动消耗Zero), 向右元素)
  // override def 向右无害计算: Result           = 计算数.向右无害(都套大壳(被动消耗Tail, 主动消耗Zero))
  override def toString: String = s"被正($被动消耗Tail, $计算数)"
}
case object 被动消耗Zero extends 被动消耗 {
  override def 向左走(主动消耗: 主动消耗, 向左元素: Item): Result = 主动消耗.向右无害计算
  override def 向左无害(主动消耗: 主动消耗): Result            = 主动消耗.向右无害计算
  // override def 向右走(主动消耗: 主动消耗, 向右元素: Item): Result = 主动消耗.向右计算(向右元素)
  // override def 向右无害(主动消耗: 主动消耗): Result            = 主动消耗.向右无害计算
  override def 向左计算(向左元素: Item): Result = ResultZero
  override def 向左无害计算: Result           = ResultZero
  // override def 向右计算(向右元素: Item): Result = ResultPositive(ResultZero, 向右元素)
  // override def 向右无害计算: Result           = ResultZero
  override def toString: String = s"被零"
}

// trait 大壳 extends 数
case class 都套大壳(被动消耗: 被动消耗, 主动消耗: 主动消耗) extends 壳 {
  override def 向左走(number: 法, 向左元素: Item): Result = {
    println("被动消耗：" + 被动消耗)
    println("主动消耗：" + 主动消耗)
    println("数：" + number)
    被动消耗.向左走(主动消耗Positive(主动消耗, number), 向左元素)
  }
  override def 向左无害(number: 法): Result            = 被动消耗.向左无害(主动消耗Positive(主动消耗, number))
  override def 向右走(number: 法, 向右元素: Item): Result = 主动消耗.向右走(被动消耗Positive(被动消耗, number), 向右元素)
  override def 向右无害(number: 法): Result            = 主动消耗.向右无害(被动消耗Positive(被动消耗, number))
  override def 向左计算(向左元素: Item): Result           = 被动消耗.向左走(主动消耗, 向左元素)
  override def 向左无害计算: Result                     = 被动消耗.向左无害(主动消耗)
  override def 向右计算(向右元素: Item): Result           = 主动消耗.向右走(被动消耗, 向右元素)
  override def 向右无害计算: Result                     = 主动消耗.向右无害(被动消耗)
  override def toString: String                   = s"壳($被动消耗, $主动消耗)"
}
