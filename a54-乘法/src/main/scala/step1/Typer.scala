package step1

class Typer {

  class Tag[T]
  def i[T](tag1: Tag[T], tag2: Tag[T]): List[Tag[T]] = List(tag1, tag2)

  type Number1 = BeMultiplyP[BeMultiplyP[BeMultiplyO, 1], 2]
  class Number2 extends MultiplyP[MultiplyP[MultiplyP[MultiplyP[MultiplyP[Number3, "3"], "4"], "5"], "6"], "7"]
  class Number3 extends MultiplyO[Number2]

  type Number4 = 乘法[Number1, Number2]
  type Number5 = ResultP[ResultP[ResultP[
    ResultP[ResultP[ResultP[ResultP[ResultP[ResultP[ResultP[ResultO, 1, "3"], 1, "4"], 1, "5"], 1, "6"], 1, "7"], 2, "3"], 2, "4"],
    2,
    "5"
  ], 2, "6"], 2, "7"]

  i(new Tag[Number4], new Tag[Number5])

  type Number6 = BeMultiplyP[BeMultiplyP[BeMultiplyP[BeMultiplyO, 1], 2], 3]
  class Number7 extends MultiplyP[MultiplyP[MultiplyP[MultiplyP[Number8, "4"], "5"], "6"], "7"]
  class Number8 extends MultiplyO[Number7]

  type Number9 = 乘法[Number6, Number7]
  type Number10 = ResultP[ResultP[ResultP[ResultP[ResultP[
    ResultP[ResultP[ResultP[ResultP[ResultP[ResultP[ResultP[ResultO, 1, "4"], 1, "5"], 1, "6"], 1, "7"], 2, "4"], 2, "5"], 2, "6"],
    2,
    "7"
  ], 3, "4"], 3, "5"], 3, "6"], 3, "7"]

  i(new Tag[Number9], new Tag[Number10])

}
