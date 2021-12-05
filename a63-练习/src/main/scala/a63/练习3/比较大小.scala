package a63.练习3

trait Nat
class _0             extends Nat
class Succ[N <: Nat] extends Nat

type _1  = Succ[_0]
type _2  = Succ[_1]
type _3  = Succ[_2]
type _4  = Succ[_3]
type _5  = Succ[_4]
type _6  = Succ[_5]
type _7  = Succ[_6]
type _8  = Succ[_7]
type _9  = Succ[_8]
type _10 = Succ[_9]

class LT
object LT {
  given LT with {}
}
type Minus[N1 <: Nat, N2 <: Nat] = (N1, N2) match {
  case (Succ[n1], Succ[n2]) => Minus[n1, n2]
  case (_0, Succ[n2])       => LT
}

def lt[N1 <: Nat, N2 <: Nat](using Minus[N1, N2]): Minus[N1, N2] = implicitly

object NatText {
  lt[_5, _8]
}
