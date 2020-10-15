package a13

import a13.乘法.{自然数对零, 自然数零}
import a13.减法.{正自然数零, 负自然数零}
import a13.加法.{加数零, 被加数零}
import a13.除法修正版.{商零, 被除数零, 除数零}

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
class Item09
class Item10

class 除数01
class 除数02
class 除数03

object 测试 {

  type Plus1 = 被加数零#Next[Item01]#Next[Item02]
  type Plus2 = 加数零#Next[Item03]#Next[Item04]#Next[Item05]#Next[Item06]
  type Plus3 = 被加数零#Next[Item01]#Next[Item02]#Next[Item03]#Next[Item04]#Next[Item05]#Next[Item06]
  类型匹配[Plus1#加[Plus2]].匹配(类型匹配[Plus3])

  type 减去1 = 正自然数零#Next[Item01]#Next[Item02]#Next[Item03]#Next[Item04]#Next[Item05]#Next[Item06]
  type 减去2 = 负自然数零#Next[Item03]#Next[Item04]#Next[Item05]#Next[Item06]
  type 减去3 = 正自然数零#Next[Item01]#Next[Item02]
  类型匹配[减去1#消去[减去2]].匹配(类型匹配[减去3])
  类型匹配[减去2#逆消去[减去1]].匹配(类型匹配[减去3])

  type 减去4 = 正自然数零#Next[Item02]#Next[Item02]#Next[Item02]#Next[Item02]
  type 减去5 = 负自然数零#Next[Item01]#Next[Item03]#Next[Item04]#Next[Item05]#Next[Item06]#Next[Item07]
  type 减去6 = 负自然数零#Next[Item01]#Next[Item03]
  类型匹配[减去4#消去[减去5]].匹配(类型匹配[减去6])
  类型匹配[减去5#逆消去[减去4]].匹配(类型匹配[减去6])

  类型匹配[正自然数零#消去[负自然数零]].匹配(类型匹配[负自然数零])
  类型匹配[负自然数零#逆消去[正自然数零]].匹配(类型匹配[正自然数零])

  type 减去7 = 正自然数零#Next[Item08]
  type 减去8 = 负自然数零#Next[Item02]
  类型匹配[减去7#消去[减去8]].匹配(类型匹配[负自然数零])
  类型匹配[减去8#逆消去[减去7]].匹配(类型匹配[正自然数零])

  type 乘以1 = 自然数零#Next[Item01]#Next[Item02]
  type 乘以2 = 自然数零#Next[Item03]#Next[Item04]#Next[Item05]
  type 乘以3 = 自然数对零#Next[Item01, Item03]#Next[Item01, Item04]#Next[Item01, Item05]#Next[Item02, Item03]#Next[Item02, Item04]#Next[Item02, Item05]
  类型匹配[乘以1#乘以[乘以2]].匹配(类型匹配[乘以3])

  type 除以1 = 被除数零#Next[Item01]#Next[Item02]#Next[Item03]#Next[Item04]#Next[Item05]#Next[Item06]#Next[Item07]#Next[Item08]
  type 除以2 = 除数零#Next[除数01]#Next[除数02]#Next[除数03]
  type 对1  = a13.除法修正版.自然数对零#Next[Item03, 除数01]#Next[Item04, 除数02]#Next[Item05, 除数03]
  type 对2  = a13.除法修正版.自然数对零#Next[Item06, 除数01]#Next[Item07, 除数02]#Next[Item08, 除数03]
  type 商1  = 商零#Next[对1]#Next[对2]
  类型匹配[除以1#除以[除以2]].匹配(类型匹配[商1])

  type 除以3 = 被除数零#Next[Item01]#Next[Item02]#Next[Item03]#Next[Item04]#Next[Item05]#Next[Item06]
  type 除以4 = 除数零#Next[除数01]#Next[除数02]#Next[除数03]
  type 对3  = a13.除法修正版.自然数对零#Next[Item01, 除数01]#Next[Item02, 除数02]#Next[Item03, 除数03]
  type 对4  = a13.除法修正版.自然数对零#Next[Item04, 除数01]#Next[Item05, 除数02]#Next[Item06, 除数03]
  type 商2  = 商零#Next[对3]#Next[对4]
  类型匹配[除以3#除以[除以4]].匹配(类型匹配[商2])

  type 除以5 = 被除数零#Next[Item01]#Next[Item02]#Next[Item03]#Next[Item04]#Next[Item05]#Next[Item06]#Next[Item07]
  type 除以6 = 除数零#Next[除数01]#Next[除数02]#Next[除数03]
  type 对5  = a13.除法修正版.自然数对零#Next[Item02, 除数01]#Next[Item03, 除数02]#Next[Item04, 除数03]
  type 对6  = a13.除法修正版.自然数对零#Next[Item05, 除数01]#Next[Item06, 除数02]#Next[Item07, 除数03]
  type 商3  = 商零#Next[对5]#Next[对6]
  类型匹配[除以5#除以[除以6]].匹配(类型匹配[商3])

  type 除以7 = 被除数零#Next[Item01]#Next[Item02]#Next[Item03]#Next[Item04]#Next[Item05]#Next[Item06]#Next[Item07]#Next[Item08]#Next[Item09]
  type 除以8 = 除数零#Next[除数01]#Next[除数02]#Next[除数03]
  type 对7  = a13.除法修正版.自然数对零#Next[Item01, 除数01]#Next[Item02, 除数02]#Next[Item03, 除数03]
  type 对8  = a13.除法修正版.自然数对零#Next[Item04, 除数01]#Next[Item05, 除数02]#Next[Item06, 除数03]
  type 对9  = a13.除法修正版.自然数对零#Next[Item07, 除数01]#Next[Item08, 除数02]#Next[Item09, 除数03]
  type 商4  = 商零#Next[对7]#Next[对8]#Next[对9]
  类型匹配[除以7#除以[除以8]].匹配(类型匹配[商4])

  type 除以9  = 被除数零#Next[Item01]#Next[Item02]#Next[Item03]#Next[Item04]#Next[Item05]#Next[Item06]#Next[Item07]#Next[Item08]#Next[Item09]#Next[Item10]
  type 除以10 = 除数零#Next[除数01]#Next[除数02]#Next[除数03]
  type 对10  = a13.除法修正版.自然数对零#Next[Item02, 除数01]#Next[Item03, 除数02]#Next[Item04, 除数03]
  type 对11  = a13.除法修正版.自然数对零#Next[Item05, 除数01]#Next[Item06, 除数02]#Next[Item07, 除数03]
  type 对12  = a13.除法修正版.自然数对零#Next[Item08, 除数01]#Next[Item09, 除数02]#Next[Item10, 除数03]
  type 商5   = 商零#Next[对10]#Next[对11]#Next[对12]
  类型匹配[除以9#除以[除以10]].匹配(类型匹配[商5])

  def main(arr: Array[String]): Unit = {
    println("22")
  }

}
