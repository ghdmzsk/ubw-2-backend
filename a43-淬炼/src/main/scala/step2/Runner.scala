package step2

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
  val item13 = Item("Item13")
  val item14 = Item("Item14")
  val item15 = Item("Item15")
  val item16 = Item("Item16")

  val number1 = 左数有(左数有(左数有(左数有(左数零, item01), item02), item03), item04)
  val number2 = 正法有(正法有(正法有(中法零.value, item05), item06), item07)

  assert(number1.methodR(number2) == results(item01, item02, item03, item04, item05, item06, item07))

  val number3            = 左数有(左数有(左数有(左数有(左数零, item01), item02), item03), item04)
  lazy val number4: NumR = 正法有(正法有(正法有(number5, item05), item06), item07)
  lazy val number5       = 正法零(() => number4)

  val result1 = Vector(item05, item06, item07)
  assert(number3.methodR(number4) == results(result1 ++: result1 ++: result1 ++: result1: _*))

  val number6 = 左数有(左数有(左数有(左数有(左数零, item01), item02), item03), item04)
  val number7 = 逆法有(逆法有(逆法有(中法零.value, item06), item07), item08)
  assert(number6.methodR(number7) == ResultP(ResultO, item01))

  val number8 = 左数有(左数有(左数有(左数有(左数零, item01), item02), item03), item04)
  val number9 = 逆法有(逆法有(逆法有(逆法有(中法零.value, item05), item06), item07), item08)
  assert(number8.methodR(number9) == ResultO)

  val number10 = 左数有(左数有(左数有(左数有(左数零, item01), item02), item03), item04)
  val number11 = 逆法有(逆法有(逆法有(逆法有(逆法有(中法零.value, item05), item06), item07), item08), item09)
  assert(number10.methodR(number11) == ResultO)

  val number12 =
    左数有(
      左数有(
        左数有(
          左数有(
            左数有(
              左数有(左数有(左数有(左数有(左数有(左数有(左数有(左数有(左数有(左数零, item01), item02), item03), item04), item05), item06), item07), item08), item09),
              item10
            ),
            item11
          ),
          item12
        ),
        item13
      ),
      item14
    )
  lazy val number13: NumR = 逆法有(逆法有(逆法有(number14, item01), item02), item03)
  lazy val number14       = 逆法零(() => number13)
  assert(number12.methodR(number14) == results(item02, item05, item08, item11, item14))

  val number15 =
    左数有(
      左数有(
        左数有(
          左数有(
            左数有(
              左数有(
                左数有(左数有(左数有(左数有(左数有(左数有(左数有(左数有(左数有(左数零, item01), item02), item03), item04), item05), item06), item07), item08), item09),
                item10
              ),
              item11
            ),
            item12
          ),
          item13
        ),
        item14
      ),
      item15
    )
  lazy val number16: NumR = 逆法有(逆法有(逆法有(number17, item01), item02), item03)
  lazy val number17       = 逆法零(() => number16)
  assert(number15.methodR(number17) == results(item03, item06, item09, item12, item15))

  val number18 =
    左数有(
      左数有(
        左数有(
          左数有(
            左数有(
              左数有(
                左数有(
                  左数有(左数有(左数有(左数有(左数有(左数有(左数有(左数有(左数有(左数零, item01), item02), item03), item04), item05), item06), item07), item08), item09),
                  item10
                ),
                item11
              ),
              item12
            ),
            item13
          ),
          item14
        ),
        item15
      ),
      item16
    )
  lazy val number19: NumR = 逆法有(逆法有(逆法有(number20, item01), item02), item03)
  lazy val number20       = 逆法零(() => number19)
  assert(number18.methodR(number20) == results(item01, item04, item07, item10, item13, item16))

}
