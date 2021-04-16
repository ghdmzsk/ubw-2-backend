package 练习23

object Runner {

  def main(arr: Array[String]): Unit = {
    {
      val t1 = NumberT1.fromInt(212)
      val t2 = NumberT2.fromInt(33)
      val t3 = NumberT3.fromInt(24)
      val p  = Product.mutiply(t1, t2, t3)
      println(s"value: ${p.length}")
      println(s"value: ${212 * 33 * 24}")
    }
  }

}
