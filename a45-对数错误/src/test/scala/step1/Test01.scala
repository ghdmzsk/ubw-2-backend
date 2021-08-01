package step1

import org.scalatest.matchers.should.Matchers
import org.scalacheck._
import org.scalatest.wordspec.AnyWordSpec

class Test01 extends AnyWordSpec with Matchers {
  val smallInteger = Gen.choose(0, 100000)

  "log" should {
    "tran with true log" in {
      Prop.forAll(smallInteger, smallInteger) { (n1, n2) =>
        n1 > 10 == true
      }
    }
  }

}
