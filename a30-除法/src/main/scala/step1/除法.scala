package step1

trait 被除数 {
  type 被除[N[_] <: 除数] <: 商
}
class 被除数Positive[Tail <: 被除数, Head] extends 被除数 {
  override type 被除[N[_] <: 除数] = N[Head]#除[Tail]
}
class 被除数Zero extends 被除数 {
  override type 被除[N[_] <: 除数] = 商Zero
}

trait 除数 {
  type 除[I <: 被除数] <: 商
}
class 除数Positive[Tail[_] <: 除数, Head] extends 除数 {
  override type 除[I <: 被除数] = I#被除[Tail]
}
class 除数1[Tail[_] <: 除数, Head] extends 除数 {
  override type 除[I <: 被除数] = 商Positive[I#被除[Tail]]
}

trait 商
class 商Positive[Tail <: 商] extends 商
class 商Zero                extends 商
