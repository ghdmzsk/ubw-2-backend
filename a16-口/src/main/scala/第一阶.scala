package a16.第一阶

trait 自然数 {
  type 逆向加[N <: 自然数] <: 自然数
  type 加[N <: 自然数] <: 自然数
}

class 零 extends 自然数 {
  override type 逆向加[N <: 自然数] = N
  override type 加[N <: 自然数]   = N#逆向加[零]
}

class 后继[Tail <: 自然数, T2] extends 自然数 {
  override type 逆向加[N <: 自然数] = 后继[Tail#逆向加[N], T2]
  override type 加[N <: 自然数]   = N#逆向加[后继[Tail, T2]]
}
