package a74.step2

object Runner {

  def main(arr: Array[String]): Unit = {
    val a = Number1T((a: Int) => (a + 1).toString, (s: String) => s.toInt - 1)
    val b = Number2T((a: String) => a.toInt + 1, (a: Int) => (a - 1).toString)
    val c = Number1S(a, b)
    val d = Number2S(b, a)

    val e = Number12.execNumber1(c)
    val f = Number12.execNumber2(d)

    val g: Int => Int       = t => e.func(t)
    val h: String => String = t => f.func(t)

    val i = Number12.reverseExecNumber1(c)
    val j = Number12.reverseExecNumber2(d)

    val k: Int => Int       = t => i.func(t)
    val l: String => String = t => j.func(t)

    println(g(2))   // 4
    println(h("3")) // 5

    println(k(2))   // 0
    println(l("3")) // 1
  }

}
