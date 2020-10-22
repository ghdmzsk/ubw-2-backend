package a15.小测试

trait 二进制数 {
  type Next[T] <: 二进制数
  type 修改上一位[T, R <: 二进制数] <: 二进制数
  type Plus[R <: 二进制数] <: 二进制数
}

class 零 extends 二进制数 {
  type _0                           = 零
  override type Next[T]             = 壹[T, 零]
  override type 修改上一位[T, R <: 二进制数] = R
  override type Plus[R <: 二进制数]     = R
}

class 壹[T1, T2 <: 二进制数] extends 二进制数 {
  type _0                           = T2
  type TH                           = T1
  override type Next[T]             = 壹进制[壹[T, 零], 壹[T1, 零]]
  override type 修改上一位[T, R <: 二进制数] = R#Next[T]
  override type Plus[R <: 二进制数] <: 二进制数
}

/*class 进位[T1, T2] extends 二进制数 {
  override type Next[T] <: 二进制数
  override type 修改上一位[T, R <: 二进制数] <: 二进制数
  override type Plus[R <: 二进制数] <: 二进制数
}*/

class 壹进制[T1 <: 二进制数, T2 <: 二进制数] extends 二进制数 {
  type _1 = T1
  override type Next[T] <: 二进制数
  override type 修改上一位[T, R <: 二进制数] = T2#修改上一位[T, R]
  override type Plus[R <: 二进制数] <: 二进制数
}

/*class 进位进制[T1 <: 二进制数, T2 <: 二进制数] extends 二进制数 {
  override type Next[T] <: 二进制数
  override type 修改上一位[T, R <: 二进制数] <: 二进制数
  override type Plus[R <: 二进制数] <: 二进制数
}*/
