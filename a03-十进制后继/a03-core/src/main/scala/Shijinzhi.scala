package shijinzhi

class Shijinzhi[T <: JinzhiItem, N <: Jinzhi](val item: T, val count: N) {
  type Instance = T
  type Add[D]   = Shijinzhi[N#Reverse#ItemAdd[T, D], N#Up]
  def add[D](d: D): Shijinzhi[N#Reverse#ItemAdd[T, D], N#Up] = new Shijinzhi(item = count.reverse.itemAdd(item, d), count = count.up)
  def apply[J <: Jinzhi](j: J): J#Take[T]                    = j.take(item)
}

object Shijinzhi {
  type Zero = Shijinzhi[JinzhiZero, Node_1[Point]]
  val zero: Shijinzhi[JinzhiZero, Node_1[Point]] = new Shijinzhi(item = new JinzhiZero, count = new Node_1(Point.value))
}
