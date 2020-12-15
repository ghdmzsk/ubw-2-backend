package a19.step1

trait 自然数 {
  type Next[T] <: 自然数
  type N[T] <: 自然数
  type Up[T, II <: 自然数] <: 自然数
  type SelfAdd[T] <: 自然数
}

class S_0[T0] extends 自然数 {
  type _0_th = T0

  override type Next[T]          = S_1[T0, T]
  override type N[T]             = S_1[T0, T]
  override type Up[T, II <: 自然数] = II
}

class S_1[T0, T1] extends 自然数 {
  type _0_th = T0
  type _1_th = T1

  override type Next[T]          = S_2[T0, T1, T]
  override type N[T]             = S_2[T0, T1, T]
  override type Up[T, II <: 自然数] = II
}

class S_2[T0, T1, T2] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  override type Next[T]          = S_2[T0, T1, T2]
  override type N[T]             = I_0[T0, T1, T2, S_0[T]]
  override type Up[T, II <: 自然数] = II#SelfAdd[T]
}

class I_0[T0, T1, T2, II0 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0

  override type Next[T]          = I_0[T0, T1, T2, II0#Next[T]]
  override type N[T]             = II0#Up[T, Next[T]]
  override type Up[T, II <: 自然数] = II0#Up[T, II]
  override type SelfAdd[T]       = I_1[T0, T1, T2, II0, S_0[T]]
}

class I_1[T0, T1, T2, II0 <: 自然数, II1 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1

  override type Next[T]          = I_1[T0, T1, T2, II0, II1#Next[T]]
  override type N[T]             = II1#Up[T, Next[T]]
  override type Up[T, II <: 自然数] = II1#Up[T, II]
  override type SelfAdd[T]       = I_2[T0, T1, T2, II0, II1, S_0[T]]
}

class I_2[T0, T1, T2, II0 <: 自然数, II1 <: 自然数, II2 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Next[T]          = I_2[T0, T1, T2, II0, II1, II2#Next[T]]
  override type N[T]             = II2#Up[T, Next[T]]
  override type Up[T, II <: 自然数] = II2#Up[T, II]
  override type SelfAdd[T]       = I_2[T0, T1, T2, II0, II1, II2]
}
