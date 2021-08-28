package step1

trait BePlus
class BePlusP[Tail<:BePlus,Head] extends BePlus
class BePlusO extends BePlus

trait Plus
class PlusP[Tail<:Plus,Head] extends Plus
class PlusO extends Plus

type 加法[T1 <: BePlus, T2 <: Plus]<:BePlus   = T2 match {
  case PlusP[tail, head] => BePlusP[加法[T1, tail], head]
  case PlusO => T1
}
