import io.circe.generic.semiauto._
import shapeless._

case class 苹果(苹果名称: String, 苹果大小: Int)
case class 桃(桃名称: String, 桃大小: Int)
case class 鸡(鸡名称: String, 鸡大小: Int, 神坛: Option[神坛])
case class 鹅(鹅名称: String, 鹅大小: Int)
case class 走地鸡(走地鸡名称: String, 走地鸡大小: Int)
case class 蛋糕(蛋糕名称: String, 蛋糕大小: Int)
case class 神坛(苹果: 苹果, 桃: 桃, 鸡: 鸡, 鹅: 鹅, 走地鸡: 走地鸡, 蛋糕: 蛋糕)

trait 水果 {
  type Init[T]  = EncoderInit[T, 水果]
  type Init1[T] = DecoderInit[T, 水果]
  implicit def implicit1: Init[苹果]  = EncoderInit(deriveEncoder)
  implicit def implicit2: Init1[苹果] = DecoderInit(deriveDecoder)

  implicit def implicit3: Init[桃]  = EncoderInit(deriveEncoder)
  implicit def implicit4: Init1[桃] = DecoderInit(deriveDecoder)
}

object 水果 extends 水果

trait 禽类 {
  object implicitI extends ImportCompanion[神坛包裹类 :: HNil]
  import implicitI._

  type Init[T]  = EncoderInit[T, 禽类]
  type Init1[T] = DecoderInit[T, 禽类]
  implicit def implicit1: Init[鸡]  = EncoderInit(deriveEncoder)
  implicit def implicit2: Init1[鸡] = DecoderInit(deriveDecoder)

  implicit def implicit3: Init[鹅]  = EncoderInit(deriveEncoder)
  implicit def implicit4: Init1[鹅] = DecoderInit(deriveDecoder)

  implicit def implicit5: Init[走地鸡]  = EncoderInit(deriveEncoder)
  implicit def implicit6: Init1[走地鸡] = DecoderInit(deriveDecoder)
}

object 禽类 extends 禽类

trait 蛋糕类 {
  type Init[T]  = EncoderInit[T, 蛋糕类]
  type Init1[T] = DecoderInit[T, 蛋糕类]
  implicit def implicit1: Init[蛋糕]  = EncoderInit(deriveEncoder)
  implicit def implicit2: Init1[蛋糕] = DecoderInit(deriveDecoder)
}

object 蛋糕类 extends 蛋糕类

trait 神坛包裹类 {
  object implicitI extends ImportCompanion[水果 :: 禽类 :: 蛋糕类 :: HNil]
  import implicitI._

  type Init[T]  = EncoderInit[T, 神坛包裹类]
  type Init1[T] = DecoderInit[T, 神坛包裹类]
  implicit def implicit1: Init[神坛]  = EncoderInit(deriveEncoder)
  implicit def implicit2: Init1[神坛] = DecoderInit(deriveDecoder)
}

object 神坛包裹类 extends 神坛包裹类
