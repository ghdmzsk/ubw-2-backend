package a20.step2_2020120501

trait Nat {
  type M[I <: Nat] <: Moon
}

trait Moon {
  type Current
}
class MoonImpl[N1 <: Nat, N2 <: Nat, C] extends Moon {
  override type Current = C
}
