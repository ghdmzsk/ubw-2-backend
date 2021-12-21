import scala.language.higherKinds

object Runner extends App {

  val 人的身体 = HNil.hNil
    .append("12")
    .append(11)
    .append(10)
    .append(9)
    .append("8")
    .append("7")
    .append("6")
    .append(5)
    .append(4)
    .append(3)
    .append("2")
    .append(1)

  println(人的身体)                                             // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, HNil
  println(人的身体.contribute)                                  // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, HNil
  println(人的身体.contribute.contribute)                       // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, HNil
  println(人的身体.contribute.contribute.contribute)            // 1, 2, 3, 4, 5, 6, 7, 8, 9, HNil
  println(人的身体.contribute.contribute.contribute.contribute) // 1, 2, 3, 4, 5, 6, 7, 8, HNil

}
