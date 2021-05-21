package step1

trait 底数被吃 {
  type 被吃[T <: 底数吃, M <: 底数中间] <: 指数
}
trait 底数吃 {
  type 吃[T <: 底数中间, B <: 底数被吃] <: 指数
}
trait 底数中间 {
  type 中间[T <: 底数吃, B <: 底数被吃] <: 指数
}

class 底数被吃Positive[Tail <: 底数被吃] extends 底数被吃 {
  override type 被吃[T <: 底数吃, M <: 底数中间] = T#吃[M, Tail]
}
class 底数被吃Zero extends 底数被吃 {
  override type 被吃[T <: 底数吃, M <: 底数中间] = 指数Zero
}

class 底数中间Positive[Tail <: 底数中间] extends 底数中间 {
  override type 中间[T <: 底数吃, B <: 底数被吃] = T#吃[Tail, B]
}
class 底数中间Zero[Tail <: 底数中间] extends 底数中间 {
  override type 中间[T <: 底数吃, B <: 底数被吃] = B#被吃[T, Tail]
}

class 底数吃Positive[Tail <: 底数吃, Head] extends 底数吃 {
  override type 吃[M <: 底数中间, B <: 底数被吃] = 指数Positive[Tail#吃[M, B], Head]
}
class 底数吃Zero[Tail <: 底数吃] extends 底数吃 {
  override type 吃[M <: 底数中间, B <: 底数被吃] = M#中间[Tail, B]
}

trait Creator[T] {
  def create: T
}
object Creator {
  def apply[T](implicit c: Creator[T]): T = c.create
}

class Item2
object Item2 {
  implicit def item2Creater: Creator[Item2] = new Creator[Item2] {
    override def create: Item2 = new Item2
  }
}

trait 指数 {
  def length: Int
}
class 指数Positive[Tail <: 指数, Head](tail: Tail, head: Head) extends 指数 {
  override def length: Int = tail.length + 1
}
object 指数Positive {
  implicit def positiveImplicit[Tail <: 指数, Head](implicit tail: Creator[Tail], head: Creator[Head]): Creator[指数Positive[Tail, Head]] =
    new Creator[指数Positive[Tail, Head]] {
      override def create: 指数Positive[Tail, Head] = new 指数Positive(tail = tail.create, head = head.create)
    }
}

class 指数Zero extends 指数 {
  override def length: Int = 0
}
object 指数Zero {
  implicit val zeroCreator: Creator[指数Zero] = new Creator[指数Zero] {
    override def create: 指数Zero = new 指数Zero
  }
}
