package a05

object Runner {

  class Test1 {
    override def toString: String = "Test1"
  }
  class Test2 {
    override def toString: String = "Test2"
  }
  class Test3 {
    override def toString: String = "Test3"
  }
  class Test4 {
    override def toString: String = "Test4"
  }
  class Test5 {
    override def toString: String = "Test5"
  }
  class Test6 {
    override def toString: String = "Test6"
  }
  class Test7 {
    override def toString: String = "Test7"
  }

  def main(arr: Array[String]): Unit = {
    type HList7 = Zero#Add[Test1]#Add[Test2]#Add[Test3]#Add[Test4]#Add[Test5]#Add[Test6]#Add[Test7]
    val hlist7: HList7 = Zero.value.add(new Test1).add(new Test2).add(new Test3).add(new Test4).add(new Test5).add(new Test6).add(new Test7)
    println(hlist7)

    hlist7.chouqu: HList7#Chouqu
    hlist7.chouqu: Zero#Add[Test2]#Add[Test3]#Add[Test4]#Add[Test5]#Add[Test6]#Add[Test7]
    println(hlist7.chouqu)

    hlist7.chouqu.chouqu.chouqu: HList7#Chouqu#Chouqu#Chouqu
    hlist7.chouqu.chouqu.chouqu: Zero#Add[Test4]#Add[Test5]#Add[Test6]#Add[Test7]
    println(hlist7.chouqu.chouqu.chouqu)
  }

}
