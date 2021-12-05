package 练习25

object Runner {

  def i1[T1, T2]: (类型匹配[T1], 类型匹配[T2])            = (new 类型匹配[T1], new 类型匹配[T2])
  def i2[T](i: (类型匹配[T], 类型匹配[T])): List[类型匹配[T]] = List(i._1, i._2)
  class 类型匹配[T]

  type 乘数值1 = b被乘数Positive[b被乘数Positive[b被乘数Positive[b被乘数Zero]]] // 3
  class 乘数值2 extends c乘数Positive[c乘数Positive[乘数值3]] // 2
  class 乘数值3 extends c乘数Zero[乘数值2]

  type 结果1 = z自然数Positive[z自然数Positive[z自然数Positive[z自然数Positive[z自然数Positive[z自然数Positive[z自然数Zero]]]]]] // 6

  i2(i1[乘数值1#被乘[乘数值2], 结果1]) // 3 * 2 = 6
  i2(i1[乘数值3#乘[乘数值1], 结果1])  // 2 * 3 = 6

  type 乘数值4 = b被乘数Positive[b被乘数Positive[b被乘数Positive[b被乘数Positive[b被乘数Positive[b被乘数Zero]]]]] // 5
  class 乘数值5 extends c乘数Positive[c乘数Positive[c乘数Positive[乘数值6]]] // 3
  class 乘数值6 extends c乘数Zero[乘数值5]

  type 结果2 =
    z自然数Positive[z自然数Positive[z自然数Positive[z自然数Positive[z自然数Positive[z自然数Positive[z自然数Positive[z自然数Positive[z自然数Positive[结果1]]]]]]]]] // 15

  i2(i1[乘数值4#被乘[乘数值5], 结果2]) // 5 * 3 = 15
  i2(i1[乘数值6#乘[乘数值4], 结果2])  // 3 * 5 = 15

}
