package step1

trait BeMinus
class BeMinusP[Tail <: BeMinus, Head] extends BeMinus
class BeMinusO extends BeMinus

trait Minus
class MinusP[Tail <: Minus, Head] extends Minus
class MinusO extends Minus

type 减法[T1 <: BeMinus, T2 <: Minus] <: BeMinus = T2 match {
  case MinusP[tail, head] => 减法一[T1, tail, head]
  case MinusO => T1
}

type 减法一[T1 <: BeMinus, T2 <: Minus, Head] <: BeMinus = T1 match {
  case BeMinusP[tail, head] => 减法[tail, T2]
  case BeMinusO => BeMinusO
}