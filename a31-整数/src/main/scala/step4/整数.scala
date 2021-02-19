package step4

trait 整数 {
  type 前驱 <: 整数
  type 后继[T] <: 整数
}

class 正数零 extends 整数 {
  override type 前驱    = 负数[({ type T1[I1] = 负数代理零 })#T1]#前驱
  override type 后继[T] = 正数[正数零, T]
}
class 正数[Tail <: 整数, Head] extends 整数 {
  override type 前驱    = Tail
  override type 后继[T] = 正数[正数[Tail, Head], T]
}

class 负数[R[_] <: 负数容器] extends 整数 {
  override type 前驱    = 负数[({ type T1[I1] = 负数代理[R, I1] })#T1]
  override type 后继[T] = R[T]#整
}

trait 负数容器 {
  type 整 <: 整数
}
class 负数代理零 extends 负数容器 {
  override type 整 = 正数零
}
class 负数代理[Tail[D] <: 负数容器, Head] extends 负数容器 {
  override type 整 = 负数[Tail]
}
