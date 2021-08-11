package step1

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
