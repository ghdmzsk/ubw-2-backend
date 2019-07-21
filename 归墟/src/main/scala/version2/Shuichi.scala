package version2

import scala.language.higherKinds

trait Shuichi {
  type Shendu[I <: HList] <: HList
  def shendu[I <: HList](shendu: I): Shendu[I]

  type Add <: Shuichi
  def add: Add
}

class ShuichiZero extends Shuichi {
  self =>

  override type Shendu[I <: HList] = I
  override def shendu[I <: HList](shendu: I): I = shendu

  override type Add = AppendShuichi[ShuichiZero]
  override def add: AppendShuichi[ShuichiZero] = new AppendShuichi(self)

}

object ShuichiZero extends ShuichiZero

class AppendShuichi[II <: Shuichi](val per: II) extends Shuichi {
  self =>

  override type Shendu[I <: HList] = II#Shendu[I]#T
  override def shendu[I <: HList](shendu: I): II#Shendu[I]#T = per.shendu(shendu).tail

  override type Add = AppendShuichi[AppendShuichi[II]]
  override def add: Add = new AppendShuichi(self)

}
