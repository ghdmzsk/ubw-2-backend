package 练习22

object Runner {

  def main(arr: Array[String]): Unit = {
    val 乘数1 = 乘数T1.fromInt(47)
    val 乘数2 = 乘数T2.fromInt(31)
    val 乘数3 = 乘数T3.fromInt(23)
    println(s"Type value: ${乘数3.乘3(乘数1, 乘数2).length}")
    println(s"Count value: ${47 * 31 * 23}")
  }

}
