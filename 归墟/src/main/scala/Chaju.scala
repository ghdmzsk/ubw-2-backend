import scala.language.higherKinds

trait Chaju {

  type Next <: Chaju
  def next: Next

  type M[Item, I <: 大海] <: 大海
  def tran[Item, II <: 大海](m: II, item: Item): M[Item, II]

  type Add <: Chaju
  def add: Add

}

class ChajuImpl[T <: Chaju](tail: T) extends Chaju {
  self =>

  override type Next = T
  override def next: T = tail

  override type M[Item, I <: 大海] = 灌水的大海[I#海水#Add[Item], I#差距#Next]
  override def tran[Item, I <: 大海](m: I, item: Item): 灌水的大海[I#海水#Add[Item], I#差距#Next] = new 灌水的大海(m.海水.add(item), m.归墟, m.差距.next)

  override type Add = ChajuImpl[ChajuImpl[T]]
  override def add: ChajuImpl[ChajuImpl[T]] = new ChajuImpl(self)

}

class Manyi extends Chaju {
  self =>

  override type Next = Manyi
  override def next: Manyi = self

  override type M[Item, I <: 大海] = 灌水的大海[I#海水, I#差距#Next]
  override def tran[Item, I <: 大海](m: I, item: Item): 灌水的大海[I#海水, I#差距#Next] = new 灌水的大海(m.海水, m.归墟.add(item), m.差距.next)

  override type Add = ChajuImpl[Manyi]
  override def add: ChajuImpl[Manyi] = new ChajuImpl(self)

}

object Manyi extends Manyi
