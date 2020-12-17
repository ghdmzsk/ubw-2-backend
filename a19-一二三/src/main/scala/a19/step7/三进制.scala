package a19.step7

trait 进位准备 {
  type Next[T] <: 进位准备
  type 加数后上级进位操作[NoNeed <: 进位准备, Need <: 进位准备] <: 进位准备
  type 变 <: 本阶变化
}

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

class 本阶变化进位零[N1 <: 初始转换] extends 本阶变化 {
  override type 变换[N]                   = N1#小转换[N]
  override type 进位[进1 <: 变化, 不进1 <: 变化] = 本阶变化进位[本阶变化进位零[N1], 进1]
  override type 不进位[不进1 <: 变化]          = 本阶变化不进位[本阶变化进位零[N1], 不进1]
}

class 本阶变化不进位零[N1 <: 初始转换] extends 本阶变化 {
  override type 变换[N]                   = N1#小转换[N]
  override type 进位[进1 <: 变化, 不进1 <: 变化] = 本阶变化不进位[本阶变化不进位零[N1], 不进1]
  override type 不进位[不进1 <: 变化]          = 本阶变化不进位[本阶变化不进位零[N1], 不进1]
}

class 本阶变化进位[Tail <: 本阶变化, 进 <: 变化] extends 本阶变化 {
  override type 变换[N]                   = 进#转化[Tail#变换[N]]
  override type 进位[进1 <: 变化, 不进1 <: 变化] = 本阶变化进位[本阶变化进位[Tail, 进], 进1]
  override type 不进位[不进1 <: 变化]          = 本阶变化不进位[本阶变化进位[Tail, 进], 不进1]
}

class 本阶变化不进位[Tail <: 本阶变化, 不进 <: 变化] extends 本阶变化 {
  override type 变换[N]                   = 不进#转化[Tail#变换[N]]
  override type 进位[进1 <: 变化, 不进1 <: 变化] = 本阶变化不进位[本阶变化不进位[Tail, 不进], 不进1]
  override type 不进位[不进1 <: 变化]          = 本阶变化不进位[本阶变化不进位[Tail, 不进], 不进1]
}

class P_3_Step_1[II1 <: 进位准备, II2 <: 进位准备] extends 进位准备 {

  type _1 = II1
  type _2 = II2

  override type Next[T] = 变#变换[T]

  class 转进位 extends 变化 {
    override type 转化[N <: 进位准备] = P_3_Step_2[N, II2]
  }
  class 转不进位 extends 变化 {
    override type 转化[N <: 进位准备] = P_3_Step_1[N, II2]
  }
  override type 变 = II1#变#进位[转进位, 转不进位]
}

class P_3_Step_2[II1 <: 进位准备, II2 <: 进位准备] extends 进位准备 {

  type _1 = II1
  type _2 = II2

  override type Next[T] = 变#变换[T]

  class 转进位 extends 变化 {
    override type 转化[N <: 进位准备] = P_3_Step_1[II1, N]
  }
  class 转不进位 extends 变化 {
    override type 转化[N <: 进位准备] = P_3_Step_2[II1, N]
  }
  override type 变 = II2#变#进位[转进位, 转不进位]
}

class S_0[T0] extends 进位准备 {
  type _0_th = T0

  class 转 extends 初始转换 {
    override type 小转换[T] = S_1[T0, T]
  }
  override type 变 = 本阶变化不进位零[转]
}

class S_1[T0, T1] extends 进位准备 {
  type _0_th = T0
  type _1_th = T1

  class 转 extends 初始转换 {
    override type 小转换[T] = S_2[T0, T1, T]
  }
  override type 变 = 本阶变化进位零[转]
}

class S_2[T0, T1, T2] extends 进位准备 {
  type _0_th = T0
  type _1_th = T1
  type _2_th = T2

  /*class 转 extends 初始转换 {
    override type 小转换[T] = I_0[T0, T1, T2, S_0[T]]
  }*/
  class 转 extends 初始转换 {
    override type 小转换[T] = S_0[T]
  }
  override type 变 = 本阶变化不进位零[转]
}

class I_0[II0 <: 进位准备] extends 进位准备 {

  type _0 = II0

  class 转进位 extends 变化 {
    override type 转化[N <: 进位准备] = I_0_To_1[N]
  }
  class 转不进位 extends 变化 {
    override type 转化[N <: 进位准备] = I_0[N]
  }
  override type 变 = II0#变#进位[转进位, 转不进位]
}

class I_0_To_1[II0 <: 进位准备] extends 进位准备 {

  type _0 = II0

  class 转不进位 extends 变化 {
    override type 转化[N <: 进位准备] = I_1[II0, N]
  }
  override type 变 = II0#变#不进位[转不进位]
}

class I_1[II0 <: 进位准备, II1 <: 进位准备] extends 进位准备 {

  type _0 = II0
  type _1 = II1

  class 转进位 extends 变化 {
    override type 转化[N <: 进位准备] = I_1_To_2[II0, N]
  }
  class 转不进位 extends 变化 {
    override type 转化[N <: 进位准备] = I_1[II0, N]
  }
  override type 变 = II1#变#进位[转进位, 转不进位]
}

class I_1_To_2[II0 <: 进位准备, II1 <: 进位准备] extends 进位准备 {

  type _0 = II0
  type _1 = II1

  override type Next[T]                             = I_2_Step_2[II0, II1, S_0[T]]
  override type 加数后上级进位操作[II <: 进位准备, Need <: 进位准备] = II

  class 转不进位 extends 变化 {
    override type 转化[N <: 进位准备] = I_2_Step_2[II0, II1, N]
  }
  override type 变 = II1#变#不进位[转不进位]
}

class I_2_Step_0[II0 <: 进位准备, II1 <: 进位准备, II2 <: 进位准备] extends 进位准备 {

  type _0 = II0
  type _1 = II1
  type _2 = II2

  class 转进位 extends 变化 {
    override type 转化[N <: 进位准备] = I_2_Step_1[N, II1, II2]
  }
  class 转不进位 extends 变化 {
    override type 转化[N <: 进位准备] = I_2_Step_0[N, II1, II2]
  }
  override type 变 = II0#变#进位[转进位, 转不进位]
}

class I_2_Step_1[II0 <: 进位准备, II1 <: 进位准备, II2 <: 进位准备] extends 进位准备 {

  type _0 = II0
  type _1 = II1
  type _2 = II2

  class 转进位 extends 变化 {
    override type 转化[N <: 进位准备] = I_2_Step_2[II0, N, II2]
  }
  class 转不进位 extends 变化 {
    override type 转化[N <: 进位准备] = I_2_Step_1[II0, N, II2]
  }
  override type 变 = II1#变#进位[转进位, 转不进位]
}

class I_2_Step_2[II0 <: 进位准备, II1 <: 进位准备, II2 <: 进位准备] extends 进位准备 {

  type _0 = II0
  type _1 = II1
  type _2 = II2

  class 转进位 extends 变化 {
    override type 转化[N <: 进位准备] = I_2_Step_0[II0, II1, N]
  }
  class 转不进位 extends 变化 {
    override type 转化[N <: 进位准备] = I_2_Step_2[II0, II1, N]
  }
  override type 变 = II2#变#进位[转进位, 转不进位]
}
