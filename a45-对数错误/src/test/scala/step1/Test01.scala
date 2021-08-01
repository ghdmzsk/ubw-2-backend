package step1

import org.scalacheck._

object Test01 extends Properties("log test") {
  val max  = 100
  val max2 = 200000

  val genEven1: Gen[Int] = Gen.choose(2, max)
  val genEven2: Gen[Int] = Gen.choose(1, max2)

  val runner1 = new RunnerContext
  property("log should tran with true log") = Prop.forAll(genEven1, genEven2) { (n1, n2) =>
    val result = runner1.printlnLog(n1, n2)
    println("=1=", result)
    result.leftResult == result.rightResult
  }

  val runner2 = new RunnerContext
  property("log should tran with true log2") = Prop.forAll(genEven1, genEven2) { (n1, n2) =>
    val result = runner2.printlnLog(n1, n2)
    println("=2=", result)
    result.leftResult == result.rightResult
  }

}
