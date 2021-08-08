package version1

import scala.language.higherKinds

trait 水 {
  def 温度: Int
}
case class 海水(是否龙宫附近: Boolean, override val 温度: Int) extends 水
case class 锅里水(override val 温度: Int)                 extends 水

trait 容器抽象 {
  type 液体 <: 水
  def 容物: List[液体]
}

trait 容器[液 <: 水] extends 容器抽象 {
  override type 液体 = 液
  override def 容物: List[液]
}

class 大地(override val 容物: List[海水])  extends 容器[海水]
class 铁锅(override val 容物: List[锅里水]) extends 容器[锅里水]

trait 法术[I <: 容器抽象] {

  def 物体: I
  def 煮: I
  def 转换器(i: I#液体): I#液体

}

object 铜钱 {
  def 过滤(海水: 海水): 海水 =
    if (海水.是否龙宫附近 == false) {
      海水.copy(温度 = 30)
    } else 海水
}

class 煮海(val 咸水: List[海水])(override val 物体: 大地 = new 大地(咸水)) extends 法术[大地] {
  override def 煮: 大地          = new 大地(物体.容物.map(f => 转换器(f.copy(温度 = 100))))
  override def 转换器(i: 海水): 海水 = 铜钱.过滤(i)
}

class 煮锅(val 锅里水: List[锅里水])(override val 物体: 铁锅 = new 铁锅(锅里水)) extends 法术[铁锅] {
  override def 煮: 铁锅            = new 铁锅(物体.容物.map(f => 转换器(f.copy(温度 = 100))))
  override def 转换器(i: 锅里水): 锅里水 = i
}
