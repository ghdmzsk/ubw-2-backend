package erjinzhi

trait Cursor {

  type Reset <: Cursor
  type Next <: Cursor
  type ReplaceChild[C <: Cursor] <: Cursor

}

trait NeedNext {
  type NeedNext[C <: Cursor] <: Cursor
}

trait PlusNode extends NeedNext {
  override type NeedNext[C <: Cursor] <: Cursor
}

trait NotPlus extends NeedNext {
  override type NeedNext[C <: Cursor] <: Cursor
}

trait Leaf_0 extends Cursor {

  override type Reset                     = Leaf_0
  override type Next                      = Leaf_1
  override type ReplaceChild[C <: Cursor] = C

}

trait Leaf_1 extends Cursor {

  override type Reset                     = Leaf_0
  override type Next                      = Leaf_0
  override type ReplaceChild[C <: Cursor] = C

}

trait Node_0[C <: Cursor] extends Cursor {

  override type Reset                         = C
  override type Next                          = Parent#ReplaceChild[Leaf_1]
  override type ReplaceChild[Child <: Cursor] = Leaf_0[P]

}

trait Node_1[C <: Cursor] extends Cursor {

  override type Reset                         = C
  override type Next                          = Parent#ReplaceChild[Leaf_1]
  override type ReplaceChild[Child <: Cursor] = Leaf_0[P]

}

trait Top[C <: Cursor] extends Cursor {

  override type Reset                         = C
  override type Next                          = Parent#ReplaceChild[Leaf_1]
  override type ReplaceChild[Child <: Cursor] = Leaf_0[P]

}
