package shijinzhi
trait JinzhiItem {
  type Add[T] <: JinzhiItem
  def add[T](t: T): Add[T]
  type _0 <: JinzhiItem
  def _0: _0
  type Replace0[T <: JinzhiItem] <: JinzhiItem
  def replace0[T <: JinzhiItem](t: T): Replace0[T]
  type _1 <: JinzhiItem
  def _1: _1
  type Replace1[T <: JinzhiItem] <: JinzhiItem
  def replace1[T <: JinzhiItem](t: T): Replace1[T]
  type _2 <: JinzhiItem
  def _2: _2
  type Replace2[T <: JinzhiItem] <: JinzhiItem
  def replace2[T <: JinzhiItem](t: T): Replace2[T]
  type _3 <: JinzhiItem
  def _3: _3
  type Replace3[T <: JinzhiItem] <: JinzhiItem
  def replace3[T <: JinzhiItem](t: T): Replace3[T]
  type _4 <: JinzhiItem
  def _4: _4
  type Replace4[T <: JinzhiItem] <: JinzhiItem
  def replace4[T <: JinzhiItem](t: T): Replace4[T]
  type _5 <: JinzhiItem
  def _5: _5
  type Replace5[T <: JinzhiItem] <: JinzhiItem
  def replace5[T <: JinzhiItem](t: T): Replace5[T]
  type _6 <: JinzhiItem
  def _6: _6
  type Replace6[T <: JinzhiItem] <: JinzhiItem
  def replace6[T <: JinzhiItem](t: T): Replace6[T]
  type _7 <: JinzhiItem
  def _7: _7
  type Replace7[T <: JinzhiItem] <: JinzhiItem
  def replace7[T <: JinzhiItem](t: T): Replace7[T]
  type _8 <: JinzhiItem
  def _8: _8
  type Replace8[T <: JinzhiItem] <: JinzhiItem
  def replace8[T <: JinzhiItem](t: T): Replace8[T]
  type _9 <: JinzhiItem
  def _9: _9
  type Replace9[T <: JinzhiItem] <: JinzhiItem
  def replace9[T <: JinzhiItem](t: T): Replace9[T]
}
class JinzhiItemImpl[
  Data,
  __0 <: JinzhiItem,
  __1 <: JinzhiItem,
  __2 <: JinzhiItem,
  __3 <: JinzhiItem,
  __4 <: JinzhiItem,
  __5 <: JinzhiItem,
  __6 <: JinzhiItem,
  __7 <: JinzhiItem,
  __8 <: JinzhiItem,
  __9 <: JinzhiItem
](
  val th: Data,
  override val _0: __0,
  override val _1: __1,
  override val _2: __2,
  override val _3: __3,
  override val _4: __4,
  override val _5: __5,
  override val _6: __6,
  override val _7: __7,
  override val _8: __8,
  override val _9: __9
) extends JinzhiItem {
  type TH = Data
  override type Add[T] = JinzhiItemImpl[
    T,
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ]
  def add[T](t: T): JinzhiItemImpl[
    T,
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ] =
    new JinzhiItemImpl(
      t,
      _0 = _0,
      _1 = _1,
      _2 = _2,
      _3 = _3,
      _4 = _4,
      _5 = _5,
      _6 = _6,
      _7 = _7,
      _8 = _8,
      _9 = _9
    )
  override type _0 = __0
  override type Replace0[T <: JinzhiItem] = JinzhiItemImpl[
    Data,
    T,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ]
  override def replace0[T <: JinzhiItem](t: T): JinzhiItemImpl[
    Data,
    T,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ] =
    new JinzhiItemImpl(
      th = th,
      _0 = t,
      _1 = _1,
      _2 = _2,
      _3 = _3,
      _4 = _4,
      _5 = _5,
      _6 = _6,
      _7 = _7,
      _8 = _8,
      _9 = _9
    )
  override type _1 = __1
  override type Replace1[T <: JinzhiItem] = JinzhiItemImpl[
    Data,
    __0,
    T,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ]
  override def replace1[T <: JinzhiItem](t: T): JinzhiItemImpl[
    Data,
    __0,
    T,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ] =
    new JinzhiItemImpl(
      th = th,
      _0 = _0,
      _1 = t,
      _2 = _2,
      _3 = _3,
      _4 = _4,
      _5 = _5,
      _6 = _6,
      _7 = _7,
      _8 = _8,
      _9 = _9
    )
  override type _2 = __2
  override type Replace2[T <: JinzhiItem] = JinzhiItemImpl[
    Data,
    __0,
    __1,
    T,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ]
  override def replace2[T <: JinzhiItem](t: T): JinzhiItemImpl[
    Data,
    __0,
    __1,
    T,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ] =
    new JinzhiItemImpl(
      th = th,
      _0 = _0,
      _1 = _1,
      _2 = t,
      _3 = _3,
      _4 = _4,
      _5 = _5,
      _6 = _6,
      _7 = _7,
      _8 = _8,
      _9 = _9
    )
  override type _3 = __3
  override type Replace3[T <: JinzhiItem] = JinzhiItemImpl[
    Data,
    __0,
    __1,
    __2,
    T,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ]
  override def replace3[T <: JinzhiItem](t: T): JinzhiItemImpl[
    Data,
    __0,
    __1,
    __2,
    T,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ] =
    new JinzhiItemImpl(
      th = th,
      _0 = _0,
      _1 = _1,
      _2 = _2,
      _3 = t,
      _4 = _4,
      _5 = _5,
      _6 = _6,
      _7 = _7,
      _8 = _8,
      _9 = _9
    )
  override type _4 = __4
  override type Replace4[T <: JinzhiItem] = JinzhiItemImpl[
    Data,
    __0,
    __1,
    __2,
    __3,
    T,
    __5,
    __6,
    __7,
    __8,
    __9
  ]
  override def replace4[T <: JinzhiItem](t: T): JinzhiItemImpl[
    Data,
    __0,
    __1,
    __2,
    __3,
    T,
    __5,
    __6,
    __7,
    __8,
    __9
  ] =
    new JinzhiItemImpl(
      th = th,
      _0 = _0,
      _1 = _1,
      _2 = _2,
      _3 = _3,
      _4 = t,
      _5 = _5,
      _6 = _6,
      _7 = _7,
      _8 = _8,
      _9 = _9
    )
  override type _5 = __5
  override type Replace5[T <: JinzhiItem] = JinzhiItemImpl[
    Data,
    __0,
    __1,
    __2,
    __3,
    __4,
    T,
    __6,
    __7,
    __8,
    __9
  ]
  override def replace5[T <: JinzhiItem](t: T): JinzhiItemImpl[
    Data,
    __0,
    __1,
    __2,
    __3,
    __4,
    T,
    __6,
    __7,
    __8,
    __9
  ] =
    new JinzhiItemImpl(
      th = th,
      _0 = _0,
      _1 = _1,
      _2 = _2,
      _3 = _3,
      _4 = _4,
      _5 = t,
      _6 = _6,
      _7 = _7,
      _8 = _8,
      _9 = _9
    )
  override type _6 = __6
  override type Replace6[T <: JinzhiItem] = JinzhiItemImpl[
    Data,
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    T,
    __7,
    __8,
    __9
  ]
  override def replace6[T <: JinzhiItem](t: T): JinzhiItemImpl[
    Data,
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    T,
    __7,
    __8,
    __9
  ] =
    new JinzhiItemImpl(
      th = th,
      _0 = _0,
      _1 = _1,
      _2 = _2,
      _3 = _3,
      _4 = _4,
      _5 = _5,
      _6 = t,
      _7 = _7,
      _8 = _8,
      _9 = _9
    )
  override type _7 = __7
  override type Replace7[T <: JinzhiItem] = JinzhiItemImpl[
    Data,
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    T,
    __8,
    __9
  ]
  override def replace7[T <: JinzhiItem](t: T): JinzhiItemImpl[
    Data,
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    T,
    __8,
    __9
  ] =
    new JinzhiItemImpl(
      th = th,
      _0 = _0,
      _1 = _1,
      _2 = _2,
      _3 = _3,
      _4 = _4,
      _5 = _5,
      _6 = _6,
      _7 = t,
      _8 = _8,
      _9 = _9
    )
  override type _8 = __8
  override type Replace8[T <: JinzhiItem] = JinzhiItemImpl[
    Data,
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    T,
    __9
  ]
  override def replace8[T <: JinzhiItem](t: T): JinzhiItemImpl[
    Data,
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    T,
    __9
  ] =
    new JinzhiItemImpl(
      th = th,
      _0 = _0,
      _1 = _1,
      _2 = _2,
      _3 = _3,
      _4 = _4,
      _5 = _5,
      _6 = _6,
      _7 = _7,
      _8 = t,
      _9 = _9
    )
  override type _9 = __9
  override type Replace9[T <: JinzhiItem] = JinzhiItemImpl[
    Data,
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    T
  ]
  override def replace9[T <: JinzhiItem](t: T): JinzhiItemImpl[
    Data,
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    T
  ] =
    new JinzhiItemImpl(
      th = th,
      _0 = _0,
      _1 = _1,
      _2 = _2,
      _3 = _3,
      _4 = _4,
      _5 = _5,
      _6 = _6,
      _7 = _7,
      _8 = _8,
      _9 = t
    )
}
trait JinzhiWeikaifa[
  __0 <: JinzhiItem,
  __1 <: JinzhiItem,
  __2 <: JinzhiItem,
  __3 <: JinzhiItem,
  __4 <: JinzhiItem,
  __5 <: JinzhiItem,
  __6 <: JinzhiItem,
  __7 <: JinzhiItem,
  __8 <: JinzhiItem,
  __9 <: JinzhiItem
] extends JinzhiItem {
  self =>
  override type Add[T] = JinzhiItemImpl[
    T,
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ]
  def add[T](t: T): JinzhiItemImpl[
    T,
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ] =
    new JinzhiItemImpl(
      th = t,
      _0 = self._0,
      _1 = self._1,
      _2 = self._2,
      _3 = self._3,
      _4 = self._4,
      _5 = self._5,
      _6 = self._6,
      _7 = self._7,
      _8 = self._8,
      _9 = self._9
    )
  override type _0 = __0
  override def _0: __0
  override type Replace0[T <: JinzhiItem] = JinzhiWeikaifa[
    T,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ]
  override def replace0[T <: JinzhiItem](t: T): JinzhiWeikaifa[
    T,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ] =
    new JinzhiWeikaifa[
      T,
      __1,
      __2,
      __3,
      __4,
      __5,
      __6,
      __7,
      __8,
      __9
    ] {
      override def _0: T   = t
      override def _1: __1 = self._1
      override def _2: __2 = self._2
      override def _3: __3 = self._3
      override def _4: __4 = self._4
      override def _5: __5 = self._5
      override def _6: __6 = self._6
      override def _7: __7 = self._7
      override def _8: __8 = self._8
      override def _9: __9 = self._9
    }
  override type _1 = __1
  override def _1: __1
  override type Replace1[T <: JinzhiItem] = JinzhiWeikaifa[
    __0,
    T,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ]
  override def replace1[T <: JinzhiItem](t: T): JinzhiWeikaifa[
    __0,
    T,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ] =
    new JinzhiWeikaifa[
      __0,
      T,
      __2,
      __3,
      __4,
      __5,
      __6,
      __7,
      __8,
      __9
    ] {
      override def _0: __0 = self._0
      override def _1: T   = t
      override def _2: __2 = self._2
      override def _3: __3 = self._3
      override def _4: __4 = self._4
      override def _5: __5 = self._5
      override def _6: __6 = self._6
      override def _7: __7 = self._7
      override def _8: __8 = self._8
      override def _9: __9 = self._9
    }
  override type _2 = __2
  override def _2: __2
  override type Replace2[T <: JinzhiItem] = JinzhiWeikaifa[
    __0,
    __1,
    T,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ]
  override def replace2[T <: JinzhiItem](t: T): JinzhiWeikaifa[
    __0,
    __1,
    T,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ] =
    new JinzhiWeikaifa[
      __0,
      __1,
      T,
      __3,
      __4,
      __5,
      __6,
      __7,
      __8,
      __9
    ] {
      override def _0: __0 = self._0
      override def _1: __1 = self._1
      override def _2: T   = t
      override def _3: __3 = self._3
      override def _4: __4 = self._4
      override def _5: __5 = self._5
      override def _6: __6 = self._6
      override def _7: __7 = self._7
      override def _8: __8 = self._8
      override def _9: __9 = self._9
    }
  override type _3 = __3
  override def _3: __3
  override type Replace3[T <: JinzhiItem] = JinzhiWeikaifa[
    __0,
    __1,
    __2,
    T,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ]
  override def replace3[T <: JinzhiItem](t: T): JinzhiWeikaifa[
    __0,
    __1,
    __2,
    T,
    __4,
    __5,
    __6,
    __7,
    __8,
    __9
  ] =
    new JinzhiWeikaifa[
      __0,
      __1,
      __2,
      T,
      __4,
      __5,
      __6,
      __7,
      __8,
      __9
    ] {
      override def _0: __0 = self._0
      override def _1: __1 = self._1
      override def _2: __2 = self._2
      override def _3: T   = t
      override def _4: __4 = self._4
      override def _5: __5 = self._5
      override def _6: __6 = self._6
      override def _7: __7 = self._7
      override def _8: __8 = self._8
      override def _9: __9 = self._9
    }
  override type _4 = __4
  override def _4: __4
  override type Replace4[T <: JinzhiItem] = JinzhiWeikaifa[
    __0,
    __1,
    __2,
    __3,
    T,
    __5,
    __6,
    __7,
    __8,
    __9
  ]
  override def replace4[T <: JinzhiItem](t: T): JinzhiWeikaifa[
    __0,
    __1,
    __2,
    __3,
    T,
    __5,
    __6,
    __7,
    __8,
    __9
  ] =
    new JinzhiWeikaifa[
      __0,
      __1,
      __2,
      __3,
      T,
      __5,
      __6,
      __7,
      __8,
      __9
    ] {
      override def _0: __0 = self._0
      override def _1: __1 = self._1
      override def _2: __2 = self._2
      override def _3: __3 = self._3
      override def _4: T   = t
      override def _5: __5 = self._5
      override def _6: __6 = self._6
      override def _7: __7 = self._7
      override def _8: __8 = self._8
      override def _9: __9 = self._9
    }
  override type _5 = __5
  override def _5: __5
  override type Replace5[T <: JinzhiItem] = JinzhiWeikaifa[
    __0,
    __1,
    __2,
    __3,
    __4,
    T,
    __6,
    __7,
    __8,
    __9
  ]
  override def replace5[T <: JinzhiItem](t: T): JinzhiWeikaifa[
    __0,
    __1,
    __2,
    __3,
    __4,
    T,
    __6,
    __7,
    __8,
    __9
  ] =
    new JinzhiWeikaifa[
      __0,
      __1,
      __2,
      __3,
      __4,
      T,
      __6,
      __7,
      __8,
      __9
    ] {
      override def _0: __0 = self._0
      override def _1: __1 = self._1
      override def _2: __2 = self._2
      override def _3: __3 = self._3
      override def _4: __4 = self._4
      override def _5: T   = t
      override def _6: __6 = self._6
      override def _7: __7 = self._7
      override def _8: __8 = self._8
      override def _9: __9 = self._9
    }
  override type _6 = __6
  override def _6: __6
  override type Replace6[T <: JinzhiItem] = JinzhiWeikaifa[
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    T,
    __7,
    __8,
    __9
  ]
  override def replace6[T <: JinzhiItem](t: T): JinzhiWeikaifa[
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    T,
    __7,
    __8,
    __9
  ] =
    new JinzhiWeikaifa[
      __0,
      __1,
      __2,
      __3,
      __4,
      __5,
      T,
      __7,
      __8,
      __9
    ] {
      override def _0: __0 = self._0
      override def _1: __1 = self._1
      override def _2: __2 = self._2
      override def _3: __3 = self._3
      override def _4: __4 = self._4
      override def _5: __5 = self._5
      override def _6: T   = t
      override def _7: __7 = self._7
      override def _8: __8 = self._8
      override def _9: __9 = self._9
    }
  override type _7 = __7
  override def _7: __7
  override type Replace7[T <: JinzhiItem] = JinzhiWeikaifa[
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    T,
    __8,
    __9
  ]
  override def replace7[T <: JinzhiItem](t: T): JinzhiWeikaifa[
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    T,
    __8,
    __9
  ] =
    new JinzhiWeikaifa[
      __0,
      __1,
      __2,
      __3,
      __4,
      __5,
      __6,
      T,
      __8,
      __9
    ] {
      override def _0: __0 = self._0
      override def _1: __1 = self._1
      override def _2: __2 = self._2
      override def _3: __3 = self._3
      override def _4: __4 = self._4
      override def _5: __5 = self._5
      override def _6: __6 = self._6
      override def _7: T   = t
      override def _8: __8 = self._8
      override def _9: __9 = self._9
    }
  override type _8 = __8
  override def _8: __8
  override type Replace8[T <: JinzhiItem] = JinzhiWeikaifa[
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    T,
    __9
  ]
  override def replace8[T <: JinzhiItem](t: T): JinzhiWeikaifa[
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    T,
    __9
  ] =
    new JinzhiWeikaifa[
      __0,
      __1,
      __2,
      __3,
      __4,
      __5,
      __6,
      __7,
      T,
      __9
    ] {
      override def _0: __0 = self._0
      override def _1: __1 = self._1
      override def _2: __2 = self._2
      override def _3: __3 = self._3
      override def _4: __4 = self._4
      override def _5: __5 = self._5
      override def _6: __6 = self._6
      override def _7: __7 = self._7
      override def _8: T   = t
      override def _9: __9 = self._9
    }
  override type _9 = __9
  override def _9: __9
  override type Replace9[T <: JinzhiItem] = JinzhiWeikaifa[
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    T
  ]
  override def replace9[T <: JinzhiItem](t: T): JinzhiWeikaifa[
    __0,
    __1,
    __2,
    __3,
    __4,
    __5,
    __6,
    __7,
    __8,
    T
  ] =
    new JinzhiWeikaifa[
      __0,
      __1,
      __2,
      __3,
      __4,
      __5,
      __6,
      __7,
      __8,
      T
    ] {
      override def _0: __0 = self._0
      override def _1: __1 = self._1
      override def _2: __2 = self._2
      override def _3: __3 = self._3
      override def _4: __4 = self._4
      override def _5: __5 = self._5
      override def _6: __6 = self._6
      override def _7: __7 = self._7
      override def _8: __8 = self._8
      override def _9: T   = t
    }
}
class JinzhiZero
    extends JinzhiWeikaifa[
      JinzhiZero,
      JinzhiZero,
      JinzhiZero,
      JinzhiZero,
      JinzhiZero,
      JinzhiZero,
      JinzhiZero,
      JinzhiZero,
      JinzhiZero,
      JinzhiZero
    ] {
  self =>
  override type _0 = JinzhiZero
  override def _0: JinzhiZero = self
  override type _1 = JinzhiZero
  override def _1: JinzhiZero = self
  override type _2 = JinzhiZero
  override def _2: JinzhiZero = self
  override type _3 = JinzhiZero
  override def _3: JinzhiZero = self
  override type _4 = JinzhiZero
  override def _4: JinzhiZero = self
  override type _5 = JinzhiZero
  override def _5: JinzhiZero = self
  override type _6 = JinzhiZero
  override def _6: JinzhiZero = self
  override type _7 = JinzhiZero
  override def _7: JinzhiZero = self
  override type _8 = JinzhiZero
  override def _8: JinzhiZero = self
  override type _9 = JinzhiZero
  override def _9: JinzhiZero = self
}
