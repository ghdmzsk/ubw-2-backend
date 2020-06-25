package shijinzhi
trait Jinzhi {
  type Take[J <: JinzhiItem] <: JinzhiItem
  type ItemAdd[J <: JinzhiItem, D] <: JinzhiItem
  type ReverseItem[T <: Jinzhi] <: Jinzhi
  type Reverse <: Jinzhi
  def take[J <: JinzhiItem](j: J): Take[J]
  def itemAdd[J <: JinzhiItem, D](j: J, d: D): ItemAdd[J, D]
  def reverseItem[T <: Jinzhi](t: T): ReverseItem[T]
  def reverse: Reverse
  type Up <: Jinzhi
  def up: Up
  type _0 <: Jinzhi
  def _0: _0
  type _1 <: Jinzhi
  def _1: _1
  type _2 <: Jinzhi
  def _2: _2
  type _3 <: Jinzhi
  def _3: _3
  type _4 <: Jinzhi
  def _4: _4
  type _5 <: Jinzhi
  def _5: _5
  type _6 <: Jinzhi
  def _6: _6
  type _7 <: Jinzhi
  def _7: _7
  type _8 <: Jinzhi
  def _8: _8
  type _9 <: Jinzhi
  def _9: _9
}
class Point extends Jinzhi {
  self =>
  override type Take[J <: JinzhiItem]       = J
  override type ItemAdd[J <: JinzhiItem, D] = J#Add[D]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Add[D] = j.add(d)
  override type ReverseItem[J <: Jinzhi] = J
  override type Reverse                  = Point
  override def take[J <: JinzhiItem](j: J): J    = j
  override def reverseItem[T <: Jinzhi](t: T): T = t
  override def reverse: Point                    = self
  override type Up = Node_1[Point]
  override def up: Node_1[Point] = new Node_1(self)
  override type _0 = Node_0[Point]
  override def _0: Node_0[Point] = new Node_0(self)
  override type _1 = Node_1[Point]
  override def _1: Node_1[Point] = new Node_1(self)
  override type _2 = Node_2[Point]
  override def _2: Node_2[Point] = new Node_2(self)
  override type _3 = Node_3[Point]
  override def _3: Node_3[Point] = new Node_3(self)
  override type _4 = Node_4[Point]
  override def _4: Node_4[Point] = new Node_4(self)
  override type _5 = Node_5[Point]
  override def _5: Node_5[Point] = new Node_5(self)
  override type _6 = Node_6[Point]
  override def _6: Node_6[Point] = new Node_6(self)
  override type _7 = Node_7[Point]
  override def _7: Node_7[Point] = new Node_7(self)
  override type _8 = Node_8[Point]
  override def _8: Node_8[Point] = new Node_8(self)
  override type _9 = Node_9[Point]
  override def _9: Node_9[Point] = new Node_9(self)
}
object Point {
  val value: Point = new Point
}
class Node_0[C <: Jinzhi](val c: C) extends Jinzhi {
  self =>
  override type Take[J <: JinzhiItem]       = C#Take[J]#_0
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace0[C#ItemAdd[J#_0, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace0[C#ItemAdd[J#_0, D]] = j.replace0(c.itemAdd(j._0, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_0]
  override type Reverse                  = ReverseItem[Point]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_0           = c.take(j)._0
  override def reverseItem[T <: Jinzhi](t: T): C#ReverseItem[T#_0] = c.reverseItem(t._0)
  override def reverse: ReverseItem[Point]                         = reverseItem(new Point)
  override type Up = Node_1[C]
  override def up: Up = new Node_1(c)
  override type _0 = Node_0[Node_0[C]]
  override def _0: Node_0[Node_0[C]] = new Node_0(self)
  override type _1 = Node_1[Node_0[C]]
  override def _1: Node_1[Node_0[C]] = new Node_1(self)
  override type _2 = Node_2[Node_0[C]]
  override def _2: Node_2[Node_0[C]] = new Node_2(self)
  override type _3 = Node_3[Node_0[C]]
  override def _3: Node_3[Node_0[C]] = new Node_3(self)
  override type _4 = Node_4[Node_0[C]]
  override def _4: Node_4[Node_0[C]] = new Node_4(self)
  override type _5 = Node_5[Node_0[C]]
  override def _5: Node_5[Node_0[C]] = new Node_5(self)
  override type _6 = Node_6[Node_0[C]]
  override def _6: Node_6[Node_0[C]] = new Node_6(self)
  override type _7 = Node_7[Node_0[C]]
  override def _7: Node_7[Node_0[C]] = new Node_7(self)
  override type _8 = Node_8[Node_0[C]]
  override def _8: Node_8[Node_0[C]] = new Node_8(self)
  override type _9 = Node_9[Node_0[C]]
  override def _9: Node_9[Node_0[C]] = new Node_9(self)
}
class Node_1[C <: Jinzhi](val c: C) extends Jinzhi {
  self =>
  override type Take[J <: JinzhiItem]       = C#Take[J]#_1
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace1[C#ItemAdd[J#_1, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace1[C#ItemAdd[J#_1, D]] = j.replace1(c.itemAdd(j._1, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_1]
  override type Reverse                  = ReverseItem[Point]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_1           = c.take(j)._1
  override def reverseItem[T <: Jinzhi](t: T): C#ReverseItem[T#_1] = c.reverseItem(t._1)
  override def reverse: ReverseItem[Point]                         = reverseItem(new Point)
  override type Up = Node_2[C]
  override def up: Up = new Node_2(c)
  override type _0 = Node_0[Node_1[C]]
  override def _0: Node_0[Node_1[C]] = new Node_0(self)
  override type _1 = Node_1[Node_1[C]]
  override def _1: Node_1[Node_1[C]] = new Node_1(self)
  override type _2 = Node_2[Node_1[C]]
  override def _2: Node_2[Node_1[C]] = new Node_2(self)
  override type _3 = Node_3[Node_1[C]]
  override def _3: Node_3[Node_1[C]] = new Node_3(self)
  override type _4 = Node_4[Node_1[C]]
  override def _4: Node_4[Node_1[C]] = new Node_4(self)
  override type _5 = Node_5[Node_1[C]]
  override def _5: Node_5[Node_1[C]] = new Node_5(self)
  override type _6 = Node_6[Node_1[C]]
  override def _6: Node_6[Node_1[C]] = new Node_6(self)
  override type _7 = Node_7[Node_1[C]]
  override def _7: Node_7[Node_1[C]] = new Node_7(self)
  override type _8 = Node_8[Node_1[C]]
  override def _8: Node_8[Node_1[C]] = new Node_8(self)
  override type _9 = Node_9[Node_1[C]]
  override def _9: Node_9[Node_1[C]] = new Node_9(self)
}
class Node_2[C <: Jinzhi](val c: C) extends Jinzhi {
  self =>
  override type Take[J <: JinzhiItem]       = C#Take[J]#_2
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace2[C#ItemAdd[J#_2, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace2[C#ItemAdd[J#_2, D]] = j.replace2(c.itemAdd(j._2, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_2]
  override type Reverse                  = ReverseItem[Point]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_2           = c.take(j)._2
  override def reverseItem[T <: Jinzhi](t: T): C#ReverseItem[T#_2] = c.reverseItem(t._2)
  override def reverse: ReverseItem[Point]                         = reverseItem(new Point)
  override type Up = Node_3[C]
  override def up: Up = new Node_3(c)
  override type _0 = Node_0[Node_2[C]]
  override def _0: Node_0[Node_2[C]] = new Node_0(self)
  override type _1 = Node_1[Node_2[C]]
  override def _1: Node_1[Node_2[C]] = new Node_1(self)
  override type _2 = Node_2[Node_2[C]]
  override def _2: Node_2[Node_2[C]] = new Node_2(self)
  override type _3 = Node_3[Node_2[C]]
  override def _3: Node_3[Node_2[C]] = new Node_3(self)
  override type _4 = Node_4[Node_2[C]]
  override def _4: Node_4[Node_2[C]] = new Node_4(self)
  override type _5 = Node_5[Node_2[C]]
  override def _5: Node_5[Node_2[C]] = new Node_5(self)
  override type _6 = Node_6[Node_2[C]]
  override def _6: Node_6[Node_2[C]] = new Node_6(self)
  override type _7 = Node_7[Node_2[C]]
  override def _7: Node_7[Node_2[C]] = new Node_7(self)
  override type _8 = Node_8[Node_2[C]]
  override def _8: Node_8[Node_2[C]] = new Node_8(self)
  override type _9 = Node_9[Node_2[C]]
  override def _9: Node_9[Node_2[C]] = new Node_9(self)
}
class Node_3[C <: Jinzhi](val c: C) extends Jinzhi {
  self =>
  override type Take[J <: JinzhiItem]       = C#Take[J]#_3
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace3[C#ItemAdd[J#_3, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace3[C#ItemAdd[J#_3, D]] = j.replace3(c.itemAdd(j._3, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_3]
  override type Reverse                  = ReverseItem[Point]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_3           = c.take(j)._3
  override def reverseItem[T <: Jinzhi](t: T): C#ReverseItem[T#_3] = c.reverseItem(t._3)
  override def reverse: ReverseItem[Point]                         = reverseItem(new Point)
  override type Up = Node_4[C]
  override def up: Up = new Node_4(c)
  override type _0 = Node_0[Node_3[C]]
  override def _0: Node_0[Node_3[C]] = new Node_0(self)
  override type _1 = Node_1[Node_3[C]]
  override def _1: Node_1[Node_3[C]] = new Node_1(self)
  override type _2 = Node_2[Node_3[C]]
  override def _2: Node_2[Node_3[C]] = new Node_2(self)
  override type _3 = Node_3[Node_3[C]]
  override def _3: Node_3[Node_3[C]] = new Node_3(self)
  override type _4 = Node_4[Node_3[C]]
  override def _4: Node_4[Node_3[C]] = new Node_4(self)
  override type _5 = Node_5[Node_3[C]]
  override def _5: Node_5[Node_3[C]] = new Node_5(self)
  override type _6 = Node_6[Node_3[C]]
  override def _6: Node_6[Node_3[C]] = new Node_6(self)
  override type _7 = Node_7[Node_3[C]]
  override def _7: Node_7[Node_3[C]] = new Node_7(self)
  override type _8 = Node_8[Node_3[C]]
  override def _8: Node_8[Node_3[C]] = new Node_8(self)
  override type _9 = Node_9[Node_3[C]]
  override def _9: Node_9[Node_3[C]] = new Node_9(self)
}
class Node_4[C <: Jinzhi](val c: C) extends Jinzhi {
  self =>
  override type Take[J <: JinzhiItem]       = C#Take[J]#_4
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace4[C#ItemAdd[J#_4, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace4[C#ItemAdd[J#_4, D]] = j.replace4(c.itemAdd(j._4, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_4]
  override type Reverse                  = ReverseItem[Point]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_4           = c.take(j)._4
  override def reverseItem[T <: Jinzhi](t: T): C#ReverseItem[T#_4] = c.reverseItem(t._4)
  override def reverse: ReverseItem[Point]                         = reverseItem(new Point)
  override type Up = Node_5[C]
  override def up: Up = new Node_5(c)
  override type _0 = Node_0[Node_4[C]]
  override def _0: Node_0[Node_4[C]] = new Node_0(self)
  override type _1 = Node_1[Node_4[C]]
  override def _1: Node_1[Node_4[C]] = new Node_1(self)
  override type _2 = Node_2[Node_4[C]]
  override def _2: Node_2[Node_4[C]] = new Node_2(self)
  override type _3 = Node_3[Node_4[C]]
  override def _3: Node_3[Node_4[C]] = new Node_3(self)
  override type _4 = Node_4[Node_4[C]]
  override def _4: Node_4[Node_4[C]] = new Node_4(self)
  override type _5 = Node_5[Node_4[C]]
  override def _5: Node_5[Node_4[C]] = new Node_5(self)
  override type _6 = Node_6[Node_4[C]]
  override def _6: Node_6[Node_4[C]] = new Node_6(self)
  override type _7 = Node_7[Node_4[C]]
  override def _7: Node_7[Node_4[C]] = new Node_7(self)
  override type _8 = Node_8[Node_4[C]]
  override def _8: Node_8[Node_4[C]] = new Node_8(self)
  override type _9 = Node_9[Node_4[C]]
  override def _9: Node_9[Node_4[C]] = new Node_9(self)
}
class Node_5[C <: Jinzhi](val c: C) extends Jinzhi {
  self =>
  override type Take[J <: JinzhiItem]       = C#Take[J]#_5
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace5[C#ItemAdd[J#_5, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace5[C#ItemAdd[J#_5, D]] = j.replace5(c.itemAdd(j._5, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_5]
  override type Reverse                  = ReverseItem[Point]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_5           = c.take(j)._5
  override def reverseItem[T <: Jinzhi](t: T): C#ReverseItem[T#_5] = c.reverseItem(t._5)
  override def reverse: ReverseItem[Point]                         = reverseItem(new Point)
  override type Up = Node_6[C]
  override def up: Up = new Node_6(c)
  override type _0 = Node_0[Node_5[C]]
  override def _0: Node_0[Node_5[C]] = new Node_0(self)
  override type _1 = Node_1[Node_5[C]]
  override def _1: Node_1[Node_5[C]] = new Node_1(self)
  override type _2 = Node_2[Node_5[C]]
  override def _2: Node_2[Node_5[C]] = new Node_2(self)
  override type _3 = Node_3[Node_5[C]]
  override def _3: Node_3[Node_5[C]] = new Node_3(self)
  override type _4 = Node_4[Node_5[C]]
  override def _4: Node_4[Node_5[C]] = new Node_4(self)
  override type _5 = Node_5[Node_5[C]]
  override def _5: Node_5[Node_5[C]] = new Node_5(self)
  override type _6 = Node_6[Node_5[C]]
  override def _6: Node_6[Node_5[C]] = new Node_6(self)
  override type _7 = Node_7[Node_5[C]]
  override def _7: Node_7[Node_5[C]] = new Node_7(self)
  override type _8 = Node_8[Node_5[C]]
  override def _8: Node_8[Node_5[C]] = new Node_8(self)
  override type _9 = Node_9[Node_5[C]]
  override def _9: Node_9[Node_5[C]] = new Node_9(self)
}
class Node_6[C <: Jinzhi](val c: C) extends Jinzhi {
  self =>
  override type Take[J <: JinzhiItem]       = C#Take[J]#_6
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace6[C#ItemAdd[J#_6, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace6[C#ItemAdd[J#_6, D]] = j.replace6(c.itemAdd(j._6, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_6]
  override type Reverse                  = ReverseItem[Point]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_6           = c.take(j)._6
  override def reverseItem[T <: Jinzhi](t: T): C#ReverseItem[T#_6] = c.reverseItem(t._6)
  override def reverse: ReverseItem[Point]                         = reverseItem(new Point)
  override type Up = Node_7[C]
  override def up: Up = new Node_7(c)
  override type _0 = Node_0[Node_6[C]]
  override def _0: Node_0[Node_6[C]] = new Node_0(self)
  override type _1 = Node_1[Node_6[C]]
  override def _1: Node_1[Node_6[C]] = new Node_1(self)
  override type _2 = Node_2[Node_6[C]]
  override def _2: Node_2[Node_6[C]] = new Node_2(self)
  override type _3 = Node_3[Node_6[C]]
  override def _3: Node_3[Node_6[C]] = new Node_3(self)
  override type _4 = Node_4[Node_6[C]]
  override def _4: Node_4[Node_6[C]] = new Node_4(self)
  override type _5 = Node_5[Node_6[C]]
  override def _5: Node_5[Node_6[C]] = new Node_5(self)
  override type _6 = Node_6[Node_6[C]]
  override def _6: Node_6[Node_6[C]] = new Node_6(self)
  override type _7 = Node_7[Node_6[C]]
  override def _7: Node_7[Node_6[C]] = new Node_7(self)
  override type _8 = Node_8[Node_6[C]]
  override def _8: Node_8[Node_6[C]] = new Node_8(self)
  override type _9 = Node_9[Node_6[C]]
  override def _9: Node_9[Node_6[C]] = new Node_9(self)
}
class Node_7[C <: Jinzhi](val c: C) extends Jinzhi {
  self =>
  override type Take[J <: JinzhiItem]       = C#Take[J]#_7
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace7[C#ItemAdd[J#_7, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace7[C#ItemAdd[J#_7, D]] = j.replace7(c.itemAdd(j._7, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_7]
  override type Reverse                  = ReverseItem[Point]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_7           = c.take(j)._7
  override def reverseItem[T <: Jinzhi](t: T): C#ReverseItem[T#_7] = c.reverseItem(t._7)
  override def reverse: ReverseItem[Point]                         = reverseItem(new Point)
  override type Up = Node_8[C]
  override def up: Up = new Node_8(c)
  override type _0 = Node_0[Node_7[C]]
  override def _0: Node_0[Node_7[C]] = new Node_0(self)
  override type _1 = Node_1[Node_7[C]]
  override def _1: Node_1[Node_7[C]] = new Node_1(self)
  override type _2 = Node_2[Node_7[C]]
  override def _2: Node_2[Node_7[C]] = new Node_2(self)
  override type _3 = Node_3[Node_7[C]]
  override def _3: Node_3[Node_7[C]] = new Node_3(self)
  override type _4 = Node_4[Node_7[C]]
  override def _4: Node_4[Node_7[C]] = new Node_4(self)
  override type _5 = Node_5[Node_7[C]]
  override def _5: Node_5[Node_7[C]] = new Node_5(self)
  override type _6 = Node_6[Node_7[C]]
  override def _6: Node_6[Node_7[C]] = new Node_6(self)
  override type _7 = Node_7[Node_7[C]]
  override def _7: Node_7[Node_7[C]] = new Node_7(self)
  override type _8 = Node_8[Node_7[C]]
  override def _8: Node_8[Node_7[C]] = new Node_8(self)
  override type _9 = Node_9[Node_7[C]]
  override def _9: Node_9[Node_7[C]] = new Node_9(self)
}
class Node_8[C <: Jinzhi](val c: C) extends Jinzhi {
  self =>
  override type Take[J <: JinzhiItem]       = C#Take[J]#_8
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace8[C#ItemAdd[J#_8, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace8[C#ItemAdd[J#_8, D]] = j.replace8(c.itemAdd(j._8, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_8]
  override type Reverse                  = ReverseItem[Point]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_8           = c.take(j)._8
  override def reverseItem[T <: Jinzhi](t: T): C#ReverseItem[T#_8] = c.reverseItem(t._8)
  override def reverse: ReverseItem[Point]                         = reverseItem(new Point)
  override type Up = Node_9[C]
  override def up: Up = new Node_9(c)
  override type _0 = Node_0[Node_8[C]]
  override def _0: Node_0[Node_8[C]] = new Node_0(self)
  override type _1 = Node_1[Node_8[C]]
  override def _1: Node_1[Node_8[C]] = new Node_1(self)
  override type _2 = Node_2[Node_8[C]]
  override def _2: Node_2[Node_8[C]] = new Node_2(self)
  override type _3 = Node_3[Node_8[C]]
  override def _3: Node_3[Node_8[C]] = new Node_3(self)
  override type _4 = Node_4[Node_8[C]]
  override def _4: Node_4[Node_8[C]] = new Node_4(self)
  override type _5 = Node_5[Node_8[C]]
  override def _5: Node_5[Node_8[C]] = new Node_5(self)
  override type _6 = Node_6[Node_8[C]]
  override def _6: Node_6[Node_8[C]] = new Node_6(self)
  override type _7 = Node_7[Node_8[C]]
  override def _7: Node_7[Node_8[C]] = new Node_7(self)
  override type _8 = Node_8[Node_8[C]]
  override def _8: Node_8[Node_8[C]] = new Node_8(self)
  override type _9 = Node_9[Node_8[C]]
  override def _9: Node_9[Node_8[C]] = new Node_9(self)
}
class Node_9[C <: Jinzhi](val c: C) extends Jinzhi {
  self =>
  override type Take[J <: JinzhiItem]       = C#Take[J]#_9
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace9[C#ItemAdd[J#_9, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace9[C#ItemAdd[J#_9, D]] = j.replace9(c.itemAdd(j._9, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_9]
  override type Reverse                  = ReverseItem[Point]
  override def take[J <: JinzhiItem](j: J): C#Take[J]#_9           = c.take(j)._9
  override def reverseItem[T <: Jinzhi](t: T): C#ReverseItem[T#_9] = c.reverseItem(t._9)
  override def reverse: ReverseItem[Point]                         = reverseItem(new Point)
  override type Up = Node_0[C#Up]
  override def up: Up = new Node_0(c.up)
  override type _0 = Node_0[Node_9[C]]
  override def _0: Node_0[Node_9[C]] = new Node_0(self)
  override type _1 = Node_1[Node_9[C]]
  override def _1: Node_1[Node_9[C]] = new Node_1(self)
  override type _2 = Node_2[Node_9[C]]
  override def _2: Node_2[Node_9[C]] = new Node_2(self)
  override type _3 = Node_3[Node_9[C]]
  override def _3: Node_3[Node_9[C]] = new Node_3(self)
  override type _4 = Node_4[Node_9[C]]
  override def _4: Node_4[Node_9[C]] = new Node_4(self)
  override type _5 = Node_5[Node_9[C]]
  override def _5: Node_5[Node_9[C]] = new Node_5(self)
  override type _6 = Node_6[Node_9[C]]
  override def _6: Node_6[Node_9[C]] = new Node_6(self)
  override type _7 = Node_7[Node_9[C]]
  override def _7: Node_7[Node_9[C]] = new Node_7(self)
  override type _8 = Node_8[Node_9[C]]
  override def _8: Node_8[Node_9[C]] = new Node_8(self)
  override type _9 = Node_9[Node_9[C]]
  override def _9: Node_9[Node_9[C]] = new Node_9(self)
}
