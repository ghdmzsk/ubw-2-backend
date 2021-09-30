package a62.除法

object Runner {
  def number1gen(n: Int): Number1 = n match {
    case n1 if n1 > 0 => Number1S(number1gen(n1 - 1))
    case 0            => Number1T
  }
  def number2gen(n: Int): (Number2, Number2) = {
    def gen(n1: Int, zero: => Number2): Number2 = n1 match {
      case n2 if n2 > 0 => Number2S(gen(n2 - 1, zero))
      case 0            => zero
    }
    lazy val number2s: Number2 = gen(n, number2t)
    lazy val number2t: Number2 = Number2T(() => number2s)
    (number2s, number2t)
  }
  def count(num: Num): Int = num match {
    case NumS(tail) => count(tail) + 1
    case NumT       => 0
  }

  // 乘法和除法都是，如果 number1 作为主调用方，那么他就会优先减弱，number2 是无限，没法通过大小补充，所以它会使用函数体有后继的那个部分投入运算
  // 如果是 number1 作为传入参数，则代表 number1 延后减弱，相对于情况一强化了，为了表示行为上的弱化，number2 就用函数体没有后继的部分
  def main(arr: Array[String]): Unit = {
    {
      val number1      = number1gen(23154)
      val (_, number2) = number2gen(125)
      assert(count(number1.method1(number2)) == 23154 / 125 + 1)
    }
    {
      val number1      = number1gen(23154)
      val (number2, _) = number2gen(125)
      assert(count(number2.method2(number1)) == 23154 / 125)
    }
  }
}
