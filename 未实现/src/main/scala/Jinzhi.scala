trait Jinzhi {

  type Tail <: Jinzhi
  def tail: Tail

  type UpdateCurrent[T] <: Jinzhi
  def add[T](t: T): UpdateCurrent[T]

}

trait Item2 {

  type I1
  def i1: I1
  type I2
  def i2: I2

}

class Item2Impl[T1, T2](override val i1: T1, override val i2: T2) extends Item2 {
  override type I1 = T1
  override type I2 = T2
  override def toString: String = s"Item2(${i2}, ${i1})"
}

class KongWei[TT <: Jinzhi](override val tail: TT) extends Jinzhi {
  override type Tail             = TT
  override type UpdateCurrent[T] = Manwei[T, TT]
  override def add[T](t: T): Manwei[T, TT] = new Manwei(t, tail)
  override def toString: String            = s"${tail} :: 空位0"
}

class Manwei[CC, TT <: Jinzhi](val current: CC, override val tail: TT) extends Jinzhi {
  override type Tail             = TT
  override type UpdateCurrent[T] = KongWei[TT#UpdateCurrent[Item2Impl[T, CC]]]
  override def add[T](t: T): KongWei[TT#UpdateCurrent[Item2Impl[T, CC]]] = {
    new KongWei(tail.add(new Item2Impl(t, current)))
  }
  override def toString: String = s"${tail} :: 满位1(${current})"
}

class KongWeiZero extends Jinzhi {
  self =>
  override type Tail = KongWeiZero
  override def tail: KongWeiZero = self
  override type UpdateCurrent[T] = Manwei[T, KongWeiZero]
  override def add[T](t: T): Manwei[T, KongWeiZero] = new Manwei[T, KongWeiZero](t, self)
  override def toString: String                     = "无限0"
}

object KongWeiZero {
  val value: KongWeiZero = new KongWeiZero
}

object Runner extends App {
  class I1 {
    override def toString = "i1"
  }
  class I2 {
    override def toString = "i2"
  }
  class I3 {
    override def toString = "i3"
  }
  class I4 {
    override def toString = "i4"
  }
  class I5 {
    override def toString = "i5"
  }
  class I6 {
    override def toString = "i6"
  }
  class I7 {
    override def toString = "i7"
  }
  class I8 {
    override def toString = "i8"
  }
  class I9 {
    override def toString = "i9"
  }

  val miao1: KongWeiZero#UpdateCurrent[I1]#UpdateCurrent[I2]#UpdateCurrent[I3]#UpdateCurrent[I4] =
    KongWeiZero.value.add(new I1).add(new I2).add(new I3).add(new I4)

  miao1: KongWei[KongWei[Manwei[Item2Impl[Item2Impl[I4, I3], Item2Impl[I2, I1]], KongWeiZero]]]
  println(miao1)

  val miao2: KongWeiZero#UpdateCurrent[I1]#UpdateCurrent[I2]#UpdateCurrent[I3]#UpdateCurrent[I4]#UpdateCurrent[I5] =
    KongWeiZero.value.add(new I1).add(new I2).add(new I3).add(new I4).add(new I5)

  miao2: Manwei[I5, KongWei[Manwei[Item2Impl[Item2Impl[I4, I3], Item2Impl[I2, I1]], KongWeiZero]]]
  println(miao2)

  val miao3
  : KongWeiZero#UpdateCurrent[I1]#UpdateCurrent[I2]#UpdateCurrent[I3]#UpdateCurrent[I4]#UpdateCurrent[I5]#UpdateCurrent[
    I6] = KongWeiZero.value.add(new I1).add(new I2).add(new I3).add(new I4).add(new I5).add(new I6)

  miao3: KongWei[Manwei[Item2Impl[I6, I5], Manwei[Item2Impl[Item2Impl[I4, I3], Item2Impl[I2, I1]], KongWeiZero]]]
  println(miao3)

  println(
    KongWeiZero.value
      .add(new I1)
      .add(new I2)
      .add(new I3)
      .add(new I4)
      .add(new I5)
      .add(new I6)
      .add(new I7)
      .add(new I8)
      .add(new I9))

}