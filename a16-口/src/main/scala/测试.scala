package a16.测试

class 类型匹配[T] {
  def 匹配(i: 类型匹配[T]): 类型匹配[T] = i
}

object 类型匹配 {
  def apply[T] = new 类型匹配[T]
}

class Item1
class Item2
class Item3
class Item4
class Item5
class Item6
class Item7

class 测试 {

  {
    import a16.第一阶._
    type Plus1 = 后继[后继[后继[零, Item1], Item2], Item3]
    type Plus2 = 后继[后继[后继[后继[零, Item4], Item5], Item6], Item7]
    type Plus3 = 后继[后继[后继[后继[后继[后继[后继[零, Item1], Item2], Item3], Item4], Item5], Item6], Item7]
    类型匹配[Plus1#加[Plus2]].匹配(类型匹配[Plus3])
  }

  {
    import a16.第二阶._
    type Plus1 = 被加数正数[被加数正数[被加数正数[被加数零, Item1], Item2], Item3]
    type Plus2 = 加数正数[加数正数[加数正数[加数正数[加数零, Item4], Item5], Item6], Item7]
    type Plus3 = 被加数正数[被加数正数[被加数正数[被加数正数[被加数正数[被加数正数[被加数正数[被加数零, Item1], Item2], Item3], Item4], Item5], Item6], Item7]
    类型匹配[Plus1#加[Plus2]].匹配(类型匹配[Plus3])
  }

  {
    import a16.第三阶._
    type Plus1 = 被加数正数[被加数正数[被加数正数[被加数零, Item1], Item2], Item3]
    type Plus2 = 加数正数[加数正数[加数正数[加数正数[加数零, Item4], Item5], Item6], Item7]
    type Plus3 = 被加数正数[被加数正数[被加数正数[被加数正数[被加数正数[被加数正数[被加数正数[被加数零, Item1], Item2], Item3], Item4], Item5], Item6], Item7]
    类型匹配[加法#相加[Plus1, Plus2]].匹配(类型匹配[Plus3])
  }

}
