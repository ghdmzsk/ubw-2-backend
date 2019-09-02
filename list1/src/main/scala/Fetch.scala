package version1

import org.scalax.asuna.mapper.miaomiao2.Natural

import scala.language.higherKinds

trait Fetch {

  type fetch[H <: Natural] <: Natural
  def fetch[H <: Natural](h: H): fetch[H]

  type data[H <: Natural] = fetch[H]#Head
  def data[H <: Natural](h: H): fetch[H]#Head = fetch(h).biggest

  type Next <: Fetch
  def next: Next

  type Next10 <: Fetch
  def next10: Next10

  type _1 = Next10#Next
  def _1: _1 = next10.next

  type _2 = Next10#Next#Next
  def _2: _2 = next10.next.next

  type _3 = Next10#Next#Next#Next
  def _3: _3 = next10.next.next.next

  type _4 = Next10#Next#Next#Next#Next
  def _4: _4 = next10.next.next.next.next

  type _5 = Next10#Next#Next#Next#Next#Next
  def _5: _5 = next10.next.next.next.next.next

  type _6 = Next10#Next#Next#Next#Next#Next#Next
  def _6: _6 = next10.next.next.next.next.next.next

  type _7 = Next10#Next#Next#Next#Next#Next#Next#Next
  def _7: _7 = next10.next.next.next.next.next.next.next

  type _8 = Next10#Next#Next#Next#Next#Next#Next#Next#Next
  def _8: _8 = next10.next.next.next.next.next.next.next.next

  type _9 = Next10#Next#Next#Next#Next#Next#Next#Next#Next#Next
  def _9: _9 = next10.next.next.next.next.next.next.next.next.next

  type _0 = Next10
  def _0: _0 = next10

}

class Fetch1 extends Fetch {
  self =>

  override type fetch[H <: Natural] = H
  override def fetch[H <: Natural](h: H): H = h

  override type data[H <: Natural] = H#Head
  override def data[H <: Natural](h: H): H#Head = h.biggest

  override type Next = FetchN[Fetch1]
  override def next: FetchN[Fetch1] = new FetchN(self)

  override type Next10 = Fetch1#Next#Next#Next#Next#Next#Next#Next#Next#Next
  override def next10: Fetch1#Next#Next#Next#Next#Next#Next#Next#Next#Next = self.next.next.next.next.next.next.next.next.next

}

object Fetch1 {
  val fetch1 = new Fetch1
}

class FetchN[I <: Fetch](val tail: I) extends Fetch {
  self =>

  override type fetch[H <: Natural] = I#fetch[H]#Tail
  override def fetch[H <: Natural](h: H): I#fetch[H]#Tail = tail.fetch(h).tail

  override type Next = FetchN[FetchN[I]]
  override def next: FetchN[FetchN[I]] = new FetchN(self)

  override type Next10 = FetchN[FetchN[FetchN[FetchN[FetchN[FetchN[FetchN[FetchN[FetchN[FetchN[I#Next10]]]]]]]]]]
  override def next10: FetchN[FetchN[FetchN[FetchN[FetchN[FetchN[FetchN[FetchN[FetchN[FetchN[I#Next10]]]]]]]]]] =
    new FetchN(new FetchN(new FetchN(new FetchN(new FetchN(new FetchN(new FetchN(new FetchN(new FetchN(new FetchN(tail.next10))))))))))

}


trait F {
  type _1 = Fetch1
  def _1: _1 = Fetch1.fetch1

  type _2 = Fetch1#Next
  def _2: _2 = Fetch1.fetch1.next

  type _3 = Fetch1#Next#Next
  def _3: _3 = Fetch1.fetch1.next.next

  type _4 = Fetch1#Next#Next#Next
  def _4: _4 = Fetch1.fetch1.next.next.next

  type _5 = Fetch1#Next#Next#Next#Next
  def _5: _5 = Fetch1.fetch1.next.next.next.next

  type _6 = Fetch1#Next#Next#Next#Next#Next
  def _6: _6 = Fetch1.fetch1.next.next.next.next.next

  type _7 = Fetch1#Next#Next#Next#Next#Next#Next
  def _7: _7 = Fetch1.fetch1.next.next.next.next.next.next

  type _8 = Fetch1#Next#Next#Next#Next#Next#Next#Next
  def _8: _8 = Fetch1.fetch1.next.next.next.next.next.next.next

  type _9 = Fetch1#Next#Next#Next#Next#Next#Next#Next#Next
  def _9: _9 = Fetch1.fetch1.next.next.next.next.next.next.next.next
}

object F extends F