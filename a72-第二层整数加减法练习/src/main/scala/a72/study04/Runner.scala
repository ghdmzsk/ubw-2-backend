package a72.study04

object Runner {

  def counterNumber(number1: () => Number1): Int = {
    try {
      number1() match {
        case Number1S(tail) => counterNumber(tail) + 1
        case Number1T       => 0
        case Number1U       => 0
      }
    } catch {
      case _: StackOverflowError => 0
    }
  }

  def number1Gen(n: Int): Number1 = if (n > 0) Number1S(() => number1Gen(n - 1)) else Number1U

  def main(arr: Array[String]): Unit = {
    {
      val number1_01 = Number1S(() => Number1S(() => Number1S(() => Number1S(() => Number1U))))
      val number1_02 = Number1S(() => Number1S(() => Number1S(() => Number1S(() => number1_01))))
      val number1_03 = Number1S(() => Number1S(() => Number1S(() => Number1S(() => number1_02))))
      val number2    = Number1S(() => Number1T)
      val result1    = Counter.counter1(() => number1_03, () => number2, () => Number1T)
      println(counterNumber(() => result1))
    }
    {
      val number1 = number1Gen(377)
      val number2 = Number1S(() => Number1T)
      val result1 = Counter.counter1(() => number1, () => number2, () => Number1T)
      println(counterNumber(() => result1))
    }
  }

}
