trait Jinzhi {

  /*type Current <: Item0
  def current: Current*/

  type Tail <: Jinzhi
  def tail: Tail

  type UpdateCurrent[T <: Item0] <: Jinzhi
  def add[T <: Item0](t: T): UpdateCurrent[T]

}

trait JinZhiImpl[CC <: Item0, TT <: Jinzhi] extends Jinzhi {
  //override def current: CC
  override def tail: TT

  //override type Current = CC
  override type Tail = TT
}

trait Item0
object Item0 extends Item0

trait Item1 extends Item0 {

  type I1
  def i1: I1

}

class Item1Impl[T](override val i1: T) extends Item1 {
  override type I1 = T
}

trait Item2 extends Item1 {

  override type I1
  override def i1: I1
  type I2
  def i2: I2

}

class Item2Impl[T1, T2](override val i1: T1, override val i2: T2) extends Item2 {
  override type I1 = T1
  override type I2 = T2
}

trait KongWei[TT <: Jinzhi] extends JinZhiImpl[Item0, TT] {
  override val tail: TT
  override type UpdateCurrent[T <: Item0] = Manwei[T, TT]
  override def add[T <: Item0](t: T): Manwei[T, TT] = new Manwei[T, TT](t, tail)

}

class KongWeiImpl[TT <: Jinzhi](override val tail: TT) extends KongWei[TT] {
  override type UpdateCurrent[T <: Item0] = Manwei[T, TT]
  override def add[T <: Item0](t: T): Manwei[T, TT] = new Manwei[T, TT](t, tail)
}

class Manwei[CC <: Item0, TT <: Jinzhi](val current: CC, override val tail: TT) extends JinZhiImpl[Item0, TT] {
  override type UpdateCurrent[T <: Item0] = KongWei[TT#UpdateCurrent[Item2Impl[T, CC]]]
  override def add[T <: Item0](t: T): KongWei[TT#UpdateCurrent[Item2Impl[T, CC]]] = {
    new KongWeiImpl(tail.add(new Item2Impl(t, current)))
  }

}

class KongWeiZero extends JinZhiImpl[Item0, KongWeiZero] {
  self =>
  override def tail: KongWeiZero = self
  override type UpdateCurrent[T <: Item0] = Manwei[T, KongWeiZero]
  override def add[T <: Item0](t: T): Manwei[T, KongWeiZero] = new Manwei[T, KongWeiZero](t, self)
}

object KongWeiZero {
  val value: KongWeiZero = new KongWeiZero
}

object Runner {

  type Alias1 = Manwei[Item0, KongWeiZero]
  val manwei: Alias1 = new Manwei(Item0, KongWeiZero.value: KongWeiZero)

  val miao
    : Alias1#UpdateCurrent[Item1Impl[String]]#UpdateCurrent[Item1Impl[String]]#UpdateCurrent[Item1Impl[String]]#UpdateCurrent[
      Item1Impl[String]] =
    throw new Exception("ii")

  miao: Manwei[
    Item1Impl[String],
    KongWei[Manwei[Item2Impl[Item2Impl[Item1Impl[String], Item1Impl[String]], Item2Impl[Item1Impl[String], Item0]],
                   KongWeiZero]]]

  val miao1
    : Alias1#UpdateCurrent[Item1Impl[String]]#UpdateCurrent[Item1Impl[String]]#UpdateCurrent[Item1Impl[String]]#UpdateCurrent[
      Item1Impl[String]]#UpdateCurrent[Item1Impl[String]] = throw new Exception("ii")

  miao1: KongWei[
    Manwei[Item2Impl[Item1Impl[String], Item1Impl[String]],
           Manwei[Item2Impl[Item2Impl[Item1Impl[String], Item1Impl[String]], Item2Impl[Item1Impl[String], Item0]],
                  KongWeiZero]]]

}
