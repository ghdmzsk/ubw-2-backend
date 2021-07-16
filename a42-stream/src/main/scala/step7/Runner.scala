package step7

object Runner {

  def fromItem(items: Item*): Num = {
    var num: Num = NumZero
    items.foreach(f => num = NumP(num, f))
    num
  }

  def resultFromItem(items: Item*): Result = {
    var num: Result = ResultZero
    items.foreach(f => num = ResultP(num, f))
    num
  }

  val itemX   = Item("ItemX")
  val minus03 = Item("Minus03")
  val minus02 = Item("Minus02")
  val minus01 = Item("Minus01")
  val minus00 = Item("Minus00")
  val item01  = Item("Item01")
  val item02  = Item("Item02")
  val item03  = Item("Item03")
  val item04  = Item("Item04")
  val item05  = Item("Item05")
  val item06  = Item("Item06")
  val item07  = Item("Item07")
  val item08  = Item("Item08")
  val item09  = Item("Item09")
  val item10  = Item("Item10")
  val item11  = Item("Item11")
  val item12  = Item("Item12")

  def main(arr: Array[String]): Unit = {
    val number1 = fromItem(minus03, minus02, minus01, minus00)
    val number2 = fromItem(item01, item02, item03)
    val number3 = fromItem(item04, item05, item06, item07)
    val number4 = fromItem(item08, item09, item10)
    val number5 = fromItem(item11, item12)

    val count1 = LNumRNumA(left = number2, method = 加法, right = number3)
    val count2 = LTreeRNumA(left = count1, method = 加法, right = number4)
    val count3 = LNumRTreeA(left = number1, method = 加法, right = count2)
    val count4 = LTreeRNumA(left = count3, method = 加法, right = number5)
    val count5 = RTreeA(method = 加法, right = LTreeA(method = 加法, left = RTreeA(method = 加法, right = RTreeA(method = 加法, right = count3))))

    val result1 = Number.count(count1)
    println(result1)
    assert(result1 == resultFromItem(item01, item02, item03, item04, item05, item06, item07))

    val result2 = Number.count(count2)
    println(result2)
    assert(result2 == resultFromItem(item01, item02, item03, item04, item05, item06, item07, item08, item09, item10))

    val result3_1 = resultFromItem(minus03, minus02, minus01, minus00, item01, item02, item03, item04, item05, item06, item07, item08, item09, item10)
    val result3   = Number.count(count3)
    println(result3)
    assert(result3 == result3_1)

    val result4 = Number.count(count4)
    println(result4)
    assert(result4 == resultFromItem(minus03, minus02, minus01, minus00, item01, item02, item03, item04, item05, item06, item07, item08, item09, item10, item11, item12))

    val result5 = Number.count(count5)
    println(result5)
    assert(result5 == result3_1)
  }

}
