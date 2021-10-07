package a64.加法

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
    val number1        = fromInt((1 to 23).to(List), numberZero)
    val number2        = fromInt((24 to 59).to(List), numberZero)
    val collect        = number2.execute(new PlusContext1)((), number1)
    val collectCompare = collectFromInt((1 to 59).to(List), CollectT())
    assert(collect == collectCompare)
  }

}
