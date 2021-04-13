package step1

object Runner {

  class Tag[T]

  def i[T](tag1: Tag[T], tag2: Tag[T]): List[Tag[T]] = List(tag1, tag2)

  def main(arr: Array[String]): Unit = {
    type 底数1 = 底数被吃Positive[底数被吃Positive[底数被吃Positive[底数被吃Positive[底数被吃Positive[底数被吃1]]]]] // 6
    class 底数2     extends 底数中间Positive[底数中间Positive[底数中间Positive[底数中间Positive[底数1_2]]]] // 5
    class 底数1_2   extends 底数中间1[底数2]
    class 底数3     extends 底数吃Positive[底数吃Positive[底数吃Positive[底数Zero3, Item2], Item2], Item2] // 3
    class 底数Zero3 extends 底数吃Zero[底数3]

    type 指数1 = 底数3#吃[底数2, 底数1]
    println(Creator[指数1].length) // 90
  }

}
