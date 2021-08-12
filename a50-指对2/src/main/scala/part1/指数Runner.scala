package part1

import part3.{左正, 左终结, 水, 火, 风, NumL, NumR}

object 指数Runner extends App {

  lazy val numR: NumR = 风(风(风(numR1)))
  lazy val numR1      = 水(numR)
  lazy val num火: NumR = 火(火(火(num火1)))
  lazy val num火1      = 水(num火)
  val numL            = 左零(左零(左零(左零(左正(左终结), num火), num火), num火), num火)

  assert(numL.methodR(numR).length == 81)

  for {
    i1 <- 1 to 10
    i2 <- 1 to 5
  } yield {
    val num火 = {
      def num1(n1: Int, tail: => NumR): NumR = {
        n1 match {
          case n2 if n2 > 0 => 火(num1(n2 - 1, tail))
          case 0            => tail
        }
      }
      lazy val numa: NumR = num1(i1, numb)
      lazy val numb: NumR = 水(numa)
      numa
    }
    val num风 = {
      def num1(n1: Int, tail: => NumR): NumR = {
        n1 match {
          case n2 if n2 > 0 => 风(num1(n2 - 1, tail))
          case 0            => tail
        }
      }
      lazy val numa: NumR = num1(i1, numb)
      lazy val numb: NumR = 水(numa)
      numa
    }
    val numL = {
      def num1(n1: Int): NumL = {
        n1 match {
          case n2 if n2 > 0 => 左零(num1(n2 - 1), num火)
          case 0            => 左正(左终结)
        }
      }
      num1(i2)
    }
    val num1 = numL.methodR(num风).length
    val num2 = math.pow(i1, i2)
    println(s"${(i1, i2)}, ${(num1, num2.toInt)}")
    assert(num1 == num2)
  }

}
