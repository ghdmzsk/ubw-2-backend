object Test01 {

  trait Space {
    type Current
    type Sub <: Space
    def current: Current
    def sub: Sub
  }

  class 黄土 extends Space {
    self =>
    override val current: String = "黄土"
    override type Current = String
    override type Sub     = 黄土
    override def sub: 黄土 = self
  }

  class 地面 extends Space {
    self =>
    override val current: String = "地狱"
    override type Current = String
    override type Sub     = 地狱
    override def sub: 地狱 = new 地狱
  }

  class 地狱 extends Space {
    self =>
    override val current: String = "地狱"
    override type Current = String
    override type Sub     = 地狱
    override def sub: 地狱 = self
  }

  class 玩具1 extends Space {
    self =>
    override val current: String = "黄泉上面的玩具"
    override type Current = String
    override type Sub     = 黄土
    override def sub: 黄土 = new 黄土
  }

  class 玩具2 extends Space {
    self =>
    override val current: String = "地狱上面的玩具"
    override type Current = String
    override type Sub     = 地面
    override def sub: 地面 = new 地面
  }

  class 天空1 extends Space {
    self =>
    override val current: String = "天空1"
    override type Current = String
    override type Sub     = 玩具1
    override def sub: 玩具1 = new 玩具1
  }

  class 天空2 extends Space {
    self =>
    override val current: String = "天空2"
    override type Current = String
    override type Sub     = 玩具2
    override def sub: 玩具2 = new 玩具2
  }

  val a1: 玩具1 = (throw new Exception("ii")): 天空1#Sub // 不可再获取天空1

}
