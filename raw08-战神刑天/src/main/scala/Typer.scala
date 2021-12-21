import scala.language.higherKinds

object Typer {

  class 身体1
  class 身体2
  class 身体3
  class 身体4
  class 身体5
  class 身体6
  type 人的身体 = HNil#Append[身体6]#Append[身体5]#Append[身体4]#Append[身体3]#Append[身体2]#Append[身体1]

  val h1: HNil#Append[身体5]#Append[身体4]#Append[身体3]#Append[身体2]#Append[身体1] = (throw new Exception("ii")): 人的身体#Contribute
  val h2: HNil#Append[身体4]#Append[身体3]#Append[身体2]#Append[身体1]             = (throw new Exception("ii")): 人的身体#Contribute#Contribute
  val h3: HNil#Append[身体3]#Append[身体2]#Append[身体1] = (throw new Exception("ii")): 人的身体#Contribute#Contribute#Contribute
  val h4: HNil#Append[身体2]#Append[身体1]             = (throw new Exception("ii")): 人的身体#Contribute#Contribute#Contribute#Contribute

}
