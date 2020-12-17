package a19.step8

trait 三进制后继 {
  type Next[T] <: 三进制后继
  type 加数后上级进位操作[NoNeed <: 三进制后继, Need <: 三进制后继] <: 三进制后继
}

class 上层_1[T1, T2, II1 <: 三进制后继, II2 <: 三进制后继] extends 三进制后继 {
  type _1_th = T1
  type _2_th = T2

  type _1 = II1
  type _2 = II2

  override type Next[T] = II1#加数后上级进位操作[上层_1[T1, T2, II1#Next[T], II2], 上层_2[T1, T2, II1#Next[T], II2]]
}

class 上层_2[T1, T2, II1 <: 三进制后继, II2 <: 三进制后继] extends 三进制后继 {
  type _1_th = T1
  type _2_th = T2

  type _1 = II1
  type _2 = II2

  override type Next[T] = II2#加数后上级进位操作[上层_2[T1, T2, II1, II2#Next[T]], 上层_1[T1, T2, II1, II2#Next[T]]]
}

class S_0[T0] extends 三进制后继 {
  type _0_th = T0

  override type Next[T]                               = S_1[T0, T]
  override type 加数后上级进位操作[II <: 三进制后继, Need <: 三进制后继] = II
}

class S_1[T0, T1] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1

  override type Next[T]                               = S_2[T0, T1, T]
  override type 加数后上级进位操作[II <: 三进制后继, Need <: 三进制后继] = Need
}

class S_2[T0, T1, T2] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  override type Next[T]                               = I_0[T0, T1, T2, S_0[T]]
  override type 加数后上级进位操作[II <: 三进制后继, Need <: 三进制后继] = II
}

class I_0[T0, T1, T2, II0 <: 三进制后继] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0

  override type Next[T]                               = II0#加数后上级进位操作[I_0[T0, T1, T2, II0#Next[T]], I_0_To_1[T0, T1, T2, II0#Next[T]]]
  override type 加数后上级进位操作[II <: 三进制后继, Need <: 三进制后继] = II
}

class I_0_To_1[T0, T1, T2, II0 <: 三进制后继] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0

  override type Next[T]                               = I_1[T0, T1, T2, II0, S_0[T]]
  override type 加数后上级进位操作[II <: 三进制后继, Need <: 三进制后继] = II
}

class I_1[T0, T1, T2, II0 <: 三进制后继, II1 <: 三进制后继] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1

  override type Next[T]                               = II1#加数后上级进位操作[I_1[T0, T1, T2, II0, II1#Next[T]], I_1_To_2[T0, T1, T2, II0, II1#Next[T]]]
  override type 加数后上级进位操作[II <: 三进制后继, Need <: 三进制后继] = II
}

class I_1_To_2[T0, T1, T2, II0 <: 三进制后继, II1 <: 三进制后继] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1

  override type Next[T]                               = I_2_Step_2[T0, T1, T2, II0, II1, S_0[T]]
  override type 加数后上级进位操作[II <: 三进制后继, Need <: 三进制后继] = II
}

class I_2_Step_0[T0, T1, T2, II0 <: 三进制后继, II1 <: 三进制后继, II2 <: 三进制后继] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Next[T]                               = II0#加数后上级进位操作[I_2_Step_0[T0, T1, T2, II0#Next[T], II1, II2], I_2_Step_1[T0, T1, T2, II0#Next[T], II1, II2]]
  override type 加数后上级进位操作[II <: 三进制后继, Need <: 三进制后继] = II
}

class I_2_Step_1[T0, T1, T2, II0 <: 三进制后继, II1 <: 三进制后继, II2 <: 三进制后继] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Next[T]                               = II1#加数后上级进位操作[I_2_Step_1[T0, T1, T2, II0, II1#Next[T], II2], I_2_Step_2[T0, T1, T2, II0, II1#Next[T], II2]]
  override type 加数后上级进位操作[II <: 三进制后继, Need <: 三进制后继] = II
}

class I_2_Step_2[T0, T1, T2, II0 <: 三进制后继, II1 <: 三进制后继, II2 <: 三进制后继] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Next[T]                               = II2#加数后上级进位操作[I_2_Step_2[T0, T1, T2, II0, II1, II2#Next[T]], I_2_Step_0[T0, T1, T2, II0, II1, II2#Next[T]]]
  override type 加数后上级进位操作[II <: 三进制后继, Need <: 三进制后继] = II2#加数后上级进位操作[II, Need]
}
