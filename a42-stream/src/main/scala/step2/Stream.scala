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
  override def 正向(number: 数): Result = number.逆向(tail)
  override def 逆向(number: 数): Result = number.正向(PlusNumberPositive(tail, head))
  override def 计算: Result            = ResultPositive(tail.计算)
}
case object PlusNumberZero extends PlusNumber {
  override def 正向(number: 数): Result = number.计算
  override def 逆向(number: 数): Result = number.计算
  override def 计算: Result            = ResultZero
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
case class 主动消耗Positive(tail: 数 /*主动消耗*/, head: 数) extends 主动消耗 {
  override def 正向(number: 数): Result = head.正向(都套大壳(tail, number))
  override def 逆向(number: 数): Result = ResultZero
  override def 计算: Result            = ResultZero
}
case object 主动消耗Zero extends 主动消耗 {
  override def 正向(number: 数): Result = ResultZero
  override def 逆向(number: 数): Result = ResultPositive(number.正向(主动消耗Zero))
  override def 计算: Result            = ResultZero
}

trait 被动消耗 extends 数
case class 被动消耗Positive(tail: 数 /*被动消耗*/, head: 数) extends 被动消耗 {
  override def 正向(number: 数): Result = ResultZero
  override def 逆向(number: 数): Result = head.逆向(都套大壳(tail, head))
  override def 计算: Result            = 正向(主动消耗Zero)
}
case object 被动消耗Zero extends 被动消耗 {
  override def 正向(number: 数): Result = {
    println(number)
    number.逆向(被动消耗Zero)
  }
  override def 逆向(number: 数): Result = ResultPositive(number.逆向(被动消耗Zero))
  override def 计算: Result            = ResultZero
}

trait 大壳 extends 数
case class 都套大壳(tailLeft: 数 /*主动消耗*/, tailRight: 数 /*被动消耗*/ ) extends 大壳 {
  override def 正向(number: 数): Result = {
    println("正向")
    println("tailLeft: " + tailLeft)
    println("tailRight: " + tailRight)
    println("number: " + number)
    主动消耗Positive(tailLeft, number).正向(tailRight)
  }
  override def 逆向(number: 数): Result = {
    println("逆向")
    println("tailLeft: " + tailLeft)
    println("tailRight: " + tailRight)
    println("number: " + number)
    被动消耗Positive(tailRight, number).逆向(tailLeft)
  }
  override def 计算: Result = ResultZero
}
