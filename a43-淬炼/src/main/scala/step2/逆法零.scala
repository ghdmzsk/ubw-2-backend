package step2

/** 逆法零，为逆法量身定做的零，增幅逆法的效果，如果用在正法，则会无限增幅正法的增加效果，让结果恒为无限大
  */
case class 逆法零(tail: () => NumR) extends NumR {
  override def methodL(num: NumL, item: Item): Result = ResultP(tail().methodL(num, item), item)
}
