package a68.a02

object Runner {

  case class Length[T <: Number1](i: Int)
  object Length {
    def length[T <: Number1](implicit n: Length[T]): Int                                  = n.i
    implicit def number1sLength[T <: Number1](implicit l: Length[T]): Length[Number1S[T]] = Length(l.i + 1)
    implicit val number1tLength: Length[Number1T]                                         = Length(0)
  }

  def main(arr: Array[String]): Unit = {
    {
      type number1 = Number1S[Number1S[Number1S[Number1S[Number1T]]]] // 4
      type number2 = Number2T                                         // 0
      val result = Length.length[number2#Method2[number1]]
      assert(result == 4 - 0)
    }
    {
      type number1 = Number1T                               // 0
      type number2 = Number2S[Number2S[Number2S[Number2T]]] // 3
      val result = Length.length[number2#Method2[number1]]
      assert(result == 0)
    }
    {
      type number1 = Number1S[Number1S[Number1S[Number1S[Number1T]]]] // 4
      type number2 = Number2S[Number2S[Number2S[Number2T]]]           // 3
      val result = Length.length[number2#Method2[number1]]
      assert(result == 1)
    }
    {
      type number1 = Number1S[Number1S[Number1S[Number1S[Number1T]]]] // 4
      type number2 = Number2S[Number2S[Number2S[Number2S[Number2T]]]] // 4
      val result = Length.length[number2#Method2[number1]]
      assert(result == 0)
    }
  }

}
