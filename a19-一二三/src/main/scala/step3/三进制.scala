package a19.step3

trait 自然数 {
  type 作进位准备 <: 自然数
}

class P_3_Step_0[T1, T2, II0 <: 自然数, II1 <: 自然数, II2 <: 自然数] extends 自然数 {
  type _1_th = T1
  type _2_th = T2

  type _1 = II0
  type _2 = II1
  type _3 = II2

  override type 作进位准备 = P_3_Step_1[T1, T2, II0, II1, II2]
}

class P_3_Step_1[T1, T2, II0 <: 自然数, II1 <: 自然数, II2 <: 自然数] extends 自然数 {
  type _1_th = T1
  type _2_th = T2

  type _1 = II0
  type _2 = II1
  type _3 = II2

  override type 作进位准备 = P_3_Step_2[T1, T2, II0, II1, II2]
}

class P_3_Step_2[T1, T2, II0 <: 自然数, II1 <: 自然数, II2 <: 自然数] extends 自然数 {
  type _1_th = T1
  type _2_th = T2

  type _1 = II0
  type _2 = II1
  type _3 = II2

  override type 作进位准备 = P_3_Step_0[T1, T2, II0, II1, II2]
}

class S_0[T0] extends 自然数 {
  type _0_th = T0
}

class S_1[T0, T1] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
}

class S_2[T0, T1, T2] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  override type 作进位准备 = I_S_To_0[T0, T1, T2]
}

class I_S_To_0[T0, T1, T2] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2
}

class I_0[T0, T1, T2, II0 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0

  override type 作进位准备 = I_0_To_1[T0, T1, T2, II0]
}

class I_0_To_1[T0, T1, T2, II0 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0

}

class I_1[T0, T1, T2, II0 <: 自然数, II1 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1

  override type 作进位准备 = I_1_To_2[T0, T1, T2, II0, II1]
}

class I_1_To_2[T0, T1, T2, II0 <: 自然数, II1 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1

}

class I_2_Step_0[T0, T1, T2, II0 <: 自然数, II1 <: 自然数, II2 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type 作进位准备 = I_2_Step_1[T0, T1, T2, II0, II1, II2]
}

class I_2_Step_1[T0, T1, T2, II0 <: 自然数, II1 <: 自然数, II2 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type 作进位准备 = I_2_Step_2[T0, T1, T2, II0, II1, II2]
}

class I_2_Step_2[T0, T1, T2, II0 <: 自然数, II1 <: 自然数, II2 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type 作进位准备 = I_2_Step_Full[T0, T1, T2, II0, II1, II2]
}

class I_2_Step_Full[T0, T1, T2, II0 <: 自然数, II1 <: 自然数, II2 <: 自然数] extends 自然数 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

}
