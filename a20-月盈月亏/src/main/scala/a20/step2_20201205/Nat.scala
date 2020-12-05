package a20.step2_20201205

trait Nat {
  type M[I <: Nat, C] <: Moon
}

class NatZero extends Nat {
  override type M[I <: Nat, C] = Moon#Apply[I, C]
}

class NatPositive[Tail <: Nat, Head] extends Nat {
  override type M[I <: Nat, C] = MoonExecute[Tail, NatPositive[I, C], Head]
}

trait Moon {
  type Current
  type Next <: Moon
  type Apply[I <: Nat, N] = MoonExecute[I, NatZero, N]
}

class MoonExecute[N1 <: Nat, N2 <: Nat, C] extends Moon {
  override type Current = C
  override type Next    = N1#M[N2, C]
}
