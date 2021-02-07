package 练习04

trait 加数 {
  type 正 <: 加数
  def 正: 正
}
class 加数Positive[Tail <: 加数, Head](val tail: Tail, val head: Head) extends 加数 {
  override type 正 = 加数Positive[Tail#正, Head]
  override def 正: 加数Positive[Tail#正, Head] = new 加数Positive(tail.正, head)
}
class 加数Positive3[Tail <: 加数, Head1, Head2, Head3](val tail3: Tail, val head1: Head1, val head2: Head2, val head3: Head3)
    extends 加数Positive[加数Positive[加数Positive[Tail, Head1], Head2], Head3](new 加数Positive(new 加数Positive(tail3, head1), head2), head3) {
  override type 正 = 加数Positive[加数Positive[加数Positive[Tail#正, Head1], Head2], Head3]
  override def 正: 加数Positive[加数Positive[加数Positive[Tail#正, Head1], Head2], Head3] = new 加数Positive(new 加数Positive(new 加数Positive(tail3.正, head1), head2), head3)
}
class 加数Zero extends 加数 {
  override type 正 = 加数Zero
  override def 正: 加数Zero = this
}
