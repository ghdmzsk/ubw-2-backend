package 四法

trait P6Num1
case class P6Num1S(tail: P6Num1) extends P6Num1
case class P6Num1T(tail: P6Num2) extends P6Num1

trait P6Num2
case class P6Num2S(tail: P6Num2) extends P6Num2
case class P6Num2T(tail: P6Num1) extends P6Num2

object AA {

  // 4 ^ 3

  lazy val aa: P6Num1 = P6Num1S(P6Num1S(P6Num1S(P6Num1S(P6Num1T(bb)))))
  lazy val bb: P6Num2 = P6Num2T(cc)
  lazy val cc: P6Num1 = P6Num1S(P6Num1S(P6Num1S(P6Num1S(P6Num1T(dd)))))
  lazy val dd: P6Num2 = P6Num2T(ee)
  lazy val ee: P6Num1 = P6Num1S(P6Num1S(P6Num1S(P6Num1S(P6Num1T(ff)))))
  lazy val ff: P6Num2 = P6Num2T(aa)

}
