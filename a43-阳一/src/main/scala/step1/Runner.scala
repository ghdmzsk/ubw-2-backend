package step1

object Runner extends App {

  def results(items: Item*): Result = {
    var r: Result = ResultO
    items.foreach(i => r = ResultP(r, i))
    r
  }

  val item01 = Item("Item01")
  val item02 = Item("Item02")
  val item03 = Item("Item03")
  val item04 = Item("Item04")
  val item05 = Item("Item05")
  val item06 = Item("Item06")
  val item07 = Item("Item07")
  val item08 = Item("Item08")
  val item09 = Item("Item09")
  val item10 = Item("Item10")
  val item11 = Item("Item11")
  val item12 = Item("Item12")

  val number1 = 被加数P(被加数P(被加数P(被加数P(被加数O, item01), item02), item03), item04)
  val number2 = 加数P(加数P(加数P(加数O, item05), item06), item07)

  assert(number1.methodR(number2) == results(item01, item02, item03, item04, item05, item06, item07))

  val number3          = 被乘数P(被乘数P(被乘数P(被乘数P(被乘数O, item01), item02), item03), item04)
  lazy val number4: 乘数 = 乘数P(乘数P(乘数P(number5, item05), item06), item07)
  lazy val number5     = 乘数O(() => number4)

  val result1 = Vector(item05, item06, item07)
  assert(number3.methodR(number4) == results(result1 ++: result1 ++: result1 ++: result1: _*))

}
