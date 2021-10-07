package a64.减法

import a64.基础._

class MinusTypeContext1[T] extends TypeContext {
  override type toDataType = Number[T]
  override type Parameter  = Unit
  override type Result     = T
}

class MinusContext1[T] extends Context[MinusTypeContext1[T], T] {
  override type DataCtx = (Number[T], Number[T])
  override def convert(t: Number[T], current: Number[T]): (Number[T], Number[T]) = (t, current)
  override def bindS(number: (Number[T], Number[T]), parameter: Unit, head: T): Collect[T] =
    number._1.execute(new MinusContext2)((), number._2)
  override def bindT(number: (Number[T], Number[T]), parameter: Unit): Collect[T] = CollectT()
}

class MinusContext2[T] extends Context[MinusTypeContext1[T], T] {
  override type DataCtx = (Number[T], Number[T])
  override def convert(t: Number[T], current: Number[T]): (Number[T], Number[T]) = (t, current)
  override def bindS(number: (Number[T], Number[T]), parameter: Unit, head: T): Collect[T] =
    number._1.execute(new MinusContext1)((), number._2)
  override def bindT(number: (Number[T], Number[T]), parameter: Unit): Collect[T] = number._1.execute(new MinusContext3)((), ())
}

class MinusTypeContext3[T] extends TypeContext {
  override type toDataType = Unit
  override type Parameter  = Unit
  override type Result     = T
}

class MinusContext3[T] extends Context[MinusTypeContext3[T], T] {
  override type DataCtx = Number[T]
  override def convert(t: Unit, current: Number[T]): Number[T]                = current
  override def bindS(number: Number[T], parameter: Unit, head: T): Collect[T] = CollectS(number.execute(this)((), ()), head)
  override def bindT(number: Number[T], parameter: Unit): Collect[T]          = CollectT()
}
