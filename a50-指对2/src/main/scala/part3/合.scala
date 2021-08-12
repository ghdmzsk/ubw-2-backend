package part3

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
  def 入队(num: NumL): NumL
  def methodR(num: NumR): Result
}
case object 左终结 extends NumL {
  override def 入队(num: NumL): NumL        = num
  override def methodR(num: NumR): Result = ResultO
}

trait NumR {
  def methodL(num: NumL): Result
}
