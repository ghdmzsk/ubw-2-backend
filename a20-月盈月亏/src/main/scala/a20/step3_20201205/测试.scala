package a20.step3_20201205

object 测试 {
  class 新月
  class 上弦
  class 渐盈
  class 满月

  class 匹配[T]

  object 匹配 {
    def apply[T]: 匹配[T]                          = new 匹配[T]
    def 匹配[T](i1: 匹配[T], i2: 匹配[T]): List[匹配[T]] = List(i1, i2)
  }

  type Moon1 = MoonInit[NatPositive[NatPositive[NatPositive[NatZero, 满月], 渐盈], 上弦], 新月]

  匹配.匹配(匹配[新月], 匹配[Moon1#Current])
  匹配.匹配(匹配[上弦], 匹配[Moon1#Next#Current])
  匹配.匹配(匹配[渐盈], 匹配[Moon1#Next#Next#Current])
  匹配.匹配(匹配[满月], 匹配[Moon1#Next#Next#Next#Current])
  匹配.匹配(匹配[满月], 匹配[Moon1#Next#Next#Next#Next#Current])
  匹配.匹配(匹配[渐盈], 匹配[Moon1#Next#Next#Next#Next#Next#Current])
  匹配.匹配(匹配[上弦], 匹配[Moon1#Next#Next#Next#Next#Next#Next#Current])
  匹配.匹配(匹配[新月], 匹配[Moon1#Next#Next#Next#Next#Next#Next#Next#Current])
  匹配.匹配(匹配[新月], 匹配[Moon1#Next#Next#Next#Next#Next#Next#Next#Next#Current])
  匹配.匹配(匹配[上弦], 匹配[Moon1#Next#Next#Next#Next#Next#Next#Next#Next#Next#Current])

  type Moon2 = Moon1#Next#Next#Next#Next#Next#Next#Next#Next#Next#Next
  匹配.匹配(匹配[渐盈], 匹配[Moon2#Current])
  匹配.匹配(匹配[满月], 匹配[Moon2#Next#Current])
  匹配.匹配(匹配[满月], 匹配[Moon2#Next#Next#Current])
  匹配.匹配(匹配[渐盈], 匹配[Moon2#Next#Next#Next#Current])
  匹配.匹配(匹配[上弦], 匹配[Moon2#Next#Next#Next#Next#Current])
  匹配.匹配(匹配[新月], 匹配[Moon2#Next#Next#Next#Next#Next#Current])
  匹配.匹配(匹配[新月], 匹配[Moon2#Next#Next#Next#Next#Next#Next#Current])
  匹配.匹配(匹配[上弦], 匹配[Moon2#Next#Next#Next#Next#Next#Next#Next#Current])
  匹配.匹配(匹配[渐盈], 匹配[Moon2#Next#Next#Next#Next#Next#Next#Next#Next#Current])

}
