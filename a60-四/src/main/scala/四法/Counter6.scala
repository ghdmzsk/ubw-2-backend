package 四法

// 弱化的无限和零之间是很小
// 弱化的无限和零两个运算，在零的运算结束之前，削弱能力一样

package 无限 {
  trait P6Num1 {
    def method2(num6: P6Num2): Result
  }
  case class P6Num1S(tail: P6Num1) extends P6Num1 {
    override def method2(num6: P6Num2): Result = num6.method1(tail)
  }
  case class P6Num1T(tail: () => P6Num1) extends P6Num1 {
    override def method2(num6: P6Num2): Result = tail().method2(num6)
  }

  trait P6Num2 {
    def method1(num6: P6Num1): Result
  }
  case class P6Num2S(tail: P6Num2) extends P6Num2 {
    override def method1(num6: P6Num1): Result = num6.method2(tail)
  }
  case class P6Num2T(tail: () => P6Num2) extends P6Num2 {
    override def method1(num6: P6Num1): Result = ResultS(tail().method1(num6))
  }
}

package 零 {
  trait P6Num1 {
    def method2(num6: P6Num2): Result
  }
  case class P6Num1S(tail: P6Num1) extends P6Num1 {
    override def method2(num6: P6Num2): Result = num6.method1(tail)
  }
  case class P6Num1T(tail: () => P6Num1) extends P6Num1 {
    override def method2(num6: P6Num2): Result = tail().method2(num6)
  }

  trait P6Num2 {
    def method1(num6: P6Num1): Result
  }
  case class P6Num2S(tail: P6Num2) extends P6Num2 {
    override def method1(num6: P6Num1): Result = num6.method2(tail)
  }
  case object P6Num2T extends P6Num2 {
    override def method1(num6: P6Num1): Result = ResultT
  }
}
