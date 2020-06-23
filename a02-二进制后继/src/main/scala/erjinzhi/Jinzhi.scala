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
  override def toString: String = s"Item2(${i1}, ${i2})"
}

class KongWei[TT <: Jinzhi](override val tail: TT) extends Jinzhi {
  override type Tail             = TT
  override type UpdateCurrent[T] = Manwei[TT, T]
  override def add[T](t: T): Manwei[TT, T] = new Manwei(tail, t)
  override def toString: String            = s"${tail} :: 空位0"
}

class Manwei[TT <: Jinzhi, CC](override val tail: TT, val current: CC) extends Jinzhi {
  override type Tail             = TT
  override type UpdateCurrent[T] = KongWei[TT#UpdateCurrent[Item2Impl[CC, T]]]
  override def add[T](t: T): KongWei[TT#UpdateCurrent[Item2Impl[CC, T]]] = new KongWei(tail.add(new Item2Impl(current, t)))
  override def toString: String                                          = s"${tail} :: 满位1(${current})"
}

class KongWeiZero extends Jinzhi {
  self =>
  override type Tail = KongWeiZero
  override def tail: KongWeiZero = self
  override type UpdateCurrent[T] = Manwei[KongWeiZero, T]
  override def add[T](t: T): Manwei[KongWeiZero, T] = new Manwei(self, t)
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
  class I10 {
    override def toString = "i10"
  }
  class I11 {
    override def toString = "i11"
  }
  class I12 {
    override def toString = "i12"
  }
  class I13 {
    override def toString = "i13"
  }
  class I14 {
    override def toString = "i14"
  }
  class I15 {
    override def toString = "i15"
  }
  class I16 {
    override def toString = "i16"
  }
  class I17 {
    override def toString = "i17"
  }
  class I18 {
    override def toString = "i18"
  }

  val miao1: KongWeiZero#UpdateCurrent[I1]#UpdateCurrent[I2]#UpdateCurrent[I3] = KongWeiZero.value.add(new I1).add(new I2).add(new I3)

  miao1: Manwei[Manwei[KongWeiZero, Item2Impl[I1, I2]], I3]
  println(miao1) // 无限0 :: 满位1(Item2(i1, i2)) :: 满位1(i3)

  val miao2: KongWeiZero#UpdateCurrent[I1]#UpdateCurrent[I2]#UpdateCurrent[I3]#UpdateCurrent[I4] = KongWeiZero.value.add(new I1).add(new I2).add(new I3).add(new I4)

  miao2: KongWei[KongWei[Manwei[KongWeiZero, Item2Impl[Item2Impl[I1, I2], Item2Impl[I3, I4]]]]]
  println(miao2) // 无限0 :: 满位1(Item2(Item2(i1, i2), Item2(i3, i4))) :: 空位0 :: 空位0

  val miao3: KongWeiZero#UpdateCurrent[I1]#UpdateCurrent[I2]#UpdateCurrent[I3]#UpdateCurrent[I4]#UpdateCurrent[I5] =
    KongWeiZero.value.add(new I1).add(new I2).add(new I3).add(new I4).add(new I5)

  miao3: Manwei[KongWei[Manwei[KongWeiZero, Item2Impl[Item2Impl[I1, I2], Item2Impl[I3, I4]]]], I5]
  println(miao3) // 无限0 :: 满位1(Item2(Item2(i1, i2), Item2(i3, i4))) :: 空位0 :: 满位1(i5)

  val miao4: KongWeiZero#UpdateCurrent[I1]#UpdateCurrent[I2]#UpdateCurrent[I3]#UpdateCurrent[I4]#UpdateCurrent[I5]#UpdateCurrent[I6] =
    KongWeiZero.value.add(new I1).add(new I2).add(new I3).add(new I4).add(new I5).add(new I6)

  miao4: KongWei[Manwei[Manwei[KongWeiZero, Item2Impl[Item2Impl[I1, I2], Item2Impl[I3, I4]]], Item2Impl[I5, I6]]]
  println(miao4) // 无限0 :: 满位1(Item2(Item2(i1, i2), Item2(i3, i4))) :: 满位1(Item2(i5, i6)) :: 空位0

  println(
    KongWeiZero.value.add(new I1).add(new I2).add(new I3).add(new I4).add(new I5).add(new I6).add(new I7).add(new I8).add(new I9)
  ) // 无限0 :: 满位1(Item2(Item2(Item2(i1, i2), Item2(i3, i4)), Item2(Item2(i5, i6), Item2(i7, i8)))) :: 空位0 :: 空位0 :: 满 位1(i9)

  val jinzhi4: KongWei[Manwei[KongWei[KongWei[Manwei[KongWeiZero, Item2Impl[
    Item2Impl[Item2Impl[Item2Impl[I1, I2], Item2Impl[I3, I4]], Item2Impl[Item2Impl[I5, I6], Item2Impl[I7, I8]]],
    Item2Impl[Item2Impl[Item2Impl[I9, I10], Item2Impl[I11, I12]], Item2Impl[Item2Impl[I13, I14], Item2Impl[I15, I16]]]
  ]]]], Item2Impl[I17, I18]]] = KongWeiZero.value
    .add(new I1)
    .add(new I2)
    .add(new I3)
    .add(new I4)
    .add(new I5)
    .add(new I6)
    .add(new I7)
    .add(new I8)
    .add(new I9)
    .add(new I10)
    .add(new I11)
    .add(new I12)
    .add(new I13)
    .add(new I14)
    .add(new I15)
    .add(new I16)
    .add(new I17)
    .add(new I18)

  println(jinzhi4) /* 无限0 :: 满位1(Item2(
Item2(Item2(Item2(i1, i2), Item2(i3, i4)), Item2(Item2(i5, i6), Item2(i7, i8))),
Item2(Item2(Item2(i9, i10), Item2(i11, i12)), Item2(Item2(i13, i14), Item2(i15, i16)))
)) :: 空位0 :: 空位0 :: 满位1(Item2(i17, i18)) :: 空位0 */

}
