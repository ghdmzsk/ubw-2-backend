package erjinzhi

trait Jinzhi {

  type Tail <: Jinzhi
  def tail: Tail

  type UpdateCurrent[T] <: Jinzhi
  def add[T](t: T): UpdateCurrent[T]

}

trait Item2 {

  type I1
  def i1: I1
  type i0
  def i0: i0

}

class Item2Impl[T1, T2](override val i1: T1, override val i0: T2) extends Item2 {
  override type I1 = T1
  override type i0 = T2
  override def toString: String = s"Item2(${i1}, ${i0})"
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
    def item1ToString: String = "I'm item1."
    override def toString     = "i1"
  }
  class I2 {
    def item2ToString: String = "I'm item2."
    override def toString     = "i0"
  }
  class I3 {
    def item3ToString: String = "I'm item3."
    override def toString     = "i3"
  }
  class I4 {
    def item4ToString: String = "I'm item4."
    override def toString     = "i4"
  }
  class I5 {
    def item5ToString: String = "I'm item5."
    override def toString     = "i5"
  }
  class I6 {
    def item6ToString: String = "I'm item6."
    override def toString     = "i6"
  }
  class I7 {
    def item7ToString: String = "I'm item7."
    override def toString     = "i7"
  }
  class I8 {
    def item8ToString: String = "I'm item8."
    override def toString     = "i8"
  }
  class I9 {
    def item9ToString: String = "I'm item9."
    override def toString     = "i9"
  }
  class I10 {
    def item10ToString: String = "I'm item10."
    override def toString      = "i10"
  }
  class I11 {
    def item11ToString: String = "I'm item11."
    override def toString      = "i11"
  }
  class I12 {
    def item12ToString: String = "I'm item12."
    override def toString      = "i12"
  }
  class I13 {
    def item13ToString: String = "I'm item13."
    override def toString      = "i13"
  }
  class I14 {
    def item14ToString: String = "I'm item14."
    override def toString      = "i14"
  }
  class I15 {
    def item15ToString: String = "I'm item15."
    override def toString      = "i15"
  }
  class I16 {
    def item16ToString: String = "I'm item16."
    override def toString      = "i16"
  }
  class I17 {
    def item17ToString: String = "I'm item17."
    override def toString      = "i17"
  }
  class I18 {
    def item18ToString: String = "I'm item18."
    override def toString      = "i18"
  }

  val miao1: KongWeiZero#UpdateCurrent[I1]#UpdateCurrent[I2]#UpdateCurrent[I3] = KongWeiZero.value.add(new I1).add(new I2).add(new I3)

  miao1: Manwei[Manwei[KongWeiZero, Item2Impl[I1, I2]], I3]
  println(miao1) // 无限0 :: 满位1(Item2(i1, i0)) :: 满位1(i3)

  val miao2: KongWeiZero#UpdateCurrent[I1]#UpdateCurrent[I2]#UpdateCurrent[I3]#UpdateCurrent[I4] = KongWeiZero.value.add(new I1).add(new I2).add(new I3).add(new I4)

  miao2: KongWei[KongWei[Manwei[KongWeiZero, Item2Impl[Item2Impl[I1, I2], Item2Impl[I3, I4]]]]]
  println(miao2) // 无限0 :: 满位1(Item2(Item2(i1, i0), Item2(i3, i4))) :: 空位0 :: 空位0

  val miao3: KongWeiZero#UpdateCurrent[I1]#UpdateCurrent[I2]#UpdateCurrent[I3]#UpdateCurrent[I4]#UpdateCurrent[I5] =
    KongWeiZero.value.add(new I1).add(new I2).add(new I3).add(new I4).add(new I5)

  miao3: Manwei[KongWei[Manwei[KongWeiZero, Item2Impl[Item2Impl[I1, I2], Item2Impl[I3, I4]]]], I5]
  println(miao3) // 无限0 :: 满位1(Item2(Item2(i1, i0), Item2(i3, i4))) :: 空位0 :: 满位1(i5)

  val miao4: KongWeiZero#UpdateCurrent[I1]#UpdateCurrent[I2]#UpdateCurrent[I3]#UpdateCurrent[I4]#UpdateCurrent[I5]#UpdateCurrent[I6] =
    KongWeiZero.value.add(new I1).add(new I2).add(new I3).add(new I4).add(new I5).add(new I6)

  miao4: KongWei[Manwei[Manwei[KongWeiZero, Item2Impl[Item2Impl[I1, I2], Item2Impl[I3, I4]]], Item2Impl[I5, I6]]]
  println(miao4) // 无限0 :: 满位1(Item2(Item2(i1, i0), Item2(i3, i4))) :: 满位1(Item2(i5, i6)) :: 空位0

  println(
    KongWeiZero.value.add(new I1).add(new I2).add(new I3).add(new I4).add(new I5).add(new I6).add(new I7).add(new I8).add(new I9)
  ) // 无限0 :: 满位1(Item2(Item2(Item2(i1, i0), Item2(i3, i4)), Item2(Item2(i5, i6), Item2(i7, i8)))) :: 空位0 :: 空位0 :: 满 位1(i9)

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
Item2(Item2(Item2(i1, i0), Item2(i3, i4)), Item2(Item2(i5, i6), Item2(i7, i8))),
Item2(Item2(Item2(i9, i10), Item2(i11, i12)), Item2(Item2(i13, i14), Item2(i15, i16)))
)) :: 空位0 :: 空位0 :: 满位1(Item2(i17, i18)) :: 空位0 */

  jinzhi4.tail.current.i0.item18ToString
  jinzhi4.tail.current.i1.item17ToString
  jinzhi4.tail.tail.tail.tail.current.i0.i0.i0.i0.item16ToString
  jinzhi4.tail.tail.tail.tail.current.i0.i0.i0.i1.item15ToString
  jinzhi4.tail.tail.tail.tail.current.i0.i0.i1.i0.item14ToString
  jinzhi4.tail.tail.tail.tail.current.i0.i0.i1.i1.item13ToString
  jinzhi4.tail.tail.tail.tail.current.i0.i1.i0.i0.item12ToString
  jinzhi4.tail.tail.tail.tail.current.i0.i1.i0.i1.item11ToString
  jinzhi4.tail.tail.tail.tail.current.i0.i1.i1.i0.item10ToString
  jinzhi4.tail.tail.tail.tail.current.i0.i1.i1.i1.item9ToString
  jinzhi4.tail.tail.tail.tail.current.i1.i0.i0.i0.item8ToString
  jinzhi4.tail.tail.tail.tail.current.i1.i0.i0.i1.item7ToString
  jinzhi4.tail.tail.tail.tail.current.i1.i0.i1.i0.item6ToString
  jinzhi4.tail.tail.tail.tail.current.i1.i0.i1.i1.item5ToString
  jinzhi4.tail.tail.tail.tail.current.i1.i1.i0.i0.item4ToString
  jinzhi4.tail.tail.tail.tail.current.i1.i1.i0.i1.item3ToString
  jinzhi4.tail.tail.tail.tail.current.i1.i1.i1.i0.item2ToString
  jinzhi4.tail.tail.tail.tail.current.i1.i1.i1.i1.item1ToString

  val jinzhi5 = KongWeiZero.value
    .add(new I18)
    .add(new I17)
    .add(new I16)
    .add(new I15)
    .add(new I14)
    .add(new I13)
    .add(new I12)
    .add(new I11)
    .add(new I10)
    .add(new I9)
    .add(new I8)
    .add(new I7)
    .add(new I6)
    .add(new I5)
    .add(new I4)
    .add(new I3)
    .add(new I2)
    .add(new I1)

  jinzhi5.tail.current.i0.item1ToString
  jinzhi5.tail.current.i1.item2ToString
  jinzhi5.tail.tail.tail.tail.current.i0.i0.i0.i1.item4ToString
  jinzhi5.tail.tail.tail.tail.current.i0.i0.i1.i0.item5ToString
  jinzhi5.tail.tail.tail.tail.current.i0.i1.i0.i1.item8ToString
  jinzhi5.tail.tail.tail.tail.current.i0.i1.i1.i0.item9ToString
  jinzhi5.tail.tail.tail.tail.current.i0.i1.i1.i1.item10ToString
  jinzhi5.tail.tail.tail.tail.current.i1.i0.i0.i0.item11ToString
  jinzhi5.tail.tail.tail.tail.current.i1.i1.i0.i1.item16ToString
  jinzhi5.tail.tail.tail.tail.current.i1.i1.i1.i0.item17ToString
  jinzhi5.tail.tail.tail.tail.current.i1.i1.i1.i1.item18ToString
  jinzhi5.tail.tail.tail.tail.current.i0.i0.i0.i0.item3ToString
  jinzhi5.tail.tail.tail.tail.current.i0.i0.i1.i1.item6ToString
  jinzhi5.tail.tail.tail.tail.current.i1.i0.i0.i1.item12ToString
  jinzhi5.tail.tail.tail.tail.current.i1.i0.i1.i0.item13ToString
  jinzhi5.tail.tail.tail.tail.current.i0.i1.i0.i0.item7ToString
  jinzhi5.tail.tail.tail.tail.current.i1.i0.i1.i1.item14ToString
  jinzhi5.tail.tail.tail.tail.current.i1.i1.i0.i0.item15ToString

  trait Mi {

    type Head
    type _0 <: Mi
    type _1 <: Mi

    def head: Head
    def _0: _0
    def _1: _1

  }

  class ZeroValue extends Mi {
    self =>
    override type Head = ZeroValue
    override type _0   = ZeroValue
    override type _1   = ZeroValue

    override def head: ZeroValue = self
    override def _0: ZeroValue   = self
    override def _1: ZeroValue   = self
  }

  class MiImpl[H, Zero <: Mi, One <: Mi](override val head: H, override val _0: Zero, override val _1: One) extends Mi {
    override type Head = H
    override type _0   = Zero
    override type _1   = One
  }

  val aa = new MiImpl(
    head = new ZeroValue,
    _0 = new ZeroValue,
    _1 = new MiImpl(
      head = new I1,
      _0 = new MiImpl(
        head = new I2,
        _0 = new MiImpl(
          head = new I4,
          _0 = new MiImpl(
            head = new I8,
            _0 = new MiImpl(head = new I16, _0 = new ZeroValue, _1 = new ZeroValue),
            _1 = new MiImpl(head = new I17, _0 = new ZeroValue, _1 = new ZeroValue)
          ),
          _1 = new MiImpl(head = new I9, _0 = new MiImpl(head = new I18, _0 = new ZeroValue, _1 = new ZeroValue), _1 = new ZeroValue)
        ),
        _1 = new MiImpl(
          head = new I5,
          _0 = new MiImpl(head = new I10, _0 = new ZeroValue, _1 = new ZeroValue),
          _1 = new MiImpl(head = new I11, _0 = new ZeroValue, _1 = new ZeroValue)
        )
      ),
      _1 = new MiImpl(
        head = new I3,
        _0 = new MiImpl(
          head = new I6,
          _0 = new MiImpl(head = new I12, _0 = new ZeroValue, _1 = new ZeroValue),
          _1 = new MiImpl(head = new I13, _0 = new ZeroValue, _1 = new ZeroValue)
        ),
        _1 = new MiImpl(
          head = new I7,
          _0 = new MiImpl(head = new I14, _0 = new ZeroValue, _1 = new ZeroValue),
          _1 = new MiImpl(head = new I15, _0 = new ZeroValue, _1 = new ZeroValue)
        )
      )
    )
  )

  aa._1.head: I1
  aa._1._0.head: I2
  aa._1._1.head: I3
  aa._1._0._0.head: I4
  aa._1._0._1.head: I5
  aa._1._1._0.head: I6
  aa._1._1._1.head: I7
  aa._1._0._0._0.head: I8
  aa._1._0._0._1.head: I9
  aa._1._0._1._0.head: I10
  aa._1._0._1._1.head: I11
  aa._1._1._0._0.head: I12
  aa._1._1._0._1.head: I13
  aa._1._1._1._0.head: I14
  aa._1._1._1._1.head: I15
  aa._1._0._0._0._0.head: I16
  aa._1._0._0._0._1.head: I17
  aa._1._0._0._1._0.head: I18



}
