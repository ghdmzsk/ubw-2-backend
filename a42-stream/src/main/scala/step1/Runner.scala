package step1

object Runner {

  def main(arr: Array[String]): Unit = {
    val t3 = NumberT3.fromInt(12)
    val t2 = NumberT2.fromInt(12)
    val t1 = NumberT1.fromInt(12)
    val t4 = NumberT4.count(t3, t2, t1)
    println(t4.length)
  }

}
