package a23.step2

object Runner {

  class 类型匹配[T]
  object 类型匹配 {
    def apply[T1, T2]: (类型匹配[T1], 类型匹配[T2])            = (new 类型匹配[T1], new 类型匹配[T2])
    def apply[T](t: (类型匹配[T], 类型匹配[T])): List[类型匹配[T]] = List(t._1, t._2)
  }

  class Item1 {
    override def toString: String = "Item1"
  }
  class Item2 {
    override def toString: String = "Item2"
  }
  class Item3 {
    override def toString: String = "Item3"
  }
  class Item4 {
    override def toString: String = "Item4"
  }
  class MM5 {
    override def toString: String = "MM5"
  }
  class MM6 {
    override def toString: String = "MM6"
  }
  class MM7 {
    override def toString: String = "MM7"
  }

  type 挑战者1 = 挑战者Positive[挑战者Positive[挑战者Positive[挑战者Positive[挑战者Zero, Item1], Item2], Item3], Item4]
  type 困难1  = 困难Positive[困难Positive[困难Positive[困难Zero, MM5], MM6], MM7]
  type 结果1  = 挑战者Positive[挑战者Positive[挑战者Positive[挑战者Positive[挑战者Positive[挑战者Positive[挑战者Positive[挑战者Zero, Item1], MM5], Item2], MM6], Item3], MM7], Item4]
  类型匹配(类型匹配[挑战者1#挑战[困难1], 结果1])

  class ItemA1 {
    override def toString: String = "ItemA1"
  }
  class ItemA2 {
    override def toString: String = "ItemA2"
  }
  class MMA3 {
    override def toString: String = "MMA3"
  }
  class MMA4 {
    override def toString: String = "MMA4"
  }
  class MMA5 {
    override def toString: String = "MMA5"
  }
  class MMA6 {
    override def toString: String = "MMA6"
  }
  class MMA7 {
    override def toString: String = "MMA7"
  }

  type 挑战者2 = 挑战者Positive[挑战者Positive[挑战者Zero, ItemA1], ItemA2]
  type 困难2  = 困难Positive[困难Positive[困难Positive[困难Positive[困难Positive[困难Zero, MMA3], MMA4], MMA5], MMA6], MMA7]
  type 结果2  = 困难Positive[困难Positive[困难Positive[困难Positive[困难Positive[困难Positive[困难Positive[困难Zero, MMA3], MMA4], MMA5], MMA6], ItemA1], MMA7], ItemA2]
  类型匹配(类型匹配[挑战者2#挑战[困难2], 结果2])

  def main(attr: Array[String]): Unit = {
    println("==========开始生成==========")
    val 挑战者1 = new 挑战者Positive(new 挑战者Positive(new 挑战者Positive(new 挑战者Positive(new 挑战者Zero, new Item1), new Item2), new Item3), new Item4)
    val 困难1  = new 困难Positive(new 困难Positive(new 困难Positive(new 困难Zero, new MM5), new MM6), new MM7)
    val 挑战者2 = new 挑战者Positive(new 挑战者Positive(new 挑战者Zero, new ItemA1), new ItemA2)
    val 困难2  = new 困难Positive(new 困难Positive(new 困难Positive(new 困难Positive(new 困难Positive(new 困难Zero, new MMA3), new MMA4), new MMA5), new MMA6), new MMA7)
    println("==========结束生成==========")

    val 结果1 = 挑战者1.挑战(困难1)
    println(s"结果1：${结果1}")

    val 结果2 = 挑战者2.挑战(困难2)
    println(s"结果2：${结果2}")

    /** ==========开始生成==========
      * 构成奖励
      * 构成奖励
      * 构成奖励
      * 构成奖励
      * 构成遗憾
      * 构成遗憾
      * 构成遗憾
      * 构成奖励
      * 构成奖励
      * 构成遗憾
      * 构成遗憾
      * 构成遗憾
      * 构成遗憾
      * 构成遗憾
      * ==========结束生成==========
      * 被困难降低数值
      * 挑战困难
      * 被困难降低数值
      * 挑战困难
      * 被困难降低数值
      * 挑战困难
      * 被困难降低数值
      * 获得胜利
      * 构成奖励
      * 构成奖励
      * 构成奖励
      * 构成奖励
      * 构成奖励
      * 构成奖励
      * 构成奖励
      * 结果1：挑战者Positive(挑战者Positive(挑战者Positive(挑战者Positive(挑战者Positive(挑战者Positive(挑战者Positive(挑战者Zero, Item1), MM5), Item2), MM6), Item3), MM7), Item4)
      * 被困难降低数值
      * 挑战困难
      * 被困难降低数值
      * 挑战困难
      * 挑战失败
      * 构成遗憾
      * 构成遗憾
      * 构成遗憾
      * 构成遗憾
      * 结果2：困难Positive(困难Positive(困难Positive(困难Positive(困难Positive(困难Positive(困难Positive(困难Zero, MMA3), MMA4), MMA5), MMA6), ItemA1), MMA7), ItemA2)
      */

  }

}
