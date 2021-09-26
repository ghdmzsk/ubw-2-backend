package 四法

package 测试1 {
// 减法：双向流动，都减少
// 加法：单向流动，我减少，你增加
// 位置：逆向单向流动，我减少，你减少（存疑）
  trait P7Num1 {
    def method2(num7: P7Num2): P7Result
  }
  case class P7Num1S(tail: P7Num1) extends P7Num1 {
    override def method2(num7: P7Num2): P7Result = num7.method1(tail)
  }
  case class P7Num1T(tail: () => P7Num1) extends P7Num1 {
    override def method2(num7: P7Num2): P7Result = tail().method2(num7)
  }

  trait P7Num2 {
    def method1(num7: P7Num1): P7Result
  }
  case class P7Num2S(tail: P7Num2) extends P7Num2 {
    override def method1(num7: P7Num1): P7Result = {
      Counter.count += 1
      P7ResultP(tail.method1(num7))
    }
  }
  case class P7Num2T(tail: () => P7Num2) extends P7Num2 {
    override def method1(num7: P7Num1): P7Result = num7.method2(tail())
  }

  object Counter {
    var count: Int = 0
  }

  trait P7Result
  case class P7ResultP(tail: P7Result) extends P7Result

  object Test1 extends App {
    lazy val num1: P7Num1     = P7Num1S(P7Num1S(P7Num1S(P7Num1S(P7Num1S(num1Zero)))))
    lazy val num1Zero: P7Num1 = P7Num1T(() => num1)

    lazy val num2: P7Num2     = P7Num2S(P7Num2S(P7Num2S(num2Zero)))
    lazy val num2Zero: P7Num2 = P7Num2T(() => num2)

    try {
      num1.method2(num2)
    } catch {
      case e: StackOverflowError =>
    }
    println(Counter.count)
  }

  object Test2 extends App {
    for (i <- 1 to 20) {
      var num = 0d
      for (num1 <- 1 to 200) {
        num += math.pow(1d / i.toDouble - 1d, num1 * 2 - 1) / (num1 * 2 - 1).toDouble
        num -= math.pow(1d / i.toDouble - 1d, num1 * 2) / (num1 * 2).toDouble
      }
      assert(math.log(i) + num < 0.000001d)
    }
  }
}
