import io.circe.{Decoder, Encoder}

import scala.language.higherKinds

case class EncoderInit[T, Poly](val encoder: Encoder[T]) extends AnyVal
case class DecoderInit[T, Poly](val decoder: Decoder[T]) extends AnyVal
