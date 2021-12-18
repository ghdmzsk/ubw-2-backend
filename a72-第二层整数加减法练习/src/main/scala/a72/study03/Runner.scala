package a72.study03

object Runner {

  def main1(arr: Array[String]): Unit = {
    def aa(n: Int, list: List[Long]): List[Long] = {
      if (n > 2)
        aa(n - 1, (list(0) + list(1)) :: list)
      else
        list
    }
    def bb(n: Int): List[Long] = aa(n, List(1, 0)).reverse
    println(bb(25))

    println((math.pow(5, 0.5) + 1) / 2)

    val cc = (math.pow(5, 0.5) + 1) / 2
    def dd(n: Int, list: List[Long]): List[Long] = {
      if (n > 3)
        dd(n - 1, ((list(0) * cc) + 0.5).toLong :: list)
      else
        list
    }
    def ee(n: Int): List[Long] = dd(n, List(1, 1, 0)).reverse
    println(ee(25))

    assert(bb(25) == ee(25))
  }

}
