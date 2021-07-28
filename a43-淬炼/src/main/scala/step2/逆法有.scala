package step2

/** 逆法有，减法和除法的正数部分
  */
case class 逆法有(tail: NumR, head: Item) extends NumR {
  override def methodL(num: NumL, item: Item): Result = num.methodR(tail)
}
