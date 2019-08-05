import scala.language.higherKinds

object Typer {

  class 日
  class 月
  class 星
  class 晨

  type 日月开始 = 五彩石#初始化[日]#初始化[月]#初始化[星]

  type 日月1 = 日月开始#运行[晨]
  val 日月1: 五彩石#初始化[月]#初始化[星]#初始化[晨] = (throw new Exception("ii")): 日月1

  type 日月2 = 日月1#运行[日]
  val 日月2: 五彩石#初始化[星]#初始化[晨]#初始化[日] = (throw new Exception("ii")): 日月2

  type 日月3 = 日月2#运行[月]
  val 日月3: 五彩石#初始化[晨]#初始化[日]#初始化[月] = (throw new Exception("ii")): 日月3

  type 日月4 = 日月3#运行[星]
  val 日月4: 五彩石#初始化[日]#初始化[月]#初始化[星] = 五彩石.value.初始化(new 日).初始化(new 月).初始化(new 星): 日月4

}
