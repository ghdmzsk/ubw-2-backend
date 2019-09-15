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

trait UnInit[Poly <: HList] {

  def toJSON[T](model: T)(implicit init: EncoderDefine[T, Poly]): Json                = init.encoder(model)
  def decode[T](json: Json)(implicit init: DecoderDefine[T, Poly]): Decoder.Result[T] = init.decoder.decodeJson(json)

}
