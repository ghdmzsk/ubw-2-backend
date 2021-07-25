package step2

/** 中法零，加减法的零，因为既有正法零的特质，也有逆法零的特质，故叫中法零
  */
case class 中法零(tail: () => NumR) extends NumR {
  override def methodL(num: NumL, item: Item): Result = ResultP(num.methodR(tail()), item)
}
object 中法零 {
  val value: NumR = 中法零(() => value)
}
