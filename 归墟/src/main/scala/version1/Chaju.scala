package version1

import scala.language.higherKinds

trait 水尺 {

  type 检验[II <: 大海] <: 大海
  def 检验[II <: 大海](m: II): 检验[II]

  type 下一重 <: 水尺
  def 下一重: 下一重

}

class 下一重水尺[尾 <: 水尺](尾: 尾) extends 水尺 {
  self =>

  override type 检验[II <: 大海] = 尾#检验[II]#尾
  override def 检验[II <: 大海](m: II): 尾#检验[II]#尾 = 尾.检验(m).尾

  override type 下一重 = 下一重水尺[下一重水尺[尾]]
  override def 下一重: 下一重水尺[下一重水尺[尾]] = new 下一重水尺(self)

}

class 初始水尺 extends 水尺 {
  self =>

  override type 检验[II <: 大海] = II
  override def 检验[II <: 大海](m: II): II = m

  override type 下一重 = 下一重水尺[初始水尺]
  override def 下一重: 下一重水尺[初始水尺] = new 下一重水尺(self)

}

object 初始水尺 extends 初始水尺
