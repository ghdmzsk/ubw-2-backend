package step1

class Typer {

  class Tag[T]
  def i[T](tag1: Tag[T], tag2: Tag[T]): List[Tag[T]] = List(tag1, tag2)

  type Number1 = BeMinusP[BeMinusP[BeMinusP[BeMinusP[BeMinusO, 1], 2], 3], 4]
  type Number2 = MinusP[MinusP[MinusP[MinusO, "5"], "6"], "7"]

  type Number3 = 减法[Number1, Number2]
  type Number4 = BeMinusP[BeMinusO, 1]

  i(new Tag[Number3], new Tag[Number4])

  type Number5 = BeMinusP[BeMinusP[BeMinusP[BeMinusP[BeMinusP[BeMinusP[BeMinusO, 1], 2], 3], 4], 5], 6]
  type Number6 = MinusP[MinusP[MinusP[MinusO, "7"], "8"], "9"]

  type Number7 = 减法[Number5, Number6]
  type Number8 = BeMinusP[BeMinusP[BeMinusP[BeMinusO, 1], 2], 3]

  i(new Tag[Number7], new Tag[Number8])

  type Number9  = BeMinusP[BeMinusP[BeMinusO, 1], 2]
  type Number10 = MinusP[MinusP[MinusP[MinusP[MinusP[MinusO, "3"], "4"], "5"], "6"], "7"]

  type Number11 = 减法[Number9, Number10]

  i(new Tag[Number11], new Tag[BeMinusO])

  type Number12 = BeMinusP[BeMinusP[BeMinusO, 1], 2]
  type Number13 = MinusP[MinusP[MinusO, "3"], "4"]

  type Number14 = 减法[Number12, Number13]

  i(new Tag[Number14], new Tag[BeMinusO])

  type Number15 = BeMinusP[BeMinusP[BeMinusO, 1], 2]
  type Number16 = MinusP[MinusP[MinusP[MinusO, "3"], "4"], "5"]

  type Number17 = 减法[Number15, Number16]

  i(new Tag[Number17], new Tag[BeMinusO])

}
