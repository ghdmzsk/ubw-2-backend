package a19.step5

trait 进制自然数 {
  type Next[T] <: 进制自然数
  type 加数后上级进位操作[II <: 进制自然数 with 进位准备] <: 进制自然数
}

trait 进位准备 {
  type 作进位准备 <: 进制自然数
}

class P_3_Step_1[T1, T2, II1 <: 进制自然数, II2 <: 进制自然数] extends 进制自然数 with 进位准备 {
  type _1_th = T1
  type _2_th = T2

  type _1 = II1
  type _2 = II2

  override type Next[T] = II1#加数后上级进位操作[P_3_Step_1[T1, T2, II1#Next[T], II2]]
  override type 作进位准备   = P_3_Step_2[T1, T2, II1, II2]
}

class P_3_Step_2[T1, T2, II1 <: 进制自然数, II2 <: 进制自然数] extends 进制自然数 with 进位准备 {
  type _1_th = T1
  type _2_th = T2

  type _1 = II1
  type _2 = II2

  override type Next[T] = II2#加数后上级进位操作[P_3_Step_2[T1, T2, II1, II2#Next[T]]]
  override type 作进位准备   = P_3_Step_1[T1, T2, II1, II2]
}

class S_0[T0] extends 进制自然数 {
  type _0_th = T0

  override type Next[T]                          = S_1[T0, T]
  override type 加数后上级进位操作[II <: 进制自然数 with 进位准备] = II
}

class S_1[T0, T1] extends 进制自然数 {
  type _0_th = T0
  type _1_th = T1

  override type Next[T]                          = S_2[T0, T1, T]
  override type 加数后上级进位操作[II <: 进制自然数 with 进位准备] = II#作进位准备
}

class S_2[T0, T1, T2] extends 进制自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  override type Next[T]                          = I_0[T0, T1, T2, S_0[T]]
  override type 加数后上级进位操作[II <: 进制自然数 with 进位准备] = II
}

class I_0[T0, T1, T2, II0 <: 进制自然数] extends 进制自然数 with 进位准备 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0

  override type Next[T]                          = II0#加数后上级进位操作[I_0[T0, T1, T2, II0#Next[T]]]
  override type 作进位准备                            = I_0_To_1[T0, T1, T2, II0]
  override type 加数后上级进位操作[II <: 进制自然数 with 进位准备] = II
}

class I_0_To_1[T0, T1, T2, II0 <: 进制自然数] extends 进制自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0

  override type Next[T]                          = I_1[T0, T1, T2, II0, S_0[T]]
  override type 加数后上级进位操作[II <: 进制自然数 with 进位准备] = II
}

class I_1[T0, T1, T2, II0 <: 进制自然数, II1 <: 进制自然数] extends 进制自然数 with 进位准备 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1

  override type Next[T]                          = II1#加数后上级进位操作[I_1[T0, T1, T2, II0, II1#Next[T]]]
  override type 作进位准备                            = I_1_To_2[T0, T1, T2, II0, II1]
  override type 加数后上级进位操作[II <: 进制自然数 with 进位准备] = II
}

class I_1_To_2[T0, T1, T2, II0 <: 进制自然数, II1 <: 进制自然数] extends 进制自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1

  override type Next[T]                          = I_2_Step_2[T0, T1, T2, II0, II1, S_0[T]]
  override type 加数后上级进位操作[II <: 进制自然数 with 进位准备] = II
}

class I_2_Step_0[T0, T1, T2, II0 <: 进制自然数, II1 <: 进制自然数, II2 <: 进制自然数] extends 进制自然数 with 进位准备 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Next[T]                          = II0#加数后上级进位操作[I_2_Step_0[T0, T1, T2, II0#Next[T], II1, II2]]
  override type 作进位准备                            = I_2_Step_1[T0, T1, T2, II0, II1, II2]
  override type 加数后上级进位操作[II <: 进制自然数 with 进位准备] = II
}

class I_2_Step_1[T0, T1, T2, II0 <: 进制自然数, II1 <: 进制自然数, II2 <: 进制自然数] extends 进制自然数 with 进位准备 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Next[T]                          = II1#加数后上级进位操作[I_2_Step_1[T0, T1, T2, II0, II1#Next[T], II2]]
  override type 作进位准备                            = I_2_Step_2[T0, T1, T2, II0, II1, II2]
  override type 加数后上级进位操作[II <: 进制自然数 with 进位准备] = II
}

class I_2_Step_2[T0, T1, T2, II0 <: 进制自然数, II1 <: 进制自然数, II2 <: 进制自然数] extends 进制自然数 with 进位准备 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Next[T]                          = II2#加数后上级进位操作[I_2_Step_2[T0, T1, T2, II0, II1, II2#Next[T]]]
  override type 作进位准备                            = I_2_Step_0[T0, T1, T2, II0, II1, II2]
  override type 加数后上级进位操作[II <: 进制自然数 with 进位准备] = II2#加数后上级进位操作[II]
}
