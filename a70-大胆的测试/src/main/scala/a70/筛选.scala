package a70

import scala.collection.mutable

object 筛选 {

  def result(i1: Int, i2: Int): List[(String, Int)] = List(
    ("if (i1 - i2 >= 0) i1 - i2 else 0", if (i1 - i2 >= 0) i1 - i2 else 0),
    ("if (i2 - i1 + 1 >= 0) i2 - i1 + 1 else 0", if (i2 - i1 + 1 >= 0) i2 - i1 + 1 else 0),
    ("i1 + i2", i1 + i2),
    ("i1 + i2 + 1", i1 + i2 + 1),
    ("if (i1 == 0) 0 else i1 + i2", if (i1 == 0) 0 else i1 + i2)
  )

  def main(arr: Array[String]): Unit = {
    val count: mutable.HashMap[String, Int] = mutable.HashMap.empty

    def append(key1: String): Unit = count.get(key1) match {
      case Some(s) => count.put(key1, s + 1)
      case None    => count.put(key1, 1)
    }

    for {
      i1 <- 0 to 19
      i2 <- 0 to 19
    } yield for {
      (key1, value1)         <- List(("result(i1, i2)", result(i1, i2)), ("result(i2, i1)", result(i2, i1)))
      (key2, value2)         <- value1
      (key3, value3, other3) <- List(("result(value2, i1)", result(value2, i1), i2), ("result(i1, value2)", result(i1, value2), i2))
      (key4, value4)         <- value3
      (key5, value5, other5) <- List(("result(value2, i2)", result(value2, i2), i1), ("result(i2, value2)", result(i2, value2), i1))
      (key6, value6)         <- value5
    } yield
      if (value4 == other3 && value6 == other5)
        append(s"To:$key1, $key2, Reverse:$key3, $key4, Third:$key5, $key6")

    println(count.filter(s => s._2 >= 400).mkString("\n"))

    // To:result(i1, i2), i1 + i2, Reverse:result(value2, i1), if (i1 - i2 >= 0) i1 - i2 else 0, Third:result(value2, i2), if (i1 - i2 >= 0) i1 - i2 else 0 -> 400
    // To:result(i2, i1), i1 + i2, Reverse:result(value2, i1), if (i1 - i2 >= 0) i1 - i2 else 0, Third:result(value2, i2), if (i1 - i2 >= 0) i1 - i2 else 0 -> 400
  }

}
