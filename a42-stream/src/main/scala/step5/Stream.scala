package step5

case class Item(name: String)

trait 正法

trait 逆法

trait 黑树
case class 黑左正右逆平衡(left: 正法,right:逆法) extends 黑树
case class 黑左树右逆平衡(left: 黑树,right:逆法) extends 黑树