import scala.language.higherKinds

/**
  * 本文件暂时是无用的, 仅作测试之用
  */
trait Chaju1 {

  type Next <: Chaju1
  def next: Next

  type Add[II] <: Chaju1
  def add[II](item: II): Add[II]

  type Tran[II <: HList] <: HList
  def tran[II <: HList](m: II): Tran[II]

  def tranGuixu(guixu: Guixu): Guixu

}

class Chaju1Impl[IL, T <: Chaju1](val item: IL, override val next: T) extends Chaju1 {
  self =>

  override type Next = T

  override type Add[II] = Chaju1Impl[II, Chaju1Impl[IL, T]]
  override def add[II](iitem: II): Chaju1Impl[II, Chaju1Impl[IL, T]] = new Chaju1Impl(iitem, self)

  override type Tran[II <: HList] = T#Tran[II]#Add[IL]
  override def tran[II <: HList](m: II): T#Tran[II]#Add[IL] = next.tran(m).add(item)

  override def tranGuixu(guixu: Guixu): Guixu = guixu

}

class Manyi1 extends Chaju1 {
  self =>

  override type Next = Manyi1
  override def next: Manyi1 = self

  override type Add[II] = Chaju1Impl[II, Manyi1]
  override def add[II](m: II): Chaju1Impl[II, Manyi1] = new Chaju1Impl(m, self)

  override type Tran[II <: HList] = II
  override def tran[II <: HList](m: II): II = m

  override def tranGuixu(guixu: Guixu): Guixu = guixu

}

object Manyi1 extends Manyi1
