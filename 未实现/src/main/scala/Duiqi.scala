trait ItemCompare {

  type UU <: ItemUnPack
  def unPack: UU

  type CUU <: ItemUnPack
  def currentUnPack: CUU

  type NN <: Jinzhi
  def jinzhi: NN

  type CNN <: Jinzhi
  def currentJinzhi: CNN

}

class ItemCompareImpl[UUU <: ItemUnPack, CUUU <: ItemUnPack, NNN <: Jinzhi, CNNN <: Jinzhi](
  override val unPack: UUU,
  override val currentUnPack: CUUU,
  override val jinzhi: NNN,
  override val currentJinzhi: CNNN)
    extends ItemCompare {
  override type UU  = UUU
  override type CUU = CUUU
  override type NN  = NNN
  override type CNN = CNNN
}

trait Qianjin {
  type M[II <: ItemCompare] <: ItemCompare
  def qianjin[II <: ItemCompare](ii: II): M[II]
}

trait Manwei_1_Q extends Qianjin {
  type M[II <: ItemCompare] = ItemCompareImpl[II#UU#_2, II#CUU, II#NN#Tail, II#CNN]
  def qianjin[II <: ItemCompare](ii: II): ItemCompareImpl[II#UU#_2, II#CUU, II#NN#Tail, II#CNN] = {
    new ItemCompareImpl(ii.unPack._2, ii.currentUnPack, ii.jinzhi.tail, ii.currentJinzhi)
  }
}

object Manwei_1_Q extends Manwei_1_Q

trait Manwei_0_Q extends Qianjin {
  type M[II <: ItemCompare] = ItemCompareImpl[II#UU#_1, II#UU#_1, II#NN#Tail, II#NN]
  def qianjin[II <: ItemCompare](ii: II): ItemCompareImpl[II#UU#_1, II#UU#_1, II#NN#Tail, II#NN] = {
    new ItemCompareImpl(ii.unPack._1, ii.unPack._1, ii.jinzhi.tail, ii.jinzhi)
  }
}

object Manwei_0_Q extends Manwei_0_Q

trait Kongwei_1_Q extends Qianjin {
  type M[II <: ItemCompare] = ItemCompareImpl[II#UU#_2, II#CUU, II#NN#Tail, II#CNN]
  def qianjin[II <: ItemCompare](ii: II): ItemCompareImpl[II#UU#_2, II#CUU, II#NN#Tail, II#CNN] = {
    new ItemCompareImpl(ii.unPack._2, ii.currentUnPack, ii.jinzhi.tail, ii.currentJinzhi)
  }
}

object Kongwei_1_Q extends Kongwei_1_Q

trait Kongwei_0_Q extends Qianjin {
  type M[II <: ItemCompare] = ItemCompareImpl[II#UU#_1, II#CUU, II#NN#Tail, II#CNN]
  def qianjin[II <: ItemCompare](ii: II): ItemCompareImpl[II#UU#_1, II#CUU, II#NN#Tail, II#CNN] = {
    new ItemCompareImpl(ii.unPack._1, ii.currentUnPack, ii.jinzhi.tail, ii.currentJinzhi)
  }
}

object Kongwei_0_Q extends Kongwei_0_Q

trait UZero extends Qianjin {
  type M[II <: ItemCompare] = II
  def qianjin[II <: ItemCompare](ii: II): II = ii
}

object UZero extends UZero
