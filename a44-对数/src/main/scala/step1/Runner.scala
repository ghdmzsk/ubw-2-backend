package step1

object Runner extends App {

  // 定义阶段
  var zero: NumL    = null
  var number2: NumR = null

  case class 右风(tail: () => NumR) extends 风(tail) {
    override def methodL(num: NumL, item: Item): Result = {
      val newZero = 左水(null, Item("Item02"))
      zero.tail = newZero
      zero = newZero
      super.methodL(num, item)
    }
  }

  case class 左火(override var tail: NumL, override val head: Item) extends 火 {
    override def methodR(num: NumR): Result = {
      if (zero.isInstanceOf[火]) {
        ResultO
      } else {
        val newZero = 左火(null, head)
        zero.tail = newZero
        zero = newZero
        super.methodR(number2)
      }
    }
  }

  // 测试运行阶段
  def numLFromInt(n: Int): NumL = n match {
    case n1 if n1 > 0 => 左水(numLFromInt(n1 - 1), Item(s"Item${n1}"))
    case 0 =>
      zero = 左火(null, Item("Item01"))
      zero
  }
  def numRFromInt(n: Int): Unit = {
    def num1(n1: Int, tail: NumR): NumR = {
      n1 match {
        case n2 if n2 > 0 => 右水(num1(n2 - 1, tail))
        case 0            => tail
      }
    }
    lazy val num2: NumR = num1(n, num3)
    lazy val num3: NumR = 右风(() => num2)
    number2 = num2
  }

  def printlnLog(num1: Int, num2: Int): Unit = {
    val number3 = numLFromInt(num2)
    numRFromInt(num1)
    val result3 = number3.methodR(number2)
    val result4 = (math.log(num2) / math.log(num1)).toInt
    val result5 = (math.log(num2 - 1) / math.log(num1)).toInt
    println(s"log($num1, $num2), result left: ${result3.length}, result right: $result4")
    /*if (result4 == result5)
      assert(result3.length == result4 + 1)
    else
      assert(result3.length == result4)*/
  }

  for (i <- 1 to math.pow(2, 8).toInt) {
    printlnLog(4, i)
  }

  /** log(4, 1), result left: 0, result right: 0
    * log(4, 2), result left: 0, result right: 0
    * log(4, 3), result left: 0, result right: 0
    * log(4, 4), result left: 0, result right: 1
    * log(4, 5), result left: 1, result right: 1
    * log(4, 6), result left: 1, result right: 1
    * log(4, 7), result left: 1, result right: 1
    * log(4, 8), result left: 1, result right: 1
    * log(4, 9), result left: 1, result right: 1
    * log(4, 10), result left: 1, result right: 1
    * log(4, 11), result left: 1, result right: 1
    * log(4, 12), result left: 1, result right: 1
    * log(4, 13), result left: 1, result right: 1
    * log(4, 14), result left: 1, result right: 1
    * log(4, 15), result left: 1, result right: 1
    * log(4, 16), result left: 1, result right: 2
    * log(4, 17), result left: 1, result right: 2
    * log(4, 18), result left: 1, result right: 2
    * log(4, 19), result left: 1, result right: 2
    * log(4, 20), result left: 1, result right: 2
    * log(4, 21), result left: 2, result right: 2
    * log(4, 22), result left: 2, result right: 2
    * log(4, 23), result left: 2, result right: 2
    * log(4, 24), result left: 2, result right: 2
    * log(4, 25), result left: 2, result right: 2
    * log(4, 26), result left: 2, result right: 2
    * log(4, 27), result left: 2, result right: 2
    * log(4, 28), result left: 2, result right: 2
    * log(4, 29), result left: 2, result right: 2
    * log(4, 30), result left: 2, result right: 2
    * log(4, 31), result left: 2, result right: 2
    * log(4, 32), result left: 2, result right: 2
    * log(4, 33), result left: 2, result right: 2
    * log(4, 34), result left: 2, result right: 2
    * log(4, 35), result left: 2, result right: 2
    * log(4, 36), result left: 2, result right: 2
    * log(4, 37), result left: 2, result right: 2
    * log(4, 38), result left: 2, result right: 2
    * log(4, 39), result left: 2, result right: 2
    * log(4, 40), result left: 2, result right: 2
    * log(4, 41), result left: 2, result right: 2
    * log(4, 42), result left: 2, result right: 2
    * log(4, 43), result left: 2, result right: 2
    * log(4, 44), result left: 2, result right: 2
    * log(4, 45), result left: 2, result right: 2
    * log(4, 46), result left: 2, result right: 2
    * log(4, 47), result left: 2, result right: 2
    * log(4, 48), result left: 2, result right: 2
    * log(4, 49), result left: 2, result right: 2
    * log(4, 50), result left: 2, result right: 2
    * log(4, 51), result left: 2, result right: 2
    * log(4, 52), result left: 2, result right: 2
    * log(4, 53), result left: 2, result right: 2
    * log(4, 54), result left: 2, result right: 2
    * log(4, 55), result left: 2, result right: 2
    * log(4, 56), result left: 2, result right: 2
    * log(4, 57), result left: 2, result right: 2
    * log(4, 58), result left: 2, result right: 2
    * log(4, 59), result left: 2, result right: 2
    * log(4, 60), result left: 2, result right: 2
    * log(4, 61), result left: 2, result right: 2
    * log(4, 62), result left: 2, result right: 2
    * log(4, 63), result left: 2, result right: 2
    * log(4, 64), result left: 2, result right: 3
    * log(4, 65), result left: 2, result right: 3
    * log(4, 66), result left: 2, result right: 3
    * log(4, 67), result left: 2, result right: 3
    * log(4, 68), result left: 2, result right: 3
    * log(4, 69), result left: 2, result right: 3
    * log(4, 70), result left: 2, result right: 3
    * log(4, 71), result left: 2, result right: 3
    * log(4, 72), result left: 2, result right: 3
    * log(4, 73), result left: 2, result right: 3
    * log(4, 74), result left: 2, result right: 3
    * log(4, 75), result left: 2, result right: 3
    * log(4, 76), result left: 2, result right: 3
    * log(4, 77), result left: 2, result right: 3
    * log(4, 78), result left: 2, result right: 3
    * log(4, 79), result left: 2, result right: 3
    * log(4, 80), result left: 2, result right: 3
    * log(4, 81), result left: 2, result right: 3
    * log(4, 82), result left: 2, result right: 3
    * log(4, 83), result left: 2, result right: 3
    * log(4, 84), result left: 2, result right: 3
    * log(4, 85), result left: 3, result right: 3
    * log(4, 86), result left: 3, result right: 3
    * log(4, 87), result left: 3, result right: 3
    * log(4, 88), result left: 3, result right: 3
    * log(4, 89), result left: 3, result right: 3
    * log(4, 90), result left: 3, result right: 3
    * log(4, 91), result left: 3, result right: 3
    * log(4, 92), result left: 3, result right: 3
    * log(4, 93), result left: 3, result right: 3
    * log(4, 94), result left: 3, result right: 3
    * log(4, 95), result left: 3, result right: 3
    * log(4, 96), result left: 3, result right: 3
    * log(4, 97), result left: 3, result right: 3
    * log(4, 98), result left: 3, result right: 3
    * log(4, 99), result left: 3, result right: 3
    * log(4, 100), result left: 3, result right: 3
    * log(4, 101), result left: 3, result right: 3
    * log(4, 102), result left: 3, result right: 3
    * log(4, 103), result left: 3, result right: 3
    * log(4, 104), result left: 3, result right: 3
    * log(4, 105), result left: 3, result right: 3
    * log(4, 106), result left: 3, result right: 3
    * log(4, 107), result left: 3, result right: 3
    * log(4, 108), result left: 3, result right: 3
    * log(4, 109), result left: 3, result right: 3
    * log(4, 110), result left: 3, result right: 3
    * log(4, 111), result left: 3, result right: 3
    * log(4, 112), result left: 3, result right: 3
    * log(4, 113), result left: 3, result right: 3
    * log(4, 114), result left: 3, result right: 3
    * log(4, 115), result left: 3, result right: 3
    * log(4, 116), result left: 3, result right: 3
    * log(4, 117), result left: 3, result right: 3
    * log(4, 118), result left: 3, result right: 3
    * log(4, 119), result left: 3, result right: 3
    * log(4, 120), result left: 3, result right: 3
    * log(4, 121), result left: 3, result right: 3
    * log(4, 122), result left: 3, result right: 3
    * log(4, 123), result left: 3, result right: 3
    * log(4, 124), result left: 3, result right: 3
    * log(4, 125), result left: 3, result right: 3
    * log(4, 126), result left: 3, result right: 3
    * log(4, 127), result left: 3, result right: 3
    * log(4, 128), result left: 3, result right: 3
    * log(4, 129), result left: 3, result right: 3
    * log(4, 130), result left: 3, result right: 3
    * log(4, 131), result left: 3, result right: 3
    * log(4, 132), result left: 3, result right: 3
    * log(4, 133), result left: 3, result right: 3
    * log(4, 134), result left: 3, result right: 3
    * log(4, 135), result left: 3, result right: 3
    * log(4, 136), result left: 3, result right: 3
    * log(4, 137), result left: 3, result right: 3
    * log(4, 138), result left: 3, result right: 3
    * log(4, 139), result left: 3, result right: 3
    * log(4, 140), result left: 3, result right: 3
    * log(4, 141), result left: 3, result right: 3
    * log(4, 142), result left: 3, result right: 3
    * log(4, 143), result left: 3, result right: 3
    * log(4, 144), result left: 3, result right: 3
    * log(4, 145), result left: 3, result right: 3
    * log(4, 146), result left: 3, result right: 3
    * log(4, 147), result left: 3, result right: 3
    * log(4, 148), result left: 3, result right: 3
    * log(4, 149), result left: 3, result right: 3
    * log(4, 150), result left: 3, result right: 3
    * log(4, 151), result left: 3, result right: 3
    * log(4, 152), result left: 3, result right: 3
    * log(4, 153), result left: 3, result right: 3
    * log(4, 154), result left: 3, result right: 3
    * log(4, 155), result left: 3, result right: 3
    * log(4, 156), result left: 3, result right: 3
    * log(4, 157), result left: 3, result right: 3
    * log(4, 158), result left: 3, result right: 3
    * log(4, 159), result left: 3, result right: 3
    * log(4, 160), result left: 3, result right: 3
    * log(4, 161), result left: 3, result right: 3
    * log(4, 162), result left: 3, result right: 3
    * log(4, 163), result left: 3, result right: 3
    * log(4, 164), result left: 3, result right: 3
    * log(4, 165), result left: 3, result right: 3
    * log(4, 166), result left: 3, result right: 3
    * log(4, 167), result left: 3, result right: 3
    * log(4, 168), result left: 3, result right: 3
    * log(4, 169), result left: 3, result right: 3
    * log(4, 170), result left: 3, result right: 3
    * log(4, 171), result left: 3, result right: 3
    * log(4, 172), result left: 3, result right: 3
    * log(4, 173), result left: 3, result right: 3
    * log(4, 174), result left: 3, result right: 3
    * log(4, 175), result left: 3, result right: 3
    * log(4, 176), result left: 3, result right: 3
    * log(4, 177), result left: 3, result right: 3
    * log(4, 178), result left: 3, result right: 3
    * log(4, 179), result left: 3, result right: 3
    * log(4, 180), result left: 3, result right: 3
    * log(4, 181), result left: 3, result right: 3
    * log(4, 182), result left: 3, result right: 3
    * log(4, 183), result left: 3, result right: 3
    * log(4, 184), result left: 3, result right: 3
    * log(4, 185), result left: 3, result right: 3
    * log(4, 186), result left: 3, result right: 3
    * log(4, 187), result left: 3, result right: 3
    * log(4, 188), result left: 3, result right: 3
    * log(4, 189), result left: 3, result right: 3
    * log(4, 190), result left: 3, result right: 3
    * log(4, 191), result left: 3, result right: 3
    * log(4, 192), result left: 3, result right: 3
    * log(4, 193), result left: 3, result right: 3
    * log(4, 194), result left: 3, result right: 3
    * log(4, 195), result left: 3, result right: 3
    * log(4, 196), result left: 3, result right: 3
    * log(4, 197), result left: 3, result right: 3
    * log(4, 198), result left: 3, result right: 3
    * log(4, 199), result left: 3, result right: 3
    * log(4, 200), result left: 3, result right: 3
    * log(4, 201), result left: 3, result right: 3
    * log(4, 202), result left: 3, result right: 3
    * log(4, 203), result left: 3, result right: 3
    * log(4, 204), result left: 3, result right: 3
    * log(4, 205), result left: 3, result right: 3
    * log(4, 206), result left: 3, result right: 3
    * log(4, 207), result left: 3, result right: 3
    * log(4, 208), result left: 3, result right: 3
    * log(4, 209), result left: 3, result right: 3
    * log(4, 210), result left: 3, result right: 3
    * log(4, 211), result left: 3, result right: 3
    * log(4, 212), result left: 3, result right: 3
    * log(4, 213), result left: 3, result right: 3
    * log(4, 214), result left: 3, result right: 3
    * log(4, 215), result left: 3, result right: 3
    * log(4, 216), result left: 3, result right: 3
    * log(4, 217), result left: 3, result right: 3
    * log(4, 218), result left: 3, result right: 3
    * log(4, 219), result left: 3, result right: 3
    * log(4, 220), result left: 3, result right: 3
    * log(4, 221), result left: 3, result right: 3
    * log(4, 222), result left: 3, result right: 3
    * log(4, 223), result left: 3, result right: 3
    * log(4, 224), result left: 3, result right: 3
    * log(4, 225), result left: 3, result right: 3
    * log(4, 226), result left: 3, result right: 3
    * log(4, 227), result left: 3, result right: 3
    * log(4, 228), result left: 3, result right: 3
    * log(4, 229), result left: 3, result right: 3
    * log(4, 230), result left: 3, result right: 3
    * log(4, 231), result left: 3, result right: 3
    * log(4, 232), result left: 3, result right: 3
    * log(4, 233), result left: 3, result right: 3
    * log(4, 234), result left: 3, result right: 3
    * log(4, 235), result left: 3, result right: 3
    * log(4, 236), result left: 3, result right: 3
    * log(4, 237), result left: 3, result right: 3
    * log(4, 238), result left: 3, result right: 3
    * log(4, 239), result left: 3, result right: 3
    * log(4, 240), result left: 3, result right: 3
    * log(4, 241), result left: 3, result right: 3
    * log(4, 242), result left: 3, result right: 3
    * log(4, 243), result left: 3, result right: 3
    * log(4, 244), result left: 3, result right: 3
    * log(4, 245), result left: 3, result right: 3
    * log(4, 246), result left: 3, result right: 3
    * log(4, 247), result left: 3, result right: 3
    * log(4, 248), result left: 3, result right: 3
    * log(4, 249), result left: 3, result right: 3
    * log(4, 250), result left: 3, result right: 3
    * log(4, 251), result left: 3, result right: 3
    * log(4, 252), result left: 3, result right: 3
    * log(4, 253), result left: 3, result right: 3
    * log(4, 254), result left: 3, result right: 3
    * log(4, 255), result left: 3, result right: 3
    * log(4, 256), result left: 3, result right: 4
    */

}
