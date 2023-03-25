package a73.execution

object Runner {

  def repeat(n: Int, exe: Exe[Int]): Exe[Int] = (1 to n).foldLeft(exe) { (a, b) => a.flatMap(t => Exe.succeed(b).map(v => v + t)) }

  def main(arr: Array[String]): Unit = {
    println(repeat(100, Exe.succeed(-50)))
    println(Exe.unsafeRun(repeat(100, Exe.succeed(-50))))
  }

}
