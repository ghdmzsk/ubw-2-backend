package shijinzhi

class Shijinzhi[T <: JinzhiItem, N <: Jinzhi](val item: T, val count: N) {
  def add[D](d: D): Shijinzhi[N#Reverse#ItemAdd[T, D], N#Up] = new Shijinzhi(item = count.reverse.itemAdd(item, d), count = count.up)
}

object Shijinzhi {
  val zero: Shijinzhi[JinzhiZero, Leaf_1] = new Shijinzhi(item = new JinzhiZero, count = new Leaf_1)
}
