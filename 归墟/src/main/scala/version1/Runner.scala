package version1

object Runner extends App {

  val ZeroHListM = new 大海之初(HNil.add("原来海水1").add("原来海水2"), Manyi.add.add.add)

  val item = ZeroHListM.add(1).add("个").add("满").add("溢").add("的").add("HList").add("例").add("子")
  println(item.toString)    //满, 个, 1, 原来海水2, 原来海水1, HNil
  println(item.归墟.toString) //子, 例, HList, 的, 溢, 归墟
  val b: HNil#Add[String]#Add[String]#Add[Int]#Add[String]#Add[String] = item.海水 //检查类型

}
