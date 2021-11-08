package a70

object Runner {

  case class NumberTag(zdPositive: String, zdZero: String, bdPositive: String, bdZero: String) {
    override def toString: String = s"(${zdPositive}: Positive, ${zdZero}: Zero).method1(${bdPositive}: Positive, ${bdZero}: Zero)"
  }

  val gen1: List[(Number1, String)] = {
    lazy val number1: Number1 = Number1S(() => number1)
    lazy val number2: Number1 = Number1T(() => number2)
    lazy val number3: Number1 = Number1U(() => number3)
    lazy val number4: Number1 = Number1V(() => number4)
    List((number1, "Number1S"), (number2, "Number1T"), (number3, "Number1U"), (number4, "Number1V"))
  }

  def gen2(n: Int, zero: Number1): List[(Number1, String)] = {
    def number1(n1: Int): Number1 = if (n1 > 0) Number1S(() => number1(n1 - 1)) else zero
    def number2(n1: Int): Number1 = if (n1 > 0) Number1T(() => number2(n1 - 1)) else zero
    def number3(n1: Int): Number1 = if (n1 > 0) Number1U(() => number3(n1 - 1)) else zero
    def number4(n1: Int): Number1 = if (n1 > 0) Number1V(() => number4(n1 - 1)) else zero
    List(
      (number1(n), "Number1S"),
      (number2(n), "Number1T"),
      (number3(n), "Number1U"),
      (number4(n), "Number1V")
    )
  }

  def gen3(n1: Int, n2: Int): List[(Number1, Number1, NumberTag)] = {
    val number1List = for {
      s <- gen1
      t <- gen2(n1, s._1)
    } yield (t._1, t._2, s._2)
    val number2List = for {
      s <- gen1
      t <- gen2(n2, s._1)
    } yield (t._1, t._2, s._2)
    for {
      num1 <- number1List
      num2 <- number2List
    } yield (num1._1, num2._1, NumberTag(zdPositive = num1._2, zdZero = num1._3, bdPositive = num2._2, bdZero = num2._3))
  }

  val data = ((10, 3), (3, 10), (93, 93), (0, 0), (56, 25), (86, 32), (52, 72), (20, 32))

  val number = gen3(data._1._1, data._1._2)
    .zip(gen3(data._2._1, data._2._2))
    .zip(gen3(data._3._1, data._3._2))
    .zip(gen3(data._4._1, data._4._2))
    .zip(gen3(data._5._1, data._5._2))
    .zip(gen3(data._6._1, data._6._2))
    .zip(gen3(data._7._1, data._7._2))
    .zip(gen3(data._8._1, data._8._2))
    .map { case (((((((number1, number2), number3), number4), number5), number6), number7), number8) =>
      (
        (number1._1, number1._2, data._1._1, data._1._2),
        (number2._1, number2._2, data._2._1, data._2._2),
        (number3._1, number3._2, data._3._1, data._3._2),
        (number4._1, number4._2, data._4._1, data._4._2),
        (number5._1, number5._2, data._5._1, data._5._2),
        (number6._1, number6._2, data._6._1, data._6._2),
        (number7._1, number7._2, data._7._1, data._7._2),
        (number8._1, number8._2, data._8._1, data._8._2),
        number1._3
      )
    }

  def main(arr: Array[String]): Unit = {
    println(
      number
        .map { s =>
          val n1 = Counter.count(() => s._1._1.method1(s._1._2))
          val n2 = Counter.count(() => s._2._1.method1(s._2._2))
          val n3 = Counter.count(() => s._3._1.method1(s._3._2))
          // val n4    = Counter.count(() => s._4._1.method1(s._4._2))
          val 不是无限大 = n1.isDefined && n2.isDefined && n3.isDefined
          def 不过大   = n1.get < 200 && n2.get < 200 && n3.get < 200
          (不是无限大 && 不过大, s)
        }
        .filter(_._1)
        .map { case (_, s) =>
          val n5    = Counter.count(() => s._5._1.method1(s._5._2)).get
          val n6    = Counter.count(() => s._6._1.method1(s._6._2)).get
          val n7    = Counter.count(() => s._7._1.method1(s._7._2)).get
          val n8    = Counter.count(() => s._8._1.method1(s._8._2)).get
          val m1    = n5 - s._5._3
          val m2    = n5 - s._5._4
          val m3    = n6 - s._6._3
          val m4    = n6 - s._6._4
          val m5    = n5 - s._5._3 * 2
          val m6    = n5 - s._5._4 * 2
          val m7    = n6 - s._6._3 * 2
          val m8    = n6 - s._6._4 * 2
          val 是最小值1 = m1 == m3 || m5 == m7
          val 是最大值1 = m2 == m4 || m6 == m8

          val m9    = n7 - s._7._3
          val m10   = n7 - s._7._4
          val m11   = n8 - s._8._3
          val m12   = n8 - s._8._4
          val m13   = n7 - s._7._3 * 2
          val m14   = n7 - s._7._4 * 2
          val m15   = n8 - s._8._3 * 2
          val m16   = n8 - s._8._4 * 2
          val 是最小值2 = m9 == m11 || m13 == m15
          val 是最大值2 = m10 == m12 || m14 == m16

          val 不为固定值1 = n5 != n6
          val 不为固定值2 = n7 != n8
          val 不为固定值3 = 不为固定值1 || 不为固定值2

          (!是最小值1 && !是最大值1 && !是最小值2 && !是最大值2 && 不为固定值3, s)
        }
        .filter(_._1)
        .map(_._2._9)
        .mkString("\n")
    )

    // (Number1U: Positive, Number1T: Zero).method1(Number1S: Positive, Number1V: Zero)
    // (Number1V: Positive, Number1T: Zero).method1(Number1S: Positive, Number1U: Zero)
    // (Number1V: Positive, Number1T: Zero).method1(Number1V: Positive, Number1U: Zero)
    // (Number1S: Positive, Number1U: Zero).method1(Number1S: Positive, Number1T: Zero)
    // (Number1S: Positive, Number1U: Zero).method1(Number1V: Positive, Number1T: Zero)
    // (Number1V: Positive, Number1U: Zero).method1(Number1V: Positive, Number1T: Zero)
    // (Number1S: Positive, Number1V: Zero).method1(Number1S: Positive, Number1T: Zero)
    // (Number1S: Positive, Number1V: Zero).method1(Number1U: Positive, Number1T: Zero)
    // (Number1S: Positive, Number1V: Zero).method1(Number1S: Positive, Number1V: Zero)
    // (Number1S: Positive, Number1V: Zero).method1(Number1U: Positive, Number1V: Zero)
    // (Number1U: Positive, Number1V: Zero).method1(Number1S: Positive, Number1V: Zero)
    // (Number1U: Positive, Number1V: Zero).method1(Number1U: Positive, Number1V: Zero)

  }

}
