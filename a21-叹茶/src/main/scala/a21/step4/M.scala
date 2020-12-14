package a21.step4

trait 水线 {
  type 倒茶[茶水, I <: 茶, U] <: 可喝茶杯
}

class 满水线 extends 水线 {
  override type 倒茶[茶水, I <: 茶, U] = 加盖茶杯[I, U]
}

class 斟水线[Tail <: 水线] extends 水线 {
  override type 倒茶[茶水, I <: 茶, U] = 有水茶杯[Tail, 有茶[I, U], 茶水]
}

// ----

trait 茶 {
  type 喝茶[S <: 水线] <: 可斟茶杯
}

class 空茶 extends 茶 {
  override type 喝茶[S <: 水线] = 空茶杯[S]
}

class 有茶[Tail <: 茶, Head] extends 茶 {
  override type 喝茶[S <: 水线] = 有水茶杯[斟水线[S], Tail, Head]
}

// ----

trait 可斟茶杯 {
  type 斟茶[T] <: 可喝茶杯
}

trait 可喝茶杯 {
  type 叹茶 <: 可斟茶杯
}

class 空茶杯[S <: 水线] extends 可斟茶杯 {
  override type 斟茶[T] = 有水茶杯[S, 空茶, T]
}

class 有水茶杯[S <: 水线, I <: 茶, U] extends 可斟茶杯 with 可喝茶杯 {
  override type 斟茶[T] = S#倒茶[T, I, U]
  override type 叹茶    = I#喝茶[S]
}

class 加盖茶杯[I <: 茶, U] extends 可喝茶杯 {
  override type 叹茶 = 有水茶杯[满水线, I, U]
}
