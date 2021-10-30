package a68.a02

trait Number1 {
  type Method1[N2 <: Number2] <: Number1
}
class Number1S[Tail <: Number1] extends Number1 {
  override type Method1[N2 <: Number2] = N2#Method2[Tail]
}
class Number1T extends Number1 {
  override type Method1[N2 <: Number2] = Number1T
}

trait Number2 {
  type Method2[N1 <: Number1] <: Number1
}
class Number2S[Tail <: Number2] extends Number2 {
  override type Method2[N1 <: Number1] = N1#Method1[Tail]
}
class Number2T extends Number2 {
  override type Method2[N1 <: Number1] = N1
}
