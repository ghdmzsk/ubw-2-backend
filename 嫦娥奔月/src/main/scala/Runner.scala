object Runner extends App {

  class 新月 {
    override def toString = "新月"
  }
  class 上弦 {
    override def toString = "上弦"
  }
  class 渐盈 {
    override def toString = "渐盈"
  }
  class 满月 {
    override def toString = "满月"
  }

  object Init extends YQImpl(YueyuanZero.add(new 满月).add(new 渐盈).add(new 上弦).add(new 新月), YueyuanZero)

  val a1: 新月 = Init.current
  val a2: 新月 = Init.next.current
  val a3: 上弦 = Init.next.next.current
  val a4: 渐盈 = Init.next.next.next.current

  val a5: 满月 = Init.next.next.next.next.current
  val a6: 满月 = Init.next.next.next.next.next.current
  val a7: 渐盈 = Init.next.next.next.next.next.next.current

  val a8: 上弦 = Init.next.next.next.next.next.next.next.current
  val a9: 新月 = Init.next.next.next.next.next.next.next.next.current

  val Init10  = Init.next.next.next.next.next.next.next.next.next
  val a10: 新月 = Init10.current
  val a11: 上弦 = Init10.next.current
  val a12: 渐盈 = Init10.next.next.current
  val a13: 满月 = Init10.next.next.next.current
  val a14: 满月 = Init10.next.next.next.next.current
  val a15: 渐盈 = Init10.next.next.next.next.next.current
  val a16: 上弦 = Init10.next.next.next.next.next.next.current

  println(a1)
  println(a2)
  println(a3)
  println(a4)
  println(a5)
  println(a6)
  println(a7)
  println(a8)
  println(a9)
  println(a10)
  println(a11)
  println(a12)
  println(a13)
  println(a14)
  println(a15)
  println(a16)

}
