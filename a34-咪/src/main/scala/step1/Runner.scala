package step1

object Runner {

  class Tag[T]

  def i[T](tag1: Tag[T], tag2: Tag[T]): List[Tag[T]] = List(tag1, tag2)

  def main(arr: Array[String]): Unit = {
    val 指数10: 指数 = new 指数Positive(
      new 指数Positive(new 指数Positive(new 指数Positive(new 指数Positive(new 指数Positive(new 指数Positive(new 指数Positive(new 指数Positive(new 指数Positive(new 指数Zero)))))))))
    )
    val 咪1 = 指数10.指(new 底数1)
    println(scala.math.pow(3, 10)) // 59049.0
    println(咪1.length)             // 咪(59049)

    val 指数3: 指数 = new 指数Positive(new 指数Positive(new 指数Positive(new 指数Zero)))
    val 咪2      = 指数3.指(new 底数1)
    println(咪2.length) // 咪(27)

    val 指数2: 指数 = new 指数Positive(new 指数Positive(new 指数Zero))
    val 咪3      = 指数2.指(new 底数1)
    println(咪3.length) // 咪(9)

    val 指数1: 指数 = new 指数Positive(new 指数Zero)
    val 咪4      = 指数1.指(new 底数1)
    println(咪4.length) // 咪(3)

    val 咪5 = (new 指数Zero).指(new 底数1)
    println(咪5.length) // 咪(1)
  }

}
