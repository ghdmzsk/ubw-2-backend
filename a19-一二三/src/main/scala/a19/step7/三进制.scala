package a19.step7

trait 进位准备 {
  type Next[T] <: 进位准备
  type 加数后上级进位操作[NoNeed <: 进位准备, Need <: 进位准备] <: 进位准备
}

/*trait 来去 {
  type Num[N] <: 进位准备
  type 进位[N <: 进位准备, H <: 本阶变化] <: 来去
  type 不进位[N <: 进位准备, H <: 本阶变化] <: 来去
}

class 初始进位来去[Num1 <: 进位准备] extends 来去 {
  override type Num            = Num1
  override type 进位[H <: 本阶变化]  = H#进位变化[Num1]
  override type 不进位[H <: 本阶变化] = H#不进位变化[Num1]
}

class 初始不进位来去[Num1 <: 进位准备] extends 来去 {
  override type Num            = Num1
  override type 进位[H <: 本阶变化]  = H#进位变化[Num1]
  override type 不进位[H <: 本阶变化] = H#不进位变化[Num1]
}

class 复杂进位来去[Tail <: 来去] extends 来去 {
  override type Num            = Tail#Num
  override type 进位[H <: 本阶变化]  = Tail#进位[H]
  override type 不进位[H <: 本阶变化] = Tail#不进位[H]
}

class 复杂不进位来去[Tail <: 来去] extends 来去 {
  override type 进位[H <: 本阶变化]  = Tail#不进位[H]
  override type 不进位[H <: 本阶变化] = Tail#不进位[H]
}*/

/*trait 变化 {
  type 转化[N <: 进位准备] <: 进位准备
}

trait 初始转换 {
  type 小转换[T] <: 进位准备
}

trait 本阶变化 {
  type 变换[N] <: 进位准备
  type 进位[进1 <: 变化, 不进1 <: 变化] <: 本阶变化
  type 不进位[进1 <: 变化, 不进1 <: 变化] <: 本阶变化
}

class 本阶变化零[N1 <: 初始转换] extends 本阶变化 {
  override type 变换[N]                    = N1#小转换[N1]
  override type 进位[进1 <: 变化, 不进1 <: 变化]  = 本阶变化进位[本阶变化零[N1], 进1, 不进1]
  override type 不进位[进1 <: 变化, 不进1 <: 变化] = 本阶变化不进位[本阶变化零[N1], 进1, 不进1]
}

class 本阶变化进位[Tail <: 本阶变化, 进 <: 变化, 不进 <: 变化] extends 本阶变化 {
  override type 变换[N]                    = 进#转化[Tail#变换[N]]
  override type 进位[进1 <: 变化, 不进1 <: 变化]  = 本阶变化进位[本阶变化进位[Tail, 进, 不进], 进1, 不进1]
  override type 不进位[进1 <: 变化, 不进1 <: 变化] = 本阶变化不进位[本阶变化进位[Tail, 进, 不进], 进1, 不进1]
}

class 本阶变化不进位[Tail <: 本阶变化, 进 <: 变化, 不进 <: 变化] extends 本阶变化 {
  override type 变换[N]                    = 不进#转化[Tail#变换[不进]]
  override type 进位[进1 <: 变化, 不进1 <: 变化]  = 本阶变化不进位[本阶变化不进位[Tail, 进, 不进], 进1, 不进1]
  override type 不进位[进1 <: 变化, 不进1 <: 变化] = 本阶变化不进位[本阶变化不进位[Tail, 进, 不进], 进1, 不进1]
}*/

trait 变化 {
  type 转化[N <: 进位准备] <: 进位准备
}

trait 初始转换 {
  type 小转换[T] <: 进位准备
}

trait 本阶变化 {
  type 变换[N] <: 进位准备
  type 进位[进1 <: 变化, 不进1 <: 变化] <: 本阶变化
  type 不进位[不进1 <: 变化] <: 本阶变化
}

class 本阶变化零[N1 <: 初始转换] extends 本阶变化 {
  override type 变换[N]                   = N1#小转换[N1]
  override type 进位[进1 <: 变化, 不进1 <: 变化] = 本阶变化进位[本阶变化零[N1], 进1]
  override type 不进位[不进1 <: 变化]          = 本阶变化不进位[本阶变化零[N1], 不进1]
}

class 本阶变化进位[Tail <: 本阶变化, 进 <: 变化] extends 本阶变化 {
  override type 变换[N]                   = 进#转化[Tail#变换[N]]
  override type 进位[进1 <: 变化, 不进1 <: 变化] = 本阶变化进位[本阶变化进位[Tail, 进], 进1]
  override type 不进位[不进1 <: 变化]          = 本阶变化不进位[本阶变化进位[Tail, 进], 不进1]
}

class 本阶变化不进位[Tail <: 本阶变化, 不进 <: 变化] extends 本阶变化 {
  override type 变换[N]                   = 不进#转化[Tail#变换[不进]]
  override type 进位[进1 <: 变化, 不进1 <: 变化] = 本阶变化不进位[本阶变化不进位[Tail, 不进], 不进1]
  override type 不进位[不进1 <: 变化]          = 本阶变化不进位[本阶变化不进位[Tail, 不进], 不进1]
}

class P_3_Step_1[T1, T2, II1 <: 进位准备, II2 <: 进位准备] extends 进位准备 {
  type _1_th = T1
  type _2_th = T2

  type _1 = II1
  type _2 = II2

  override type Next[T] = II1#加数后上级进位操作[P_3_Step_1[T1, T2, II1#Next[T], II2], P_3_Step_2[T1, T2, II1#Next[T], II2]]
}

class P_3_Step_2[T1, T2, II1 <: 进位准备, II2 <: 进位准备] extends 进位准备 {
  type _1_th = T1
  type _2_th = T2

  type _1 = II1
  type _2 = II2

  override type Next[T] = II2#加数后上级进位操作[P_3_Step_2[T1, T2, II1, II2#Next[T]], P_3_Step_1[T1, T2, II1, II2#Next[T]]]
}

class S_0[T0] extends 进位准备 {
  type _0_th = T0

  override type Next[T]                             = S_1[T0, T]
  override type 加数后上级进位操作[II <: 进位准备, Need <: 进位准备] = II
}

class S_1[T0, T1] extends 进位准备 {
  type _0_th = T0
  type _1_th = T1

  override type Next[T]                             = S_2[T0, T1, T]
  override type 加数后上级进位操作[II <: 进位准备, Need <: 进位准备] = Need
}

class S_2[T0, T1, T2] extends 进位准备 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  override type Next[T]                             = I_0[T0, T1, T2, S_0[T]]
  override type 加数后上级进位操作[II <: 进位准备, Need <: 进位准备] = II
}

class I_0[T0, T1, T2, II0 <: 进位准备] extends 进位准备 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0

  override type Next[T]                             = II0#加数后上级进位操作[I_0[T0, T1, T2, II0#Next[T]], I_0_To_1[T0, T1, T2, II0#Next[T]]]
  override type 加数后上级进位操作[II <: 进位准备, Need <: 进位准备] = II
}

class I_0_To_1[T0, T1, T2, II0 <: 进位准备] extends 进位准备 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0

  override type Next[T]                             = I_1[T0, T1, T2, II0, S_0[T]]
  override type 加数后上级进位操作[II <: 进位准备, Need <: 进位准备] = II
}

class I_1[T0, T1, T2, II0 <: 进位准备, II1 <: 进位准备] extends 进位准备 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1

  override type Next[T]                             = II1#加数后上级进位操作[I_1[T0, T1, T2, II0, II1#Next[T]], I_1_To_2[T0, T1, T2, II0, II1#Next[T]]]
  override type 加数后上级进位操作[II <: 进位准备, Need <: 进位准备] = II
}

class I_1_To_2[T0, T1, T2, II0 <: 进位准备, II1 <: 进位准备] extends 进位准备 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1

  override type Next[T]                             = I_2_Step_2[T0, T1, T2, II0, II1, S_0[T]]
  override type 加数后上级进位操作[II <: 进位准备, Need <: 进位准备] = II
}

class I_2_Step_0[T0, T1, T2, II0 <: 进位准备, II1 <: 进位准备, II2 <: 进位准备] extends 进位准备 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Next[T]                             = II0#加数后上级进位操作[I_2_Step_0[T0, T1, T2, II0#Next[T], II1, II2], I_2_Step_1[T0, T1, T2, II0#Next[T], II1, II2]]
  override type 加数后上级进位操作[II <: 进位准备, Need <: 进位准备] = II
}

class I_2_Step_1[T0, T1, T2, II0 <: 进位准备, II1 <: 进位准备, II2 <: 进位准备] extends 进位准备 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Next[T]                             = II1#加数后上级进位操作[I_2_Step_1[T0, T1, T2, II0, II1#Next[T], II2], I_2_Step_2[T0, T1, T2, II0, II1#Next[T], II2]]
  override type 加数后上级进位操作[II <: 进位准备, Need <: 进位准备] = II
}

class I_2_Step_2[T0, T1, T2, II0 <: 进位准备, II1 <: 进位准备, II2 <: 进位准备] extends 进位准备 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Next[T]                             = II2#加数后上级进位操作[I_2_Step_2[T0, T1, T2, II0, II1, II2#Next[T]], I_2_Step_0[T0, T1, T2, II0, II1, II2#Next[T]]]
  override type 加数后上级进位操作[II <: 进位准备, Need <: 进位准备] = II2#加数后上级进位操作[II, Need]
}
