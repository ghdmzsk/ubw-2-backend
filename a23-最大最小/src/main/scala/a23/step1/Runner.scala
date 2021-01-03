package a23.step1

object Runner {
  class 类型匹配[T1]
  object 类型匹配 {
    def apply[T]: 类型匹配[T]                                 = new 类型匹配[T]
    def apply[T](i1: 类型匹配[T], i2: 类型匹配[T]): List[类型匹配[T]] = List(i1, i2)
  }

  class Item1
  class Item2
  class Item3
  class Item4
  class Item5
  class Item6
  class Item7

  type 被计算1 = 被计算Zero#Next[Item1]#Next[Item2]#Next[Item3]
  type 计算1  = 计算Zero#Next[Item4]#Next[Item5]#Next[Item6]#Next[Item7]
  类型匹配(类型匹配[被计算1#confirm[计算1]], 类型匹配[小于等于[被计算1, 计算1]])

  type 被计算2 = 被计算Zero#Next[Item1]#Next[Item2]#Next[Item3]#Next[Item4]
  type 计算2  = 计算Zero#Next[Item5]#Next[Item6]#Next[Item7]
  类型匹配(类型匹配[被计算2#confirm[计算2]], 类型匹配[大于[被计算2, 计算2]])

  type 被计算3 = 被计算Zero#Next[Item1]#Next[Item2]#Next[Item3]
  type 计算3  = 计算Zero#Next[Item4]#Next[Item5]#Next[Item6]
  类型匹配(类型匹配[被计算3#confirm[计算3]], 类型匹配[小于等于[被计算3, 计算3]])

  type 被计算4 = 被计算Zero#Next[Item1]#Next[Item2]
  type 计算4  = 计算Zero#Next[Item3]#Next[Item4]#Next[Item5]#Next[Item6]#Next[Item7]
  类型匹配(类型匹配[被计算4#confirm[计算4]], 类型匹配[小于等于[被计算4, 计算4]])

  type 被计算5 = 被计算Zero#Next[Item1]#Next[Item2]#Next[Item3]#Next[Item4]#Next[Item5]
  type 计算5  = 计算Zero#Next[Item6]#Next[Item7]
  类型匹配(类型匹配[被计算5#confirm[计算5]], 类型匹配[大于[被计算5, 计算5]])
}
