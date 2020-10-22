package a14.魔王勇者

class 类型匹配[T] {
  def 匹配(i: 类型匹配[T]): 类型匹配[T] = i
}

object 类型匹配 {
  def apply[T] = new 类型匹配[T]
}
