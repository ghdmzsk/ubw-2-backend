package a23.step3

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

  class 挑战者基础3 extends 挑战者[挑战者基础2, Item3](tail1 = () => 挑战者基础.挑战者基础2, head = new Item3) {
    override def toString: String = "挑战者基础"
  }
  class 挑战者基础2 extends 挑战者[挑战者基础1, Item2](tail1 = () => 挑战者基础.挑战者基础1, head = new Item2) {
    override def toString: String = "挑战者基础"
  }
  class 挑战者基础1 extends 挑战者[挑战者基础3, Item1](tail1 = () => 挑战者基础.挑战者基础3, head = new Item1) {
    override def toString: String = "挑战者基础"
  }

  object 挑战者基础 {
    val 挑战者基础3: 挑战者基础3 = new 挑战者基础3
    val 挑战者基础2: 挑战者基础2 = new 挑战者基础2
    val 挑战者基础1: 挑战者基础1 = new 挑战者基础1
  }

  class Item4 {
    override def toString: String = "Item4"
  }
  class Item5 {
    override def toString: String = "Item5"
  }
  class Item6 {
    override def toString: String = "Item6"
  }
  class MM7 {
    override def toString: String = "MM7"
  }
  class MM8 {
    override def toString: String = "MM8"
  }

  type 挑战者1 = 挑战者[挑战者[挑战者[挑战者基础3, Item4], Item5], Item6]
  type 困难1  = 困难Positive[困难Positive[困难Zero, MM7], MM8]
  type 结果1  = 挑战者[挑战者[挑战者[挑战者[挑战者[挑战者基础3, Item4], MM7], Item5], MM8], Item6]
  类型匹配(类型匹配[挑战者1#挑战[困难1], 结果1])

  class MM9 {
    override def toString: String = "MM9"
  }
  class MM10 {
    override def toString: String = "MM10"
  }
  class MM11 {
    override def toString: String = "MM11"
  }
  class MM12 {
    override def toString: String = "MM12"
  }
  class MM13 {
    override def toString: String = "MM13"
  }
  class MM14 {
    override def toString: String = "MM14"
  }

  type 挑战者2 = 挑战者[挑战者[挑战者[挑战者基础3, Item4], Item5], Item6]
  type 困难2 = 困难Positive[
    困难Positive[困难Positive[困难Positive[困难Positive[困难Positive[困难Positive[困难Positive[困难Zero, MM7], MM8], MM9], MM10], MM11], MM12], MM13],
    MM14
  ]
  type 结果2 = 挑战者[挑战者[挑战者[
    挑战者[挑战者[挑战者[
      挑战者[挑战者[挑战者[挑战者[挑战者[挑战者[挑战者[挑战者[挑战者[挑战者[挑战者[挑战者基础3, Item1], MM7], Item2], MM8], Item3], MM9], Item1], MM10], Item2], MM11], Item3],
      MM12
    ], Item4], MM13],
    Item5
  ], MM14], Item6]
  类型匹配(类型匹配[挑战者2#挑战[困难2], 结果2])

  def main(arr: Array[String]): Unit = {
    println("==========开始初始化==========")

    val 挑战者1 = new 挑战者(() => new 挑战者(() => new 挑战者(() => new 挑战者基础3, new Item4), new Item5), new Item6)
    val 困难1  = new 困难Positive(new 困难Positive(new 困难Zero, new MM7), new MM8)
    挑战者1.tail.tail.tail.tail.tail.tail

    val 挑战者2 = new 挑战者(() => new 挑战者(() => new 挑战者(() => new 挑战者基础3, new Item4), new Item5), new Item6)
    val 困难2 = new 困难Positive(
      new 困难Positive(
        new 困难Positive(
          new 困难Positive(
            new 困难Positive(new 困难Positive(new 困难Positive(new 困难Positive(new 困难Zero, new MM7), new MM8), new MM9), new MM10),
            new MM11
          ),
          new MM12
        ),
        new MM13
      ),
      new MM14
    )
    挑战者2.tail.tail.tail.tail.tail.tail

    println("==========结束初始化==========")

    val 结果1 = 挑战者1.挑战(困难1)
    println(s"结果1：${结果1}")

    val 结果2 = 挑战者2.挑战(困难2)
    println(s"结果2：${结果2}")

    /** ==========开始初始化========== 构成奖励 构成遗憾 构成遗憾 构成奖励 构成奖励 构成奖励 构成奖励 构成奖励 构成奖励 构成奖励 构成遗憾 构成遗憾 构成遗憾 构成遗憾 构成遗憾 构成遗憾 构成遗憾 构成遗憾 构成奖励 构成奖励 构成奖励
      * ==========结束初始化========== 被困难降低数值 挑战困难 构成奖励 构成奖励 被困难降低数值 挑战困难 构成奖励 构成奖励 被困难降低数值 获得胜利 构成奖励 结果1：挑战者(挑战者(挑战者(挑战者(挑战者(挑战者基础, Item4),
      * MM7), Item5), MM8), Item6) 被困难降低数值 挑战困难 构成奖励 构成奖励 被困难降低数值 挑战困难 构成奖励 构成奖励 被困难降低数值 挑战困难 构成奖励 构成奖励 被困难降低数值 挑战困难 构成奖励 构成奖励 被困难降低数值 挑战困难
      * 构成奖励 构成奖励 被困难降低数值 挑战困难 构成奖励 构成奖励 被困难降低数值 挑战困难 构成奖励 构成奖励 被困难降低数值 挑战困难 构成奖励 构成奖励 被困难降低数值 获得胜利 构成奖励
      * 结果2：挑战者(挑战者(挑战者(挑战者(挑战者(挑战者(挑战者(挑战者(挑战者(挑战者(挑战者(挑战者(挑战者(挑战者(挑战者(挑战者(挑战者(挑战者基础, Item1), MM7), Item2), MM8), Item3), MM9), Item1),
      * MM10), Item2), MM11), Item3), MM12), Item4), MM13), Item5), MM14), Item6)
      */

  }

}
