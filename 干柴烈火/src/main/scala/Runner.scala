package version1

import scala.language.higherKinds

trait Runner {

  type 柴1 = 燃干的柴#初始化[一片木头#热量#热量#热量]#初始化[一片木头#热量#热量]#初始化[一片木头#热量#热量]#初始化[一片木头#热量]

  type 柴2 = 柴1#燃烧
  val a2: 燃干的柴#初始化[一片木头#热量#热量#热量]#初始化[一片木头#热量#热量]#初始化[一片木头#热量#热量] = (throw new Exception("ii")): 柴2

  type 柴3 = 柴2#燃烧
  val a3: 燃干的柴#初始化[一片木头#热量#热量#热量]#初始化[一片木头#热量#热量]#初始化[一片木头#热量] = (throw new Exception("ii")): 柴3

  type 柴4 = 柴3#燃烧
  val a5: 燃干的柴#初始化[一片木头#热量#热量#热量]#初始化[一片木头#热量#热量] = (throw new Exception("ii")): 柴4

  type 柴6 = 柴4#燃烧
  val a6: 燃干的柴#初始化[一片木头#热量#热量#热量]#初始化[一片木头#热量] = (throw new Exception("ii")): 柴6

  type 柴7 = 柴6#燃烧
  val a7: 燃干的柴#初始化[一片木头#热量#热量#热量] = (throw new Exception("ii")): 柴7

  type 柴8 = 柴7#燃烧
  val a8: 燃干的柴#初始化[一片木头#热量#热量] = (throw new Exception("ii")): 柴8

  type 柴9 = 柴8#燃烧
  val a9: 燃干的柴#初始化[一片木头#热量] = (throw new Exception("ii")): 柴9

  type 柴10 = 柴9#燃烧
  val a10: 燃干的柴 = (throw new Exception("ii")): 柴10

  type 柴11 = 柴10#燃烧
  val a11: 燃干的柴 = (throw new Exception("ii")): 柴11
}
