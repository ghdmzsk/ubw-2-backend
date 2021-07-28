package step2

/** 正法零，为正法量身定做的零，增幅正法的效果，如果用在逆法，则会无限增幅逆法的减少效果，让结果恒为零
  */
case class 正法零(tail: () => NumR) extends NumR {
  override def methodL(num: NumL, item: Item): Result = num.methodR(tail())
}
