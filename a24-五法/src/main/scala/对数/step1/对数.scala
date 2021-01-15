package 对数.step1

trait 底数 {
  type 被对[I <: 真数, Head, T <: 对数] <: 对数
  type 深度被对[I <: 真数, Head, T <: 对数] <: 真数
  type 直对花心[I <: 真数, Head] <: 真数
  type 天道消去[I <: 真数, Head] <: 广义对数
}

trait 底数Positive[Total <: 底数, Tail <: 底数] extends 底数 {
  override type 被对[I <: 真数, Head, T <: 对数]   = T#对[I, Head, Total]#天道索求[Tail, T]
  override type 深度被对[I <: 真数, Head, T <: 对数] = T#对[I, Head, Total]#深度索求[Tail, T]
  override type 直对花心[I <: 真数, Head]          = I#地道索求[Tail]
  override type 天道消去[I <: 真数, Head]          = I#内部对[Tail]
}

trait 底数One[Tail <: 底数] extends 底数 {
  override type 被对[I <: 真数, Head, T <: 对数]   = Tail#被对[I, Head, 对数Positive[T]]
  override type 深度被对[I <: 真数, Head, T <: 对数] = T#对[I, Head, Tail]
  override type 直对花心[I <: 真数, Head]          = I
  override type 天道消去[I <: 真数, Head]          = Tail#被对[I, Head, 对数1]
}

trait 真数 {
  type 对[N <: 底数]
  type 内部对[N <: 底数] <: 广义对数
  type 地道索求[N <: 底数] <: 真数
  type 深度索求[N <: 底数, T <: 对数] <: 真数
  type 天道索求[N <: 底数, T <: 对数] <: 对数
}

class 真数Positive[Tail <: 真数, Head] extends 真数 {
  override type 对[N <: 底数]             = 内部对[N]
  override type 内部对[N <: 底数]           = N#天道消去[Tail, Head]
  override type 地道索求[N <: 底数]          = N#直对花心[Tail, Head]
  override type 深度索求[N <: 底数, T <: 对数] = N#深度被对[Tail, Head, T]
  override type 天道索求[N <: 底数, T <: 对数] = N#被对[Tail, Head, T]
}

class 真数Zero extends 真数 {
  override type 对[N <: 底数]             = 对数特殊负无穷
  override type 内部对[N <: 底数]           = 对数Zero
  override type 地道索求[N <: 底数]          = 真数Zero
  override type 深度索求[N <: 底数, T <: 对数] = 真数Zero
  override type 天道索求[N <: 底数, T <: 对数] = T
}

trait 广义对数

class 对数Zero  extends 广义对数
class 对数特殊负无穷 extends 广义对数

trait 对数 extends 广义对数 {
  type 对[I <: 真数, Head, N <: 底数] <: 真数
}

class 对数Positive[Tail <: 对数] extends 对数 {
  override type 对[I <: 真数, Head, N <: 底数] = N#深度被对[I, Head, Tail]
}

class 对数1 extends 对数 {
  override type 对[I <: 真数, Head, N <: 底数] = N#直对花心[I, Head]
}
