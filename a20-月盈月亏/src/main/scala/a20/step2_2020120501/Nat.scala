package a20.step2_2020120501

trait Nat {
  type M[I <: Nat, C] <: Moon
}

class NatZero extends Nat {
  override type M[I <: Nat, C] = MoonImpl[I, NatZero, C]
}

class NatPositive[Tail <: Nat, Head] extends Nat {
  override type M[I <: Nat, C] = MoonImpl[Tail, NatPositive[I, C], Head]
}

trait Moon {
  type Current
  type Next <: Moon
  type Apply[N1 <: Nat, C] = MoonImpl[N1, NatZero, C]
}

class MoonImpl[N1 <: Nat, N2 <: Nat, C] extends Moon {
  override type Current = C
  override type Next    = N1#M[N2, C]
}
