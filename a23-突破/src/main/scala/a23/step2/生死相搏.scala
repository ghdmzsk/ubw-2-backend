package a23.step2

trait 自然数 {
  type Next[T] <: 自然数
}

trait 挑战者 extends 自然数 {
  type 挑战[N <: 困难] <: 自然数
  override type Next[T] <: 挑战者
}

trait 困难 extends 自然数 {
  type byConfirm[N <: 挑战者, T] <: 自然数
  override type Next[T] <: 困难
}

class 挑战者Zero extends 挑战者 {
  override type 挑战[N <: 困难] = N
  override type Next[T]     = 挑战者Positive[挑战者Zero, T]
}

class 挑战者Positive[Tail <: 挑战者, Head] extends 挑战者 {
  override type 挑战[N <: 困难] = N#byConfirm[Tail, Head]
  override type Next[T]     = 挑战者Positive[挑战者Positive[Tail, Head], T]
}

class 困难Zero extends 困难 {
  override type byConfirm[N <: 挑战者, T] = 挑战者Positive[N, T]
  override type Next[T]                = 困难Positive[困难Zero, T]
}

class 困难Positive[Tail <: 困难, Head] extends 困难 {
  override type byConfirm[N <: 挑战者, T] = N#挑战[Tail]#Next[Head]#Next[T]
  override type Next[T]                = 困难Positive[困难Positive[Tail, Head], T]
}
