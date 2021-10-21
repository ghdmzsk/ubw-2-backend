package a64.加法

import a64.基础._

class PlusTypeContext1[T] extends TypeContext {
  override type toDataType = Number[T]
  override type Parameter  = Unit
  override type Result     = T
}

class PlusContext1[T] extends Context[PlusTypeContext1[T], T] {
  override type DataCtx = (Number[T], Number[T])
  override def convert(t: Number[T], current: Number[T]): (Number[T], Number[T]) = (t, current)
  override def bindS(number: (Number[T], Number[T]), parameter: Unit, head: T): Collect[T] =
    CollectS(number._2.execute(this)((), number._1), head)
  override def bindT(number: (Number[T], Number[T]), parameter: Unit): Collect[T] = number._1.execute(new PlusContext2)((), ())
}

class PlusTypeContext2[T] extends TypeContext {
  override type toDataType = Unit
  override type Parameter  = Unit
  override type Result     = T
}

class PlusContext2[T] extends Context[PlusTypeContext2[T], T] {
  override type DataCtx = Number[T]
  override def convert(t: Unit, current: Number[T]): Number[T] = current
  override def bindS(number: Number[T], parameter: Unit, head: T): Collect[T] =
    CollectS(number.execute(this)((), ()), head)
  override def bindT(number: Number[T], parameter: Unit): Collect[T] = CollectT()
}
