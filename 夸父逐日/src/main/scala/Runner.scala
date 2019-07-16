object Runner extends App {

  type 追逐1 = Init#追逐
  val a1: 路        = (throw new Exception("ii")): 追逐1#太阳的路
  val a2: 路#Add[路] = (throw new Exception("ii")): 追逐1#夸父的路

  type 追逐2 = Init#追逐#追逐
  val a3: 路               = (throw new Exception("ii")): 追逐2#太阳的路
  val a4: 路#Add[路]#Add[路] = (throw new Exception("ii")): 追逐2#夸父的路

  type 追逐3 = Init#追逐#追逐#追逐
  val a5: 路                      = (throw new Exception("ii")): 追逐3#太阳的路
  val a6: 路#Add[路]#Add[路]#Add[路] = (throw new Exception("ii")): 追逐3#夸父的路

  type 追逐4 = Init#追逐#追逐#追逐#追逐
  val a7: 路                             = (throw new Exception("ii")): 追逐4#太阳的路
  val a8: 路#Add[路]#Add[路]#Add[路]#Add[路] = (throw new Exception("ii")): 追逐4#夸父的路

  type 追逐5 = Init#追逐#追逐#追逐#追逐#追逐
  val a9: 路                                     = (throw new Exception("ii")): 追逐5#太阳的路
  val a10: 路#Add[路]#Add[路]#Add[路]#Add[路]#Add[路] = (throw new Exception("ii")): 追逐5#夸父的路

}
