package a13

import a13.减法.{正自然数零, 自然数对实现, 负自然数零}
import a13.加法.自然数零

class 类型匹配[T] {
  def 匹配(i: 类型匹配[T]): 类型匹配[T] = i
}

object 类型匹配 {
  def apply[T] = new 类型匹配[T]
}

class Item01
class Item02
class Item03
class Item04
class Item05
class Item06
class Item07
class Item08

object 测试 {

  type Plus1 = 自然数零#Next[Item01]#Next[Item02]
  type Plus2 = 自然数零#Next[Item03]#Next[Item04]#Next[Item05]#Next[Item06]
  type Plus3 = 自然数零#Next[Item01]#Next[Item02]#Next[Item03]#Next[Item04]#Next[Item05]#Next[Item06]

  类型匹配[Plus1#再加[Plus2]].匹配(类型匹配[Plus3])

  type 减去1 = 正自然数零#Next[Item01]#Next[Item02]#Next[Item03]#Next[Item04]#Next[Item05]#Next[Item06]
  type 减去2 = 负自然数零#Next[Item03]#Next[Item04]#Next[Item05]#Next[Item06]
  type 减去3 = 自然数对实现[负自然数零, 正自然数零#Next[Item01]#Next[Item02]]
  类型匹配[减去1#消去[减去2]].匹配(类型匹配[减去3])

  type 减去4 = 正自然数零#Next[Item02]#Next[Item02]#Next[Item02]#Next[Item02]
  type 减去5 = 负自然数零#Next[Item01]#Next[Item03]#Next[Item04]#Next[Item05]#Next[Item06]#Next[Item07]
  type 减去6 = 自然数对实现[负自然数零#Next[Item01]#Next[Item03], 正自然数零]
  类型匹配[减去4#消去[减去5]].匹配(类型匹配[减去6])

  def main(arr: Array[String]): Unit = {
    println("22")
  }

}
