package step1

class Typer {

  class Tag[T]
  def i[T](tag1:Tag[T],tag2:Tag[T]):List[Tag[T]] = List(tag1,tag2)

  type Number1 = BeDivisionP[BeDivisionP[BeDivisionP[BeDivisionP[BeDivisionP[BeDivisionP[BeDivisionP[BeDivisionP[BeDivisionP[BeDivisionO, 1], 2], 3], 4], 5], 6], 7], 8], 9]
  class Number2 extends DivisionP[DivisionP[DivisionP[DivisionP[Number3, "3"], "4"], "5"], "6"]
  class Number3 extends DivisionO[Number2]

  type Number4 = 除法[Number1, Number3]
  type Number5 = ResultP[ResultP[ResultP[ResultO]]]

  i(new Tag[Number4], new Tag[Number5])

  type Number6 = BeDivisionP[BeDivisionP[BeDivisionP[BeDivisionP[BeDivisionP[BeDivisionP[BeDivisionO, 1], 2], 3], 4], 5], 6]
  class Number7 extends DivisionP[DivisionP[Number8, "7"], "8"]
  class Number8 extends DivisionO[Number7]

  type Number9 = 除法[Number6, Number8]
  type Number10 = ResultP[ResultP[ResultP[ResultO]]]

  i(new Tag[Number9], new Tag[Number10])

}
