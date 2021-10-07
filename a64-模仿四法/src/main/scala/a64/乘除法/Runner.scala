package a64.乘除法

import a64.基础._

case class Item(name: Int) {
  override def toString: String = s"$name"
}

object Runner {

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

  def chufaFromInt(n: List[Int]): (Number[Item], Number[Item]) = {
    def toNumber(l: List[Int], numZero: => Number[Item]): Number[Item] = l match {
      case _ :: tail => toNumber(tail, NumberT(() => numZero))
      case Nil       => numZero
    }
    lazy val numberTail: Number[Item] = toNumber(n, zero)
    lazy val zero: Number[Item]       = NumberS(() => numberTail, Item(0))
    (numberTail, zero)
  }

  def collectFromInt(n: List[Int], tailNumber: Collect[Item]): Collect[Item] = n match {
    case head :: tail => collectFromInt(tail, CollectS(tailNumber, Item(head)))
    case Nil          => tailNumber
  }

  def count(collect: Collect[Item]): Int = collect match {
    case CollectS(tail, _) => count(tail) + 1
    case CollectT()        => 0
  }

  def main(arr: Array[String]): Unit = {
    {
      val (number1Tail, number1Zero) = roundFromInt((1 to 25).to(List))
      val number2                    = fromInt((1 to 4).to(List), numberZero)
      val collect                    = number2.execute(new MultiplyContext1)((), number1Tail)
      val countNum                   = count(collect)
      assert(countNum == 25 * 4)
    }
    {
      val (number1Tail, number1Zero) = roundFromInt((1 to 25).to(List))
      val number2                    = fromInt((1 to 4).to(List), numberZero)
      val collect                    = number1Zero.execute(new MultiplyContext2)((), number2)
      val countNum                   = count(collect)
      assert(countNum == 25 * 4)
    }
    {
      val (number1Tail, number1Zero) = chufaFromInt((1 to 6).to(List))
      val number2                    = fromInt((1 to 25).to(List), numberZero)
      val collect                    = number2.execute(new MultiplyContext1)((), number1Zero)
      val countNum                   = count(collect)
      assert(countNum == 25 / 6 + 1)
    }
    {
      val (number1Tail, number1Zero) = chufaFromInt((1 to 6).to(List))
      val number2                    = fromInt((1 to 25).to(List), numberZero)
      val collect                    = number1Tail.execute(new MultiplyContext2)((), number2)
      val countNum                   = count(collect)
      assert(countNum == 25 / 6)
    }
    {
      val (number1Tail, number1Zero) = chufaFromInt((1 to 7).to(List))
      val number2                    = fromInt((1 to 56).to(List), numberZero)
      val collect                    = number2.execute(new MultiplyContext1)((), number1Zero)
      val countNum                   = count(collect)
      assert(countNum == 8)
    }
    {
      val (number1Tail, number1Zero) = chufaFromInt((1 to 7).to(List))
      val number2                    = fromInt((1 to 56).to(List), numberZero)
      val collect                    = number1Tail.execute(new MultiplyContext2)((), number2)
      val countNum                   = count(collect)
      assert(countNum == 8)
    }
  }

}
