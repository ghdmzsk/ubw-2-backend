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
  override val currentJinzhi: CNNN
) extends ItemCompare {
  override type UU  = UUU
  override type CUU = CUUU
  override type NN  = NNN
  override type CNN = CNNN
}

class InitUnpack[U <: ItemUnPack, N <: Jinzhi](val u: U, val j: N) extends ItemCompareImpl(u, ZeroItemUnPack, j, j) {
  self =>

  def apply = {
    val a = u.qianjin(j.guishu).qianjin(new ItemCompareImpl(unPack, currentUnPack, jinzhi, currentJinzhi))
    println("123456789" + a.currentUnPack)
    println("123456789" + a.currentJinzhi)
    a.currentUnPack.unPack(a.currentJinzhi.item)
  }

}

trait Qianjin {
  type M[II <: ItemCompare] <: ItemCompare
  def qianjin[II <: ItemCompare](ii: II): M[II]
}

trait Manwei_1_Q extends Qianjin {
  type M[II <: ItemCompare] = II#UU#Sub#G[II#NN#Tail#G]#M[ItemCompareImpl[II#UU#Sub, II#UU, II#NN#Tail, II#NN]]
  def qianjin[II <: ItemCompare](
    ii: II
  ): II#UU#Sub#G[II#NN#Tail#G]#M[ItemCompareImpl[II#UU#Sub, II#UU, II#NN#Tail, II#NN]] = {
    println("1111" + ii.unPack)
    val aa: II#UU#Sub#G[II#NN#Tail#G] = ii.unPack.sub.qianjin(ii.jinzhi.tail.guishu)
    aa.qianjin(new ItemCompareImpl(ii.unPack.sub, ii.unPack, ii.jinzhi.tail, ii.jinzhi))
  }
}

object Manwei_1_Q extends Manwei_1_Q

trait Manwei_0_Q extends Qianjin {
  type M[II <: ItemCompare] = II#UU#Sub#G[II#NN#Tail#G]#M[ItemCompareImpl[II#UU#Sub, II#CUU, II#NN#Tail, II#NN]]
  def qianjin[II <: ItemCompare](ii: II): II#UU#Sub#G[II#NN#Tail#G]#M[ItemCompareImpl[II#UU#Sub, II#CUU, II#NN#Tail, II#NN]] = {
    println("2222" + ii.unPack)
    val aa: II#UU#Sub#G[II#NN#Tail#G] = ii.unPack.sub.qianjin(ii.jinzhi.tail.guishu)
    aa.qianjin(new ItemCompareImpl(ii.unPack.sub, ii.currentUnPack, ii.jinzhi.tail, ii.jinzhi))
  }
}

object Manwei_0_Q extends Manwei_0_Q

trait Kongwei_1_Q extends Qianjin {
  type M[II <: ItemCompare] = II#UU#Sub#G[II#NN#Tail#G]#M[ItemCompareImpl[II#UU#Sub, II#UU, II#NN#Tail, II#CNN]]
  def qianjin[II <: ItemCompare](ii: II): II#UU#Sub#G[II#NN#Tail#G]#M[ItemCompareImpl[II#UU#Sub, II#UU, II#NN#Tail, II#CNN]] = {
    println("3333" + ii.unPack)
    val aa: II#UU#Sub#G[II#NN#Tail#G] = ii.unPack.sub.qianjin(ii.jinzhi.tail.guishu)
    aa.qianjin(new ItemCompareImpl(ii.unPack.sub, ii.unPack, ii.jinzhi.tail, ii.currentJinzhi))
  }
}

object Kongwei_1_Q extends Kongwei_1_Q

trait Kongwei_0_Q extends Qianjin {
  type M[II <: ItemCompare] = II#UU#Sub#G[II#NN#Tail#G]#M[ItemCompareImpl[II#UU#Sub, II#CUU, II#NN#Tail, II#CNN]]
  def qianjin[II <: ItemCompare](ii: II): II#UU#Sub#G[II#NN#Tail#G]#M[ItemCompareImpl[II#UU#Sub, II#CUU, II#NN#Tail, II#CNN]] = {
    println("4444" + ii.unPack)
    val aa: II#UU#Sub#G[II#NN#Tail#G] = ii.unPack.sub.qianjin(ii.jinzhi.tail.guishu)
    aa.qianjin(new ItemCompareImpl(ii.unPack.sub, ii.currentUnPack, ii.jinzhi.tail, ii.currentJinzhi))
  }
}

object Kongwei_0_Q extends Kongwei_0_Q

trait UZero extends Qianjin {
  type M[II <: ItemCompare] = II
  def qianjin[II <: ItemCompare](ii: II): II = {
    println("5555" + ii.unPack)
    ii
  }
}

object UZero extends UZero
