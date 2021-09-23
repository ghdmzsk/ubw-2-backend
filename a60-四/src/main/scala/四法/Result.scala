package 四法

trait Result
case class ResultS(tail: Result) extends Result
case object ResultT              extends Result
