package a23.step3

trait 挑战者I {
  type 挑战[N <: 困难] <: 挑战者I
  def 挑战[N <: 困难](n: N): 挑战[N]
}

trait 困难 {
  type byConfirm[N <: 挑战者I, T] <: 挑战者I
  def byConfirm[N <: 挑战者I, T](n: N, t: T): byConfirm[N, T]
}

class 挑战者[Tail1 <: 挑战者I, Head](val tail: () => Tail1, val head: Head) extends 挑战者I {
  println("构成奖励")

  override type 挑战[N <: 困难] = N#byConfirm[Tail1, Head]
  override def 挑战[N <: 困难](n: N): N#byConfirm[Tail1, Head] = {
    println("被困难降低数值")
    n.byConfirm(tail(), head)
  }

  override def toString: String = s"挑战者(${tail()}, ${head})"
}

class 困难Zero extends 困难 {
  override type byConfirm[N <: 挑战者I, T] = 挑战者[N, T]
  override def byConfirm[N <: 挑战者I, T](n: N, t: T): 挑战者[N, T] = {
    println("获得胜利")
    new 挑战者(() => n, t)
  }

  override def toString: String = s"困难Zero"
}

class 困难Positive[Tail <: 困难, Head](val tail: Tail, val head: Head) extends 困难 {
  println("构成遗憾")

  override type byConfirm[N <: 挑战者I, T] = 挑战者[挑战者[N#挑战[Tail], Head], T]
  override def byConfirm[N <: 挑战者I, T](n: N, t: T): 挑战者[挑战者[N#挑战[Tail], Head], T] = {
    println("挑战困难")
    new 挑战者(() => new 挑战者(() => n.挑战(tail), head), t)
  }

  override def toString: String = s"困难Positive(${tail}, ${head})"
}
