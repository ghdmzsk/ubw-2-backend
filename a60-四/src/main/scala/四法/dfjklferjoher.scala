package 四法

import scala.annotation.tailrec

object dfjklferjoher extends App {

  @scala.annotation.tailrec
  def f(s: String, i: Char, j: Int)(z: StringBuilder): String =
    s.headOption match {
      case None              => z.append(j).append(i).toString()
      case Some(c) if c == i => f(s.tail, i, j + 1)(z)
      case Some(c)           => f(s.tail, c, 1)(z.append(j).append(i))
    }

  // the next term of s
  def g(s: String): String =
    s.headOption match {
      case Some(c) => f(s.tail, c, 1)(new StringBuilder)
      case _       => "1"
    }

  def lookAndSay(n: Int): String = (1 to n).foldLeft("") { case (s, _) => g(s) }

  // The first n terms of the look and say series
  def lookAndSaySeries(n: Int): List[String] =
    (1 to n)
      .foldLeft((List.empty[String], "")) { case ((zs, z), _) =>
        val m = g(z)
        (m :: zs, m)
      }
      ._1

  println(lookAndSaySeries(30).head)

  def inner(list1: List[Int], current: Int, currentNum: Int): List[Int] = if (list1.isEmpty)
    currentNum :: current :: list1
  else if (list1.head == current)
    inner(list1.tail, current, currentNum + 1)
  else
    currentNum :: current :: inner(list1.tail, list1.head, 1)

  @tailrec
  def cc(n: Int, list: List[Int]): List[Int] = if (n == 1)
    list
  else
    cc(n - 1, inner(list.tail, list.head, 1))

  def dd(n: Int): List[Int] = cc(n, List(1))

  println(dd(30).mkString)

  println(lookAndSay(30) == dd(30).mkString) // true

  val date1_1 = System.currentTimeMillis()
  for (_ <- 1 to 10000) {
    lookAndSay(30)
  }
  val date1_2 = System.currentTimeMillis()

  val date2_1 = System.currentTimeMillis()
  for (_ <- 1 to 10000) {
    dd(30).mkString
  }
  val date2_2 = System.currentTimeMillis()

  println(date1_2 - date1_1) // 31963
  println(date2_2 - date2_1) // 3688

}
