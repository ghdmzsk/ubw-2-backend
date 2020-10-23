package a16.第二阶

trait 被加数 {
  type 加[T <: 加数] <: 被加数
}

class 被加数零 extends 被加数 {
  override type 加[T <: 加数] = T#反向加[被加数零]
}

class 被加数正数[Tail <: 被加数, Head] extends 被加数 {
  override type 加[T <: 加数] = T#反向加[被加数正数[Tail, Head]]
}

trait 加数 {
  type 反向加[T <: 被加数] <: 被加数
}

class 加数零 extends 加数 {
  override type 反向加[T <: 被加数] = T
}

class 加数正数[Tail <: 加数, Head] extends 加数 {
  override type 反向加[T <: 被加数] = 被加数正数[Tail#反向加[T], Head]
}
