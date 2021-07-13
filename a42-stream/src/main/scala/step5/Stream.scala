package step5

case class Item(name: String)

trait 正法

trait 逆法

trait 黑树

case class 黑左逆右正(left: 逆法, right: 正法) extends 黑树
case class 黑左逆右逆(left: 逆法, right: 逆法) extends 黑树
case class 黑左逆右树(left: 逆法, right: 黑树) extends 黑树
case class 黑左正右正(left: 正法, right: 正法) extends 黑树
case class 黑左正右逆(left: 正法, right: 逆法) extends 黑树
case class 黑左正右树(left: 正法, right: 黑树) extends 黑树
case class 黑左树右正(left: 黑树, right: 正法) extends 黑树
case class 黑左树右逆(left: 黑树, right: 逆法) extends 黑树
case class 黑左树右树(left: 黑树, right: 黑树) extends 黑树

trait 白树

case object 白树零                              extends 白树
case class 白正(left: 逆法, right: 正法, sub: 白树)  extends 白树
case class 白逆(left: 逆法, right: 逆法, sub: 白树)  extends 白树
case class 白黑树(left: 逆法, right: 黑树, sub: 白树) extends 白树
