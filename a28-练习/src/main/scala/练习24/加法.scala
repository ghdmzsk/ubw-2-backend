package 练习24

trait Summand {
  def length: Int
}
object Summand {
  def fromInt(n: Int): Summand = n match {
    case n1 if n1 > 0 => new PositiveSummand(fromInt(n1 - 1))
    case 0            => new ZeroSummand
  }
}
trait Addend {
  def plus(summand: Summand): Summand
}
object Addend {
  def fromInt(n: Int): Addend = n match {
    case n1 if n1 > 0 => new PositiveAddend(fromInt(n1 - 1))
    case 0            => new ZeroAddend
  }
}
object Sum {
  def sum(summand: Summand, addend: Addend): Summand = addend.plus(summand)
}

class PositiveSummand(tail: Summand) extends Summand {
  override def length: Int = tail.length + 1
}
class ZeroSummand extends Summand {
  override def length: Int = 0
}

class PositiveAddend(tail: Addend) extends Addend {
  override def plus(summand: Summand): Summand = new PositiveSummand(tail.plus(summand))
}
class ZeroAddend extends Addend {
  override def plus(summand: Summand): Summand = summand
}
