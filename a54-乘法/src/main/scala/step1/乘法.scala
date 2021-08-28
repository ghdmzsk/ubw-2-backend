package step1

trait Result
class ResultP[Tail <: Result, Head1, Head2] extends Result
class ResultO extends Result

trait BeMultiply
class BeMultiplyP[Tail <: BeMultiply, Head] extends BeMultiply
class BeMultiplyO extends BeMultiply

trait Multiply
class MultiplyP[Tail <: Multiply, Head] extends Multiply
class MultiplyO[Tail <: Multiply] extends Multiply

type 乘法[T1 <: BeMultiply, T2 <: Multiply] <: Result = T1 match {
  case BeMultiplyP[tail, head] => 乘法一[tail, T2, head]
  case BeMultiplyO => ResultO
}

type 乘法一[T1 <: BeMultiply, T2 <: Multiply, Head] <: Result = T2 match {
  case MultiplyP[tail, head] => ResultP[乘法一[T1, tail, Head], Head, head]
  case MultiplyO[tail] => 乘法[T1, tail]
}