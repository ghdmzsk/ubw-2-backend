package a64.减法

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

  def collectFromInt(n: List[Int], tailNumber: Collect[Item]): Collect[Item] = n match {
    case head :: tail => collectFromInt(tail, CollectS(tailNumber, Item(head)))
    case Nil          => tailNumber
  }

  def main(arr: Array[String]): Unit = {
    val number1        = fromInt((1 to 35).to(List), numberZero)
    val number2        = fromInt((22 to 1 by -1).to(List), numberZero)
    val collect        = number2.execute(new MinusContext2)((), number1)
    val collectCompare = collectFromInt((1 to 13).to(List), CollectT())
    assert(collect == collectCompare)
  }

}
