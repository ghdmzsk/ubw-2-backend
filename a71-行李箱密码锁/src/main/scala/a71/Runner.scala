package a71

object Runner {

  lazy val number2: Number2     = Number2S(Number2S(Number2S(n2Zero)))
  lazy val n2Zero: Number2      = Number2T(tailCurrent = () => number2, tailNext = () => number2Zero)
  lazy val number2Zero: Number2 = Number2Zero(() => number2)

}
