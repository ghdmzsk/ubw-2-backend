package shijinzhi
trait Counter {
  type Take[J <: JinzhiItem] <: JinzhiItem
  type ToSetter[J <: Setter] <: Setter
  type Set <: Setter
  def toSetter[T <: Setter](t: T): ToSetter[T]
  def take[J <: JinzhiItem](j: J): Take[J]
  def setter: Set
  type Up <: Counter
  def up: Up
  type _0 <: Counter
  def _0: _0
  type _1 <: Counter
  def _1: _1
  type _2 <: Counter
  def _2: _2
  type _3 <: Counter
  def _3: _3
  type _4 <: Counter
  def _4: _4
  type _5 <: Counter
  def _5: _5
  type _6 <: Counter
  def _6: _6
  type _7 <: Counter
  def _7: _7
  type _8 <: Counter
  def _8: _8
  type _9 <: Counter
  def _9: _9
}
class CounterPoint extends Counter {
  self =>
  override type Take[J <: JinzhiItem] = J
  override def take[J <: JinzhiItem](j: J): J = j
  override type Set                   = SetterPoint
  override type ToSetter[J <: Setter] = J
  override def toSetter[T <: Setter](t: T): T = t
  override def setter: SetterPoint            = SetterPoint.value
  override type Up = Counter_1[CounterPoint]
  override def up: Counter_1[CounterPoint] = new Counter_1(self)
  override type _0 = Counter_0[CounterPoint]
  override def _0: Counter_0[CounterPoint] = new Counter_0(self)
  override type _1 = Counter_1[CounterPoint]
  override def _1: Counter_1[CounterPoint] = new Counter_1(self)
  override type _2 = Counter_2[CounterPoint]
  override def _2: Counter_2[CounterPoint] = new Counter_2(self)
  override type _3 = Counter_3[CounterPoint]
  override def _3: Counter_3[CounterPoint] = new Counter_3(self)
  override type _4 = Counter_4[CounterPoint]
  override def _4: Counter_4[CounterPoint] = new Counter_4(self)
  override type _5 = Counter_5[CounterPoint]
  override def _5: Counter_5[CounterPoint] = new Counter_5(self)
  override type _6 = Counter_6[CounterPoint]
  override def _6: Counter_6[CounterPoint] = new Counter_6(self)
  override type _7 = Counter_7[CounterPoint]
  override def _7: Counter_7[CounterPoint] = new Counter_7(self)
  override type _8 = Counter_8[CounterPoint]
  override def _8: Counter_8[CounterPoint] = new Counter_8(self)
  override type _9 = Counter_9[CounterPoint]
  override def _9: Counter_9[CounterPoint] = new Counter_9(self)
}
object CounterPoint {
  val value: CounterPoint = new CounterPoint
}
class Counter_0[C <: Counter](val c: C) extends Counter {
  self =>
  override type Take[J <: JinzhiItem] = C#Take[J]#_0
  override type Set                   = ToSetter[SetterPoint]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_0 = c.take(j)._0
  override type ToSetter[J <: Setter] = C#ToSetter[J#_0]
  override def toSetter[T <: Setter](t: T): C#ToSetter[T#_0] = c.toSetter(t._0)
  override def setter: ToSetter[SetterPoint]                 = toSetter(SetterPoint.value)
  override type Up = Counter_1[C]
  override def up: Up = new Counter_1(c)
  override type _0 = Counter_0[Counter_0[C]]
  override def _0: Counter_0[Counter_0[C]] = new Counter_0(self)
  override type _1 = Counter_1[Counter_0[C]]
  override def _1: Counter_1[Counter_0[C]] = new Counter_1(self)
  override type _2 = Counter_2[Counter_0[C]]
  override def _2: Counter_2[Counter_0[C]] = new Counter_2(self)
  override type _3 = Counter_3[Counter_0[C]]
  override def _3: Counter_3[Counter_0[C]] = new Counter_3(self)
  override type _4 = Counter_4[Counter_0[C]]
  override def _4: Counter_4[Counter_0[C]] = new Counter_4(self)
  override type _5 = Counter_5[Counter_0[C]]
  override def _5: Counter_5[Counter_0[C]] = new Counter_5(self)
  override type _6 = Counter_6[Counter_0[C]]
  override def _6: Counter_6[Counter_0[C]] = new Counter_6(self)
  override type _7 = Counter_7[Counter_0[C]]
  override def _7: Counter_7[Counter_0[C]] = new Counter_7(self)
  override type _8 = Counter_8[Counter_0[C]]
  override def _8: Counter_8[Counter_0[C]] = new Counter_8(self)
  override type _9 = Counter_9[Counter_0[C]]
  override def _9: Counter_9[Counter_0[C]] = new Counter_9(self)
}
class Counter_1[C <: Counter](val c: C) extends Counter {
  self =>
  override type Take[J <: JinzhiItem] = C#Take[J]#_1
  override type Set                   = ToSetter[SetterPoint]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_1 = c.take(j)._1
  override type ToSetter[J <: Setter] = C#ToSetter[J#_1]
  override def toSetter[T <: Setter](t: T): C#ToSetter[T#_1] = c.toSetter(t._1)
  override def setter: ToSetter[SetterPoint]                 = toSetter(SetterPoint.value)
  override type Up = Counter_2[C]
  override def up: Up = new Counter_2(c)
  override type _0 = Counter_0[Counter_1[C]]
  override def _0: Counter_0[Counter_1[C]] = new Counter_0(self)
  override type _1 = Counter_1[Counter_1[C]]
  override def _1: Counter_1[Counter_1[C]] = new Counter_1(self)
  override type _2 = Counter_2[Counter_1[C]]
  override def _2: Counter_2[Counter_1[C]] = new Counter_2(self)
  override type _3 = Counter_3[Counter_1[C]]
  override def _3: Counter_3[Counter_1[C]] = new Counter_3(self)
  override type _4 = Counter_4[Counter_1[C]]
  override def _4: Counter_4[Counter_1[C]] = new Counter_4(self)
  override type _5 = Counter_5[Counter_1[C]]
  override def _5: Counter_5[Counter_1[C]] = new Counter_5(self)
  override type _6 = Counter_6[Counter_1[C]]
  override def _6: Counter_6[Counter_1[C]] = new Counter_6(self)
  override type _7 = Counter_7[Counter_1[C]]
  override def _7: Counter_7[Counter_1[C]] = new Counter_7(self)
  override type _8 = Counter_8[Counter_1[C]]
  override def _8: Counter_8[Counter_1[C]] = new Counter_8(self)
  override type _9 = Counter_9[Counter_1[C]]
  override def _9: Counter_9[Counter_1[C]] = new Counter_9(self)
}
class Counter_2[C <: Counter](val c: C) extends Counter {
  self =>
  override type Take[J <: JinzhiItem] = C#Take[J]#_2
  override type Set                   = ToSetter[SetterPoint]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_2 = c.take(j)._2
  override type ToSetter[J <: Setter] = C#ToSetter[J#_2]
  override def toSetter[T <: Setter](t: T): C#ToSetter[T#_2] = c.toSetter(t._2)
  override def setter: ToSetter[SetterPoint]                 = toSetter(SetterPoint.value)
  override type Up = Counter_3[C]
  override def up: Up = new Counter_3(c)
  override type _0 = Counter_0[Counter_2[C]]
  override def _0: Counter_0[Counter_2[C]] = new Counter_0(self)
  override type _1 = Counter_1[Counter_2[C]]
  override def _1: Counter_1[Counter_2[C]] = new Counter_1(self)
  override type _2 = Counter_2[Counter_2[C]]
  override def _2: Counter_2[Counter_2[C]] = new Counter_2(self)
  override type _3 = Counter_3[Counter_2[C]]
  override def _3: Counter_3[Counter_2[C]] = new Counter_3(self)
  override type _4 = Counter_4[Counter_2[C]]
  override def _4: Counter_4[Counter_2[C]] = new Counter_4(self)
  override type _5 = Counter_5[Counter_2[C]]
  override def _5: Counter_5[Counter_2[C]] = new Counter_5(self)
  override type _6 = Counter_6[Counter_2[C]]
  override def _6: Counter_6[Counter_2[C]] = new Counter_6(self)
  override type _7 = Counter_7[Counter_2[C]]
  override def _7: Counter_7[Counter_2[C]] = new Counter_7(self)
  override type _8 = Counter_8[Counter_2[C]]
  override def _8: Counter_8[Counter_2[C]] = new Counter_8(self)
  override type _9 = Counter_9[Counter_2[C]]
  override def _9: Counter_9[Counter_2[C]] = new Counter_9(self)
}
class Counter_3[C <: Counter](val c: C) extends Counter {
  self =>
  override type Take[J <: JinzhiItem] = C#Take[J]#_3
  override type Set                   = ToSetter[SetterPoint]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_3 = c.take(j)._3
  override type ToSetter[J <: Setter] = C#ToSetter[J#_3]
  override def toSetter[T <: Setter](t: T): C#ToSetter[T#_3] = c.toSetter(t._3)
  override def setter: ToSetter[SetterPoint]                 = toSetter(SetterPoint.value)
  override type Up = Counter_4[C]
  override def up: Up = new Counter_4(c)
  override type _0 = Counter_0[Counter_3[C]]
  override def _0: Counter_0[Counter_3[C]] = new Counter_0(self)
  override type _1 = Counter_1[Counter_3[C]]
  override def _1: Counter_1[Counter_3[C]] = new Counter_1(self)
  override type _2 = Counter_2[Counter_3[C]]
  override def _2: Counter_2[Counter_3[C]] = new Counter_2(self)
  override type _3 = Counter_3[Counter_3[C]]
  override def _3: Counter_3[Counter_3[C]] = new Counter_3(self)
  override type _4 = Counter_4[Counter_3[C]]
  override def _4: Counter_4[Counter_3[C]] = new Counter_4(self)
  override type _5 = Counter_5[Counter_3[C]]
  override def _5: Counter_5[Counter_3[C]] = new Counter_5(self)
  override type _6 = Counter_6[Counter_3[C]]
  override def _6: Counter_6[Counter_3[C]] = new Counter_6(self)
  override type _7 = Counter_7[Counter_3[C]]
  override def _7: Counter_7[Counter_3[C]] = new Counter_7(self)
  override type _8 = Counter_8[Counter_3[C]]
  override def _8: Counter_8[Counter_3[C]] = new Counter_8(self)
  override type _9 = Counter_9[Counter_3[C]]
  override def _9: Counter_9[Counter_3[C]] = new Counter_9(self)
}
class Counter_4[C <: Counter](val c: C) extends Counter {
  self =>
  override type Take[J <: JinzhiItem] = C#Take[J]#_4
  override type Set                   = ToSetter[SetterPoint]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_4 = c.take(j)._4
  override type ToSetter[J <: Setter] = C#ToSetter[J#_4]
  override def toSetter[T <: Setter](t: T): C#ToSetter[T#_4] = c.toSetter(t._4)
  override def setter: ToSetter[SetterPoint]                 = toSetter(SetterPoint.value)
  override type Up = Counter_5[C]
  override def up: Up = new Counter_5(c)
  override type _0 = Counter_0[Counter_4[C]]
  override def _0: Counter_0[Counter_4[C]] = new Counter_0(self)
  override type _1 = Counter_1[Counter_4[C]]
  override def _1: Counter_1[Counter_4[C]] = new Counter_1(self)
  override type _2 = Counter_2[Counter_4[C]]
  override def _2: Counter_2[Counter_4[C]] = new Counter_2(self)
  override type _3 = Counter_3[Counter_4[C]]
  override def _3: Counter_3[Counter_4[C]] = new Counter_3(self)
  override type _4 = Counter_4[Counter_4[C]]
  override def _4: Counter_4[Counter_4[C]] = new Counter_4(self)
  override type _5 = Counter_5[Counter_4[C]]
  override def _5: Counter_5[Counter_4[C]] = new Counter_5(self)
  override type _6 = Counter_6[Counter_4[C]]
  override def _6: Counter_6[Counter_4[C]] = new Counter_6(self)
  override type _7 = Counter_7[Counter_4[C]]
  override def _7: Counter_7[Counter_4[C]] = new Counter_7(self)
  override type _8 = Counter_8[Counter_4[C]]
  override def _8: Counter_8[Counter_4[C]] = new Counter_8(self)
  override type _9 = Counter_9[Counter_4[C]]
  override def _9: Counter_9[Counter_4[C]] = new Counter_9(self)
}
class Counter_5[C <: Counter](val c: C) extends Counter {
  self =>
  override type Take[J <: JinzhiItem] = C#Take[J]#_5
  override type Set                   = ToSetter[SetterPoint]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_5 = c.take(j)._5
  override type ToSetter[J <: Setter] = C#ToSetter[J#_5]
  override def toSetter[T <: Setter](t: T): C#ToSetter[T#_5] = c.toSetter(t._5)
  override def setter: ToSetter[SetterPoint]                 = toSetter(SetterPoint.value)
  override type Up = Counter_6[C]
  override def up: Up = new Counter_6(c)
  override type _0 = Counter_0[Counter_5[C]]
  override def _0: Counter_0[Counter_5[C]] = new Counter_0(self)
  override type _1 = Counter_1[Counter_5[C]]
  override def _1: Counter_1[Counter_5[C]] = new Counter_1(self)
  override type _2 = Counter_2[Counter_5[C]]
  override def _2: Counter_2[Counter_5[C]] = new Counter_2(self)
  override type _3 = Counter_3[Counter_5[C]]
  override def _3: Counter_3[Counter_5[C]] = new Counter_3(self)
  override type _4 = Counter_4[Counter_5[C]]
  override def _4: Counter_4[Counter_5[C]] = new Counter_4(self)
  override type _5 = Counter_5[Counter_5[C]]
  override def _5: Counter_5[Counter_5[C]] = new Counter_5(self)
  override type _6 = Counter_6[Counter_5[C]]
  override def _6: Counter_6[Counter_5[C]] = new Counter_6(self)
  override type _7 = Counter_7[Counter_5[C]]
  override def _7: Counter_7[Counter_5[C]] = new Counter_7(self)
  override type _8 = Counter_8[Counter_5[C]]
  override def _8: Counter_8[Counter_5[C]] = new Counter_8(self)
  override type _9 = Counter_9[Counter_5[C]]
  override def _9: Counter_9[Counter_5[C]] = new Counter_9(self)
}
class Counter_6[C <: Counter](val c: C) extends Counter {
  self =>
  override type Take[J <: JinzhiItem] = C#Take[J]#_6
  override type Set                   = ToSetter[SetterPoint]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_6 = c.take(j)._6
  override type ToSetter[J <: Setter] = C#ToSetter[J#_6]
  override def toSetter[T <: Setter](t: T): C#ToSetter[T#_6] = c.toSetter(t._6)
  override def setter: ToSetter[SetterPoint]                 = toSetter(SetterPoint.value)
  override type Up = Counter_7[C]
  override def up: Up = new Counter_7(c)
  override type _0 = Counter_0[Counter_6[C]]
  override def _0: Counter_0[Counter_6[C]] = new Counter_0(self)
  override type _1 = Counter_1[Counter_6[C]]
  override def _1: Counter_1[Counter_6[C]] = new Counter_1(self)
  override type _2 = Counter_2[Counter_6[C]]
  override def _2: Counter_2[Counter_6[C]] = new Counter_2(self)
  override type _3 = Counter_3[Counter_6[C]]
  override def _3: Counter_3[Counter_6[C]] = new Counter_3(self)
  override type _4 = Counter_4[Counter_6[C]]
  override def _4: Counter_4[Counter_6[C]] = new Counter_4(self)
  override type _5 = Counter_5[Counter_6[C]]
  override def _5: Counter_5[Counter_6[C]] = new Counter_5(self)
  override type _6 = Counter_6[Counter_6[C]]
  override def _6: Counter_6[Counter_6[C]] = new Counter_6(self)
  override type _7 = Counter_7[Counter_6[C]]
  override def _7: Counter_7[Counter_6[C]] = new Counter_7(self)
  override type _8 = Counter_8[Counter_6[C]]
  override def _8: Counter_8[Counter_6[C]] = new Counter_8(self)
  override type _9 = Counter_9[Counter_6[C]]
  override def _9: Counter_9[Counter_6[C]] = new Counter_9(self)
}
class Counter_7[C <: Counter](val c: C) extends Counter {
  self =>
  override type Take[J <: JinzhiItem] = C#Take[J]#_7
  override type Set                   = ToSetter[SetterPoint]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_7 = c.take(j)._7
  override type ToSetter[J <: Setter] = C#ToSetter[J#_7]
  override def toSetter[T <: Setter](t: T): C#ToSetter[T#_7] = c.toSetter(t._7)
  override def setter: ToSetter[SetterPoint]                 = toSetter(SetterPoint.value)
  override type Up = Counter_8[C]
  override def up: Up = new Counter_8(c)
  override type _0 = Counter_0[Counter_7[C]]
  override def _0: Counter_0[Counter_7[C]] = new Counter_0(self)
  override type _1 = Counter_1[Counter_7[C]]
  override def _1: Counter_1[Counter_7[C]] = new Counter_1(self)
  override type _2 = Counter_2[Counter_7[C]]
  override def _2: Counter_2[Counter_7[C]] = new Counter_2(self)
  override type _3 = Counter_3[Counter_7[C]]
  override def _3: Counter_3[Counter_7[C]] = new Counter_3(self)
  override type _4 = Counter_4[Counter_7[C]]
  override def _4: Counter_4[Counter_7[C]] = new Counter_4(self)
  override type _5 = Counter_5[Counter_7[C]]
  override def _5: Counter_5[Counter_7[C]] = new Counter_5(self)
  override type _6 = Counter_6[Counter_7[C]]
  override def _6: Counter_6[Counter_7[C]] = new Counter_6(self)
  override type _7 = Counter_7[Counter_7[C]]
  override def _7: Counter_7[Counter_7[C]] = new Counter_7(self)
  override type _8 = Counter_8[Counter_7[C]]
  override def _8: Counter_8[Counter_7[C]] = new Counter_8(self)
  override type _9 = Counter_9[Counter_7[C]]
  override def _9: Counter_9[Counter_7[C]] = new Counter_9(self)
}
class Counter_8[C <: Counter](val c: C) extends Counter {
  self =>
  override type Take[J <: JinzhiItem] = C#Take[J]#_8
  override type Set                   = ToSetter[SetterPoint]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_8 = c.take(j)._8
  override type ToSetter[J <: Setter] = C#ToSetter[J#_8]
  override def toSetter[T <: Setter](t: T): C#ToSetter[T#_8] = c.toSetter(t._8)
  override def setter: ToSetter[SetterPoint]                 = toSetter(SetterPoint.value)
  override type Up = Counter_9[C]
  override def up: Up = new Counter_9(c)
  override type _0 = Counter_0[Counter_8[C]]
  override def _0: Counter_0[Counter_8[C]] = new Counter_0(self)
  override type _1 = Counter_1[Counter_8[C]]
  override def _1: Counter_1[Counter_8[C]] = new Counter_1(self)
  override type _2 = Counter_2[Counter_8[C]]
  override def _2: Counter_2[Counter_8[C]] = new Counter_2(self)
  override type _3 = Counter_3[Counter_8[C]]
  override def _3: Counter_3[Counter_8[C]] = new Counter_3(self)
  override type _4 = Counter_4[Counter_8[C]]
  override def _4: Counter_4[Counter_8[C]] = new Counter_4(self)
  override type _5 = Counter_5[Counter_8[C]]
  override def _5: Counter_5[Counter_8[C]] = new Counter_5(self)
  override type _6 = Counter_6[Counter_8[C]]
  override def _6: Counter_6[Counter_8[C]] = new Counter_6(self)
  override type _7 = Counter_7[Counter_8[C]]
  override def _7: Counter_7[Counter_8[C]] = new Counter_7(self)
  override type _8 = Counter_8[Counter_8[C]]
  override def _8: Counter_8[Counter_8[C]] = new Counter_8(self)
  override type _9 = Counter_9[Counter_8[C]]
  override def _9: Counter_9[Counter_8[C]] = new Counter_9(self)
}
class Counter_9[C <: Counter](val c: C) extends Counter {
  self =>
  override type Take[J <: JinzhiItem] = C#Take[J]#_9
  override type ToSetter[J <: Setter] = C#ToSetter[J#_9]
  override type Set                   = ToSetter[SetterPoint]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_9     = c.take(j)._9
  override def toSetter[T <: Setter](t: T): C#ToSetter[T#_9] = c.toSetter(t._9)
  override def setter: ToSetter[SetterPoint]                 = toSetter(SetterPoint.value)
  override type Up = Counter_0[C#Up]
  override def up: Up = new Counter_0(c.up)
  override type _0 = Counter_0[Counter_9[C]]
  override def _0: Counter_0[Counter_9[C]] = new Counter_0(self)
  override type _1 = Counter_1[Counter_9[C]]
  override def _1: Counter_1[Counter_9[C]] = new Counter_1(self)
  override type _2 = Counter_2[Counter_9[C]]
  override def _2: Counter_2[Counter_9[C]] = new Counter_2(self)
  override type _3 = Counter_3[Counter_9[C]]
  override def _3: Counter_3[Counter_9[C]] = new Counter_3(self)
  override type _4 = Counter_4[Counter_9[C]]
  override def _4: Counter_4[Counter_9[C]] = new Counter_4(self)
  override type _5 = Counter_5[Counter_9[C]]
  override def _5: Counter_5[Counter_9[C]] = new Counter_5(self)
  override type _6 = Counter_6[Counter_9[C]]
  override def _6: Counter_6[Counter_9[C]] = new Counter_6(self)
  override type _7 = Counter_7[Counter_9[C]]
  override def _7: Counter_7[Counter_9[C]] = new Counter_7(self)
  override type _8 = Counter_8[Counter_9[C]]
  override def _8: Counter_8[Counter_9[C]] = new Counter_8(self)
  override type _9 = Counter_9[Counter_9[C]]
  override def _9: Counter_9[Counter_9[C]] = new Counter_9(self)
}
