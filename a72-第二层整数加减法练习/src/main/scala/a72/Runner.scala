package a72

object Runner {

  def countNumber1(number1: Number1): Int = number1 match {
    case Number1S(tail, head) => countNumber1(tail) + countNumber2(head) + 1
    case Number1T             => 0
  }
  def countNumber2(number2: Number2): Int = number2 match {
    case Number2S(tail, head) => countNumber2(tail) + countNumber1(head) - 1
    case Number2T             => 0
  }

  def randomDeep: Int   = math.abs(util.Random.nextInt() % 10)
  def randomLength: Int = math.abs(util.Random.nextInt() % 6)

  def genNumber1(deep: Int): Number1 = {
    if (deep > randomDeep) {
      def genLeaf(length: Int): Number1 = if (length > 0) Number1S(genLeaf(length - 1), genNumber2(deep - 1)) else Number1T
      genLeaf(randomLength)
    } else
      Number1T
  }
  def genNumber2(deep: Int): Number2 = {
    if (deep > randomDeep) {
      def genLeaf(length: Int): Number2 = if (length > 0) Number2S(genLeaf(length - 1), genNumber1(deep - 1)) else Number2T
      genLeaf(randomLength)
    } else
      Number2T
  }

  def main(arr: Array[String]): Unit = {
    for {
      i <- 8 to 20
      _ <- 1 to 3
    } {
      val num1   = genNumber1(i)
      val num2   = genNumber2(i + 1)
      val num3   = num1.method1(num2)
      val count1 = countNumber1(num1)
      val count2 = countNumber2(num2)
      val count3 = countNumber2(num3)
      // println(s"$count1 + $count2 = $count3 ${count1 + count2 == count3}")
      assert(count1 + count2 == count3)
    }
  }

}
