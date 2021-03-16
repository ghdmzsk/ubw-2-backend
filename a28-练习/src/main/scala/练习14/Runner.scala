package 练习14

object Runner {

  def main(arr: Array[String]): Unit = {
    println(除数(4).除(被除数(15)).value == 3)
    println(除数(4).除(被除数(16)).value == 4)
    println(除数(4).除(被除数(17)).value == 4)
    println(除数(83).除(被除数(2859)).value == 34)
    println(除数(83).除(被除数(3072)).value == 37)
    println(除数(83).除(被除数(3071)).value == 37)
    println(除数(83).除(被除数(3070)).value == 36)
  }

}
