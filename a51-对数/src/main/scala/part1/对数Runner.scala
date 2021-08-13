package part1

import part2.{水, 风, NumLO, NumLP, NumR}

object 对数Runner extends App {

  def numFromInt(numL: Int, numR: Int): (Queue, NumR) = {
    def num1(n1: Int, tail: => NumR): NumR = {
      n1 match {
        case n2 if n2 > 0 => 水(num1(n2 - 1, tail))
        case 0            => tail
      }
    }
    lazy val num2: NumR = num1(numR, num3)
    lazy val num3: NumR = 风(num2)
    val num4            = Queue(Vector.fill(numL)(NumLP).appended(NumLO(num2)): _*)
    (num4, num2)
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
    val (queue, numR) = numFromInt(i2, i1)
    val num1          = numR.methodL(queue).length
    val num2          = log(i1, i2)
    assert(num1 == num2)
  }

  for {
    i2 <- 1 to 400
  } yield {
    val (queue, numR) = numFromInt(i2, 3)
    val num1          = numR.methodL(queue).length

    val num2 = log(3, i2)
    println(s"result left: $num1, result right: $num2")
  }

}
