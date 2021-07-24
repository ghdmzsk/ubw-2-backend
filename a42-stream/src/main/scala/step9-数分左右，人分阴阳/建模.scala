object HelloWorld {
	import step9._
   def main(args: Array[String]) {
      println(Item("11" * 100))
   }
}

package step9 {

case class Item(name: String)

trait Result
case class ResultP(tail: Result, item: Item) extends Result {
  override def toString: String = s"($tail, ${item.name})"
}
case object ResultZero extends Result {
  override def toString: String = "Zero"
}

trait NumLeft {
  def 左被索取(cTree: LeftCTree, method: MethodLeft): Result
}
case class NumLeftP(tail: NumLeft, head: Item) extends NumLeft {
  override def 左被索取(cTree: LeftCTree, method: MethodLeft): Result = method.左返回数据(cTree, tail, head)
}
case object NumLeftZero extends NumLeft {
  override def 左被索取(cTree: LeftCTree, method: MethodLeft): Result = method.左结束返回(cTree)
}

trait NumRight {
  def 右被索取(cTree: RightCTree, method: MethodRight): Result
}
case class NumRightP(tail: NumRight, head: Item) extends NumRight {
  override def 右被索取(cTree: RightCTree, method: MethodRight): Result = ResultZero
}
case object NumRightZero extends NumRight {
  override def 右被索取(cTree: RightCTree, method: MethodRight): Result = ResultZero
}

case class NumLR(left: NumLeft, right: NumRight) extends NumLeft with NumRight {
  override def 左被索取(cTree: LeftCTree, method: MethodLeft): Result   = ResultZero
  override def 右被索取(cTree: RightCTree, method: MethodRight): Result = ResultZero
}

trait LeftCTree

trait RightCTree

trait MethodLeft {
	def 左返回数据(cTree: LeftCTree, num: NumLeft, item: Item): Result
	def 左结束返回(cTree: LeftCTree): Result
}

trait MethodRight

}