trait Guishu {

  type _1 <: Qianjin
  def _1: _1

  type _2 <: Qianjin
  def _2: _2

}

class ManweiGuishu extends Guishu {
  override type _1 = Manwei_0_Q
  override def _1: Manwei_0_Q = Manwei_0_Q

  override type _2 = Manwei_1_Q
  override def _2: Manwei_1_Q = Manwei_1_Q
}

object ManweiGuishu extends ManweiGuishu

class KongweiGuishu extends Guishu {
  override type _1 = Kongwei_0_Q
  override def _1: Kongwei_0_Q = Kongwei_0_Q

  override type _2 = Kongwei_1_Q
  override def _2: Kongwei_1_Q = Kongwei_1_Q
}

object KongweiGuishu extends KongweiGuishu

class WanjieGuishu extends Guishu {
  override type _1 = UZero
  override def _1: UZero = UZero

  override type _2 = UZero
  override def _2: UZero = UZero
}

object WanjieGuishu extends WanjieGuishu
