trait Jinzhi {

  type Item <: Item2
  def item: Item

  type Tail <: Jinzhi
  def tail: Tail

  type UpdateCurrent[T <: Item2] <: Jinzhi
  def add[T <: Item2](t: T): UpdateCurrent[T]
  def add2[T](t: T): UpdateCurrent[Item1Impl[T]] = add(new Item1Impl(t))

  type G <: Guishu
  def guishu: G

}

class KongWei[TT <: Jinzhi](override val tail: TT) extends Jinzhi {
  override type Item = Item0Impl
  override def item: Item0Impl = Item0Impl
  override type Tail                      = TT
  override type UpdateCurrent[T <: Item2] = Manwei[T, TT]
  override def add[T <: Item2](t: T): Manwei[T, TT] = new Manwei(t, tail)

  override type G = KongweiGuishu
  override def guishu: KongweiGuishu = KongweiGuishu

  override def toString: String = s"${tail} :: 空位0"
}

class Manwei[CC <: Item2, TT <: Jinzhi](override val item: CC, override val tail: TT) extends Jinzhi {
  override type Tail                      = TT
  override type Item                      = CC
  override type UpdateCurrent[T <: Item2] = KongWei[TT#UpdateCurrent[Item2Impl[T, CC]]]
  override def add[T <: Item2](t: T): KongWei[TT#UpdateCurrent[Item2Impl[T, CC]]] =
    new KongWei(tail.add(new Item2Impl(t, item)))

  override type G = ManweiGuishu
  override def guishu: ManweiGuishu = ManweiGuishu

  override def toString: String = s"${tail} :: 满位1(${item})"
}

class KongWeiZero extends Jinzhi {
  self =>
  override type Item = Item0Impl
  override def item: Item0Impl = Item0Impl
  override type Tail = KongWeiZero
  override def tail: KongWeiZero = self
  override type UpdateCurrent[T <: Item2] = Manwei[T, KongWeiZero]
  override def add[T <: Item2](t: T): Manwei[T, KongWeiZero] = new Manwei[T, KongWeiZero](t, self)

  override type G = WanjieGuishu
  override def guishu: WanjieGuishu = WanjieGuishu

  override def toString: String = "无限0"
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

  /*val miao1: KongWeiZero#UpdateCurrent[I1]#UpdateCurrent[I2]#UpdateCurrent[I3]#UpdateCurrent[I4] =
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
  println(miao3)*/

  println(
    KongWeiZero.value
      .add2(new I1)
      .add2(new I2)
      .add2(new I3)
      .add2(new I4)
      .add2(new I5)
      .add2(new I6)
      .add2(new I7)
      .add2(new I8)
      .add2(new I9))

  val a1 = KongWeiZero.value.add2(new I1).add2(new I2).add2(new I3).add2(new I4)
  val a2 = new InitUnpack(ZeroItemUnPack._2, a1).apply
  println(a2)

}
