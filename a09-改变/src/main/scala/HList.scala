package a05

trait HList {

  type add[T] <: HList
  def add[T](item: T): add[T]

  type drop[H, T] <: HList
  def drop[H, T](head: H, item: T): drop[H, T]

}

class Zero extends HList {
  self =>

  override type add[T] = Zhengshu[Zero, T]
  override def add[T](item: T): Zhengshu[Zero, T] = new Zhengshu(tail = self, head = item)

  override type drop[H, T] = add[T]
  override def drop[H, T](head: H, item: T): Zhengshu[Zero, T] = new Zhengshu(tail = self, head = item)

  override def toString: String = s"Zero"

}

object Zero {
  val value: Zero = new Zero
}

class Zhengshu[Tail <: HList, Head](val tail: Tail, val head: Head) extends HList {
  self =>

  override type add[T] = Zhengshu[Zhengshu[Tail, Head], T]
  override def add[T](item: T): Zhengshu[Zhengshu[Tail, Head], T] = new Zhengshu(tail = self, head = item)

  override type drop[H, T] = push[T]#add[H]
  override def drop[H, T](head: H, item: T): push[T]#add[H] = push(item).add(head)

  type push[T] = Tail#drop[Head, T]
  def push[T](item: T): push[T] = tail.drop(head, item)

  override def toString: String = s"$tail :: $head"

}
