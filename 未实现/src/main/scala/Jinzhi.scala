trait Jinzhi {

  type Tail <: Jinzhi
  def tail: Tail

  type UpdateCurrent[T] <: Jinzhi
  def add[T](t: T): UpdateCurrent[T]

}

trait JinZhiImpl[TT <: Jinzhi] extends Jinzhi {
  override def tail: TT
  override type Tail = TT
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
}

trait KongWei[TT <: Jinzhi] extends JinZhiImpl[TT] {
  override val tail: TT
  override type UpdateCurrent[T] = Manwei[T, TT]
  override def add[T](t: T): Manwei[T, TT] = new Manwei[T, TT](t, tail)

}

class KongWeiImpl[TT <: Jinzhi](override val tail: TT) extends KongWei[TT] {
  override type UpdateCurrent[T] = Manwei[T, TT]
  override def add[T](t: T): Manwei[T, TT] = new Manwei[T, TT](t, tail)
}

class Manwei[CC, TT <: Jinzhi](val current: CC, override val tail: TT) extends JinZhiImpl[TT] {
  override type UpdateCurrent[T] = KongWei[TT#UpdateCurrent[Item2Impl[T, CC]]]
  override def add[T](t: T): KongWei[TT#UpdateCurrent[Item2Impl[T, CC]]] = {
    new KongWeiImpl(tail.add(new Item2Impl(t, current)))
  }
}

class KongWeiZero extends JinZhiImpl[KongWeiZero] {
  self =>
  override def tail: KongWeiZero = self
  override type UpdateCurrent[T] = Manwei[T, KongWeiZero]
  override def add[T](t: T): Manwei[T, KongWeiZero] = new Manwei[T, KongWeiZero](t, self)
}

object KongWeiZero {
  val value: KongWeiZero = new KongWeiZero
}

object Runner {

  val miao1: KongWeiZero#UpdateCurrent[String]#UpdateCurrent[String]#UpdateCurrent[String]#UpdateCurrent[String] =
    throw new Exception("ii")

  miao1: KongWei[KongWei[Manwei[Item2Impl[Item2Impl[String, String], Item2Impl[String, String]], KongWeiZero]]]

  val miao2
    : KongWeiZero#UpdateCurrent[String]#UpdateCurrent[String]#UpdateCurrent[String]#UpdateCurrent[String]#UpdateCurrent[
      String] = throw new Exception("ii")

  miao2: Manwei[String, KongWei[Manwei[Item2Impl[Item2Impl[String, String], Item2Impl[String, String]], KongWeiZero]]]

  val miao3
    : KongWeiZero#UpdateCurrent[String]#UpdateCurrent[String]#UpdateCurrent[String]#UpdateCurrent[String]#UpdateCurrent[
      String]#UpdateCurrent[String] = throw new Exception("ii")

  miao3: KongWei[Manwei[Item2Impl[String, String],
                        Manwei[Item2Impl[Item2Impl[String, String], Item2Impl[String, String]], KongWeiZero]]]

}
