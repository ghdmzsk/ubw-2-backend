import io.circe.{Encoder, Json, JsonObject, ObjectEncoder}

object EncoderTest extends App {

  trait FooApply[T1, T2] {
    def apply(t1: T1): T2
  }
  object FooApply {
    def func[T1, T2](func: T1 => T2): FooApply[T1, T2] = new FooApply[T1, T2] {
      override def apply(t1: T1): T2 = func(t1)
    }
  }

  trait EncoderApply[H] {
    def implicitEncoder[R, I <: TypeParam](
      implicit ll: FooApply[H, R],
      app: Application[KContext, R, I],
      cv1: FooApply[H, I#T#H],
      cv2: I#H
    ): H => Json = { h: H =>
      app.application(ii).addName(cv2)(cv1(h))
    }

    def implicitEncoder1[R](implicit ll: FooApply[H, R]): EncoderApply2[H, R] = new EncoderApply2[H, R] {}

    trait EncoderApply2[H, R] {
      def implicitEncoder[I <: TypeParam](
        implicit app: Application[KContext, R, I],
        cv1: FooApply[H, I#T#H],
        cv2: I#H
      ): H => Json = { h: H =>
        app.application(ii).addName(cv2)(cv1(h))
      }

      def implicitEncoder2[I <: TypeParam](implicit app: Application[KContext, R, I]): EncoderApply2[I] =
        new EncoderApply2[I](app)

      class EncoderApply2[I <: TypeParam](app: Application[KContext, R, I]) {
        def implicitEncoder(
          implicit cv1: FooApply[H, I#T#H],
          cv2: I#H
        ): H => Json = { h: H =>
          app.application(ii).addName(cv2)(cv1(h))
        }
      }
    }
  }

  def encoder[H]: EncoderApply[H] = new EncoderApply[H] {}

  trait JsonEncoder[T, II] {
    self =>

    def p(obj: T, name: II, m: List[(String, Json)]): List[(String, Json)]

    def addName(name: II): ObjectEncoder[T] = ObjectEncoder.instance { i =>
      JsonObject.fromIterable(self.p(i, name, List.empty))
    }

  }

  class KContext extends KindContext {
    override type M[P <: TypeParam] = JsonEncoder[P#T#H, P#H]
  }

  object ii extends Context[KContext] {
    override def isReverse: Boolean = false
    override def useHList: Boolean  = false

    override def append[X <: TypeParam, Y <: TypeParam, Z <: TypeParam](
      x: JsonEncoder[X#T#H, X#H],
      y: JsonEncoder[Y#T#H, Y#H],
      plus: Plus[X, Y, Z]
    ): JsonEncoder[Z#T#H, Z#H] = new JsonEncoder[Z#T#H, Z#H] {
      override def p(obj: Z#T#H, name: Z#H, m: List[(String, Json)]): List[(String, Json)] =
        x.p(plus.sub.takeTail(obj), plus.takeTail(name), y.p(plus.sub.takeHead(obj), plus.takeHead(name), m))
    }

    override def start: JsonEncoder[KongWeiZero, KongWeiZero] = new JsonEncoder[KongWeiZero, KongWeiZero] {
      override def p(name: KongWeiZero, obj: KongWeiZero, m: List[(String, Json)]): List[(String, Json)] = m
    }
  }

  class TypeParam1[T1] extends TypeParam {
    override type H = T1
    override type T = EndParam
  }

  class TypeParam2[T1, T2] extends TypeParam {
    override type H = T1
    override type T = TypeParam1[T2]
  }

  implicit def propertyEncoder[T1](
    implicit encoder: ByNameImplicit[Encoder[T1]]
  ): Application[KContext, T1, TypeParam2[String, T1]] = new Application[KContext, T1, TypeParam2[String, T1]] {
    override def application(context: Context[KContext]): JsonEncoder[T1, String] = new JsonEncoder[T1, String] {
      override def p(obj: T1, name: String, m: List[(String, Json)]): List[(String, Json)] =
        ((name, encoder.value(obj))) :: m
    }
  }

  case class Foo(i1: String, i2: String, i3: Int, i4: String, i5: Int, i6: Int, i7: Int)

  implicit val ii1 = FooApply.func { foo: Foo =>
    KongWeiZero.value.add(foo.i1).add(foo.i2).add(foo.i3).add(foo.i4).add(foo.i5).add(foo.i6).add(foo.i7)
  }
  implicit val ii2 = KongWeiZero.value.add("i1").add("i2").add("i3").add("i4").add("i5").add("i6").add("i7")

  println(encoder[Foo].implicitEncoder.apply(Foo("i1", "i2", 3, "i4", 5, 6, 7)).noSpaces)

}
