package a19.step3

trait 自然数 {
  type Next[T] <: 自然数
  type 作进位准备 <: 自然数
  type 加数后上级进位操作[II <: 自然数] <: 自然数
  type 开辟加数空间 <: 自然数
}

class P_3_Step_0[T1, T2, II0 <: 自然数, II1 <: 自然数, II2 <: 自然数] extends 自然数 {
  type _1_th = T1
  type _2_th = T2

  type _1 = II0
  type _2 = II1
  type _3 = II2

  override type Next[T] = II0#加数后上级进位操作[P_3_Step_0[T1, T2, II0#Next[T], II1, II2]]
  override type 作进位准备   = P_3_Step_1[T1, T2, II0, II1, II2]
}

class P_3_Step_1[T1, T2, II0 <: 自然数, II1 <: 自然数, II2 <: 自然数] extends 自然数 {
  type _1_th = T1
  type _2_th = T2

  type _1 = II0
  type _2 = II1
  type _3 = II2

  override type Next[T] = II1#加数后上级进位操作[P_3_Step_1[T1, T2, II0, II1#Next[T], II2]]
  override type 作进位准备   = P_3_Step_2[T1, T2, II0, II1, II2]
}

class P_3_Step_2[T1, T2, II0 <: 自然数, II1 <: 自然数, II2 <: 自然数] extends 自然数 {
  type _1_th = T1
  type _2_th = T2

  type _1 = II0
  type _2 = II1
  type _3 = II2

  override type Next[T] = II2#加数后上级进位操作[P_3_Step_2[T1, T2, II0, II1, II2#Next[T]]]
  override type 作进位准备   = P_3_Step_0[T1, T2, II0, II1, II2]
  override type 开辟加数空间  = P_3_Step_0[T1, T2, II0#开辟加数空间, II1, II2]
}

class S_0[T0] extends 自然数 {
  type _0_th = T0

  override type Next[T]              = S_1[T0, T]
  override type 加数后上级进位操作[II <: 自然数] = II
}

class S_1[T0, T1] extends 自然数 {
  type _0_th = T0
  type _1_th = T1

  override type Next[T]              = S_2[T0, T1, T]
  override type 加数后上级进位操作[II <: 自然数] = II#作进位准备
}

class S_2[T0, T1, T2] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  override type 开辟加数空间 = I_S_To_0[T0, T1, T2]
}

class I_S_To_0[T0, T1, T2] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  override type Next[T]              = I_0[T0, T1, T2, S_0[T]]
  override type 加数后上级进位操作[II <: 自然数] = II
}

class I_0[T0, T1, T2, II0 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0

  override type Next[T]              = II0#加数后上级进位操作[I_0[T0, T1, T2, II0#Next[T]]]
  override type 作进位准备                = I_0_To_1[T0, T1, T2, II0]
  override type 加数后上级进位操作[II <: 自然数] = II
}

class I_0_To_1[T0, T1, T2, II0 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0

  override type Next[T]              = I_1[T0, T1, T2, II0, S_0[T]]
  override type 加数后上级进位操作[II <: 自然数] = II
}

class I_1[T0, T1, T2, II0 <: 自然数, II1 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1

  override type Next[T]              = II1#加数后上级进位操作[I_1[T0, T1, T2, II0, II1#Next[T]]]
  override type 作进位准备                = I_1_To_2[T0, T1, T2, II0, II1]
  override type 加数后上级进位操作[II <: 自然数] = II
}

class I_1_To_2[T0, T1, T2, II0 <: 自然数, II1 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1

  override type Next[T]              = I_2_Step_2[T0, T1, T2, II0, II1, S_0[T]]
  override type 加数后上级进位操作[II <: 自然数] = II
}

class I_2_Step_Full[T0, T1, T2, II0 <: 自然数, II1 <: 自然数, II2 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type 开辟加数空间 = I_2_Step_0[T0, T1, T2, II0#开辟加数空间, II1, II2]
}

class I_2_Step_0[T0, T1, T2, II0 <: 自然数, II1 <: 自然数, II2 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Next[T]              = II0#加数后上级进位操作[I_2_Step_0[T0, T1, T2, II0#Next[T], II1, II2]]
  override type 作进位准备                = I_2_Step_1[T0, T1, T2, II0, II1, II2]
  override type 加数后上级进位操作[II <: 自然数] = II
}

class I_2_Step_1[T0, T1, T2, II0 <: 自然数, II1 <: 自然数, II2 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Next[T]              = II1#加数后上级进位操作[I_2_Step_1[T0, T1, T2, II0, II1#Next[T], II2]]
  override type 作进位准备                = I_2_Step_2[T0, T1, T2, II0, II1, II2]
  override type 加数后上级进位操作[II <: 自然数] = II
}

class I_2_Step_2[T0, T1, T2, II0 <: 自然数, II1 <: 自然数, II2 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Next[T]              = II2#加数后上级进位操作[I_2_Step_2[T0, T1, T2, II0, II1, II2#Next[T]]]
  override type 作进位准备                = I_2_Step_Full[T0, T1, T2, II0, II1, II2]
  override type 加数后上级进位操作[II <: 自然数] = II2#加数后上级进位操作[II]
}
