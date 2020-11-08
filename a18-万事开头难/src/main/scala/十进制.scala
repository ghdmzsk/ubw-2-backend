package a18

trait 自然数 {
  type Up <: 自然数
  type Self <: 自然数
  type _0 = S_0[Self]
  type _1 = S_1[Self]
  type _2 = S_2[Self]
  type _3 = S_3[Self]
  type _4 = S_4[Self]
  type _5 = S_5[Self]
  type _6 = S_6[Self]
  type _7 = S_7[Self]
  type _8 = S_8[Self]
  type _9 = S_9[Self]
}

class 进位 extends 自然数 {
  override type Up   = S_1[进位]
  override type Self = 进位
}

class S_0[Tail <: 自然数] extends 自然数 {
  override type Up   = S_1[Tail]
  override type Self = S_0[Tail]
}

class S_1[Tail <: 自然数] extends 自然数 {
  override type Up   = S_2[Tail]
  override type Self = S_1[Tail]
}

class S_2[Tail <: 自然数] extends 自然数 {
  override type Up   = S_3[Tail]
  override type Self = S_2[Tail]
}

class S_3[Tail <: 自然数] extends 自然数 {
  override type Up   = S_4[Tail]
  override type Self = S_3[Tail]
}

class S_4[Tail <: 自然数] extends 自然数 {
  override type Up   = S_5[Tail]
  override type Self = S_4[Tail]
}

class S_5[Tail <: 自然数] extends 自然数 {
  override type Up   = S_6[Tail]
  override type Self = S_5[Tail]
}

class S_6[Tail <: 自然数] extends 自然数 {
  override type Up   = S_7[Tail]
  override type Self = S_6[Tail]
}

class S_7[Tail <: 自然数] extends 自然数 {
  override type Up   = S_8[Tail]
  override type Self = S_7[Tail]
}

class S_8[Tail <: 自然数] extends 自然数 {
  override type Up   = S_9[Tail]
  override type Self = S_8[Tail]
}

class S_9[Tail <: 自然数] extends 自然数 {
  override type Up   = S_0[Tail#Up]
  override type Self = S_9[Tail]
}
