package version2

import scala.language.higherKinds

object Typer {

  type sc   = ShuichiZero#Add#Add#Add#Add
  type shui = HNil#Add[Int]#Add[String]#Add[Int]#Add[String]#Add[String]#Add[String]#Add[String]

  type a1 = sc#Shendu[shui]
  type b1 = a1#Con#M[shui]

  val 溢水1: HNil#Add[Int]#Add[String]#Add[Int]#Add[String]#Add[String]#Add[String] = (throw new Exception("ii")): b1

  type a2 = sc#Shendu[b1]
  type b2 = a2#Con#M[b1]

  val 溢水2: HNil#Add[Int]#Add[String]#Add[Int]#Add[String]#Add[String] = (throw new Exception("ii")): b2

  type a3 = sc#Shendu[b2]
  type b3 = a3#Con#M[b2]

  val 溢水3: HNil#Add[Int]#Add[String]#Add[Int]#Add[String] = (throw new Exception("ii")): b3

  type a4 = sc#Shendu[b3]
  type b4 = a4#Con#M[b3]

  val 溢水4: HNil#Add[Int]#Add[String]#Add[Int]#Add[String] = (throw new Exception("ii")): b4

  type a5 = sc#Shendu[b4]
  type b5 = a5#Con#M[b4]

  val 溢水5: HNil#Add[Int]#Add[String]#Add[Int]#Add[String] = (throw new Exception("ii")): b5

  type a6 = sc#Shendu[b5]
  type b6 = a6#Con#M[b5]

  val 溢水6: HNil#Add[Int]#Add[String]#Add[Int]#Add[String] = (throw new Exception("ii")): b6

  type a7 = sc#Shendu[b6]
  type b7 = a7#Con#M[b6]

  val 溢水7: HNil#Add[Int]#Add[String]#Add[Int]#Add[String] = (throw new Exception("ii")): b7

}
