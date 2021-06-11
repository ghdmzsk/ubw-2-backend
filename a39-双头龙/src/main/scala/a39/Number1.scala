package a39

case class Item(name: String)

trait Number1
case class Number1Positive(tail: Number1, head: Item) extends Number1
case class Number1Zero(tail: () => Number2)           extends Number1

trait Number2
case class Number2Positive(tail: Number2, head: Item) extends Number2
case class Number2Zero(tail: () => Number1)           extends Number2
