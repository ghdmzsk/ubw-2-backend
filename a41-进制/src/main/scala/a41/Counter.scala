package a41

case class Item(name: String)

trait Number13 {
  self: Number1 =>
  def apply(number8: Number8): Item = number8.method9(this)
}

trait Number1 extends Number13 {
  def method1(item: Item): Number1
}
trait Number2 {
  def method2(number3: Number3, item: Item): Number1
}
trait Number3 {
  def method3(item: Number2): Number1
}
trait Number4 {
  def method4(item: Item): Number1
}
trait Number5 {
  def method5(number7: Number7, item: Item): Number1
}
trait Number6 {
  def method6(item: Item): Number1
}
trait Number7 {
  def method7(number5: Number5): Number1
  def method8(number5: Number5, item: Number5): Number1
}

case object Number1PSimple0 extends Number1 {
  override def method1(item: Item): Number1 = Number1PSimple1(item)
}
case class Number1PSimple1(t1: Item) extends Number1 {
  override def method1(item: Item): Number1 = Number1PSimple2(t1 = t1, t2 = item)
}
case class Number1PSimple2(t1: Item, t2: Item) extends Number1 {
  override def method1(item: Item): Number1 = Number1PSimple3(t1 = t1, t2 = t2, Number2Zero0(Number5Bottom0(item)))
}
case class Number1PSimple3(t1: Item, t2: Item, tail: Number2) extends Number1 {
  override def method1(item: Item): Number1 = tail.method2(Number3PSimple3(t1 = t1, t2 = t2), item)
}
case class Number2PDeep3(n0: Number5, n1: Number5, tail: Number2) extends Number2 {
  override def method2(number3: Number3, item: Item): Number1 = tail.method2(Number3PDeep3(n0 = n0, n1 = n1, tail = number3), item)
}
case class Number2Zero0(n0: Number5) extends Number2 {
  override def method2(number3: Number3, item: Item): Number1 = Number4Zero0(n0 = n0, tail = number3).method4(item)
}
case class Number2Zero1(n0: Number5, n1: Number5) extends Number2 {
  override def method2(number3: Number3, item: Item): Number1 = Number4Zero1(n0 = n0, n1 = n1, tail = number3).method4(item)
}

case class Number3PSimple3(t1: Item, t2: Item) extends Number3 {
  override def method3(item: Number2): Number1 = Number1PSimple3(t1 = t1, t2 = t2, tail = item)
}
case class Number3PDeep3(n0: Number5, n1: Number5, tail: Number3) extends Number3 {
  override def method3(item: Number2): Number1 = tail.method3(Number2PDeep3(n0 = n0, n1 = n1, item))
}

case class Number4Zero0(n0: Number5, tail: Number3) extends Number4 {
  def method4(item: Item): Number1 = n0.method5(Number7Bottom0(tail = tail), item)
}
case class Number4Zero1(n0: Number5, n1: Number5, tail: Number3) extends Number4 {
  def method4(item: Item): Number1 = n1.method5(Number7Bottom1(n0 = n0, tail = tail), item)
}

case class Number5Middle0(n0: Number5) extends Number5 {
  override def method5(number7: Number7, item: Item): Number1 = n0.method5(Number7Middle0(tail = number7), item)
}
case class Number5Middle1(n0: Number5, n1: Number5) extends Number5 {
  override def method5(number7: Number7, item: Item): Number1 = n1.method5(Number7Middle1(n0 = n0, tail = number7), item)
}
case class Number5Middle2(n0: Number5, n1: Number5, n2: Number5) extends Number5 {
  override def method5(number7: Number7, item: Item): Number1 = n2.method5(Number7Middle2(n0 = n0, n1 = n1, tail = number7), item)
}

case class Number5Bottom0(n0: Item) extends Number5 {
  override def method5(number7: Number7, item: Item): Number1 = Number6Top0(n0 = n0, tail = number7).method6(item)
}
case class Number5Bottom1(n0: Item, n1: Item) extends Number5 {
  override def method5(number7: Number7, item: Item): Number1 = Number6Top1(n0 = n0, n1 = n1, tail = number7).method6(item)
}
case class Number5Bottom2(n0: Item, n1: Item, n2: Item) extends Number5 {
  override def method5(number7: Number7, item: Item): Number1 = Number6Top2(n0 = n0, n1 = n1, n2 = n2, tail = number7).method6(item)
}

case class Number6Top0(n0: Item, tail: Number7) extends Number6 {
  def method6(item: Item): Number1 = tail.method7(Number5Bottom1(n0 = n0, n1 = item))
}
case class Number6Top1(n0: Item, n1: Item, tail: Number7) extends Number6 {
  def method6(item: Item): Number1 = tail.method7(Number5Bottom2(n0 = n0, n1 = n1, n2 = item))
}
case class Number6Top2(n0: Item, n1: Item, n2: Item, tail: Number7) extends Number6 {
  override def method6(item: Item): Number1 = tail.method8(Number5Bottom2(n0 = n0, n1 = n1, n2 = n2), Number5Bottom0(n0 = item))
}

case class Number7Middle0(tail: Number7) extends Number7 {
  override def method7(number5: Number5): Number1                = tail.method7(Number5Middle0(n0 = number5))
  override def method8(number5: Number5, item: Number5): Number1 = tail.method7(Number5Middle1(n0 = number5, n1 = item))
}
case class Number7Middle1(n0: Number5, tail: Number7) extends Number7 {
  override def method7(number5: Number5): Number1                = tail.method7(Number5Middle1(n0 = n0, n1 = number5))
  override def method8(number5: Number5, item: Number5): Number1 = tail.method7(Number5Middle2(n0 = n0, n1 = number5, n2 = item))
}
case class Number7Middle2(n0: Number5, n1: Number5, tail: Number7) extends Number7 {
  override def method7(number5: Number5): Number1                = tail.method7(Number5Middle2(n0 = n0, n1 = n1, n2 = number5))
  override def method8(number5: Number5, item: Number5): Number1 = tail.method8(Number5Middle2(n0 = n0, n1 = n1, n2 = number5), Number5Middle0(item))
}

case class Number7Bottom0(tail: Number3) extends Number7 {
  override def method7(number5: Number5): Number1                = tail.method3(Number2Zero0(number5))
  override def method8(number5: Number5, item: Number5): Number1 = tail.method3(Number2Zero1(number5, item))
}
case class Number7Bottom1(n0: Number5, tail: Number3) extends Number7 {
  override def method7(number5: Number5): Number1                = tail.method3(Number2Zero1(n0, number5))
  override def method8(number5: Number5, item: Number5): Number1 = tail.method3(Number2PDeep3(n0, number5, Number2Zero0(Number5Middle0(item))))
}
