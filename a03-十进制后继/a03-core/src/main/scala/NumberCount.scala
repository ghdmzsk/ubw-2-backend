package shijinzhi
trait Jinzhi {
  type ItemAdd[J <: JinzhiItem, D] <: JinzhiItem
  type ReverseItem[T <: Jinzhi] <: Jinzhi
  type Reverse <: Jinzhi
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
  override type ItemAdd[J <: JinzhiItem, D] = J
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J = j
  override type ReverseItem[J <: Jinzhi] = J
  override type Reverse                  = Point
  override def reverseItem[T <: Jinzhi](t: T): T = t
  override def reverse: Point                    = self
  override type Up = Leaf_1
  override def up: Leaf_1 = new Leaf_1
  override type _0 = Leaf_0
  override def _0: Leaf_0 = new Leaf_0
  override type _1 = Leaf_1
  override def _1: Leaf_1 = new Leaf_1
  override type _2 = Leaf_2
  override def _2: Leaf_2 = new Leaf_2
  override type _3 = Leaf_3
  override def _3: Leaf_3 = new Leaf_3
  override type _4 = Leaf_4
  override def _4: Leaf_4 = new Leaf_4
  override type _5 = Leaf_5
  override def _5: Leaf_5 = new Leaf_5
  override type _6 = Leaf_6
  override def _6: Leaf_6 = new Leaf_6
  override type _7 = Leaf_7
  override def _7: Leaf_7 = new Leaf_7
  override type _8 = Leaf_8
  override def _8: Leaf_8 = new Leaf_8
  override type _9 = Leaf_9
  override def _9: Leaf_9 = new Leaf_9
}
class Leaf_0 extends Jinzhi {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace0[J#_0#Add[D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace0[J#_0#Add[D]] = j.replace0(j._0.add(d))
  override type ReverseItem[J <: Jinzhi] = Node_0[J]
  override type Reverse                  = Leaf_0
  override def reverseItem[T <: Jinzhi](t: T): Node_0[T] = new Node_0(t)
  override def reverse: Leaf_0                           = self
  override type Up = Leaf_1
  override def up: Leaf_1 = new Leaf_1
  override type _0 = Node_0[Leaf_0]
  override def _0: Node_0[Leaf_0] = new Node_0(self)
  override type _1 = Node_1[Leaf_0]
  override def _1: Node_1[Leaf_0] = new Node_1(self)
  override type _2 = Node_2[Leaf_0]
  override def _2: Node_2[Leaf_0] = new Node_2(self)
  override type _3 = Node_3[Leaf_0]
  override def _3: Node_3[Leaf_0] = new Node_3(self)
  override type _4 = Node_4[Leaf_0]
  override def _4: Node_4[Leaf_0] = new Node_4(self)
  override type _5 = Node_5[Leaf_0]
  override def _5: Node_5[Leaf_0] = new Node_5(self)
  override type _6 = Node_6[Leaf_0]
  override def _6: Node_6[Leaf_0] = new Node_6(self)
  override type _7 = Node_7[Leaf_0]
  override def _7: Node_7[Leaf_0] = new Node_7(self)
  override type _8 = Node_8[Leaf_0]
  override def _8: Node_8[Leaf_0] = new Node_8(self)
  override type _9 = Node_9[Leaf_0]
  override def _9: Node_9[Leaf_0] = new Node_9(self)
}
class Leaf_1 extends Jinzhi {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace1[J#_1#Add[D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace1[J#_1#Add[D]] = j.replace1(j._1.add(d))
  override type ReverseItem[J <: Jinzhi] = Node_1[J]
  override type Reverse                  = Leaf_1
  override def reverseItem[T <: Jinzhi](t: T): Node_1[T] = new Node_1(t)
  override def reverse: Leaf_1                           = self
  override type Up = Leaf_2
  override def up: Leaf_2 = new Leaf_2
  override type _0 = Node_0[Leaf_1]
  override def _0: Node_0[Leaf_1] = new Node_0(self)
  override type _1 = Node_1[Leaf_1]
  override def _1: Node_1[Leaf_1] = new Node_1(self)
  override type _2 = Node_2[Leaf_1]
  override def _2: Node_2[Leaf_1] = new Node_2(self)
  override type _3 = Node_3[Leaf_1]
  override def _3: Node_3[Leaf_1] = new Node_3(self)
  override type _4 = Node_4[Leaf_1]
  override def _4: Node_4[Leaf_1] = new Node_4(self)
  override type _5 = Node_5[Leaf_1]
  override def _5: Node_5[Leaf_1] = new Node_5(self)
  override type _6 = Node_6[Leaf_1]
  override def _6: Node_6[Leaf_1] = new Node_6(self)
  override type _7 = Node_7[Leaf_1]
  override def _7: Node_7[Leaf_1] = new Node_7(self)
  override type _8 = Node_8[Leaf_1]
  override def _8: Node_8[Leaf_1] = new Node_8(self)
  override type _9 = Node_9[Leaf_1]
  override def _9: Node_9[Leaf_1] = new Node_9(self)
}
class Leaf_2 extends Jinzhi {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace2[J#_2#Add[D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace2[J#_2#Add[D]] = j.replace2(j._2.add(d))
  override type ReverseItem[J <: Jinzhi] = Node_2[J]
  override type Reverse                  = Leaf_2
  override def reverseItem[T <: Jinzhi](t: T): Node_2[T] = new Node_2(t)
  override def reverse: Leaf_2                           = self
  override type Up = Leaf_3
  override def up: Leaf_3 = new Leaf_3
  override type _0 = Node_0[Leaf_2]
  override def _0: Node_0[Leaf_2] = new Node_0(self)
  override type _1 = Node_1[Leaf_2]
  override def _1: Node_1[Leaf_2] = new Node_1(self)
  override type _2 = Node_2[Leaf_2]
  override def _2: Node_2[Leaf_2] = new Node_2(self)
  override type _3 = Node_3[Leaf_2]
  override def _3: Node_3[Leaf_2] = new Node_3(self)
  override type _4 = Node_4[Leaf_2]
  override def _4: Node_4[Leaf_2] = new Node_4(self)
  override type _5 = Node_5[Leaf_2]
  override def _5: Node_5[Leaf_2] = new Node_5(self)
  override type _6 = Node_6[Leaf_2]
  override def _6: Node_6[Leaf_2] = new Node_6(self)
  override type _7 = Node_7[Leaf_2]
  override def _7: Node_7[Leaf_2] = new Node_7(self)
  override type _8 = Node_8[Leaf_2]
  override def _8: Node_8[Leaf_2] = new Node_8(self)
  override type _9 = Node_9[Leaf_2]
  override def _9: Node_9[Leaf_2] = new Node_9(self)
}
class Leaf_3 extends Jinzhi {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace3[J#_3#Add[D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace3[J#_3#Add[D]] = j.replace3(j._3.add(d))
  override type ReverseItem[J <: Jinzhi] = Node_3[J]
  override type Reverse                  = Leaf_3
  override def reverseItem[T <: Jinzhi](t: T): Node_3[T] = new Node_3(t)
  override def reverse: Leaf_3                           = self
  override type Up = Leaf_4
  override def up: Leaf_4 = new Leaf_4
  override type _0 = Node_0[Leaf_3]
  override def _0: Node_0[Leaf_3] = new Node_0(self)
  override type _1 = Node_1[Leaf_3]
  override def _1: Node_1[Leaf_3] = new Node_1(self)
  override type _2 = Node_2[Leaf_3]
  override def _2: Node_2[Leaf_3] = new Node_2(self)
  override type _3 = Node_3[Leaf_3]
  override def _3: Node_3[Leaf_3] = new Node_3(self)
  override type _4 = Node_4[Leaf_3]
  override def _4: Node_4[Leaf_3] = new Node_4(self)
  override type _5 = Node_5[Leaf_3]
  override def _5: Node_5[Leaf_3] = new Node_5(self)
  override type _6 = Node_6[Leaf_3]
  override def _6: Node_6[Leaf_3] = new Node_6(self)
  override type _7 = Node_7[Leaf_3]
  override def _7: Node_7[Leaf_3] = new Node_7(self)
  override type _8 = Node_8[Leaf_3]
  override def _8: Node_8[Leaf_3] = new Node_8(self)
  override type _9 = Node_9[Leaf_3]
  override def _9: Node_9[Leaf_3] = new Node_9(self)
}
class Leaf_4 extends Jinzhi {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace4[J#_4#Add[D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace4[J#_4#Add[D]] = j.replace4(j._4.add(d))
  override type ReverseItem[J <: Jinzhi] = Node_4[J]
  override type Reverse                  = Leaf_4
  override def reverseItem[T <: Jinzhi](t: T): Node_4[T] = new Node_4(t)
  override def reverse: Leaf_4                           = self
  override type Up = Leaf_5
  override def up: Leaf_5 = new Leaf_5
  override type _0 = Node_0[Leaf_4]
  override def _0: Node_0[Leaf_4] = new Node_0(self)
  override type _1 = Node_1[Leaf_4]
  override def _1: Node_1[Leaf_4] = new Node_1(self)
  override type _2 = Node_2[Leaf_4]
  override def _2: Node_2[Leaf_4] = new Node_2(self)
  override type _3 = Node_3[Leaf_4]
  override def _3: Node_3[Leaf_4] = new Node_3(self)
  override type _4 = Node_4[Leaf_4]
  override def _4: Node_4[Leaf_4] = new Node_4(self)
  override type _5 = Node_5[Leaf_4]
  override def _5: Node_5[Leaf_4] = new Node_5(self)
  override type _6 = Node_6[Leaf_4]
  override def _6: Node_6[Leaf_4] = new Node_6(self)
  override type _7 = Node_7[Leaf_4]
  override def _7: Node_7[Leaf_4] = new Node_7(self)
  override type _8 = Node_8[Leaf_4]
  override def _8: Node_8[Leaf_4] = new Node_8(self)
  override type _9 = Node_9[Leaf_4]
  override def _9: Node_9[Leaf_4] = new Node_9(self)
}
class Leaf_5 extends Jinzhi {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace5[J#_5#Add[D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace5[J#_5#Add[D]] = j.replace5(j._5.add(d))
  override type ReverseItem[J <: Jinzhi] = Node_5[J]
  override type Reverse                  = Leaf_5
  override def reverseItem[T <: Jinzhi](t: T): Node_5[T] = new Node_5(t)
  override def reverse: Leaf_5                           = self
  override type Up = Leaf_6
  override def up: Leaf_6 = new Leaf_6
  override type _0 = Node_0[Leaf_5]
  override def _0: Node_0[Leaf_5] = new Node_0(self)
  override type _1 = Node_1[Leaf_5]
  override def _1: Node_1[Leaf_5] = new Node_1(self)
  override type _2 = Node_2[Leaf_5]
  override def _2: Node_2[Leaf_5] = new Node_2(self)
  override type _3 = Node_3[Leaf_5]
  override def _3: Node_3[Leaf_5] = new Node_3(self)
  override type _4 = Node_4[Leaf_5]
  override def _4: Node_4[Leaf_5] = new Node_4(self)
  override type _5 = Node_5[Leaf_5]
  override def _5: Node_5[Leaf_5] = new Node_5(self)
  override type _6 = Node_6[Leaf_5]
  override def _6: Node_6[Leaf_5] = new Node_6(self)
  override type _7 = Node_7[Leaf_5]
  override def _7: Node_7[Leaf_5] = new Node_7(self)
  override type _8 = Node_8[Leaf_5]
  override def _8: Node_8[Leaf_5] = new Node_8(self)
  override type _9 = Node_9[Leaf_5]
  override def _9: Node_9[Leaf_5] = new Node_9(self)
}
class Leaf_6 extends Jinzhi {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace6[J#_6#Add[D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace6[J#_6#Add[D]] = j.replace6(j._6.add(d))
  override type ReverseItem[J <: Jinzhi] = Node_6[J]
  override type Reverse                  = Leaf_6
  override def reverseItem[T <: Jinzhi](t: T): Node_6[T] = new Node_6(t)
  override def reverse: Leaf_6                           = self
  override type Up = Leaf_7
  override def up: Leaf_7 = new Leaf_7
  override type _0 = Node_0[Leaf_6]
  override def _0: Node_0[Leaf_6] = new Node_0(self)
  override type _1 = Node_1[Leaf_6]
  override def _1: Node_1[Leaf_6] = new Node_1(self)
  override type _2 = Node_2[Leaf_6]
  override def _2: Node_2[Leaf_6] = new Node_2(self)
  override type _3 = Node_3[Leaf_6]
  override def _3: Node_3[Leaf_6] = new Node_3(self)
  override type _4 = Node_4[Leaf_6]
  override def _4: Node_4[Leaf_6] = new Node_4(self)
  override type _5 = Node_5[Leaf_6]
  override def _5: Node_5[Leaf_6] = new Node_5(self)
  override type _6 = Node_6[Leaf_6]
  override def _6: Node_6[Leaf_6] = new Node_6(self)
  override type _7 = Node_7[Leaf_6]
  override def _7: Node_7[Leaf_6] = new Node_7(self)
  override type _8 = Node_8[Leaf_6]
  override def _8: Node_8[Leaf_6] = new Node_8(self)
  override type _9 = Node_9[Leaf_6]
  override def _9: Node_9[Leaf_6] = new Node_9(self)
}
class Leaf_7 extends Jinzhi {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace7[J#_7#Add[D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace7[J#_7#Add[D]] = j.replace7(j._7.add(d))
  override type ReverseItem[J <: Jinzhi] = Node_7[J]
  override type Reverse                  = Leaf_7
  override def reverseItem[T <: Jinzhi](t: T): Node_7[T] = new Node_7(t)
  override def reverse: Leaf_7                           = self
  override type Up = Leaf_8
  override def up: Leaf_8 = new Leaf_8
  override type _0 = Node_0[Leaf_7]
  override def _0: Node_0[Leaf_7] = new Node_0(self)
  override type _1 = Node_1[Leaf_7]
  override def _1: Node_1[Leaf_7] = new Node_1(self)
  override type _2 = Node_2[Leaf_7]
  override def _2: Node_2[Leaf_7] = new Node_2(self)
  override type _3 = Node_3[Leaf_7]
  override def _3: Node_3[Leaf_7] = new Node_3(self)
  override type _4 = Node_4[Leaf_7]
  override def _4: Node_4[Leaf_7] = new Node_4(self)
  override type _5 = Node_5[Leaf_7]
  override def _5: Node_5[Leaf_7] = new Node_5(self)
  override type _6 = Node_6[Leaf_7]
  override def _6: Node_6[Leaf_7] = new Node_6(self)
  override type _7 = Node_7[Leaf_7]
  override def _7: Node_7[Leaf_7] = new Node_7(self)
  override type _8 = Node_8[Leaf_7]
  override def _8: Node_8[Leaf_7] = new Node_8(self)
  override type _9 = Node_9[Leaf_7]
  override def _9: Node_9[Leaf_7] = new Node_9(self)
}
class Leaf_8 extends Jinzhi {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace8[J#_8#Add[D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace8[J#_8#Add[D]] = j.replace8(j._8.add(d))
  override type ReverseItem[J <: Jinzhi] = Node_8[J]
  override type Reverse                  = Leaf_8
  override def reverseItem[T <: Jinzhi](t: T): Node_8[T] = new Node_8(t)
  override def reverse: Leaf_8                           = self
  override type Up = Leaf_9
  override def up: Leaf_9 = new Leaf_9
  override type _0 = Node_0[Leaf_8]
  override def _0: Node_0[Leaf_8] = new Node_0(self)
  override type _1 = Node_1[Leaf_8]
  override def _1: Node_1[Leaf_8] = new Node_1(self)
  override type _2 = Node_2[Leaf_8]
  override def _2: Node_2[Leaf_8] = new Node_2(self)
  override type _3 = Node_3[Leaf_8]
  override def _3: Node_3[Leaf_8] = new Node_3(self)
  override type _4 = Node_4[Leaf_8]
  override def _4: Node_4[Leaf_8] = new Node_4(self)
  override type _5 = Node_5[Leaf_8]
  override def _5: Node_5[Leaf_8] = new Node_5(self)
  override type _6 = Node_6[Leaf_8]
  override def _6: Node_6[Leaf_8] = new Node_6(self)
  override type _7 = Node_7[Leaf_8]
  override def _7: Node_7[Leaf_8] = new Node_7(self)
  override type _8 = Node_8[Leaf_8]
  override def _8: Node_8[Leaf_8] = new Node_8(self)
  override type _9 = Node_9[Leaf_8]
  override def _9: Node_9[Leaf_8] = new Node_9(self)
}
class Leaf_9 extends Jinzhi {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace9[J#_9#Add[D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace9[J#_9#Add[D]] = j.replace9(j._9.add(d))
  override type ReverseItem[J <: Jinzhi] = Node_9[J]
  override type Reverse                  = Leaf_9
  override def reverseItem[T <: Jinzhi](t: T): Node_9[T] = new Node_9(t)
  override def reverse: Leaf_9                           = self
  override type Up = Node_0[Leaf_1]
  override def up: Node_0[Leaf_1] = new Node_0(new Leaf_1)
  override type _0 = Node_0[Leaf_9]
  override def _0: Node_0[Leaf_9] = new Node_0(self)
  override type _1 = Node_1[Leaf_9]
  override def _1: Node_1[Leaf_9] = new Node_1(self)
  override type _2 = Node_2[Leaf_9]
  override def _2: Node_2[Leaf_9] = new Node_2(self)
  override type _3 = Node_3[Leaf_9]
  override def _3: Node_3[Leaf_9] = new Node_3(self)
  override type _4 = Node_4[Leaf_9]
  override def _4: Node_4[Leaf_9] = new Node_4(self)
  override type _5 = Node_5[Leaf_9]
  override def _5: Node_5[Leaf_9] = new Node_5(self)
  override type _6 = Node_6[Leaf_9]
  override def _6: Node_6[Leaf_9] = new Node_6(self)
  override type _7 = Node_7[Leaf_9]
  override def _7: Node_7[Leaf_9] = new Node_7(self)
  override type _8 = Node_8[Leaf_9]
  override def _8: Node_8[Leaf_9] = new Node_8(self)
  override type _9 = Node_9[Leaf_9]
  override def _9: Node_9[Leaf_9] = new Node_9(self)
}
class Node_0[C <: Jinzhi](val c: C) extends Jinzhi {
  self =>
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace0[C#ItemAdd[J#_0, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace0[C#ItemAdd[J#_0, D]] = j.replace0(c.itemAdd(j._0, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_0]
  override type Reverse                  = ReverseItem[Point]
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
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace1[C#ItemAdd[J#_1, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace1[C#ItemAdd[J#_1, D]] = j.replace1(c.itemAdd(j._1, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_1]
  override type Reverse                  = ReverseItem[Point]
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
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace2[C#ItemAdd[J#_2, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace2[C#ItemAdd[J#_2, D]] = j.replace2(c.itemAdd(j._2, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_2]
  override type Reverse                  = ReverseItem[Point]
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
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace3[C#ItemAdd[J#_3, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace3[C#ItemAdd[J#_3, D]] = j.replace3(c.itemAdd(j._3, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_3]
  override type Reverse                  = ReverseItem[Point]
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
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace4[C#ItemAdd[J#_4, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace4[C#ItemAdd[J#_4, D]] = j.replace4(c.itemAdd(j._4, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_4]
  override type Reverse                  = ReverseItem[Point]
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
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace5[C#ItemAdd[J#_5, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace5[C#ItemAdd[J#_5, D]] = j.replace5(c.itemAdd(j._5, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_5]
  override type Reverse                  = ReverseItem[Point]
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
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace6[C#ItemAdd[J#_6, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace6[C#ItemAdd[J#_6, D]] = j.replace6(c.itemAdd(j._6, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_6]
  override type Reverse                  = ReverseItem[Point]
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
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace7[C#ItemAdd[J#_7, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace7[C#ItemAdd[J#_7, D]] = j.replace7(c.itemAdd(j._7, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_7]
  override type Reverse                  = ReverseItem[Point]
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
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace8[C#ItemAdd[J#_8, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace8[C#ItemAdd[J#_8, D]] = j.replace8(c.itemAdd(j._8, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_8]
  override type Reverse                  = ReverseItem[Point]
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
  override type ItemAdd[J <: JinzhiItem, D] = J#Replace9[C#ItemAdd[J#_9, D]]
  override def itemAdd[J <: JinzhiItem, D](j: J, d: D): J#Replace9[C#ItemAdd[J#_9, D]] = j.replace9(c.itemAdd(j._9, d))
  override type ReverseItem[J <: Jinzhi] = C#ReverseItem[J#_9]
  override type Reverse                  = ReverseItem[Point]
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
