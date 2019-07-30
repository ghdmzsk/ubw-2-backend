import scala.language.higherKinds

class JinzhiType0 extends TypeParam {
  override type H = KongWeiZero
  override type T = JinzhiType0
}

object JinzhiType0 {
  implicit def appendImplicit[K <: KindContext]: Application[K, KongWeiZero, JinzhiType0] =
    new Application[K, KongWeiZero, JinzhiType0] {
      override def application(context: Context[K]): K#M[JinzhiType0] = {
        context.start
      }
    }
}

trait JinzhiTypeParam extends TypeParam {
  override type H <: Jinzhi
  override type T <: JinzhiTypeParam
}

class ManweiType[T1 <: TypeParam, T2 <: JinzhiTypeParam] extends JinzhiTypeParam {
  override type H = Manwei[T1#H, T2#H]
  override type T = ManweiType[T1#T, T2#T]
}

object ManweiType {
  implicit def appendImplicit[
    K <: KindContext,
    H1,
    H2 <: Jinzhi,
    T1 <: TypeParam,
    T2 <: JinzhiTypeParam
  ](
    implicit t1: Application[K, H1, T1],
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

class KongWeiType[T1 <: JinzhiTypeParam] extends JinzhiTypeParam {
  override type H = KongWei[T1#H]
  override type T = KongWeiType[T1#T]
}

object KongWeiType {
  implicit def appendImplicit[
    K <: KindContext,
    H1 <: Jinzhi,
    T1 <: JinzhiTypeParam
  ](
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

class Item2Type[T1 <: TypeParam, T2 <: TypeParam] extends TypeParam {
  override type H = Item2Impl[T1#H, T2#H]
  override type T = Item2Type[T1#T, T2#T]
}

object Item2Type {
  implicit def appendImplicit[
    K <: KindContext,
    H1,
    H2,
    T1 <: TypeParam,
    T2 <: TypeParam
  ](
    implicit t1: Application[K, H1, T1],
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
