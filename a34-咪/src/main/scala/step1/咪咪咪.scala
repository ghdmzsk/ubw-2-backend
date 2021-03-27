package step1

trait 底数 {
  def length: 咪
}

class 底数1 extends 底数 {
  override val length: 咪 = 咪(1)
}
class 底数3_Positive[I1 <: 底数, I2 <: 底数, I3 <: 底数](i1: I1, i2: I2, i3: I3) extends 底数 {
  override def length: 咪 = i1.length + i2.length + i3.length
}

trait 指数 {
  type 指[I <: 底数] <: 底数
  def 指[I <: 底数](i: I): 指[I]
}
class 指数Positive[Tail <: 指数](tail: Tail) extends 指数 {
  override type 指[I <: 底数] = Tail#指[底数3_Positive[I, I, I]]
  override def 指[I <: 底数](i: I): Tail#指[底数3_Positive[I, I, I]] = tail.指(new 底数3_Positive(i, i, i))
}
class 指数Zero extends 指数 {
  override type 指[I <: 底数] = I
  override def 指[I <: 底数](i: I): I = i
}

case class 咪(len: Int) {
  def +(other: 咪): 咪 = 咪(len + other.len)
}
