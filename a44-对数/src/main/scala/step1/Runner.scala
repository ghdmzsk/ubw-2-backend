package step1

object Runner extends App {

  def results(items: Item*): Result = {
    var r: Result = ResultO
    items.foreach(i => r = ResultP(r, i))
    r
  }

  var zero: NumLPositive = null
  def numFromInt(n: Int): NumL = n match {
    case n1 if n1 > 0 => 左水(numFromInt(n1 - 1), Item(s"Item${n1}"))
    case 0 =>
      zero = 左土(左零, Item("Item01"))
      zero
  }

  case class 右风(tail: () => NumR) extends 风(tail) {
    override def methodL(num: NumL, item: Item): Result = {
      val newZero = 左水(左零, Item("Item02"))
      zero.tail = newZero
      zero = newZero
      super.methodL(num, item)
    }
  }

  case class 左土(override var tail: NumL, override val head: Item) extends 土 {
    override def methodR(num: NumR): Result = {
      val newZero = 左土(左零, Item("Item02"))
      zero.tail = newZero
      zero = newZero
      super.methodR(num)
    }
  }

  val number1            = numFromInt(8)
  lazy val number2: NumR = 右水(右水(右水(number3)))
  lazy val number3       = 右风(() => number2)
  println(number1.methodR(number2))

}
