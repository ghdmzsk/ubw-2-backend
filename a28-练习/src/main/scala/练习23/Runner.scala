package 练习23

object Runner {

  def main(arr: Array[String]): Unit = {
    val summand = Summand.fromInt(532)
    val addend  = Addend.fromInt(35455)
    val sum     = Summand.sum(summand, addend)
    println(s"value1: ${532 + 35455}")
    println(s"value2: ${sum.length}")
  }

}
