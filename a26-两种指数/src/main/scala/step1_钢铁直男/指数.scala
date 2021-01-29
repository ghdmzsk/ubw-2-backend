package step1_钢铁直男

trait 底 {
  type 乘以[N <: 底] <: 底
  type 加[N <: 底] <: 底
}

class 底Zero extends 底 {
  override type 乘以[N <: 底] = 底Zero
  override type 加[N <: 底]  = N
}

class 底Positive[Tail <: 底, Head] extends 底 {
  override type 乘以[N <: 底] = Tail#乘以[N]#加[N]
  override type 加[N <: 底]  = 底Positive[Tail#加[N], Head]
}

trait 幂 {
  type 阶乘[N <: 底] <: 底
}

class 幂1 extends 幂 {
  override type 阶乘[N <: 底] = N
}

class 幂Positive[Tail <: 幂] extends 幂 {
  override type 阶乘[N <: 底] = Tail#阶乘[N]#乘以[N]
}
