package 练习19

object 重组 {

  trait HList
  class HPositive[Head, Tail <: HList] extends HList
  class HZero                          extends HList

  class 五十里好好的
  class 五十里准备中弹
  class 五十里中弹
  class 五十里流血
  class 五十里死亡准备

  type 后续事件 = HList

  type 五十里1 = HPositive[五十里好好的, HPositive[五十里准备中弹, 后续事件]]
  type 五十里2 = HPositive[五十里好好的, HPositive[五十里准备中弹, HPositive[五十里中弹, 后续事件]]]
  type 五十里3 = HPositive[五十里好好的, HPositive[五十里准备中弹, HPositive[五十里中弹, HPositive[五十里流血, 后续事件]]]]
  type 五十里4 = HPositive[五十里好好的, HPositive[五十里准备中弹, HPositive[五十里中弹, HPositive[五十里流血, HPositive[五十里死亡准备, 后续事件]]]]]

  println("开始回溯")

  class 情报体历史 extends HPositive[五十里中弹, HPositive[五十里流血, HPositive[五十里死亡准备, 重组]]]
  class 重组    extends HPositive[五十里准备中弹, 情报体历史]

  type 改写后的五十里 = HPositive[五十里好好的, 情报体历史]

  println("世界：你个死 lazy，你有完没完，呕你出来")

  type 世界修正力发动后的五十里 = HPositive[五十里好好的, 后续事件]

  println("情报体历史被世界抛弃，术式消散")

}
