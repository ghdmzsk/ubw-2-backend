import io.circe.{Decoder, Encoder, Json}
import shapeless._

import scala.language.higherKinds

trait ImportCompanion[II <: HList] extends Any {

  implicit def implicit11[Model](implicit i: EncoderInit[Model, II]): Encoder[Model]                           = i.encoder
  implicit def implicit12[H, I <: HList, Model](implicit i: EncoderInit[Model, H]): EncoderInit[Model, H :: I] = EncoderInit(i.encoder)
  implicit def implicit13[H, I <: HList, Model](implicit i: EncoderInit[Model, I]): EncoderInit[Model, H :: I] = EncoderInit(i.encoder)
  implicit def implicit21[Model](implicit i: DecoderInit[Model, II]): Decoder[Model]                           = i.decoder
  implicit def implicit22[H, I <: HList, Model](implicit i: DecoderInit[Model, H]): DecoderInit[Model, H :: I] = DecoderInit(i.decoder)
  implicit def implicit23[H, I <: HList, Model](implicit i: DecoderInit[Model, I]): DecoderInit[Model, H :: I] = DecoderInit(i.decoder)

}

trait UnInit[Poly] {

  def toJSON[T](model: T)(implicit init: EncoderInit[T, Poly]): Json                = init.encoder(model)
  def decode[T](json: Json)(implicit init: DecoderInit[T, Poly]): Decoder.Result[T] = init.decoder.decodeJson(json)

}

object Runner extends App {

  val i1 = 苹果("苹果名称1", 12)
  val i2 = 桃("桃名称2", 13)
  val i3 = 鸡("桃名称3", 14)
  val i4 = 鹅("桃名称4", 15)
  val i5 = 走地鸡("走地鸡名称5", 16)
  val i6 = 蛋糕("蛋糕名称6", 18)

  val i8 = 神坛(i1, i2, i3, i4, i5, i6)

  object PolyJson extends UnInit[神坛包裹类]

  val str = PolyJson.toJSON(i8)
  println(str.noSpaces)
  println(PolyJson.decode[神坛](str))

}
