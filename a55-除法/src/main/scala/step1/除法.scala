package step1

trait Result
class ResultP[Tail <: Result] extends Result
class ResultO extends Result

trait BeDivision
class BeDivisionP[Tail <: BeDivision, Head] extends BeDivision
class BeDivisionO extends BeDivision

trait Division
class DivisionP[Tail <: Division, Head] extends Division
class DivisionO[Tail <: Division] extends Division

type 除法[T1 <: BeDivision, T2 <: Division] <: Result = T1 match {
  case BeDivisionP[tail, head] => 除法一[tail, T2, head]
  case BeDivisionO => ResultO
}

type 除法一[T1 <: BeDivision, T2 <: Division, Head] <: Result = T2 match {
  case DivisionP[tail, head] => 除法[T1, tail]
  case DivisionO[tail] => ResultP[除法一[T1, tail, Head]]
}