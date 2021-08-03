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

object Item2Impl {
  implicit def appendImplicit[
    K <: KindContext,
    H1,
    H2,
    T1 <: TypeParam,
    T2 <: TypeParam
  ](implicit
    t1: Application[K, H1, T1],
    t2: Application[K, H2, T2]
  ): Application[K, Item2Impl[H1, H2], Item2Type[T1, T2]] =
    new Application[K, Item2Impl[H1, H2], Item2Type[T1, T2]] {
      override def application(context: Context[K]): K#M[Item2Type[T1, T2]] = {
        def i[TT1 <: TypeParam, TT2 <: TypeParam]: Plus[TT1, TT2, Item2Type[TT1, TT2]] =
          new Plus[TT1, TT2, Item2Type[TT1, TT2]] {
            override def plus(p: TT1#H, item: TT2#H): Item2Impl[TT1#H, TT2#H] = new Item2Impl(p, item)
            override def takeHead(t: Item2Impl[TT1#H, TT2#H]): TT2#H          = t.i2
            override def takeTail(t: Item2Impl[TT1#H, TT2#H]): TT1#H          = t.i1
            override def sub: Plus[TT1#T, TT2#T, Item2Type[TT1#T, TT2#T]]     = i[TT1#T, TT2#T]
          }
        context.append(t1.application(context), t2.application(context), i[T1, T2])
      }
    }
}

class KongWei[TT <: Jinzhi](override val tail: TT) extends Jinzhi {
  override type Tail             = TT
  override type UpdateCurrent[T] = Manwei[T, TT]
  override def add[T](t: T): Manwei[T, TT] = new Manwei(t, tail)
  override def toString: String            = s"${tail} :: 空位0"
}

object KongWei {
  implicit def appendImplicit[
    K <: KindContext,
    H1 <: Jinzhi,
    T1 <: JinzhiTypeParam
  ](implicit
    t1: Application[K, H1, T1]
  ): Application[K, KongWei[H1], KongWeiType[T1]] =
    new Application[K, KongWei[H1], KongWeiType[T1]] {
      override def application(context: Context[K]): K#M[KongWeiType[T1]] = {
        def i[TT1 <: JinzhiType0, TT2 <: JinzhiTypeParam]: Plus[TT1, TT2, KongWeiType[TT2]] =
          new Plus[TT1, TT2, KongWeiType[TT2]] {
            override def plus(p: KongWeiZero, item: TT2#H): KongWei[TT2#H] = new KongWei(item)
            override def takeHead(t: KongWei[TT2#H]): TT2#H                = t.tail
            override def takeTail(t: KongWei[TT2#H]): KongWeiZero          = KongWeiZero.value
            override def sub: Plus[JinzhiType0, TT2#T, KongWeiType[TT2#T]] = i[TT1#T, TT2#T]
          }
        context.append(context.start, t1.application(context), i[JinzhiType0, T1])
      }
    }
}

class Manwei[CC, TT <: Jinzhi](val current: CC, override val tail: TT) extends Jinzhi {
  override type Tail             = TT
  override type UpdateCurrent[T] = KongWei[TT#UpdateCurrent[Item2Impl[T, CC]]]
  override def add[T](t: T): KongWei[TT#UpdateCurrent[Item2Impl[T, CC]]] = {
    new KongWei(tail.add(new Item2Impl(t, current)))
  }
  override def toString: String = s"${tail} :: 满位1(${current})"
}

object Manwei {
  implicit def appendImplicit2[
    K <: KindContext,
    H1,
    H2 <: Jinzhi,
    T1 <: TypeParam,
    T2 <: JinzhiTypeParam
  ](implicit
    t1: Application[K, H1, T1],
    t2: Application[K, H2, T2]
  ): Application[K, Manwei[H1, H2], ManweiType[T1, T2]] =
    new Application[K, Manwei[H1, H2], ManweiType[T1, T2]] {
      override def application(context: Context[K]): K#M[ManweiType[T1, T2]] = {
        def i[TT1 <: TypeParam, TT2 <: JinzhiTypeParam]: Plus[TT1, TT2, ManweiType[TT1, TT2]] =
          new Plus[TT1, TT2, ManweiType[TT1, TT2]] {
            override def plus(p: TT1#H, item: TT2#H): Manwei[TT1#H, TT2#H] = new Manwei(p, item)
            override def takeHead(t: Manwei[TT1#H, TT2#H]): TT2#H          = t.tail
            override def takeTail(t: Manwei[TT1#H, TT2#H]): TT1#H          = t.current
            override def sub: Plus[TT1#T, TT2#T, ManweiType[TT1#T, TT2#T]] = i[TT1#T, TT2#T]
          }
        context.append(t1.application(context), t2.application(context), i[T1, T2])
      }
    }
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

  implicit def appendImplicit1[K <: KindContext]: Application[K, KongWeiZero, JinzhiType0] =
    new Application[K, KongWeiZero, JinzhiType0] {
      override def application(context: Context[K]): K#M[JinzhiType0] = {
        context.start
      }
    }

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

  val miao3: KongWeiZero#UpdateCurrent[I1]#UpdateCurrent[I2]#UpdateCurrent[I3]#UpdateCurrent[I4]#UpdateCurrent[I5]#UpdateCurrent[
    I6
  ] = KongWeiZero.value.add(new I1).add(new I2).add(new I3).add(new I4).add(new I5).add(new I6)

  miao3: KongWei[Manwei[Item2Impl[I6, I5], Manwei[Item2Impl[Item2Impl[I4, I3], Item2Impl[I2, I1]], KongWeiZero]]]
  println(miao3)

  println(
    KongWeiZero.value.add(new I1).add(new I2).add(new I3).add(new I4).add(new I5).add(new I6).add(new I7).add(new I8).add(new I9)
  )

}
