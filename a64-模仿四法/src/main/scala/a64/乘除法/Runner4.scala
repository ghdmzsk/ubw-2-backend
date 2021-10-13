package a64.乘除法

import a64.基础._

import scala.collection.mutable
import scala.util.Random

object Runner4 {

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
    val hashMap: mutable.HashMap[Set[Set[String]], Int] = mutable.HashMap.empty

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

      val list        = List(("result1", result1), ("result2", result2), ("result3", result3), ("result4", result4))
      val confirmList = list.groupBy(_._2).to(List).map(_._2).filter(_.size >= 2)
      assert(confirmList.size >= 1)
      val set = confirmList.map(_.map(_._1).to(Set)).to(Set)
      hashMap.get(set) match {
        case Some(s) => hashMap.put(set, s + 1)
        case None    => hashMap.put(set, 1)
      }
    }

    println(hashMap) // HashMap(Set(Set(result1, result4)) -> 167, Set(Set(result2, result4), Set(result1, result3)) -> 9833)
  }

}
