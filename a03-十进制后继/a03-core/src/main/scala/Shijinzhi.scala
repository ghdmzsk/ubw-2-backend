package shijinzhi

class Shijinzhi[T <: JinzhiItem, N <: Counter](val item: T, val count: N) {
  type Instance            = T
  type Add[D]              = Shijinzhi[N#Set#ItemAdd[T, D], N#Up]
  type Apply[J <: Counter] = J#Take[T]
  def add[D](d: D): Shijinzhi[N#Set#ItemAdd[T, D], N#Up] = new Shijinzhi(item = count.setter.itemAdd(item, d), count = count.up)
  def apply[J <: Counter](j: J): J#Take[T]               = j.take(item)

}

object Shijinzhi {
  type Zero = Shijinzhi[JinzhiZero, CounterPoint#_1]
  val zero: Shijinzhi[JinzhiZero, CounterPoint#_1] = new Shijinzhi(item = new JinzhiZero, count = CounterPoint.value._1)
}
