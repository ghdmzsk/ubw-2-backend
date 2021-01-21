package a23.step2

trait 自然数 {
  type Next[T] <: 自然数
  def next[T](t: T): Next[T]
}

trait 挑战者 extends 自然数 {
  type 挑战[N <: 困难] <: 自然数
  def 挑战[N <: 困难](n: N): 挑战[N]
  override type Next[T] <: 挑战者
  override def next[T](t: T): Next[T]
}

trait 困难 extends 自然数 {
  type byConfirm[N <: 挑战者, T] <: 自然数
  def byConfirm[N <: 挑战者, T](n: N, t: T): byConfirm[N, T]
  override type Next[T] <: 困难
  override def next[T](t: T): Next[T]
}

class 挑战者Zero extends 挑战者 {
  override type 挑战[N <: 困难] = N
  override def 挑战[N <: 困难](n: N): N = {
    println("挑战失败")
    n
  }
  override type Next[T] = 挑战者Positive[挑战者Zero, T]
  override def next[T](t: T): 挑战者Positive[挑战者Zero, T] = new 挑战者Positive(this, t)

  override def toString: String = "挑战者Zero"
}

class 挑战者Positive[Tail <: 挑战者, Head](val tail: Tail, val head: Head) extends 挑战者 {
  println("构成奖励")

  override type 挑战[N <: 困难] = N#byConfirm[Tail, Head]
  override def 挑战[N <: 困难](n: N): N#byConfirm[Tail, Head] = {
    println("被困难降低数值")
    n.byConfirm(tail, head)
  }
  override type Next[T] = 挑战者Positive[挑战者Positive[Tail, Head], T]
  override def next[T](t: T): 挑战者Positive[挑战者Positive[Tail, Head], T] = new 挑战者Positive(this, t)

  override def toString: String = s"挑战者Positive(${tail}, ${head})"
}

class 困难Zero extends 困难 {
  override type byConfirm[N <: 挑战者, T] = 挑战者Positive[N, T]
  override def byConfirm[N <: 挑战者, T](n: N, t: T): 挑战者Positive[N, T] = {
    println("获得胜利")
    new 挑战者Positive(n, t)
  }
  override type Next[T] = 困难Positive[困难Zero, T]
  override def next[T](t: T): 困难Positive[困难Zero, T] = new 困难Positive(this, t)

  override def toString: String = "困难Zero"
}

class 困难Positive[Tail <: 困难, Head](val tail: Tail, val head: Head) extends 困难 {
  println("构成遗憾")

  override type byConfirm[N <: 挑战者, T] = N#挑战[Tail]#Next[Head]#Next[T]
  override def byConfirm[N <: 挑战者, T](n: N, t: T): N#挑战[Tail]#Next[Head]#Next[T] = {
    println("挑战困难")
    n.挑战(tail).next(head).next(t)
  }
  override type Next[T] = 困难Positive[困难Positive[Tail, Head], T]
  override def next[T](t: T): 困难Positive[困难Positive[Tail, Head], T] = new 困难Positive(this, t)

  override def toString: String = s"困难Positive(${tail}, ${head})"
}
