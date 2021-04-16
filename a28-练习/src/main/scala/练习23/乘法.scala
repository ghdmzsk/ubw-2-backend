package 练习23

trait NumberT1 {
  def multiplyT1(t2: NumberT2, t3: NumberT3): Product
}
object NumberT1 {
  def fromInt(n: Int): NumberT1 = n match {
    case n1 if n1 > 1 => new NumberT1Positive(fromInt(n1 - 1))
    case 1            => new NumberT1One
  }
}
trait NumberT2 {
  def multiplyT2(t3: NumberT3, t1: NumberT1): Product
}
object NumberT2 {
  def fromInt(n: Int): NumberT2 = {
    def fromIntImpl(n1: Int, p: () => NumberT2): NumberT2 = n1 match {
      case n2 if n2 > 1 => new NumberT2Positive(fromIntImpl(n2 - 1, p))
      case 1            => new NumberT2One(p)
    }
    lazy val p2: NumberT2 = fromIntImpl(n, () => p2)
    p2
  }
}
trait NumberT3 {
  def multiplyT3(t1: NumberT1, t2: NumberT2): Product
}
object NumberT3 {
  def fromInt(n: Int): NumberT3 = {
    def fromIntImpl(n1: Int, p: () => NumberT3): NumberT3 = n1 match {
      case n2 if n2 > 0 => new NumberT3Positive(fromIntImpl(n2 - 1, p))
      case 0            => new NumberT3Zero(p)
    }
    lazy val p2: NumberT3 = fromIntImpl(n, () => p2)
    p2
  }
}

class NumberT1Positive(val tail: NumberT1) extends NumberT1 {
  override def multiplyT1(t2: NumberT2, t3: NumberT3): Product = t3.multiplyT3(tail, t2)
}
class NumberT1One extends NumberT1 {
  override def multiplyT1(t2: NumberT2, t3: NumberT3): Product = new ZeroProduct
}
class NumberT2Positive(val tail: NumberT2) extends NumberT2 {
  override def multiplyT2(t3: NumberT3, t1: NumberT1): Product = t3.multiplyT3(t1, tail)
}
class NumberT2One(val tail: () => NumberT2) extends NumberT2 {
  lazy val tail1                                               = tail()
  override def multiplyT2(t3: NumberT3, t1: NumberT1): Product = t1.multiplyT1(tail1, t3)
}
class NumberT3Positive(val tail: NumberT3) extends NumberT3 {
  override def multiplyT3(t1: NumberT1, t2: NumberT2): Product = new PositiveProduct(tail.multiplyT3(t1, t2))
}
class NumberT3Zero(val tail: () => NumberT3) extends NumberT3 {
  lazy val tail1                                               = tail()
  override def multiplyT3(t1: NumberT1, t2: NumberT2): Product = t2.multiplyT2(tail1, t1)
}

trait Product {
  def length: Int
}
class PositiveProduct(val tail: Product) extends Product {
  override def length: Int = tail.length + 1
}
class ZeroProduct extends Product {
  override val length: Int = 0
}
object Product {
  def mutiply(t1: NumberT1, t2: NumberT2, t3: NumberT3): Product = t3.multiplyT3(t1, t2)
}
