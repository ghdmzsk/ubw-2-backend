package a14.魔王勇者

class 类型匹配[T] {
  def 匹配(i: 类型匹配[T]): 类型匹配[T] = i
}

object 类型匹配 {
  def apply[T] = new 类型匹配[T]
}

class 勇者血量
class 誓约胜利之剑
class 无毁的湖光
class 魔王血量

class 一顿饭
class 一个包

object 测试 {

  type 现实世界勇者 = 勇者起源#Next[勇者血量]#Next[勇者血量]
  type 现实世界魔王 = 奖励起源#Next[一顿饭]#Next[一个包]#添加枷锁[魔王血量]#Next[魔王血量]#Next[魔王血量]#Next[魔王血量]
  type 魔王胜利   = 奖励起源#Next[一顿饭]#Next[一个包]#添加枷锁[魔王血量]#Next[魔王血量]

  类型匹配[现实世界勇者#挑战[现实世界魔王]].匹配(类型匹配[魔王胜利])

  type 小说世界勇者 = 勇者起源#Next[勇者血量]#Next[勇者血量]#Next[勇者血量]#Next[勇者血量]#Next[勇者血量]#Next[勇者血量]
  type 小说世界魔王 = 奖励起源#Next[誓约胜利之剑]#Next[无毁的湖光]#添加枷锁[魔王血量]#Next[魔王血量]#Next[魔王血量]#Next[魔王血量]
  type 勇者得到宝藏 = 勇者起源#Next[勇者血量]#Next[勇者血量]#Next[誓约胜利之剑]#Next[无毁的湖光]
  类型匹配[小说世界勇者#挑战[小说世界魔王]].匹配(类型匹配[勇者得到宝藏])

  def main(arr: Array[String]): Unit = {
    println("22")
  }

}
