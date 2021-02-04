package 运行时测试

trait Item {
  def name: String
}

trait 底 {
  def 交(i: 容器): 自然数
  def 退位(i: 容器, t: 指数, n: 底): 自然数
}
class 底Positive(tailI: () => 底, val head: Item) extends 底 {
  private lazy val tail: 底                 = tailI()
  override def 交(i: 容器): 自然数               = new 自然数Positive(tail.交(i), head)
  override def 退位(i: 容器, t: 指数, n: 底): 自然数 = t.指(n, new 容器Positive(i, tail, t))
}
class 底1(totalI: () => 底, val head: Item) extends 底 {
  private lazy val total: 底                = totalI()
  override def 交(i: 容器): 自然数               = new 自然数Positive(i.容器恢复(total), head)
  override def 退位(i: 容器, t: 指数, n: 底): 自然数 = i.容器恢复(total)
}

trait 指数 {
  def 指(n: 底, i: 容器): 自然数
}

object 指数 {
  def 指数(n: 底, t: 指数): 自然数 = t.指(n, new 容器Zero)
}

class 指数Positive(tail: 指数) extends 指数 {
  override def 指(n: 底, i: 容器): 自然数 = tail.指(n, new 容器Positive(i, n, tail))
}
class 指数1 extends 指数 {
  override def 指(n: 底, i: 容器): 自然数 = n.交(i)
}

trait 容器 {
  def 容器恢复(n: 底): 自然数
}
class 容器Positive(tail: 容器, head1: 底, head2: 指数) extends 容器 {
  override def 容器恢复(N: 底): 自然数 = head1.退位(tail, head2, N)
}
class 容器Zero extends 容器 {
  override def 容器恢复(N: 底): 自然数 = new 自然数Zero
}

trait 自然数 {
  def length: Int
}
class 自然数Positive(tail: 自然数, head: Item) extends 自然数 {
  override val length: Int      = tail.length + 1
  override val toString: String = s"$tail :: ${head.name}"
}
class 自然数Zero extends 自然数 {
  override val length: Int      = 0
  override val toString: String = "自然数Zero"
}
