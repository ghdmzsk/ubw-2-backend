package a68.a04

trait Number1 {
  type Method1[N2 <: Number2] <: Number3
}
class Number1S[Tail <: Number1] extends Number1 {
  override type Method1[N2 <: Number2] = N2#Method2[Tail]
}
class Number1T extends Number1 {
  override type Method1[N2 <: Number2] = Number3T
}

trait Number2 {
  type Method2[N1 <: Number1] <: Number3
}
class Number2S[Tail <: Number2] extends Number2 {
  override type Method2[N1 <: Number1] = N1#Method1[Tail]
}
class Number2T[Tail <: Number2] extends Number2 {
  override type Method2[N1 <: Number1] = Number3S[Tail#Method2[N1]]
}

trait Number3
class Number3S[Tail <: Number3] extends Number3
class Number3T                  extends Number3
