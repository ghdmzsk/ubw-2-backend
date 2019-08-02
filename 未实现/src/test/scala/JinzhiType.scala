import scala.language.higherKinds

class JinzhiType0 extends JinzhiTypeParam {
  override type H = KongWeiZero
  override type T = JinzhiType0
}

trait JinzhiTypeParam extends TypeParam {
  override type H <: Jinzhi
  override type T <: JinzhiTypeParam
}

class ManweiType[T1 <: TypeParam, T2 <: JinzhiTypeParam] extends JinzhiTypeParam {
  override type H = Manwei[T1#H, T2#H]
  override type T = ManweiType[T1#T, T2#T]
}

class KongWeiType[T1 <: JinzhiTypeParam] extends JinzhiTypeParam {
  override type H = KongWei[T1#H]
  override type T = KongWeiType[T1#T]
}

class Item2Type[T1 <: TypeParam, T2 <: TypeParam] extends TypeParam {
  override type H = Item2Impl[T1#H, T2#H]
  override type T = Item2Type[T1#T, T2#T]
}
