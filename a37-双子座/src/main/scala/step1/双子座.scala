package step1

trait 被双子数 {
  type 升阳商[Y <: 圆数, YS <: 阳商] <: 商
  type 降阳商[Y <: 圆数, YS <: 阳商, Head] <: 商
  type 升阴商[Y <: 圆数, YS <: 阴商] <: 商
  type 降阴商[Y <: 圆数, YS <: 阴商, Head] <: 商
}
class 被双子数Positive[Tail <: 被双子数, Head] extends 被双子数 {
  override type 升阳商[Y <: 圆数, YS <: 阳商]       = Y#升阳商[Tail, 阳商Positive[YS, Head]]
  override type 降阳商[Y <: 圆数, YS <: 阳商, Head] = YS#被降[Tail, 圆数Positive[Y]]
  override type 升阴商[Y <: 圆数, YS <: 阴商]       = Y#升阴商[Tail, 阴商Positive[YS, Head]]
  override type 降阴商[Y <: 圆数, YS <: 阴商, Head] = YS#被降[Tail, 圆数Positive[Y]]
}
class 被双子数Zero extends 被双子数 {
  override type 升阳商[Y <: 圆数, YS <: 阳商]       = YS
  override type 降阳商[Y <: 圆数, YS <: 阳商, Head] = 阳商Positive[YS, Head]
  override type 升阴商[Y <: 圆数, YS <: 阴商]       = YS
  override type 降阴商[Y <: 圆数, YS <: 阴商, Head] = 阴商Positive[YS, Head]
}

trait 圆数 {
  type 升阳商[T <: 被双子数, YS <: 阳商] <: 商
  type 升阴商[T <: 被双子数, YS <: 阴商] <: 商
}
class 圆数Positive[Tail <: 圆数] extends 圆数 {
  override type 升阳商[T <: 被双子数, YS <: 阳商] = T#升阳商[Tail, YS]
  override type 升阴商[T <: 被双子数, YS <: 阴商] = T#升阴商[Tail, YS]
}
class 圆数Zero extends 圆数 {
  override type 升阳商[T <: 被双子数, YS <: 阳商] = YS#被降[T, 圆数Zero]
  override type 升阴商[T <: 被双子数, YS <: 阴商] = YS#被降[T, 圆数Zero]
}

trait 商 {
  type 被降[T <: 被双子数, Y <: 圆数] <: 商
}

trait 阴商 extends 商 {
  override type 被降[T <: 被双子数, Y <: 圆数] <: 商
}
class 阴商Positive[Tail <: 阴商, Head] extends 阴商 {
  override type 被降[T <: 被双子数, Y <: 圆数] = T#降阴商[Y, Tail, Head]
}
class 阴商Zero extends 阴商 {
  override type 被降[T <: 被双子数, Y <: 圆数] = Y#升阳商[T, 阳商Zero]
}

trait 阳商 extends 商 {
  type 被降[T <: 被双子数, Y <: 圆数] <: 商
}
class 阳商Positive[Tail <: 阳商, Head] extends 阳商 {
  override type 被降[T <: 被双子数, Y <: 圆数] = T#降阳商[Y, Tail, Head]
}
class 阳商Zero extends 阳商 {
  override type 被降[T <: 被双子数, Y <: 圆数] = Y#升阴商[T, 阴商Zero]
}

class 双子运算 {
  type 运算[T <: 被双子数, Y <: 圆数] = 阴商Zero#被降[T, Y]
}
