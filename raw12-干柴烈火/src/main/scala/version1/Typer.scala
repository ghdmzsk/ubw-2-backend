package version1

import scala.language.higherKinds

trait Typer {

  type 柴1 = 没有铁的锅#加铁[热透的铁#初始化#初始化#初始化]#加铁[热透的铁#初始化#初始化]#加铁[热透的铁#初始化#初始化]#加铁[热透的铁#初始化]

  type 柴2 = 柴1#武火
  val a2: 没有铁的锅#加铁[热透的铁#初始化#初始化]#加铁[热透的铁#初始化]#加铁[热透的铁#初始化]#加铁[热透的铁] = (throw new Exception("ii")): 柴2

  type 柴3 = 柴2#武火
  val a3: 没有铁的锅#加铁[热透的铁#初始化]#加铁[热透的铁]#加铁[热透的铁]#加铁[热透的铁] = (throw new Exception("ii")): 柴3

  type 柴4 = 柴3#武火
  val a4: 没有铁的锅#加铁[热透的铁]#加铁[热透的铁]#加铁[热透的铁]#加铁[热透的铁] = (throw new Exception("ii")): 柴4

  type 柴5 = 柴4#武火
  val a5: 没有铁的锅#加铁[热透的铁]#加铁[热透的铁]#加铁[热透的铁]#加铁[热透的铁] = (throw new Exception("ii")): 柴5

}
