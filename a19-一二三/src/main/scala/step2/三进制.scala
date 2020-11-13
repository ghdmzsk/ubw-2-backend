package a19.step2

trait 自然数 {
  type Put[T] <: 自然数
  type Self <: 自然数
  type FirstAdd[T] <: 自然数
  type 上级进位[T <: 自然数] <: 自然数
  type 本级进位[T] <: 自然数
}

class P_3[T1, T2, II0 <: 自然数, II1 <: 自然数, II2 <: 自然数] extends 自然数 {
  type _1_th = T1
  type _2_th = T2

  type _1 = II0
  type _2 = II1
  type _3 = II2

  override type Self        = P_3[T1, T2, II0, II1, II2]
  override type FirstAdd[T] = P_3[T1, T2, II0#本级进位[T], II1, II2]
  override type 本级进位[T]     = FirstAdd[T]
}

class Input[N <: 自然数, T1] extends 自然数 {
  override type Self           = N
  override type 上级进位[T <: 自然数] = T#本级进位[T1]
}

class S_0[T0] extends 自然数 {
  type _0_th = T0

  override type Put[T]         = S_1[T0, T]
  override type Self           = S_0[T0]
  override type 上级进位[T <: 自然数] = T
}

class S_1[T0, T1] extends 自然数 {
  type _0_th = T0
  type _1_th = T1

  override type Put[T]         = S_2[T0, T1, T]
  override type Self           = S_1[T0, T1]
  override type 上级进位[T <: 自然数] = T
}

class S_2[T0, T1, T2] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  override type Put[T]         = Input[S_2[T0, T1, T2], T]
  override type FirstAdd[T]    = I_0[T0, T1, T2, S_0[T]]
  override type Self           = S_2[T0, T1, T2]
  override type 上级进位[T <: 自然数] = T
}

class I_0[T0, T1, T2, II0 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0

  override type Put[T]         = II0#Put[T]#上级进位[I_0[T0, T1, T2, II0#Put[T]#Self]]
  override type Self           = I_0[T0, T1, T2, II0]
  override type 上级进位[T <: 自然数] = T
  override type 本级进位[T]        = I_1[T0, T1, T2, II0, S_0[T]]
}

class I_1[T0, T1, T2, II0 <: 自然数, II1 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1

  override type Put[T]         = II1#Put[T]#上级进位[I_1[T0, T1, T2, II0, II1#Put[T]#Self]]
  override type Self           = I_1[T0, T1, T2, II0, II1]
  override type 上级进位[T <: 自然数] = T
  override type 本级进位[T]        = I_2[T0, T1, T2, II0, II1, S_0[T]]
}

class I_2[T0, T1, T2, II0 <: 自然数, II1 <: 自然数, II2 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Put[T]         = II2#Put[T]#上级进位[I_2[T0, T1, T2, II0, II1, II2#Put[T]#Self]]
  override type Self           = I_2[T0, T1, T2, II0, II1, II2]
  override type FirstAdd[T]    = I_2[T0, T1, T2, II0#FirstAdd[T], II1, II2]
  override type 上级进位[T <: 自然数] = T
  override type 本级进位[T]        = Input[I_2[T0, T1, T2, II0, II1, II2], T]
}
