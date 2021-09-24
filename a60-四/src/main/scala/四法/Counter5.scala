package 四法

// 强化的无限和自身之间是很大
// 强化的无限和自身两个运算，在自身运算结束之前，后继速度一样

package 无限 {
  trait P5Num1 {
    def method2(num5: P5Num2): Result
  }
  case class P5Num1S(tail: P5Num1) extends P5Num1 {
    override def method2(num5: P5Num2): Result = num5.method1(tail)
  }
  case class P5Num1T(tail: () => P5Num1) extends P5Num1 {
    override def method2(num5: P5Num2): Result = tail().method2(num5)
  }

  trait P5Num2 {
    def method1(num5: P5Num1): Result
  }
  case class P5Num2S(tail: P5Num2) extends P5Num2 {
    override def method1(num5: P5Num1): Result = ResultS(tail.method1(num5))
  }
  case class P5Num2T(tail: () => P5Num2) extends P5Num2 {
    override def method1(num5: P5Num1): Result = num5.method2(tail())
  }
}

package 自身 {
  trait P5Num1 {
    def method2(num5: P5Num2): Result
  }
  case class P5Num1S(tail: P5Num1) extends P5Num1 {
    override def method2(num5: P5Num2): Result = num5.method1(tail)
  }
  case class P5Num1T(tail: () => P5Num1) extends P5Num1 {
    override def method2(num5: P5Num2): Result = tail().method2(num5)
  }

  trait P5Num2 {
    def method1(num5: P5Num1): Result
  }
  case class P5Num2S(tail: P5Num2) extends P5Num2 {
    override def method1(num5: P5Num1): Result = ResultS(tail.method1(num5))
  }
  case object P5Num2T extends P5Num2 {
    override def method1(num5: P5Num1): Result = ResultT
  }
}
