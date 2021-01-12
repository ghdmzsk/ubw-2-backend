package 除.step1

trait 商
class 商Zero             extends 商
class 商Positive[I <: 商] extends 商

trait 被除数 {
  type 除以[N <: 除数] <: 商
}

class 被除数Zero extends 被除数 {
  override type 除以[N <: 除数] = 商Zero
}

class 被除数Positive[Tail <: 被除数, Head] extends 被除数 {
  override type 除以[N <: 除数] = N#除[Tail]
}

trait 除数 {
  type 除[CTail <: 被除数] <: 商
}

trait 除数Zero[Tail <: 除数] extends 除数 {
  override type 除[CTail <: 被除数] = 商Positive[Tail#除[CTail]]
}

trait 除数Positive[Tail <: 除数] extends 除数 {
  override type 除[CTail <: 被除数] = CTail#除以[Tail]
}
