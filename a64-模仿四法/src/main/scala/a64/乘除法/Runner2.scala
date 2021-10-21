package a64.乘除法

import a64.基础._

import scala.util.Random

object Runner2 {

  def numberZero[T]: Number[T] = {
    lazy val zero: Number[T] = NumberT(() => zero)
    zero
  }

  def fromInt(n: List[Int], tailNumber: Number[Item]): Number[Item] = n match {
    case head :: tail => fromInt(tail, NumberS(() => tailNumber, Item(head)))
    case Nil          => tailNumber
  }

  def chufaFromInt(n: List[Int]): (Number[Item], Number[Item]) = {
    def toNumber(l: List[Int], numZero: => Number[Item]): Number[Item] = l match {
      case _ :: tail => toNumber(tail, NumberT(() => numZero))
      case Nil       => numZero
    }
    lazy val numberTail: Number[Item] = toNumber(n, zero)
    lazy val zero: Number[Item]       = NumberS(() => numberTail, Item(0))
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
    var m_1: Int   = 0
    var m_2: Int   = 0
    var m_3: Int   = 0
    var m_4: Int   = 0
    var n_1_2: Int = 0
    var n_1_3: Int = 0
    var n_1_4: Int = 0
    var n_2_3: Int = 0
    var n_2_4: Int = 0
    var n_3_4: Int = 0
    for (_ <- 1 to 10000) {
      var random1 = math.abs(Random.nextInt()) % 2000
      var random2 = math.abs(Random.nextInt()) % 400
      if (random1 == 0) random1 += 1
      if (random2 == 0) random2 += 1
      val result1 = {
        val (number1Tail, number1Zero) = chufaFromInt((1 to random2).to(List))
        val number2                    = fromInt((1 to random1).to(List), numberZero)
        val collect                    = number1Tail.execute(new MultiplyContext2)((), number2)
        count(collect)
      }
      val result2 = {
        val (number1Tail, number1Zero) = chufaFromInt((1 to random2).to(List))
        val number2                    = fromInt((1 to random1).to(List), numberZero)
        val collect                    = number1Zero.execute(new MultiplyContext2)((), number2)
        count(collect)
      }
      val result3 = {
        val (number1Tail, number1Zero) = chufaFromInt((1 to random2).to(List))
        val number2                    = fromInt((1 to random1).to(List), numberZero)
        val collect                    = number2.execute(new MultiplyContext1)((), number1Tail)
        count(collect)
      }
      val result4 = {
        val (number1Tail, number1Zero) = chufaFromInt((1 to random2).to(List))
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
      if (d_1_2 == 0) {
        r_1_2 += 1
        if (result1 * random2 == random1) n_1_2 += 1
      }
      if (d_1_3 == 0) {
        r_1_3 += 1
        if (result1 * random2 == random1) n_1_3 += 1
      }
      if (d_1_4 == 0) {
        r_1_4 += 1
        if (result1 * random2 == random1) n_1_4 += 1
      }
      if (d_2_3 == 0) {
        r_2_3 += 1
        if (result2 * random2 == random1) n_2_3 += 1
      }
      if (d_2_4 == 0) {
        r_2_4 += 1
        if (result2 * random2 == random1) n_2_4 += 1
      }
      if (d_3_4 == 0) {
        r_3_4 += 1
        if (result3 * random2 == random1) n_3_4 += 1
      }

      if (result1 * random2 == random1) m_1 += 1
      if (result2 * random2 == random1) m_2 += 1
      if (result3 * random2 == random1) m_3 += 1
      if (result4 * random2 == random1) m_4 += 1
    }

    // 使被除数和除数的值为不为零的任何自然数，如果有一种计算方式的商乘以除数有可以还原成被除数的情况
    // 那这种计算方式，就可以成为除法运算
    // 并且这样的运算方式有两种，可以预知，当还原操作成立的时候，两种运算的商是相等的
    println(r_1_2, r_1_3, r_1_4, r_2_3, r_2_4, r_3_4) // (0,9833,167,0,9833,0)
    println(n_1_2, n_1_3, n_1_4, n_2_3, n_2_4, n_3_4) // (0,0,167,0,0,0)
    println(m_1, m_2, m_3, m_4)                       // (167,0,0,167)
  }

}
