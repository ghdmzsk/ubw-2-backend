package a19.step8

trait 三进制后继 {
  type Next[T] <: 三进制后继
  type Pred <: 三进制后继
  type 后继上一级操作[NoNeed <: 三进制后继, Need <: 三进制后继] <: 三进制后继
  type 前驱上一级操作[不退位 <: 三进制后继, 退位 <: 三进制后继] <: 三进制后继
}

class 上层_1[T1, T2, II1 <: 三进制后继, II2 <: 三进制后继] extends 三进制后继 {
  type _1_th = T1
  type _2_th = T2

  type _1 = II1
  type _2 = II2

  override type Next[T] = II1#后继上一级操作[上层_1[T1, T2, II1#Next[T], II2], 上层_2[T1, T2, II1#Next[T], II2]]
  override type Pred    = II1#前驱上一级操作[上层_1[T1, T2, II1#Pred, II2], 上层_2[T1, T2, II1#Pred, II2]]
}

class 上层_2[T1, T2, II1 <: 三进制后继, II2 <: 三进制后继] extends 三进制后继 {
  type _1_th = T1
  type _2_th = T2

  type _1 = II1
  type _2 = II2

  override type Next[T] = II2#后继上一级操作[上层_2[T1, T2, II1, II2#Next[T]], 上层_1[T1, T2, II1, II2#Next[T]]]
  override type Pred    = II2#后继上一级操作[上层_2[T1, T2, II1, II2#Pred], 上层_1[T1, T2, II1, II2#Pred]]
}

class 底层_0[T0] extends 三进制后继 {
  type _0_th = T0

  override type Next[T]                             = 底层_1[T0, T]
  override type 后继上一级操作[II <: 三进制后继, Need <: 三进制后继] = II
}

class 底层_1[T0, T1] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1

  override type Next[T]                             = 底层_2[T0, T1, T]
  override type 后继上一级操作[II <: 三进制后继, Need <: 三进制后继] = Need
  override type Pred                                = 底层_0[T0]
  override type 前驱上一级操作[不退位 <: 三进制后继, 退位 <: 三进制后继]  = 退位
}

class 底层_2[T0, T1, T2] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  override type Next[T]                             = 中层_0[T0, T1, T2, 底层_0[T]]
  override type 后继上一级操作[II <: 三进制后继, Need <: 三进制后继] = II
  override type Pred                                = 底层_1[T0, T1]
  override type 前驱上一级操作[不退位 <: 三进制后继, 退位 <: 三进制后继]  = 不退位
}

class 中层_0[T0, T1, T2, II0 <: 三进制后继] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0

  override type Next[T]                             = II0#后继上一级操作[中层_0[T0, T1, T2, II0#Next[T]], 中层准备进位_0[T0, T1, T2, II0#Next[T]]]
  override type 后继上一级操作[II <: 三进制后继, Need <: 三进制后继] = II
}

class 中层准备进位_0[T0, T1, T2, II0 <: 三进制后继] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0

  override type Next[T]                             = 中层_1[T0, T1, T2, II0, 底层_0[T]]
  override type 后继上一级操作[II <: 三进制后继, Need <: 三进制后继] = II
}

class 中层_1[T0, T1, T2, II0 <: 三进制后继, II1 <: 三进制后继] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1

  override type Next[T]                             = II1#后继上一级操作[中层_1[T0, T1, T2, II0, II1#Next[T]], 中层准备进位_1[T0, T1, T2, II0, II1#Next[T]]]
  override type 后继上一级操作[II <: 三进制后继, Need <: 三进制后继] = II
}

class 中层准备进位_1[T0, T1, T2, II0 <: 三进制后继, II1 <: 三进制后继] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1

  override type Next[T]                             = 中层满位_2[T0, T1, T2, II0, II1, 底层_0[T]]
  override type 后继上一级操作[II <: 三进制后继, Need <: 三进制后继] = II
}

class 中层满位_0[T0, T1, T2, II0 <: 三进制后继, II1 <: 三进制后继, II2 <: 三进制后继] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Next[T]                             = II0#后继上一级操作[中层满位_0[T0, T1, T2, II0#Next[T], II1, II2], 中层满位_1[T0, T1, T2, II0#Next[T], II1, II2]]
  override type 后继上一级操作[II <: 三进制后继, Need <: 三进制后继] = II
}

class 中层满位_1[T0, T1, T2, II0 <: 三进制后继, II1 <: 三进制后继, II2 <: 三进制后继] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Next[T]                             = II1#后继上一级操作[中层满位_1[T0, T1, T2, II0, II1#Next[T], II2], 中层满位_2[T0, T1, T2, II0, II1#Next[T], II2]]
  override type 后继上一级操作[II <: 三进制后继, Need <: 三进制后继] = II
}

class 中层满位_2[T0, T1, T2, II0 <: 三进制后继, II1 <: 三进制后继, II2 <: 三进制后继] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Next[T]                             = II2#后继上一级操作[中层满位_2[T0, T1, T2, II0, II1, II2#Next[T]], 中层满位_0[T0, T1, T2, II0, II1, II2#Next[T]]]
  override type 后继上一级操作[II <: 三进制后继, Need <: 三进制后继] = II2#后继上一级操作[II, Need]
}
