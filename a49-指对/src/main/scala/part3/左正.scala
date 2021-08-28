package part3

case class 左正(override var tail: NumL) extends NumL {
  override def methodR(num: NumR): Result = num.methodL(tail)
}
