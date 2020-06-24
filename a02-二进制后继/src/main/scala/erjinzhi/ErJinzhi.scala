package erjinzhi

trait Cursor {
  type Up <: Cursor
  type _0 <: Cursor
  type _1 <: Cursor

  def up: Up
  def _0: _0
  def _1: _1
}

object Cursor {
  val _0: Leaf_0 = new Leaf_0
  val _1: Leaf_1 = new Leaf_1
}

class Leaf_0 extends Cursor {
  self =>
  override type Up = Leaf_1
  override type _0 = Node_0[Leaf_0]
  override type _1 = Node_1[Leaf_0]

  override def up: Leaf_1 = Cursor._1
  override def _0         = new Node_0(self)
  override def _1         = new Node_1(self)
}

class Leaf_1 extends Cursor {
  self =>
  override type Up = Node_0[Leaf_1]
  override type _0 = Node_0[Leaf_1]
  override type _1 = Node_1[Leaf_1]
  override def up: Node_0[Leaf_1] = new Node_0(self)
  override def _0: Node_0[Leaf_1] = new Node_0(self)
  override def _1: Node_1[Leaf_1] = new Node_1(self)
}

class Node_0[C <: Cursor](val c: C) extends Cursor {
  self =>
  override type Up = Node_1[C]
  override type _0 = Node_0[Node_0[C]]
  override type _1 = Node_1[Node_0[C]]
  override def up: Node_1[C]         = new Node_1(c)
  override def _0: Node_0[Node_0[C]] = new Node_0(self)
  override def _1: Node_1[Node_0[C]] = new Node_1(self)
}

class Node_1[C <: Cursor](val c: C) extends Cursor {
  self =>
  override type Up = Node_0[C#Up]
  override type _0 = Node_0[Node_1[C]]
  override type _1 = Node_1[Node_1[C]]
  override def up: Node_0[C#Up]      = new Node_0(c.up)
  override def _0: Node_0[Node_1[C]] = new Node_0(self)
  override def _1: Node_1[Node_1[C]] = new Node_1(self)
}

object II {

  type AA = Leaf_0
  val aa: AA = Cursor._0: Leaf_0

  type BB = Leaf_0#Up
  val bb: BB = Cursor._1: Leaf_1

  type CC = Leaf_0#Up#Up
  val cc: CC = Cursor._1._0: Leaf_1#_0

  type DD = Leaf_0#Up#Up#Up
  val dd: DD = Cursor._1._1: Leaf_1#_1

  type EE = Leaf_0#Up#Up#Up#Up
  val ee: EE = Cursor._1._0._0: Leaf_1#_0#_0

  type FF = Leaf_0#Up#Up#Up#Up#Up
  val ff: FF = Cursor._1._0._1: Leaf_1#_0#_1

  type GG = Leaf_0#Up#Up#Up#Up#Up#Up
  val gg: GG = Cursor._1._1._0: Leaf_1#_1#_0

}
