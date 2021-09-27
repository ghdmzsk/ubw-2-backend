package a61

object Runner extends App {
  for (i <- 1 to 100) {
    val yuan        = (i - 1).toDouble / i
    var num: Double = 0
    for (num1 <- 1 to 4000) {
      num += math.pow(yuan, num1) / num1
    }
    assert(math.abs(math.log(i) - num) < 0.000001d)
  }
}
