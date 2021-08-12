package part1

trait Result {
  def length: Int
}
case class ResultP(tail: Result) extends Result {
  override def length: Int = tail.length + 1
}
case object ResultO extends Result {
  override def length: Int = 0
}

trait NumL {
  var tail: NumL
  def methodR(num: NumR): Result
}

trait NumR {
  def tail: NumR
  def methodL(num: NumL): Result
}

case class 火(override val tail: NumR) extends NumR {
  override def methodL(num: NumL): Result = ResultP(tail.methodL(num))
}

case class 水(tail1: () => NumR) extends NumR {
  override def tail: NumR                 = tail1()
  override def methodL(num: NumL): Result = num.methodR(tail)
}

case object 左终结 extends NumL {
  override var tail: NumL                 = null
  override def methodR(num: NumR): Result = ResultO
}

case class 左正(override var tail: NumL) extends NumL {
  override def methodR(num: NumR): Result = num.methodL(tail)
}
