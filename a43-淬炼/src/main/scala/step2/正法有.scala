package step2

/** 正法有，加法和乘法的正数部分
  */
case class 正法有(tail: NumR, head: Item) extends NumR {
  override def methodL(num: NumL, item: Item): Result = ResultP(tail.methodL(num, item), head)
}
