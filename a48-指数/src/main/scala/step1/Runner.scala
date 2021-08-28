package step1

object Runner extends App {

  case class 左正(override var tail: NumL) extends NumL {
    override def methodR(num: NumR): Result = num.methodL(tail)
  }

  case class 左零(override var tail: NumL) extends NumL {
    override def methodR(num: NumR): Result = {
      if (tail.isInstanceOf[左零]) {
        val newZero = 左零(null)
        zero.tail = newZero
        zero = newZero
        tail.methodR(num)
      } else if (zero.isInstanceOf[左正]) {
        zero.tail = 左终结
        tail.methodR(num火)
      } else tail.methodR(num)
    }
  }

  case object 左终结 extends NumL {
    override var tail: NumL                 = null
    override def methodR(num: NumR): Result = ResultO
  }

  case class 风(override val tail: NumR) extends NumR {
    override def methodL(num: NumL): Result = {
      val newZero = 左正(null)
      zero.tail = newZero
      zero = newZero
      tail.methodL(num)
    }
  }

  case class 火(override val tail: NumR) extends NumR {
    override def methodL(num: NumL): Result = ResultP(tail.methodL(num))
  }

  case class 水(tail1: () => NumR) extends NumR {
    override def tail: NumR                 = tail1()
    override def methodL(num: NumL): Result = num.methodR(tail)
  }

  var zero: NumL      = 左正(null)
  val numL            = 左零(左零(左零(左零(zero))))
  lazy val numR: NumR = 风(风(风(numR1)))
  lazy val numR1      = 水(() => numR)
  lazy val num火: NumR = 火(火(火(num火1)))
  lazy val num火1      = 水(() => num火)

  println(numL.methodR(numR).length) // 81

}
