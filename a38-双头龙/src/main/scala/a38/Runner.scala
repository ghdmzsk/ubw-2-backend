package a38

object Runner {

  def fromIntImpl(n: Int, num: Number1): Number1 = n match {
    case i if i > 0 => fromIntImpl(i - 1, Number5.method1(num))
    case 0          => num
  }
  def fromInt(n: Int): Number1 = fromIntImpl(n, Number3_1(Number4_Bottom_1))

  def main(arr: Array[String]): Unit = {
    for (i <- 0 to 20) {
      println(fromInt(i).value)
    }
// Value(3,10)
// Value(4,11)
// Value(5,12)
// Value(6,20)
// Value(7,21)
// Value(8,22)
// Value(9,100)
// Value(10,101)
// Value(11,102)
// Value(12,110)
// Value(13,111)
// Value(14,112)
// Value(15,120)
// Value(16,121)
// Value(17,122)
// Value(18,200)
// Value(19,201)
// Value(20,202)
// Value(21,210)
// Value(22,211)
// Value(23,212)
  }

}
