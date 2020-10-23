package a16.第三阶

class 加法 {
  type 相加[T1 <: 被加数, T2 <: 加数] = T2#反向加[T1]
}

trait 被加数

class 被加数零 extends 被加数

class 被加数正数[Tail <: 被加数, Head] extends 被加数

trait 加数 {
  type 反向加[T <: 被加数] <: 被加数
}

class 加数零 extends 加数 {
  override type 反向加[T <: 被加数] = T
}

class 加数正数[Tail <: 加数, Head] extends 加数 {
  override type 反向加[T <: 被加数] = 被加数正数[Tail#反向加[T], Head]
}
