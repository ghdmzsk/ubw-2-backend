package step3

/*trait 整数 {
  type input[T] <: 负数容器
  type 加[T <: 整数] <: 整数
  type 辅助加[T[_] <: 负数容器, N] <: 整数
}

class 负数[R[_] <: 负数容器] extends 整数 {
  override type input[T]          = R[T]
  override type 加[T <: 整数]        = 负数[({ type T1[N1] = T#辅助加[R, N1] })#T1]
  override type 辅助加[T[_] <: 负数容器] = 负数[({ type T1[N1] = R[N1]#辅助加[T] })#T1]
}

trait 负数容器 {
  type 辅助加[T[_] <: 负数容器] <: 整数
}
class 负数代理零 extends 负数容器 {
  override type 辅助加[T[_] <: 负数容器] = 负数[T]
}
class 负数代理[Tail[D] <: 负数容器, Head] extends 负数容器 {
  override type 辅助加[T[_] <: 负数容器] = 负数[({ type T2[N2] = 负数代理[({ type T1[N1] = Tail[N1]#辅助加[T] })#T1, Head] })#T2]
}*/
