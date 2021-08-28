package part3

case class 左正(tail: NumL) extends NumL {
  override def 入队(num: NumL): NumL        = 左正(tail.入队(num))
  override def methodR(num: NumR): Result = num.methodL(tail)
}
