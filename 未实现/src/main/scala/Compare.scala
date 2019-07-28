trait ItemUnPack {

  type M[I <: Item2] <: Item2
  def unPack[I <: Item2](i: I): M[I]

  type Sub <: ItemUnPack
  def sub: Sub

  type _1 <: ItemUnPack
  def _1: _1

  type _2 <: ItemUnPack
  def _2: _2

}

class ZeroItemUnPack extends ItemUnPack {
  self =>

  override type M[I <: Item2] = I
  override def unPack[I <: Item2](i: I): I = i

  override type Sub = ZeroItemUnPack
  override val sub: ZeroItemUnPack = self

  override type _1 = ItemUnPack_1[ZeroItemUnPack]
  override def _1: ItemUnPack_1[ZeroItemUnPack] = new ItemUnPack_1(self)

  override type _2 = ItemUnPack_2[ZeroItemUnPack]
  override def _2: ItemUnPack_2[ZeroItemUnPack] = new ItemUnPack_2(self)

}

object ZeroItemUnPack extends ZeroItemUnPack

class ItemUnPack_1[RR <: ItemUnPack](override val sub: RR) extends ItemUnPack {
  self =>

  override type M[I <: Item2] = Sub#M[I#I1]
  override def unPack[I <: Item2](i: I): Sub#M[I#I1] = sub.unPack(i.i1)

  override type Sub = RR

  override type _1 = ItemUnPack_1[ItemUnPack_1[RR]]
  override def _1: ItemUnPack_1[ItemUnPack_1[RR]] = new ItemUnPack_1(self)

  override type _2 = ItemUnPack_2[ItemUnPack_1[RR]]
  override def _2: ItemUnPack_2[ItemUnPack_1[RR]] = new ItemUnPack_2(self)

}

class ItemUnPack_2[RR <: ItemUnPack](override val sub: RR) extends ItemUnPack {
  self =>

  override type M[I <: Item2] = Sub#M[I#I2]
  override def unPack[I <: Item2](i: I): Sub#M[I#I2] = sub.unPack(i.i2)

  override type Sub = RR

  override type _1 = ItemUnPack_1[ItemUnPack_2[RR]]
  override def _1: ItemUnPack_1[ItemUnPack_2[RR]] = new ItemUnPack_1(self)

  override type _2 = ItemUnPack_2[ItemUnPack_2[RR]]
  override def _2: ItemUnPack_2[ItemUnPack_2[RR]] = new ItemUnPack_2(self)

}
