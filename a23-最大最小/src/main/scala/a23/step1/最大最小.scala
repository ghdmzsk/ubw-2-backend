package a23.step1

trait 关系 {
  type Next[T1, T2] <: 关系
}
class 大于[N1 <: 被计算, N2 <: 计算] extends 关系 {
  override type Next[T1, T2] = 大于[被计算Positive[N1, T1], 计算Positive[N2, T2]]
}
class 小于等于[N1 <: 被计算, N2 <: 计算] extends 关系 {
  override type Next[T1, T2] = 小于等于[被计算Positive[N1, T1], 计算Positive[N2, T2]]
}

trait 自然数 {
  type Next[T] <: 自然数
}

trait 被计算 extends 自然数 {
  override type Next[T] <: 被计算
  type confirm[N <: 计算] <: 关系
}

trait 计算 extends 自然数 {
  override type Next[T] <: 计算
  type byConfirm[N <: 被计算, T] <: 关系
}

class 被计算Zero extends 被计算 {
  override type Next[T]          = 被计算Positive[被计算Zero, T]
  override type confirm[N <: 计算] = 小于等于[被计算Zero, N]
}

class 被计算Positive[Tail <: 被计算, Head] extends 被计算 {
  override type Next[T]          = 被计算Positive[被计算Positive[Tail, Head], T]
  override type confirm[N <: 计算] = N#byConfirm[Tail, Head]
}

class 计算Zero extends 计算 {
  override type Next[T]                = 计算Positive[计算Zero, T]
  override type byConfirm[N <: 被计算, T] = 大于[被计算Positive[N, T], 计算Zero]
}

class 计算Positive[Tail <: 计算, Head] extends 计算 {
  override type Next[T]                = 计算Positive[计算Positive[Tail, Head], T]
  override type byConfirm[N <: 被计算, T] = N#confirm[Tail]#Next[T, Head]
}
