import io.circe.{Decoder, Encoder}
import shapeless._

import scala.language.higherKinds

case class EncoderDefine[T, Poly](val encoder: Encoder[T]) extends AnyVal
object EncoderDefine {
  implicit def implicit1[Model, H, T <: HList](implicit encoderInit: EncoderInit[Model, H]): EncoderDefine[Model, H :: T] = EncoderDefine(
    encoderInit.encoder
  )
  implicit def implicit2[Model, H, T <: HList](implicit encoderInit: EncoderDefine[Model, T]): EncoderDefine[Model, H :: T] = EncoderDefine(
    encoderInit.encoder
  )
}

case class DecoderDefine[T, Poly](val decoder: Decoder[T]) extends AnyVal
object DecoderDefine {
  implicit def implicit1[Model, H, T <: HList](implicit decoderInit: DecoderInit[Model, H]): DecoderDefine[Model, H :: T] = DecoderDefine(
    decoderInit.decoder
  )
  implicit def implicit2[Model, H, T <: HList](implicit decoderInit: DecoderDefine[Model, T]): DecoderDefine[Model, H :: T] = DecoderDefine(
    decoderInit.decoder
  )
}
