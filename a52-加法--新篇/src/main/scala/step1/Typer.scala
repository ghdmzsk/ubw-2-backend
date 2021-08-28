package step1

class Typer {

  type Number1 = BePlusP[BePlusP[BePlusP[BePlusP[BePlusO, 1], 2], 3], 4]
  type Number2 = PlusP[PlusP[PlusP[PlusO, "5"], "6"], "7"]

  type Number3 = 加法[Number1, Number2]
  type Number4 = BePlusP[BePlusP[BePlusP[BePlusP[BePlusP[BePlusP[BePlusP[BePlusO, 1], 2], 3], 4], "5"], "6"], "7"]

  class Tag[T]
  def i[T](tag1:Tag[T],tag2:Tag[T]):List[Tag[T]] = List(tag1,tag2)

  i(new Tag[Number3],new Tag[Number4])

}
