package a39

import scala.annotation.tailrec

object Runner {

  val item01 = Item("item01")
  val item02 = Item("item02")
  val item03 = Item("item03")
  val item04 = Item("item04")
  val item05 = Item("item05")
  val item06 = Item("item06")
  val item07 = Item("item07")
  val item08 = Item("item08")
  val item09 = Item("item09")
  val item10 = Item("item10")

  lazy val number1: Number1 =
    Number1Positive(Number1Positive(Number1Positive(Number1Positive(Number1Positive(Number1Zero(() => number2), item01), item02), item03), item04), item05)
  lazy val number2: Number2 =
    Number2Positive(Number2Positive(Number2Positive(Number2Positive(Number2Positive(Number2Zero(() => number1), item06), item07), item08), item09), item10)

  def main(arr: Array[String]): Unit = {
    @tailrec
    def printlnNumber(number: Any, index: Int): Unit = {
      if (index > 0) {
        number match {
          case Number1Positive(tail, item) =>
            println(item)
            printlnNumber(tail, index - 1)
          case Number1Zero(tail) =>
            printlnNumber(tail(), index)
          case Number2Positive(tail, item) =>
            println(item)
            printlnNumber(tail, index - 1)
          case Number2Zero(tail) =>
            printlnNumber(tail(), index)
        }
      }
    }
    printlnNumber(number1, 50)
  }

}
