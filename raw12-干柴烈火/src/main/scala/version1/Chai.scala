package version1

import scala.language.higherKinds

trait 铁 {
  type 需要热量 <: 铁
  def 需要热量: 需要热量

  type 初始化 <: 铁
  def 初始化: 初始化

}

class 热透的铁(id: Int) extends 铁 {
  self =>

  override type 需要热量 = 热透的铁
  override def 需要热量: 热透的铁 = {
    println(s"熟透的铁: ${id} 散发热量")
    self
  }
  override type 初始化 = 未热的铁[热透的铁]
  override def 初始化: 未热的铁[热透的铁]  = new 未热的铁(self)
  override def toString: String = "热透的铁"

}

class 未热的铁[TT <: 铁](val 锅铁: TT) extends 铁 {
  self =>
  override def 需要热量: TT = self.锅铁
  override type 需要热量 = TT
  override type 初始化  = 未热的铁[未热的铁[TT]]
  override def 初始化: 未热的铁[未热的铁[TT]] = new 未热的铁(self)
  override def toString: String    = "未热的铁" + ", " + 锅铁.toString
}
