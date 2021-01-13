package 待定.step1

class Item1
class Item2
class Item3
class Item4

trait Ba[T <: Ba[T, H], H] {
  type Tail <: Ba[Tail, Head]
  type Head
}

class A1 extends Ba[A1, Item1] {
  override type Tail = A2
  override type Head = Item2
}

class A2 extends Ba[A2, Item2] {
  override type Tail = A3
  override type Head = Item3
}

class A3 extends Ba[A3, Item3] {
  override type Tail = A4
  override type Head = Item4
}

class A4 extends Ba[A4, Item4] {
  override type Tail = A1
  override type Head = Item1
}

object bb {

  trait CC {
    def cc: CC
  }

  lazy val ccbb: CC = new CC {
    override lazy val cc: CC = ccbb
  }

}
