package step3

/** 中法，加减法的零，因为既有正法的特质，也有逆法的特质，故叫中法，中法既不放大，亦不收缩，刚好地把一个左数转化为值
  */
trait 中法 extends NumR {
  def tail: NumR
  override def methodL(num: NumL, item: Item): Result = ResultP(num.methodR(tail), item)
}
object 中法 {
  val 零: NumR = new 中法 {
    override def tail: NumR = 零
  }
}
