package step1

trait NumberT1 {
  def method1(t2: NumberT2, t3: NumberT3): NumberT4
}
object NumberT1 {
  def fromInt(n: Int): NumberT1 = {
    def fromIntImpl(n1: Int, p: () => NumberT1): NumberT1 = {
      n1 match {
        case n2 if n2 > 1 => new NumberT1Positive(fromIntImpl(n1 - 1, p))
        case 1            => new NumberT1Zero(p)
      }
    }
    def nn: NumberT1 = fromIntImpl(n, () => nn)
    nn
  }
}
trait NumberT2 {
  def method2(t3: NumberT3, t1: NumberT1): NumberT4
}
object NumberT2 {
  def fromInt(n: Int): NumberT2 = {
    def fromIntImpl(n1: Int, p: () => NumberT2): NumberT2 = {
      n1 match {
        case n2 if n2 > 1 => new NumberT2Positive(fromIntImpl(n1 - 1, p))
        case 1            => new NumberT2One(p)
      }
    }
    def nn: NumberT2 = fromIntImpl(n, () => nn)
    nn
  }
}
trait NumberT3 {
  def method3(t1: NumberT1, t2: NumberT2): NumberT4
}
object NumberT3 {
  def fromInt(n: Int): NumberT3 = n match {
    case n1 if n1 > 0 => new NumberT3Positive(fromInt(n1 - 1))
    case 0            => new NumberT3Zero
  }
}

class NumberT1Positive(tail: NumberT1) extends NumberT1 {
  override def method1(t2: NumberT2, t3: NumberT3): NumberT4 = t2.method2(t3, tail)
}
class NumberT1Zero(tail: () => NumberT1) extends NumberT1 {
  override def method1(t2: NumberT2, t3: NumberT3): NumberT4 = new NumberT4Positive(tail().method1(t2, t3))
}
class NumberT2Positive(tail: NumberT2) extends NumberT2 {
  override def method2(t3: NumberT3, t1: NumberT1): NumberT4 = t1.method1(tail, t3)
}
class NumberT2One(tail: () => NumberT2) extends NumberT2 {
  override def method2(t3: NumberT3, t1: NumberT1): NumberT4 = t3.method3(t1, tail())
}
class NumberT3Positive(tail: NumberT3) extends NumberT3 {
  override def method3(t1: NumberT1, t2: NumberT2): NumberT4 = t2.method2(tail, t1)
}
class NumberT3Zero extends NumberT3 {
  override def method3(t1: NumberT1, t2: NumberT2): NumberT4 = new NumberT4Zero
}

trait NumberT4 {
  def length: Int
}
class NumberT4Positive(tail: NumberT4) extends NumberT4 {
  override def length: Int = tail.length + 1
}
class NumberT4Zero extends NumberT4 {
  override def length: Int = 0
}
object NumberT4 {
  def count(t3: NumberT3, t2: NumberT2, t1: NumberT1): NumberT4 = t3.method3(t1, t2)
}
