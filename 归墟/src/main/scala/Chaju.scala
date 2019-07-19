import scala.language.higherKinds

trait Chaju {

  type Next <: Chaju
  def next: Next

  type M[Item, II <: HList] <: HList
  def tran[Item, II <: HList](m: II, item: Item): M[Item, II]

  def tranGuixu[Item](guixu: Guixu, item: Item): Guixu

  type Add <: Chaju
  def add: Add

}

class ChajuImpl[T <: Chaju](tail: T) extends Chaju {
  self =>

  override type Next = T
  override def next: T = tail

  override type M[Item, II <: HList] = II#Add[Item]
  override def tran[Item, II <: HList](m: II, item: Item): II#Add[Item] = m.add(item)

  override def tranGuixu[Item](guixu: Guixu, item: Item): Guixu = guixu

  override type Add = ChajuImpl[ChajuImpl[T]]
  override def add: ChajuImpl[ChajuImpl[T]] = new ChajuImpl(self)

}

class Manyi extends Chaju {
  self =>

  override type Next = Manyi
  override def next: Manyi = self

  override type M[Item, II <: HList] = II
  override def tran[Item, II <: HList](m: II, item: Item): II = m

  override def tranGuixu[Item](guixu: Guixu, item: Item): Guixu = guixu.add(item)

  override type Add = ChajuImpl[Manyi]
  override def add: ChajuImpl[Manyi] = new ChajuImpl(self)

}

object Manyi extends Manyi
