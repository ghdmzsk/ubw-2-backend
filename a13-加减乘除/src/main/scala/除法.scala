package a13.除法

trait 自然数 {
  type Next[T] <: 自然数
}

trait 被除数 extends 自然数 {
  override type Next[T] <: 被除数
}

trait 除数 extends 自然数 {
  override type Next[T] <: 除数
}

trait 自然数对 {
  type Next[T1, T2] <: 自然数对
}

class 自然数对零 extends 自然数对 {
  override type Next[T1, T2] = 自然数对正数[自然数对零, T1, T2]
}

class 自然数对正数[Tail <: 自然数对, Head1, Head2] extends 自然数对 {
  override type Next[T1, T2] = 自然数对正数[自然数对正数[Tail, Head1, Head2], T1, T2]
}

trait 商 {
  type Next[T <: 自然数对] <: 商
  type 虚 <: 虚商
}

class 商零 extends 商 {
  override type Next[T <: 自然数对] = 商正数[商零, T]
  override type 虚               = 虚商零
}

class 商正数[Tail <: 商, Head <: 自然数对] extends 商 {
  override type Next[T <: 自然数对] = 商正数[商正数[Tail, Head], T]
  override type 虚               = 虚商正数[Tail#虚]
}

trait 虚商 {
  type Next <: 虚商
}

class 虚商零 extends 虚商 {
  override type Next = 虚商正数[虚商零]
}

class 虚商正数[Tail <: 虚商] extends 虚商 {
  override type Next = 虚商正数[虚商正数[Tail]]
}

class 被除数零 extends 被除数 {
  override type Next[T] = 被除数正数[被除数零, T]
}

class 被除数正数[Tail <: 被除数, Head] extends 被除数 {
  override type Next[T] = 被除数正数[被除数正数[Tail, Head], T]
}

class 除数零 extends 除数 {
  override type Next[T] = 除数正数[除数零, T]
}

class 除数正数[Tail <: 除数, Head] extends 除数 {
  override type Next[T] = 除数正数[除数正数[Tail, Head], T]
}
