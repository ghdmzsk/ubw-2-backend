package a68.a04

object Runner {

  case class Length[T <: Number3](i: Int)
  object Length {
    def length[T <: Number3](implicit n: Length[T]): Int                                  = n.i
    implicit def number1sLength[T <: Number3](implicit l: Length[T]): Length[Number3S[T]] = Length(l.i + 1)
    implicit val number1tLength: Length[Number3T]                                         = Length(0)
  }

  def main(arr: Array[String]): Unit = {
    {
      type number1 = Number1S[Number1S[Number1S[Number1S[Number1T]]]] // 4
      class number2t extends Number2T[Number2T[number2s]] // 2
      class number2s extends Number2S[number2t]
      val result1 = Length.length[number1#Method1[number2t]]
      val result2 = Length.length[number2s#Method2[number1]]
      assert(result1 == 4 * 2)
      assert(result2 == 4 * 2)
    }
    {
      type number1 = Number1S[Number1S[Number1S[Number1S[Number1T]]]] // 4
      class number2s extends Number2S[Number2S[number2t]] // 2
      class number2t extends Number2T[number2s]
      val result1 = Length.length[number1#Method1[number2t]]
      val result2 = Length.length[number2s#Method2[number1]]
      assert(result1 == 4 / 2)
      assert(result2 == 4 / 2)
    }
    {
      type number1 = Number1S[Number1S[Number1S[Number1S[Number1S[Number1T]]]]] // 5
      class number2s extends Number2S[Number2S[number2t]] // 2
      class number2t extends Number2T[number2s]
      val result1 = Length.length[number1#Method1[number2t]]
      val result2 = Length.length[number2s#Method2[number1]]
      assert(result1 == 5 / 2 + 1)
      assert(result2 == 5 / 2)
    }
  }

}
