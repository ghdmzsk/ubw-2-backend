package a73.execution

import scala.annotation.tailrec

trait Exe[+T] {
  def map[V](s: T => V): Exe[V]          = ExeMap(this, s)
  def flatMap[V](s: T => Exe[V]): Exe[V] = ExeFlatMap(this, s)
}
case class ExeSuccess[+T](value: T)                       extends Exe[T]
case class ExeMap[U, T](u: Exe[U], func: U => T)          extends Exe[T]
case class ExeFlatMap[U, T](u: Exe[U], func: U => Exe[T]) extends Exe[T]

object Exe {

  def succeed[T](v: T): Exe[T] = ExeSuccess(v)

  def unsafeRun[T](e: Exe[T]): T = {
    var v: List[Either[Any => Any, Any => Exe[Any]]] = List.empty
    @tailrec
    def loop(exe: Exe[Any]): Unit = exe match {
      case ExeSuccess(value) =>
        v = Left((_: Any) => value) :: v
      case ExeMap(u, func) =>
        v = Left(func.asInstanceOf[Any => Any]) :: v
        loop(u)
      case ExeFlatMap(u, func) =>
        v = Right(func.asInstanceOf[Any => Exe[Any]]) :: v
        loop(u)
    }
    loop(e)

    var temp: Any = v.head.asInstanceOf[Left[Unit => Any, Any]].left.getOrElse(throw new Exception("Not allowed head"))(())
    v = v.tail
    var i = 0
    while (i < v.size - 1) {
      v.head match {
        case Left(func) => temp = func(temp)
        case Right(func) =>
          val exe = func(temp)
          temp = unsafeRun(exe)
      }
      v = v.tail
      i += 1
    }

    temp.asInstanceOf[T]
  }

}

trait Number[A] {
  def execute[ToDataType, Result](contexts: Context[ToDataType, A, Result])(t: ToDataType): Result
}
case class NumberS[A](tail: () => Number[A], head: A) extends Number[A] {
  override def execute[ToDataType, Result](context: Context[ToDataType, A, Result])(t: ToDataType): Result = context.bindS(t, tail(), head)
}
case class NumberT[A](tail: () => Number[A]) extends Number[A] {
  override def execute[ToDataType, Result](context: Context[ToDataType, A, Result])(t: ToDataType): Result = context.bindT(t, tail())
}

trait Context[ToDataType, A, Result] {
  def bindS(t: ToDataType, current: Number[A], head: A): Result
  def bindT(t: ToDataType, current: Number[A]): Result
}
