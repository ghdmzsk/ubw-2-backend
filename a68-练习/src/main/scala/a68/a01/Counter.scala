package a68.a01

trait Number1
class Number1S[Tail <: Number1] extends Number1
class Number1T                  extends Number1

trait Number2 {
  type Method1[N1 <: Number1] <: Number1
}
class Number2S[Tail <: Number2] extends Number2 {
  override type Method1[N1 <: Number1] = Number1S[Tail#Method1[N1]]
}
class Number2T extends Number2 {
  override type Method1[N1 <: Number1] = N1
}
