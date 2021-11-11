package a70

object 正确加法 {

  def main(arr: Array[String]): Unit = {
    {
      def genNumber1(n: Int): Number1 = if (n > 0) Number1S(() => genNumber1(n - 1)) else Number1V(() => genNumber1(n - 1))
      def genNumber2(n: Int): Number1 = if (n > 0) Number1S(() => genNumber2(n - 1)) else Number1T(() => genNumber2(n - 1))
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } yield {
        val result1 = Counter.countThrow(() => genNumber1(i1).method1(genNumber2(i2)))
        val result2 = i1 + i2
        assert(result1 == result2)
      }
    }
    {
      def genNumber1(n: Int): Number1 = if (n > 0) Number1S(() => genNumber1(n - 1)) else Number1V(() => genNumber1(n - 1))
      def genNumber2(n: Int): Number1 = if (n > 0) Number1U(() => genNumber2(n - 1)) else Number1T(() => genNumber2(n - 1))
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } yield {
        val result1 = Counter.countThrow(() => genNumber1(i1).method1(genNumber2(i2)))
        val result2 = i1 + i2
        assert(result1 == result2)
      }
    }
    {
      def genNumber1(n: Int): Number1 = if (n > 0) Number1S(() => genNumber1(n - 1)) else Number1V(() => genNumber1(n - 1))
      def genNumber2(n: Int): Number1 = if (n > 0) Number1S(() => genNumber2(n - 1)) else Number1V(() => genNumber2(n - 1))
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } yield {
        val result1 = Counter.countThrow(() => genNumber1(i1).method1(genNumber2(i2)))
        val result2 = i1 + i2
        assert(result1 == result2)
      }
    }
    {
      def genNumber1(n: Int): Number1 = if (n > 0) Number1S(() => genNumber1(n - 1)) else Number1V(() => genNumber1(n - 1))
      def genNumber2(n: Int): Number1 = if (n > 0) Number1U(() => genNumber2(n - 1)) else Number1V(() => genNumber2(n - 1))
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } yield {
        val result1 = Counter.countThrow(() => genNumber1(i1).method1(genNumber2(i2)))
        val result2 = i1 + i2
        assert(result1 == result2)
      }
    }
    {
      def genNumber1(n: Int): Number1 = if (n > 0) Number1U(() => genNumber1(n - 1)) else Number1V(() => genNumber1(n - 1))
      def genNumber2(n: Int): Number1 = if (n > 0) Number1S(() => genNumber2(n - 1)) else Number1V(() => genNumber2(n - 1))
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } yield {
        val result1 = Counter.countThrow(() => genNumber1(i1).method1(genNumber2(i2)))
        val result2 = i1 + i2
        assert(result1 == result2)
      }
    }
    {
      def genNumber1(n: Int): Number1 = if (n > 0) Number1U(() => genNumber1(n - 1)) else Number1V(() => genNumber1(n - 1))
      def genNumber2(n: Int): Number1 = if (n > 0) Number1U(() => genNumber2(n - 1)) else Number1V(() => genNumber2(n - 1))
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } yield {
        val result1 = Counter.countThrow(() => genNumber1(i1).method1(genNumber2(i2)))
        val result2 = i1 + i2
        assert(result1 == result2)
      }
    }
  }

}
