package version2

import scala.language.higherKinds

object Typer {

  type sc   = ShuichiZero#Add#Add#Add
  type shui = HNil#Add[Int]#Add[String]#Add[Int]#Add[String]#Add[String]#Add[String]

  type a1 = sc#Shendu[shui]
  type b1 = a1#Con#M[shui]
  val 溢水1: HNil#Add[Int]#Add[String]#Add[Int]#Add[String]#Add[String] = (throw new Exception("ii")): b1

  type a2 = sc#Shendu[b1]
  type b2 = a2#Con#M[b1]
  val 溢水2: HNil#Add[Int]#Add[String]#Add[Int]#Add[String] = (throw new Exception("ii")): b2

  type a3 = sc#Shendu[b2]
  type b3 = a3#Con#M[b2]
  val 溢水3: HNil#Add[Int]#Add[String]#Add[Int] = (throw new Exception("ii")): b3

  type a4 = sc#Shendu[b3]
  type b4 = a4#Con#M[b3]
  val 溢水4: HNil#Add[Int]#Add[String]#Add[Int] = (throw new Exception("ii")): b4

  type a5 = sc#Shendu[b4]
  type b5 = a5#Con#M[b4]
  val 溢水5: HNil#Add[Int]#Add[String]#Add[Int] = (throw new Exception("ii")): b5

}
