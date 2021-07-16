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
    {
      val number1 = fromItem(minus03, minus02, minus01, minus00)
      val number2 = fromItem(item01, item02, item03)
      val number3 = fromItem(item04, item05, item06, item07)
      val number4 = fromItem(item08, item09, item10)
      val number5 = fromItem(item11, item12)

      val count1 = LRA(left = number2, method = 加法, right = number3)
      val count2 = LRA(left = count1, method = 加法, right = number4)
      val count3 = LRA(left = number1, method = 加法, right = count2)
      val count4 = LRA(left = count3, method = 加法, right = number5)
      val count5 = RA(method = 加法, right = LA(method = 加法, left = RA(method = 加法, right = RA(method = 加法, right = count3))))

      val result1 = Number.count(count1)
      // 3 + 4 = 7
      println("result1: " + result1)
      assert(result1 == resultFromItem(item01, item02, item03, item04, item05, item06, item07))

      val result2 = Number.count(count2)
      // (3 + 4) + 3 = 10
      println("result2: " + result2)
      assert(result2 == resultFromItem(item01, item02, item03, item04, item05, item06, item07, item08, item09, item10))

      val result3_1 = resultFromItem(minus03, minus02, minus01, minus00, item01, item02, item03, item04, item05, item06, item07, item08, item09, item10)
      val result3   = Number.count(count3)
      // 4 + ((3 + 4) + 3) = 14
      println("result3: " + result3)
      assert(result3 == result3_1)

      val result4 = Number.count(count4)
      // (4 + ((3 + 4) + 3)) + 2 = 16
      println("result4: " + result4)
      assert(
        result4 == resultFromItem(minus03, minus02, minus01, minus00, item01, item02, item03, item04, item05, item06, item07, item08, item09, item10, item11, item12)
      )

      val result5 = Number.count(count5)
      // +(+(+(+(4 + ((3 + 4) + 3))))) = 14
      println("result5: " + result5)
      assert(result5 == result3_1)
    }

    print("\n")

    {
      val number1 = fromItem(item01, item02, item03, item04, item05, item06)
      val number2 = fromItem(item07, item08, item09)
      val number3 = fromItem(item10)
      val number4 = fromItem(item01, item02, item03)
      val number5 = fromItem(item04, item05)

      val count1  = LRA(left = number1, method = 减法, right = number2)
      val result1 = Number.count(count1)
      // 6 - 3 = 3
      println("result1: " + result1)
      assert(result1 == resultFromItem(item01, item02, item03))

      val count2  = LRA(left = number2, method = 减法, right = number1)
      val result2 = Number.count(count2)
      // 3 - 6 = 0
      println("result2: " + result2)
      assert(result2 == ResultZero)

      val count3  = LRA(left = number1, method = 减法, right = LRA(left = number2, method = 加法, right = number3))
      val result3 = Number.count(count3)
      // 6 - (3 + 1) = 2
      println("result3: " + result3)
      assert(result3 == resultFromItem(item01, item02))

      val count4  = RA(right = count3, method = 减法)
      val result4 = Number.count(count4)
      // -(6 - (3 + 1)) = 0
      println("result4: " + result4)
      assert(result4 == ResultZero)

      val count5  = LA(left = count4, method = 减法)
      val result5 = Number.count(count5)
      // -(-(6 - (3 + 1))) = 0
      println("result5: " + result5)
      assert(result5 == ResultZero)

      val count6  = LRA(left = LRA(left = number4, method = 加法, LA(left = count4, method = 减法)), method = 加法, right = number5)
      val result6 = Number.count(count6)
      // (3 + -(-(6 - (3 + 1)))) + 2 = 5
      println("result6: " + result6)
      assert(result6 == resultFromItem(item01, item02, item03, item04, item05))
    }
  }

}
