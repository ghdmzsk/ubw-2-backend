package step7

object Tagger {

  val arr: Array[Boolean] = new Array[Boolean](8)

  def update(n: Int): Unit = arr(n) = true

  override def toString: String = arr.zipWithIndex.mkString("(", ",", ")")

}
