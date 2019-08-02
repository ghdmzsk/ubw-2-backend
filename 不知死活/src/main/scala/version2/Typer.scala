package version2

import scala.language.higherKinds

object Typer {

type 测试水尺 = 初始水尺#下一重#下一重#下一重#下一重
type 大海0  = 大海之初#加水[Int]#加水[String]#加水[Int]#加水[String]#加水[String]#加水[String]

type 去水1 = 测试水尺#检验[大海0]
type 大海1 = 去水1#目前去水#去[大海0]
val 大海1: 大海之初#加水[Int]#加水[String]#加水[Int]#加水[String]#加水[String] = (throw new Exception("ii")): 大海1

type 去水2 = 测试水尺#检验[大海1]
type 大海2 = 去水2#目前去水#去[大海1]
val 大海2: 大海之初#加水[Int]#加水[String]#加水[Int]#加水[String] = (throw new Exception("ii")): 大海2

type 去水3 = 测试水尺#检验[大海2]
type 大海3 = 去水3#目前去水#去[大海2]
val 大海3: 大海之初#加水[Int]#加水[String]#加水[Int]#加水[String] = (throw new Exception("ii")): 大海3

type 去水4 = 测试水尺#检验[大海3]
type 大海4 = 去水4#目前去水#去[大海3]
val 大海4: 大海之初#加水[Int]#加水[String]#加水[Int]#加水[String] = (throw new Exception("ii")): 大海4

type 去水5 = 测试水尺#检验[大海4]
type 大海5 = 去水5#目前去水#去[大海4]
val 大海5: 大海之初#加水[Int]#加水[String]#加水[Int]#加水[String] = (throw new Exception("ii")): 大海5

}
