package a19.step9

trait 三进制后继 {
  type Next[T] <: 三进制后继
  type 是否进位[不进位 <: 三进制后继, 进位 <: 三进制后继] <: 三进制后继
  type 开辟[T] <: 三进制后继
}

class 上层_1[T1, T2, II1 <: 三进制后继, II2 <: 三进制后继] extends 三进制后继 {
  type _1_th = T1
  type _2_th = T2

  type _1 = II1
  type _2 = II2

  override type Next[T] = II1#是否进位[上层_1[T1, T2, II1#Next[T], II2], 上层_2[T1, T2, II1, II2#开辟[T]]]
}

class 上层_2[T1, T2, II1 <: 三进制后继, II2 <: 三进制后继] extends 三进制后继 {
  type _1_th = T1
  type _2_th = T2

  type _1 = II1
  type _2 = II2

  override type Next[T] = II2#是否进位[上层_2[T1, T2, II1, II2#Next[T]], 上层_1[T1, T2, II1#开辟[T], II2]]
}

class 底层_0[T0] extends 三进制后继 {
  type _0_th = T0

  override type Next[T]                         = 底层_1[T0, T]
  override type 是否进位[不进位 <: 三进制后继, 进位 <: 三进制后继] = 不进位
}

class 底层_1[T0, T1] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1

  override type Next[T]                         = 底层_2[T0, T1, T]
  override type 是否进位[不进位 <: 三进制后继, 进位 <: 三进制后继] = 不进位
}

class 底层_2[T0, T1, T2] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  override type 是否进位[不进位 <: 三进制后继, 进位 <: 三进制后继] = 进位
  override type 开辟[T]                           = 中层_0[T0, T1, T2, 底层_0[T]]
}

class 中层_0[T0, T1, T2, II0 <: 三进制后继] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0

  override type Next[T]                         = II0#是否进位[中层_0[T0, T1, T2, II0#Next[T]], 中层_1[T0, T1, T2, II0, 底层_0[T]]]
  override type 是否进位[不进位 <: 三进制后继, 进位 <: 三进制后继] = 不进位
}

class 中层_1[T0, T1, T2, II0 <: 三进制后继, II1 <: 三进制后继] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1

  override type Next[T]                         = II1#是否进位[中层_1[T0, T1, T2, II0, II1#Next[T]], 中层满位_2[T0, T1, T2, II0, II1, 底层_0[T]]]
  override type 是否进位[不进位 <: 三进制后继, 进位 <: 三进制后继] = 不进位
}

class 中层满位_0[T0, T1, T2, II0 <: 三进制后继, II1 <: 三进制后继, II2 <: 三进制后继] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Next[T]                         = II0#是否进位[中层满位_0[T0, T1, T2, II0#Next[T], II1, II2], 中层满位_1[T0, T1, T2, II0, II1#开辟[T], II2]]
  override type 是否进位[不进位 <: 三进制后继, 进位 <: 三进制后继] = 不进位
}

class 中层满位_1[T0, T1, T2, II0 <: 三进制后继, II1 <: 三进制后继, II2 <: 三进制后继] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Next[T]                         = II1#是否进位[中层满位_1[T0, T1, T2, II0, II1#Next[T], II2], 中层满位_2[T0, T1, T2, II0, II1, II2#开辟[T]]]
  override type 是否进位[不进位 <: 三进制后继, 进位 <: 三进制后继] = 不进位
}

class 中层满位_2[T0, T1, T2, II0 <: 三进制后继, II1 <: 三进制后继, II2 <: 三进制后继] extends 三进制后继 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  type _0 = II0
  type _1 = II1
  type _2 = II2

  override type Next[T]                         = II2#是否进位[中层满位_2[T0, T1, T2, II0, II1, II2#Next[T]], 中层满位_2[T0, T1, T2, II0, II1, II2]]
  override type 是否进位[不进位 <: 三进制后继, 进位 <: 三进制后继] = II2#是否进位[不进位, 进位]
  override type 开辟[T]                           = 中层满位_0[T0, T1, T2, II0#开辟[T], II1, II2]
}
