package step8

object Tagger {

  val arr: Array[Boolean] = Array.fill(44)(false)

  def update(n: Int): Unit = arr(n) = true

  override def toString: String = arr.zipWithIndex.mkString("(", ",", ")")
  def falseItem: String         = arr.zipWithIndex.filter(_._1 == false).mkString("(", ",", ")")

}
