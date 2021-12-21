package step3

object Runner extends App {

  def results(items: Item*): Result = {
    var r: Result = ResultO
    items.foreach(i => r = ResultP(r, i))
    r
  }
  def 左数go(n: Int): NumL = {
    n match {
      case n1 if n1 > 0 => 左数有(左数go(n1 - 1), Item(s"Item${n1}"))
      case 0            => 左数零
    }
  }

  val itemX  = Item("ItemX")
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
  val number2 = 正法(正法(正法(中法.零, item05), item06), item07)

  assert(number1.methodR(number2) == results(item01, item02, item03, item04, item05, item06, item07))

  val number3            = 左数有(左数有(左数有(左数有(左数零, item01), item02), item03), item04)
  lazy val number4: NumR = 正法(正法(正法(number5, item05), item06), item07)
  lazy val number5       = 逆法(number4)

  val result1 = Vector(item05, item06, item07)
  assert(number3.methodR(number4) == results(result1 ++: result1 ++: result1 ++: result1: _*))

  val number6 = 左数有(左数有(左数有(左数有(左数零, item01), item02), item03), item04)
  val number7 = 逆法(逆法(逆法(中法.零)))
  assert(number6.methodR(number7) == ResultP(ResultO, item01))

  val number8 = 左数有(左数有(左数有(左数有(左数零, item01), item02), item03), item04)
  val number9 = 逆法(逆法(逆法(逆法(中法.零))))
  assert(number8.methodR(number9) == ResultO)

  val number10 = 左数有(左数有(左数有(左数有(左数零, item01), item02), item03), item04)
  val number11 = 逆法(逆法(逆法(逆法(逆法(中法.零)))))
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
  lazy val number13: NumR = 逆法(逆法(逆法(number14)))
  lazy val number14       = 正法(number13, itemX)
  assert(number12.methodR(number14) == results(itemX, itemX, itemX, itemX, itemX))

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
  lazy val number16: NumR = 逆法(逆法(逆法(number17)))
  lazy val number17       = 正法(number16, itemX)
  assert(number15.methodR(number17) == results(itemX, itemX, itemX, itemX, itemX))

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
  lazy val number19: NumR = 逆法(逆法(逆法(number20)))
  lazy val number20       = 正法(number19, itemX)
  assert(number18.methodR(number20) == results(itemX, itemX, itemX, itemX, itemX, itemX))

  trait Number21 extends NumR {
    var tail1: NumR
  }

  case class Number21P(override var tail1: NumR, override val head: Item) extends Number21 with 正法 {
    override def tail: NumR = {
      val zero1 = Number21O2(null)
      val num   = Number21P(Number21P(Number21P(zero1, item01), item02), item03)
      number21.tail1 = num
      number21 = zero1
      tail1
    }
  }
  case class Number21O1(override var tail1: NumR) extends Number21 with 逆法 {
    override def tail: NumR = {
      val zero = Number21O1(null)
      number21.tail1 = zero
      number21 = zero
      tail1
    }
  }
  case class Number21O2(override var tail1: NumR) extends Number21 with 微法 {
    override def tail: NumR = tail1
  }

  var number21: Number21 = null
  var number22: NumR     = null

  def reset1 = {
    number21 = Number21O1(null)
    number22 = Number21P(Number21P(number21, item01), item02)
  }

  reset1
  assert(ResultP(左数go(6).methodR(number22), item01).length == 729) // 3 ^ 6 = 729
  reset1
  assert(ResultP(左数go(7).methodR(number22), item01).length == 2187) // 3 ^ 7 = 2187
  reset1
  assert(ResultP(左数go(8).methodR(number22), item01).length == 6561) // 3 ^ 8 = 6561
  reset1
  assert(ResultP(左数零.methodR(number22), item01).length == 1) // 3 ^ 0 = 1

  case class Number22P(override var tail1: NumR) extends Number21 with 逆法 {
    override def tail: NumR = {
      val zero1 = Number22O2(null)
      val num   = Number22P(Number22P(Number22P(zero1)))
      number23.tail1 = num
      number23 = zero1
      tail1
    }
  }
  case class Number22O1(override var tail1: NumR, override val head: Item) extends Number21 with 正法 {
    override def tail: NumR = {
      val zero = Number22O1(null, head)
      number23.tail1 = zero
      number23 = zero
      tail1
    }
  }
  case class Number22O2(override var tail1: NumR) extends Number21 with 微法 {
    override def tail: NumR = tail1
  }

  var number23: Number21 = null
  var number24: NumR     = null

  def reset2 = {
    number23 = Number22O1(null, item01)
    number24 = Number22P(Number22P(number23))
  }

  reset2
  assert(左数go(728).methodR(number24).length == 5) // log(3, 728) = 5
  reset2
  assert(左数go(729).methodR(number24).length == 6) // log(3, 729) = 6
  reset2
  assert(左数go(730).methodR(number24).length == 6) // log(3, 730) = 6
  reset2
  assert(左数go(2186).methodR(number24).length == 6) // log(3, 2186) = 6
  reset2
  assert(左数go(2187).methodR(number24).length == 7) // log(3, 2187) = 7
  reset2
  assert(左数go(2188).methodR(number24).length == 7) // log(3, 2188) = 7
  reset2
  assert(左数go(1).methodR(number24).length == 0) // log(3, 1) = 0

}
