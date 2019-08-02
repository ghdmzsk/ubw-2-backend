package version2

import scala.language.higherKinds

trait 水尺 {
  type 检验[I <: 大海] <: 大海
  def 检验[I <: 大海](shendu: I): 检验[I]

  type 下一重 <: 水尺
  def 下一重: 下一重
}

class 下一重水尺[尾 <: 水尺](val per: 尾) extends 水尺 {
  self =>

  override type 检验[I <: 大海] = 尾#检验[I]#尾
  override def 检验[I <: 大海](shendu: I): 尾#检验[I]#尾 = per.检验(shendu).tail

  override type 下一重 = 下一重水尺[下一重水尺[尾]]
  override def 下一重: 下一重 = new 下一重水尺(self)

}

class 初始水尺 extends 水尺 {
  self =>

  override type 检验[I <: 大海] = I
  override def 检验[I <: 大海](shendu: I): I = shendu

  override type 下一重 = 下一重水尺[初始水尺]
  override def 下一重: 下一重水尺[初始水尺] = new 下一重水尺(self)

}

object 初始水尺 extends 初始水尺
