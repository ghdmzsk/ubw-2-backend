package step1

object Runner {

  def ii[T <: 自然数](i1: Tag[T], i2: Tag[T]): List[Tag[T]] = List(i1, i2)

  trait 特质0 {
    def i: Unit = ()
  }

  trait 特质1 extends 特质0 {
    override def i: Unit = {
      println("特质1")
      super.i
    }
  }

  trait 特质2 extends 特质0 {
    override def i: Unit = {
      println("特质2")
      super.i
    }
  }

  trait 特质3 extends 特质0 {
    override def i: Unit = {
      println("特质3")
      super.i
    }
  }

  trait 特质4 extends 特质0 with 特质2 with 特质3 {
    override def i: Unit = {
      println("特质4")
      super.i
    }
  }

  trait 特质5 extends 特质0 with 特质1 with 特质6 {
    override def i: Unit = {
      println("特质5")
      super.i
    }
  }

  trait 特质6 extends 特质0 {
    override def i: Unit = {
      println("特质6")
      super.i
    }
  }

  class b extends 特质3 with 特质5 with 特质4

  class Item1
  class Item2
  class Item3
  class Item4
  class Item5
  class Item6

  class 特质1值[T <: 自然数] extends 自然数Positive[T, Item1]
  class 特质2值[T <: 自然数] extends 自然数Positive[T, Item2]
  class 特质3值[T <: 自然数] extends 自然数Positive[T, Item3]
  class 特质4值[T <: 自然数] extends 自然数Positive[特质3值[特质2值[T]], Item4]
  class 特质5值[T <: 自然数] extends 自然数Positive[特质6值[特质1值[T]], Item5]
  class 特质6值[T <: 自然数] extends 自然数Positive[T, Item6]

  val bb = 自然数IO(new Tag[特质4值[特质5值[特质3值[自然数Zero]]]#In])

  def main(arr: Array[String]): Unit = {
    val b = new b
    b.i

    /** 特质4 特质2 特质5 特质6 特质1 特质3
      */
    ii(
      bb,
      new Tag[
        自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Zero, Item3], Item1], Item6], Item5], Item2], Item4]
      ]
    )
  }

}
