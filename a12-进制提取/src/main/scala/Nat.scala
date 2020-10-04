package a10

trait 自然数 {
  type Next[T] <: 自然数
  type 消去标记[T <: 自然数标记] <: 自然数对
  def next[T](t: T): Next[T]
  def 消去标记[T <: 自然数标记](item: T): 消去标记[T]

  type _0 <: 自然数容器
  def _0: _0
  type _1 <: 自然数容器
  def _1: _1
  type _2 <: 自然数容器
  def _2: _2
  type _3 <: 自然数容器
  def _3: _3
  type _4 <: 自然数容器
  def _4: _4
  type _5 <: 自然数容器
  def _5: _5
  type _6 <: 自然数容器
  def _6: _6
  type _7 <: 自然数容器
  def _7: _7
  type _8 <: 自然数容器
  def _8: _8
  type _9 <: 自然数容器
  def _9: _9
}

class 自然数零 extends 自然数 {
  self =>
  override type Next[T]          = 正整数[自然数零, T]
  override type 消去标记[T <: 自然数标记] = 非正整数自然数对[T]
  override def next[T](t: T): 正整数[自然数零, T]            = new 正整数(tail = self, head = t)
  override def 消去标记[T <: 自然数标记](item: T): 非正整数自然数对[T] = new 非正整数自然数对(负数部分 = item, 正数部分 = self)

  override type _0 = 自然数容器I[自然数零, 自然数标记零]
  override def _0: _0 = 自然数容器I(self, 自然数标记零.value)
  override type _1 = 自然数容器I[自然数零, 自然数容器I.Tag_1]
  override def _1: _1 = 自然数容器I(self, 自然数容器I.tag_1)
  override type _2 = 自然数容器I[自然数零, 自然数容器I.Tag_2]
  override def _2: _2 = 自然数容器I(self, 自然数容器I.tag_2)
  override type _3 = 自然数容器I[自然数零, 自然数容器I.Tag_3]
  override def _3: _3 = 自然数容器I(self, 自然数容器I.tag_3)
  override type _4 = 自然数容器I[自然数零, 自然数容器I.Tag_4]
  override def _4: _4 = 自然数容器I(self, 自然数容器I.tag_4)
  override type _5 = 自然数容器I[自然数零, 自然数容器I.Tag_5]
  override def _5: _5 = 自然数容器I(self, 自然数容器I.tag_5)
  override type _6 = 自然数容器I[自然数零, 自然数容器I.Tag_6]
  override def _6: _6 = 自然数容器I(self, 自然数容器I.tag_6)
  override type _7 = 自然数容器I[自然数零, 自然数容器I.Tag_7]
  override def _7: _7 = 自然数容器I(self, 自然数容器I.tag_7)
  override type _8 = 自然数容器I[自然数零, 自然数容器I.Tag_8]
  override def _8: _8 = 自然数容器I(self, 自然数容器I.tag_8)
  override type _9 = 自然数容器I[自然数零, 自然数容器I.Tag_9]
  override def _9: _9 = 自然数容器I(self, 自然数容器I.tag_9)

  override def toString: String = "自然数零"
}

object 自然数零 {
  val value: 自然数零 = new 自然数零
}

class 正整数[Tail <: 自然数, Head](val tail: Tail, val head: Head) extends 自然数 {
  self =>
  override type Next[T]          = 正整数[正整数[Tail, Head], T]
  override type 消去标记[T <: 自然数标记] = T#自然数消去[Tail, Head]
  override def next[T](t: T): 正整数[正整数[Tail, Head], T]         = new 正整数(tail = self, head = t)
  override def 消去标记[T <: 自然数标记](item: T): T#自然数消去[Tail, Head] = item.自然数消去(tail, head)

  override type _0 = 自然数容器I[正整数[Tail, Head], 自然数标记零]
  override def _0: _0 = 自然数容器I(self, 自然数标记零.value)
  override type _1 = 自然数容器I[正整数[Tail, Head], 自然数容器I.Tag_1]
  override def _1: _1 = 自然数容器I(self, 自然数容器I.tag_1)
  override type _2 = 自然数容器I[正整数[Tail, Head], 自然数容器I.Tag_2]
  override def _2: _2 = 自然数容器I(self, 自然数容器I.tag_2)
  override type _3 = 自然数容器I[正整数[Tail, Head], 自然数容器I.Tag_3]
  override def _3: _3 = 自然数容器I(self, 自然数容器I.tag_3)
  override type _4 = 自然数容器I[正整数[Tail, Head], 自然数容器I.Tag_4]
  override def _4: _4 = 自然数容器I(self, 自然数容器I.tag_4)
  override type _5 = 自然数容器I[正整数[Tail, Head], 自然数容器I.Tag_5]
  override def _5: _5 = 自然数容器I(self, 自然数容器I.tag_5)
  override type _6 = 自然数容器I[正整数[Tail, Head], 自然数容器I.Tag_6]
  override def _6: _6 = 自然数容器I(self, 自然数容器I.tag_6)
  override type _7 = 自然数容器I[正整数[Tail, Head], 自然数容器I.Tag_7]
  override def _7: _7 = 自然数容器I(self, 自然数容器I.tag_7)
  override type _8 = 自然数容器I[正整数[Tail, Head], 自然数容器I.Tag_8]
  override def _8: _8 = 自然数容器I(self, 自然数容器I.tag_8)
  override type _9 = 自然数容器I[正整数[Tail, Head], 自然数容器I.Tag_9]
  override def _9: _9 = 自然数容器I(self, 自然数容器I.tag_9)

  override def toString: String = s"$tail :: $head"
}
