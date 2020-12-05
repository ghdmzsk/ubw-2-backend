package a20.step2_20201205

trait Nat {
  type M[I <: Nat, C] <: Moon
}

class NatZero extends Nat {
  override type M[I <: Nat, C] = MoonExecute[I, NatZero, C]
}

class NatPositive[Tail <: Nat, Head] extends Nat {
  override type M[I <: Nat, C] = MoonExecute[Tail, NatPositive[I, C], Head]
}

trait Moon {
  type Current
  type Next <: Moon
  type Append[T] <: Moon
  type Apply[N] = MoonExecute[NatZero, NatZero, N]
}

class MoonExecute[N1 <: Nat, N2 <: Nat, C] extends Moon {
  override type Current   = C
  override type Next      = N1#M[N2, C]
  override type Append[T] = MoonExecute[NatPositive[N1, C], N2, T]
}
