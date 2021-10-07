package a64.乘除法

import a64.基础._

import scala.util.Random

object Runner3 {

  def numberZero[T]: Number[T] = {
    lazy val zero: Number[T] = NumberT(() => zero)
    zero
  }

  def fromInt(n: List[Int], tailNumber: Number[Item]): Number[Item] = n match {
    case head :: tail => fromInt(tail, NumberS(() => tailNumber, Item(head)))
    case Nil          => tailNumber
  }

  def roundFromInt(n: List[Int]): (Number[Item], Number[Item]) = {
    def toNumber(l: List[Int], numZero: => Number[Item]): Number[Item] = l match {
      case head :: tail => toNumber(tail, NumberS(() => numZero, Item(head)))
      case Nil          => numZero
    }
    lazy val numberTail: Number[Item] = toNumber(n, zero)
    lazy val zero: Number[Item]       = NumberT(() => numberTail)
    (numberTail, zero)
  }

  def count(collect: Collect[Item]): Int = collect match {
    case CollectS(tail, _) => count(tail) + 1
    case CollectT()        => 0
  }

  def main(arr: Array[String]): Unit = {
    var r_1_2: Int = 0
    var r_1_3: Int = 0
    var r_1_4: Int = 0
    var r_2_3: Int = 0
    var r_2_4: Int = 0
    var r_3_4: Int = 0
    for (_ <- 1 to 10000) {
      val random1 = math.abs(Random.nextInt()) % 200
      val random2 = math.abs(Random.nextInt()) % 80
      val result1 = {
        val (number1Tail, number1Zero) = roundFromInt((1 to random2).to(List))
        val number2                    = fromInt((1 to random1).to(List), numberZero)
        val collect                    = number1Tail.execute(new MultiplyContext2)((), number2)
        count(collect)
      }
      val result2 = {
        val (number1Tail, number1Zero) = roundFromInt((1 to random2).to(List))
        val number2                    = fromInt((1 to random1).to(List), numberZero)
        val collect                    = number1Zero.execute(new MultiplyContext2)((), number2)
        count(collect)
      }
      val result3 = {
        val (number1Tail, number1Zero) = roundFromInt((1 to random2).to(List))
        val number2                    = fromInt((1 to random1).to(List), numberZero)
        val collect                    = number2.execute(new MultiplyContext1)((), number1Tail)
        count(collect)
      }
      val result4 = {
        val (number1Tail, number1Zero) = roundFromInt((1 to random2).to(List))
        val number2                    = fromInt((1 to random1).to(List), numberZero)
        val collect                    = number2.execute(new MultiplyContext1)((), number1Zero)
        count(collect)
      }
      val d_1_2 = math.abs(result1 - result2)
      val d_1_3 = math.abs(result1 - result3)
      val d_1_4 = math.abs(result1 - result4)
      val d_2_3 = math.abs(result2 - result3)
      val d_2_4 = math.abs(result2 - result4)
      val d_3_4 = math.abs(result3 - result4)
      if (d_1_2 == 0) r_1_2 += 1
      if (d_1_3 == 0) r_1_3 += 1
      if (d_1_4 == 0) r_1_4 += 1
      if (d_2_3 == 0) r_2_3 += 1
      if (d_2_4 == 0) r_2_4 += 1
      if (d_3_4 == 0) r_3_4 += 1
    }
    // 选定两种计算方式，这两种计算方式的结果总是相等，则这两种计算方式共同成为乘法的两个体现。
    println(r_1_2, r_1_3, r_1_4, r_2_3, r_2_4, r_3_4) // (115,115,115,10000,151,151)
  }

}
