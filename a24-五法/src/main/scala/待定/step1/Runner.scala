package 待定.step1

trait HList {
  type changePre[H <: HList] <: HList
  type changeNext[H <: HList] <: HList
  type changeMe[Item] <: HList
}

class Nat[Pre <: HList, Next <: HList, Current] extends HList {

  override type changePre[H <: HList]  = Nat[H, Next, Current]
  override type changeNext[H <: HList] = Nat[Pre, H, Current]
  override type changeMe[Item] = ({
    type N1 = Pre#changeNext[N3]
    type N2 = Next#changePre[N3]
    type N3 = Nat[N1, N2, Item]
  })#N3

}
