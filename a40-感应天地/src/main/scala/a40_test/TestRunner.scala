package a40_test

object Runner {

  def main(arr: Array[String]): Unit = {
    println(TopNumber2(MiddleNumber2(MiddleNumber2(MiddleNumber2(BottomNumber2)))).method1.length) // 242
    println(TopNumber1(MiddleNumber2(MiddleNumber1(MiddleNumber0(BottomNumber2)))).method1.length) // 146
    println(
      TopNumber0(MiddleNumber0(MiddleNumber0(MiddleNumber0(MiddleNumber0(MiddleNumber2(MiddleNumber2(MiddleNumber2(MiddleNumber2(BottomNumber2))))))))).method1.length
    ) // 242
  }

}
