package a64.乘除法

import a64.基础._

class MultiplyTypeContext1[T] extends TypeContext {
  override type toDataType = Number[T]
  override type Parameter  = Unit
  override type Result     = T
}

class MultiplyContext1[T] extends Context[MultiplyTypeContext1[T], T] {
  override type DataCtx = (Number[T], Number[T])
  override def convert(t: Number[T], current: Number[T]): (Number[T], Number[T]) = (t, current)
  override def bindS(number: (Number[T], Number[T]), parameter: Unit, head: T): Collect[T] =
    number._1.execute(new MultiplyContext2)((), number._2)
  override def bindT(number: (Number[T], Number[T]), parameter: Unit): Collect[T] = CollectT()
}

class MultiplyTypeContext2[T] extends TypeContext {
  override type toDataType = Number[T]
  override type Parameter  = Unit
  override type Result     = T
}

class MultiplyContext2[T] extends Context[MultiplyTypeContext2[T], T] {
  override type DataCtx = (Number[T], Number[T])
  override def convert(t: Number[T], current: Number[T]): (Number[T], Number[T]) = (t, current)
  override def bindS(number: (Number[T], Number[T]), parameter: Unit, head: T): Collect[T] =
    CollectS(number._2.execute(this)((), number._1), head)
  override def bindT(number: (Number[T], Number[T]), parameter: Unit): Collect[T] = number._1.execute(new MultiplyContext1)((), number._2)
}
