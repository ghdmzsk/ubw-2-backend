package plus

object Runner extends App {

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
    def item4ToString: String     = "I'm Item4."
    override def toString: String = "Item4"
  }
  class Item5 {
    def item5ToString: String     = "I'm Item5."
    override def toString: String = "Item5"
  }
  class Item6 {
    override def toString: String = "Item6"
  }
  class Item7 {
    override def toString: String = "Item7"
  }

  type HList3 = Zero#Add[Item1]#Add[Item2]#Add[Item3]
  val hlist3: HList3 = Zero.value.add(new Item1).add(new Item2).add(new Item3)
  println(hlist3) // Zero , Item1 , Item2 , Item3

  type HList4 = Zero#Add[Item4]#Add[Item5]#Add[Item6]#Add[Item7]
  val hlist4: HList4 = Zero.value.add(new Item4).add(new Item5).add(new Item6).add(new Item7)
  println(hlist4) // Zero , Item4 , Item5 , Item6 , Item7

  type HList7 = Zero#Add[Item4]#Add[Item5]#Add[Item6]#Add[Item7]#Add[Item3]#Add[Item2]#Add[Item1]
  val hlist7: HList3#Plus[HList4] = hlist3.plus(hlist4)
  hlist7: HList7
  println(hlist7) // Zero , Item4 , Item5 , Item6 , Item7 , Item3 , Item2 , Item1

  type HList7_1 = Zero#Add[Item1]#Add[Item2]#Add[Item3]#Add[Item7]#Add[Item6]#Add[Item5]#Add[Item4]
  val hlist7_1: HList4#Plus[HList3] = hlist4.plus(hlist3)
  hlist7_1: HList7_1
  println(hlist7_1) // Zero , Item1 , Item2 , Item3 , Item7 , Item6 , Item5 , Item4

}
