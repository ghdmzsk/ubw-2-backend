import scala.language.higherKinds

trait Zhuri {
  type 太阳的路 <: HList
  def 太阳的路: 太阳的路

  type 夸父的路 <: HList
  def 夸父的路: 夸父的路

  type 追逐 <: Zhuri
  def 追逐: 追逐
}

class ZhuriImpl[TT <: HList, KK <: HList](override val 太阳的路: TT, override val 夸父的路: KK) extends Zhuri {
  override type 太阳的路 = TT
  override type 夸父的路 = KK

  override type 追逐 = ZhuriImpl[TT#Tail, KK#Add[TT#Head]]
  override def 追逐: ZhuriImpl[TT#Tail, KK#Add[TT#Head]] = new ZhuriImpl(太阳的路.tail, 夸父的路.add(太阳的路.head))
}

class Init  extends ZhuriImpl[路, 路](路, 路)
object Init extends Init
