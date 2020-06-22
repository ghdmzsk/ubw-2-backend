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

  type HList7 = Zero#Add[Item1]#Add[Item2]#Add[Item3]#Add[Item4]#Add[Item5]#Add[Item6]#Add[Item7]
  val hlist7_4: HList3#RePlus[HList4] = hlist3.rePlus(hlist4)
  hlist7_4: HList7
  println(hlist7_4) // Zero , Item1 , Item2 , Item3 , Item4 , Item5 , Item6 , Item7

  type HList1 = Zero#Add[String]
  val hlist1_1: Zero#Add[String] = Zero.value.add("22")
  hlist1_1: HList1

  type II = HList7#RePlus[HList7]#RePlus[HList7]#RePlus[HList3#RePlus[Zero#Add[String]]]
  val ii: II =
    hlist3.rePlus(hlist4).rePlus(hlist3.rePlus(hlist4)).rePlus(hlist3.rePlus(hlist4)).rePlus(hlist3.rePlus(hlist1_1))

  type BB = II#RePlus[II]#RePlus[II]#RePlus[II]#RePlus[HList7]
  val bb = ii.rePlus(ii).rePlus(ii).rePlus(ii).rePlus(hlist7_4)

  println(bb.tail.tail.tail.tail.head: Item3)                                                          // Item3
  println(bb.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head.item4ToString) // I'm Item4.
  println(bb)
  /*Zero , Item1 , Item2 , Item3 , Item4 , Item5 , Item6 , Item7 ,
Item1 , Item2 , Item3 , Item4 , Item5 , Item6 , Item7 ,
Item1 , Item2 , Item3 , Item4 , Item5 , Item6 , Item7 ,
Item1 , Item2 , Item3 , 22 ,
Item1 , Item2 , Item3 , Item4 , Item5 , Item6 , Item7 ,
Item1 , Item2 , Item3 , Item4 , Item5 , Item6 , Item7 ,
Item1 , Item2 , Item3 , Item4 , Item5 , Item6 , Item7 ,
Item1 , Item2 , Item3 , 22 ,
Item1 , Item2 , Item3 , Item4 , Item5 , Item6 , Item7 ,
Item1 , Item2 , Item3 , Item4 , Item5 , Item6 , Item7 ,
Item1 , Item2 , Item3 , Item4 , Item5 , Item6 , Item7 ,
Item1 , Item2 , Item3 , 22 ,
Item1 , Item2 , Item3 , Item4 , Item5 , Item6 , Item7 ,
Item1 , Item2 , Item3 , Item4 , Item5 , Item6 , Item7 ,
Item1 , Item2 , Item3 , Item4 , Item5 , Item6 , Item7 ,
Item1 , Item2 , Item3 , 22 ,
Item1 , Item2 , Item3 , Item4 , Item5 , Item6 , Item7*/

}
