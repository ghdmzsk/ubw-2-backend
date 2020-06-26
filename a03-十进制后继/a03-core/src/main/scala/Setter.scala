package shijinzhi
trait Setter {
  type ItemAdd[J <: JinzhiItem, D] <: JinzhiItem
  def itemAdd[J <: JinzhiItem, D](j: J, d: D): ItemAdd[J, D]
  type _0 <: Setter
  def _0: _0
  type _1 <: Setter
  def _1: _1
  type _2 <: Setter
  def _2: _2
  type _3 <: Setter
  def _3: _3
  type _4 <: Setter
  def _4: _4
  type _5 <: Setter
  def _5: _5
  type _6 <: Setter
  def _6: _6
  type _7 <: Setter
  def _7: _7
  type _8 <: Setter
  def _8: _8
  type _9 <: Setter
  def _9: _9
}
class SetterPoint extends Setter {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Add[D]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Add[D] = j.add(d)
  override type _0 = Setter_0[SetterPoint]
  override def _0: Setter_0[SetterPoint] = new Setter_0(self)
  override type _1 = Setter_1[SetterPoint]
  override def _1: Setter_1[SetterPoint] = new Setter_1(self)
  override type _2 = Setter_2[SetterPoint]
  override def _2: Setter_2[SetterPoint] = new Setter_2(self)
  override type _3 = Setter_3[SetterPoint]
  override def _3: Setter_3[SetterPoint] = new Setter_3(self)
  override type _4 = Setter_4[SetterPoint]
  override def _4: Setter_4[SetterPoint] = new Setter_4(self)
  override type _5 = Setter_5[SetterPoint]
  override def _5: Setter_5[SetterPoint] = new Setter_5(self)
  override type _6 = Setter_6[SetterPoint]
  override def _6: Setter_6[SetterPoint] = new Setter_6(self)
  override type _7 = Setter_7[SetterPoint]
  override def _7: Setter_7[SetterPoint] = new Setter_7(self)
  override type _8 = Setter_8[SetterPoint]
  override def _8: Setter_8[SetterPoint] = new Setter_8(self)
  override type _9 = Setter_9[SetterPoint]
  override def _9: Setter_9[SetterPoint] = new Setter_9(self)
}
object SetterPoint {
  val value: SetterPoint = new SetterPoint
}
class Setter_0[C <: Setter](val c: C) extends Setter {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace0[C#ItemAdd[J#_0, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace0[C#ItemAdd[J#_0, D]] = j.replace0(c.itemAdd(j._0, d))
  override type _0 = Setter_0[Setter_0[C]]
  override def _0: Setter_0[Setter_0[C]] = new Setter_0(self)
  override type _1 = Setter_1[Setter_0[C]]
  override def _1: Setter_1[Setter_0[C]] = new Setter_1(self)
  override type _2 = Setter_2[Setter_0[C]]
  override def _2: Setter_2[Setter_0[C]] = new Setter_2(self)
  override type _3 = Setter_3[Setter_0[C]]
  override def _3: Setter_3[Setter_0[C]] = new Setter_3(self)
  override type _4 = Setter_4[Setter_0[C]]
  override def _4: Setter_4[Setter_0[C]] = new Setter_4(self)
  override type _5 = Setter_5[Setter_0[C]]
  override def _5: Setter_5[Setter_0[C]] = new Setter_5(self)
  override type _6 = Setter_6[Setter_0[C]]
  override def _6: Setter_6[Setter_0[C]] = new Setter_6(self)
  override type _7 = Setter_7[Setter_0[C]]
  override def _7: Setter_7[Setter_0[C]] = new Setter_7(self)
  override type _8 = Setter_8[Setter_0[C]]
  override def _8: Setter_8[Setter_0[C]] = new Setter_8(self)
  override type _9 = Setter_9[Setter_0[C]]
  override def _9: Setter_9[Setter_0[C]] = new Setter_9(self)
}
class Setter_1[C <: Setter](val c: C) extends Setter {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace1[C#ItemAdd[J#_1, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace1[C#ItemAdd[J#_1, D]] = j.replace1(c.itemAdd(j._1, d))
  override type _0 = Setter_0[Setter_1[C]]
  override def _0: Setter_0[Setter_1[C]] = new Setter_0(self)
  override type _1 = Setter_1[Setter_1[C]]
  override def _1: Setter_1[Setter_1[C]] = new Setter_1(self)
  override type _2 = Setter_2[Setter_1[C]]
  override def _2: Setter_2[Setter_1[C]] = new Setter_2(self)
  override type _3 = Setter_3[Setter_1[C]]
  override def _3: Setter_3[Setter_1[C]] = new Setter_3(self)
  override type _4 = Setter_4[Setter_1[C]]
  override def _4: Setter_4[Setter_1[C]] = new Setter_4(self)
  override type _5 = Setter_5[Setter_1[C]]
  override def _5: Setter_5[Setter_1[C]] = new Setter_5(self)
  override type _6 = Setter_6[Setter_1[C]]
  override def _6: Setter_6[Setter_1[C]] = new Setter_6(self)
  override type _7 = Setter_7[Setter_1[C]]
  override def _7: Setter_7[Setter_1[C]] = new Setter_7(self)
  override type _8 = Setter_8[Setter_1[C]]
  override def _8: Setter_8[Setter_1[C]] = new Setter_8(self)
  override type _9 = Setter_9[Setter_1[C]]
  override def _9: Setter_9[Setter_1[C]] = new Setter_9(self)
}
class Setter_2[C <: Setter](val c: C) extends Setter {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace2[C#ItemAdd[J#_2, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace2[C#ItemAdd[J#_2, D]] = j.replace2(c.itemAdd(j._2, d))
  override type _0 = Setter_0[Setter_2[C]]
  override def _0: Setter_0[Setter_2[C]] = new Setter_0(self)
  override type _1 = Setter_1[Setter_2[C]]
  override def _1: Setter_1[Setter_2[C]] = new Setter_1(self)
  override type _2 = Setter_2[Setter_2[C]]
  override def _2: Setter_2[Setter_2[C]] = new Setter_2(self)
  override type _3 = Setter_3[Setter_2[C]]
  override def _3: Setter_3[Setter_2[C]] = new Setter_3(self)
  override type _4 = Setter_4[Setter_2[C]]
  override def _4: Setter_4[Setter_2[C]] = new Setter_4(self)
  override type _5 = Setter_5[Setter_2[C]]
  override def _5: Setter_5[Setter_2[C]] = new Setter_5(self)
  override type _6 = Setter_6[Setter_2[C]]
  override def _6: Setter_6[Setter_2[C]] = new Setter_6(self)
  override type _7 = Setter_7[Setter_2[C]]
  override def _7: Setter_7[Setter_2[C]] = new Setter_7(self)
  override type _8 = Setter_8[Setter_2[C]]
  override def _8: Setter_8[Setter_2[C]] = new Setter_8(self)
  override type _9 = Setter_9[Setter_2[C]]
  override def _9: Setter_9[Setter_2[C]] = new Setter_9(self)
}
class Setter_3[C <: Setter](val c: C) extends Setter {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace3[C#ItemAdd[J#_3, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace3[C#ItemAdd[J#_3, D]] = j.replace3(c.itemAdd(j._3, d))
  override type _0 = Setter_0[Setter_3[C]]
  override def _0: Setter_0[Setter_3[C]] = new Setter_0(self)
  override type _1 = Setter_1[Setter_3[C]]
  override def _1: Setter_1[Setter_3[C]] = new Setter_1(self)
  override type _2 = Setter_2[Setter_3[C]]
  override def _2: Setter_2[Setter_3[C]] = new Setter_2(self)
  override type _3 = Setter_3[Setter_3[C]]
  override def _3: Setter_3[Setter_3[C]] = new Setter_3(self)
  override type _4 = Setter_4[Setter_3[C]]
  override def _4: Setter_4[Setter_3[C]] = new Setter_4(self)
  override type _5 = Setter_5[Setter_3[C]]
  override def _5: Setter_5[Setter_3[C]] = new Setter_5(self)
  override type _6 = Setter_6[Setter_3[C]]
  override def _6: Setter_6[Setter_3[C]] = new Setter_6(self)
  override type _7 = Setter_7[Setter_3[C]]
  override def _7: Setter_7[Setter_3[C]] = new Setter_7(self)
  override type _8 = Setter_8[Setter_3[C]]
  override def _8: Setter_8[Setter_3[C]] = new Setter_8(self)
  override type _9 = Setter_9[Setter_3[C]]
  override def _9: Setter_9[Setter_3[C]] = new Setter_9(self)
}
class Setter_4[C <: Setter](val c: C) extends Setter {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace4[C#ItemAdd[J#_4, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace4[C#ItemAdd[J#_4, D]] = j.replace4(c.itemAdd(j._4, d))
  override type _0 = Setter_0[Setter_4[C]]
  override def _0: Setter_0[Setter_4[C]] = new Setter_0(self)
  override type _1 = Setter_1[Setter_4[C]]
  override def _1: Setter_1[Setter_4[C]] = new Setter_1(self)
  override type _2 = Setter_2[Setter_4[C]]
  override def _2: Setter_2[Setter_4[C]] = new Setter_2(self)
  override type _3 = Setter_3[Setter_4[C]]
  override def _3: Setter_3[Setter_4[C]] = new Setter_3(self)
  override type _4 = Setter_4[Setter_4[C]]
  override def _4: Setter_4[Setter_4[C]] = new Setter_4(self)
  override type _5 = Setter_5[Setter_4[C]]
  override def _5: Setter_5[Setter_4[C]] = new Setter_5(self)
  override type _6 = Setter_6[Setter_4[C]]
  override def _6: Setter_6[Setter_4[C]] = new Setter_6(self)
  override type _7 = Setter_7[Setter_4[C]]
  override def _7: Setter_7[Setter_4[C]] = new Setter_7(self)
  override type _8 = Setter_8[Setter_4[C]]
  override def _8: Setter_8[Setter_4[C]] = new Setter_8(self)
  override type _9 = Setter_9[Setter_4[C]]
  override def _9: Setter_9[Setter_4[C]] = new Setter_9(self)
}
class Setter_5[C <: Setter](val c: C) extends Setter {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace5[C#ItemAdd[J#_5, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace5[C#ItemAdd[J#_5, D]] = j.replace5(c.itemAdd(j._5, d))
  override type _0 = Setter_0[Setter_5[C]]
  override def _0: Setter_0[Setter_5[C]] = new Setter_0(self)
  override type _1 = Setter_1[Setter_5[C]]
  override def _1: Setter_1[Setter_5[C]] = new Setter_1(self)
  override type _2 = Setter_2[Setter_5[C]]
  override def _2: Setter_2[Setter_5[C]] = new Setter_2(self)
  override type _3 = Setter_3[Setter_5[C]]
  override def _3: Setter_3[Setter_5[C]] = new Setter_3(self)
  override type _4 = Setter_4[Setter_5[C]]
  override def _4: Setter_4[Setter_5[C]] = new Setter_4(self)
  override type _5 = Setter_5[Setter_5[C]]
  override def _5: Setter_5[Setter_5[C]] = new Setter_5(self)
  override type _6 = Setter_6[Setter_5[C]]
  override def _6: Setter_6[Setter_5[C]] = new Setter_6(self)
  override type _7 = Setter_7[Setter_5[C]]
  override def _7: Setter_7[Setter_5[C]] = new Setter_7(self)
  override type _8 = Setter_8[Setter_5[C]]
  override def _8: Setter_8[Setter_5[C]] = new Setter_8(self)
  override type _9 = Setter_9[Setter_5[C]]
  override def _9: Setter_9[Setter_5[C]] = new Setter_9(self)
}
class Setter_6[C <: Setter](val c: C) extends Setter {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace6[C#ItemAdd[J#_6, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace6[C#ItemAdd[J#_6, D]] = j.replace6(c.itemAdd(j._6, d))
  override type _0 = Setter_0[Setter_6[C]]
  override def _0: Setter_0[Setter_6[C]] = new Setter_0(self)
  override type _1 = Setter_1[Setter_6[C]]
  override def _1: Setter_1[Setter_6[C]] = new Setter_1(self)
  override type _2 = Setter_2[Setter_6[C]]
  override def _2: Setter_2[Setter_6[C]] = new Setter_2(self)
  override type _3 = Setter_3[Setter_6[C]]
  override def _3: Setter_3[Setter_6[C]] = new Setter_3(self)
  override type _4 = Setter_4[Setter_6[C]]
  override def _4: Setter_4[Setter_6[C]] = new Setter_4(self)
  override type _5 = Setter_5[Setter_6[C]]
  override def _5: Setter_5[Setter_6[C]] = new Setter_5(self)
  override type _6 = Setter_6[Setter_6[C]]
  override def _6: Setter_6[Setter_6[C]] = new Setter_6(self)
  override type _7 = Setter_7[Setter_6[C]]
  override def _7: Setter_7[Setter_6[C]] = new Setter_7(self)
  override type _8 = Setter_8[Setter_6[C]]
  override def _8: Setter_8[Setter_6[C]] = new Setter_8(self)
  override type _9 = Setter_9[Setter_6[C]]
  override def _9: Setter_9[Setter_6[C]] = new Setter_9(self)
}
class Setter_7[C <: Setter](val c: C) extends Setter {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace7[C#ItemAdd[J#_7, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace7[C#ItemAdd[J#_7, D]] = j.replace7(c.itemAdd(j._7, d))
  override type _0 = Setter_0[Setter_7[C]]
  override def _0: Setter_0[Setter_7[C]] = new Setter_0(self)
  override type _1 = Setter_1[Setter_7[C]]
  override def _1: Setter_1[Setter_7[C]] = new Setter_1(self)
  override type _2 = Setter_2[Setter_7[C]]
  override def _2: Setter_2[Setter_7[C]] = new Setter_2(self)
  override type _3 = Setter_3[Setter_7[C]]
  override def _3: Setter_3[Setter_7[C]] = new Setter_3(self)
  override type _4 = Setter_4[Setter_7[C]]
  override def _4: Setter_4[Setter_7[C]] = new Setter_4(self)
  override type _5 = Setter_5[Setter_7[C]]
  override def _5: Setter_5[Setter_7[C]] = new Setter_5(self)
  override type _6 = Setter_6[Setter_7[C]]
  override def _6: Setter_6[Setter_7[C]] = new Setter_6(self)
  override type _7 = Setter_7[Setter_7[C]]
  override def _7: Setter_7[Setter_7[C]] = new Setter_7(self)
  override type _8 = Setter_8[Setter_7[C]]
  override def _8: Setter_8[Setter_7[C]] = new Setter_8(self)
  override type _9 = Setter_9[Setter_7[C]]
  override def _9: Setter_9[Setter_7[C]] = new Setter_9(self)
}
class Setter_8[C <: Setter](val c: C) extends Setter {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace8[C#ItemAdd[J#_8, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace8[C#ItemAdd[J#_8, D]] = j.replace8(c.itemAdd(j._8, d))
  override type _0 = Setter_0[Setter_8[C]]
  override def _0: Setter_0[Setter_8[C]] = new Setter_0(self)
  override type _1 = Setter_1[Setter_8[C]]
  override def _1: Setter_1[Setter_8[C]] = new Setter_1(self)
  override type _2 = Setter_2[Setter_8[C]]
  override def _2: Setter_2[Setter_8[C]] = new Setter_2(self)
  override type _3 = Setter_3[Setter_8[C]]
  override def _3: Setter_3[Setter_8[C]] = new Setter_3(self)
  override type _4 = Setter_4[Setter_8[C]]
  override def _4: Setter_4[Setter_8[C]] = new Setter_4(self)
  override type _5 = Setter_5[Setter_8[C]]
  override def _5: Setter_5[Setter_8[C]] = new Setter_5(self)
  override type _6 = Setter_6[Setter_8[C]]
  override def _6: Setter_6[Setter_8[C]] = new Setter_6(self)
  override type _7 = Setter_7[Setter_8[C]]
  override def _7: Setter_7[Setter_8[C]] = new Setter_7(self)
  override type _8 = Setter_8[Setter_8[C]]
  override def _8: Setter_8[Setter_8[C]] = new Setter_8(self)
  override type _9 = Setter_9[Setter_8[C]]
  override def _9: Setter_9[Setter_8[C]] = new Setter_9(self)
}
class Setter_9[C <: Setter](val c: C) extends Setter {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace9[C#ItemAdd[J#_9, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace9[C#ItemAdd[J#_9, D]] = j.replace9(c.itemAdd(j._9, d))
  override type _0 = Setter_0[Setter_9[C]]
  override def _0: Setter_0[Setter_9[C]] = new Setter_0(self)
  override type _1 = Setter_1[Setter_9[C]]
  override def _1: Setter_1[Setter_9[C]] = new Setter_1(self)
  override type _2 = Setter_2[Setter_9[C]]
  override def _2: Setter_2[Setter_9[C]] = new Setter_2(self)
  override type _3 = Setter_3[Setter_9[C]]
  override def _3: Setter_3[Setter_9[C]] = new Setter_3(self)
  override type _4 = Setter_4[Setter_9[C]]
  override def _4: Setter_4[Setter_9[C]] = new Setter_4(self)
  override type _5 = Setter_5[Setter_9[C]]
  override def _5: Setter_5[Setter_9[C]] = new Setter_5(self)
  override type _6 = Setter_6[Setter_9[C]]
  override def _6: Setter_6[Setter_9[C]] = new Setter_6(self)
  override type _7 = Setter_7[Setter_9[C]]
  override def _7: Setter_7[Setter_9[C]] = new Setter_7(self)
  override type _8 = Setter_8[Setter_9[C]]
  override def _8: Setter_8[Setter_9[C]] = new Setter_8(self)
  override type _9 = Setter_9[Setter_9[C]]
  override def _9: Setter_9[Setter_9[C]] = new Setter_9(self)
}
