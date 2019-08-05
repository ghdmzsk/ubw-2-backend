package version1

import scala.language.higherKinds

trait 水尺 {

  type 检验[II <: 池塘] <: 池塘
  def 检验[II <: 池塘](m: II): 检验[II]

  type 下一重 <: 水尺
  def 下一重: 下一重

}

class 下一重水尺[尾 <: 水尺](尾: 尾) extends 水尺 {
  self =>

  override type 检验[II <: 池塘] = 尾#检验[II]#尾
  override def 检验[II <: 池塘](m: II): 尾#检验[II]#尾 = 尾.检验(m).尾

  override type 下一重 = 下一重水尺[下一重水尺[尾]]
  override def 下一重: 下一重水尺[下一重水尺[尾]] = new 下一重水尺(self)

}

class 初始水尺 extends 水尺 {
  self =>

  override type 检验[II <: 池塘] = II
  override def 检验[II <: 池塘](m: II): II = m

  override type 下一重 = 下一重水尺[初始水尺]
  override def 下一重: 下一重水尺[初始水尺] = new 下一重水尺(self)

}

object 初始水尺 extends 初始水尺
