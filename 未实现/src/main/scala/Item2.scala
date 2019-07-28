trait Item2 {

  type I1 <: Item2
  def i1: I1
  type I2 <: Item2
  def i2: I2

}

class Item0Impl extends Item2 {
  self =>
  override type I1 = Item0Impl
  override type I2 = Item0Impl
  override def i1: Item0Impl    = self
  override def i2: Item0Impl    = self
  override def toString: String = s"Item0"
}

object Item0Impl extends Item0Impl

class Item1Impl[T](val value: T) extends Item2 {
  self =>
  override type I1 = Item1Impl[T]
  override type I2 = Item1Impl[T]
  override def i1: Item1Impl[T] = self
  override def i2: Item1Impl[T] = self
  override def toString: String = s"Item1(${value})"
}

class Item2Impl[T1 <: Item2, T2 <: Item2](override val i1: T1, override val i2: T2) extends Item2 {
  override type I1 = T1
  override type I2 = T2
  override def toString: String = s"Item2(${i2}, ${i1})"
}
