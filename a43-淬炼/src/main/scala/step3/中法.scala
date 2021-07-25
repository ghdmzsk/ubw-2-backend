package step3

/** 中法零，加减法的零，因为既有正法零的特质，也有逆法零的特质，故叫中法零，中法零既不放大，亦不收缩，刚好地把一个左数转化为值
  */
case class 中法(tail: () => NumR) extends NumR {
  override def methodL(num: NumL, item: Item): Result = ResultP(num.methodR(tail()), item)
}
object 中法 {
  val 零: NumR = 中法(() => 零)
}
