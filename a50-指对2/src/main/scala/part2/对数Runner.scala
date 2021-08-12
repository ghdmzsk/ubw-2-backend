package part2

import part3.{左正, 左终结, 水, 风, NumL, NumR}

object 对数Runner extends App {

  def numRFromInt(n: Int): (NumR, NumR) = {
    def num1(n1: Int, tail: => NumR): NumR = {
      n1 match {
        case n2 if n2 > 0 => 水(num1(n2 - 1, tail))
        case 0            => tail
      }
    }
    lazy val num2: NumR = num1(n, num3)
    lazy val num3: NumR = 风(num2)
    (num2, num3)
  }

  def numLFromInt(n: Int, numR: NumR): NumL = n match {
    case n1 if n1 > 0 => 左正(numLFromInt(n1 - 1, numR))
    case 0            => 左零(左终结, numR)
  }

  def log(num1: Int, num2: Int): Int = {
    var result = 0
    while (math.pow(num1, result).toInt < num2) result += 1
    if (math.pow(num1, result).toInt > num2) result - 1 else result
  }

  for {
    i1 <- 2 to 40
    i2 <- 1 to 1000
  } yield {
    val (numR, _) = numRFromInt(i1)
    val numL      = numLFromInt(i2, numR)
    val num1      = numR.methodL(numL).length
    val num2      = log(i1, i2)
    assert(num1 == num2)
  }

  val (numR1, numR2) = numRFromInt(3)
  for {
    i2 <- 1 to 400
  } yield {
    val numL = numLFromInt(i2, numR1)
    val num1 = numR1.methodL(numL).length

    val num2 = log(3, i2)
    println(s"result left: $num1, result right: $num2")
  }

}
