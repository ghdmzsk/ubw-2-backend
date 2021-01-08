package a23.step3

trait 挑战者I {
  type Tail <: 挑战者I
  type 挑战[N <: 困难] <: 挑战者I
}

trait 困难 {
  type byConfirm[N <: 挑战者I, T] <: 挑战者I
}

class 挑战者[Tail1 <: 挑战者I, Head] extends 挑战者I {
  override type Tail        = Tail1
  override type 挑战[N <: 困难] = N#byConfirm[Tail, Head]
}

class 困难Zero extends 困难 {
  override type byConfirm[N <: 挑战者I, T] = 挑战者[N, T]
}

class 困难Positive[Tail <: 困难, Head] extends 困难 {
  override type byConfirm[N <: 挑战者I, T] = 挑战者[挑战者[N#挑战[Tail], Head], T]
}
