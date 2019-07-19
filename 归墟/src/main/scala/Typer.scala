import java.util.Date

object Typer {

  //脱离实体的运算
  type ZeroType = 大海之初[HNil, Manyi#Add#Add#Add]
  val i1: ZeroType#Add[Int]#Add[Date]#Add[String]#Add[String]#Add[String]#Add[String]#Add[String]#Add[String] = throw new Exception("abc")
  val i2: ZeroType#Add[Int]#Add[Date]#Add[String]#Add[String]#Add[String]                                     = i1
  val i3: ZeroType#Add[Int]#Add[Date]#Add[String]                                                             = i1
  val i4: HNil#Add[Int]#Add[Date]#Add[String]                                                                 = i1.海水

}
