package a70

import scala.annotation.tailrec

class Context {
  private var list: List[(String, Int)]              = List.empty
  def append(abstractName: String, count: Int): Unit = list = (abstractName, count) :: list
  def confirm: Boolean = list match {
    case (headAbstraceName, count) :: tail => confirmImpl(tail, headAbstraceName, count)
    case Nil                               => true
  }
  @tailrec
  private final def confirmImpl(tail: List[(String, Int)], headAbstractName: String, count: Int): Boolean = tail match {
    case (abstrateName, c) :: tail1 =>
      if (headAbstractName == abstrateName) confirmImpl(tail1, abstrateName, c)
      else {
        if (c + count == 1) confirmImpl(tail1, abstrateName, c) else false
      }
    case Nil => true
  }
}
object Context {
  def empty: Context = new Context
}

trait Number1 {
  def method1(number1: Number1, context: Context): Number2
}
case class Number1S(tail: () => Number1) extends Number1 {
  override def method1(number1: Number1, context: Context): Number2 = Number2S(() => {
    context.append("Number1S", 1)
    tail().method1(number1, context)
  })
}
case class Number1T(tail: () => Number1) extends Number1 {
  override def method1(number1: Number1, context: Context): Number2 = {
    context.append("Number1T", 0)
    tail().method1(number1, context)
  }
}
case class Number1U(tail: () => Number1) extends Number1 {
  override def method1(number1: Number1, context: Context): Number2 = Number2S(() => {
    context.append("Number1U", 1)
    number1.method1(tail(), context)
  })
}
case class Number1V(tail: () => Number1) extends Number1 {
  override def method1(number1: Number1, context: Context): Number2 = {
    context.append("Number1V", 0)
    number1.method1(tail(), context)
  }
}

sealed trait Number2
case class Number2S(tail: () => Number2) extends Number2

object Counter {
  def countImpl(number2: () => Number2): Int = {
    val value =
      try Option(number2())
      catch {
        case _: StackOverflowError => Option.empty
      }
    value match {
      case Some(Number2S(tail)) => countImpl(tail) + 1
      case None                 => 0
    }
  }

  def count(number2: () => Number2): Option[Int] = {
    try Option(countImpl(number2))
    catch {
      case _: StackOverflowError => Option.empty
    }
  }
}
