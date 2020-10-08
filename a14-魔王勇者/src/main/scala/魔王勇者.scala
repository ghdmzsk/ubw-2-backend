package a14.魔王勇者

trait 起源 {
  type Next[T] <: 起源
}

trait 勇者 extends 起源 {
  type Next[T] <: 勇者
  type 挑战[N <: 灵物] <: 起源
}

class 勇者起源 extends 勇者 {
  override type Next[T]     = 勇者肉体[勇者起源, T]
  override type 挑战[N <: 灵物] = N
}

class 勇者肉体[Tail <: 勇者, Head](val tail: Tail, val head: Head) extends 勇者 {
  override type Next[T]     = 勇者肉体[勇者肉体[Tail, Head], T]
  override type 挑战[N <: 灵物] = N#守护宝物[Tail, Head]
}

trait 灵物 extends 起源 {
  type Next[T] <: 灵物
  type 守护宝物[N <: 勇者, Head] <: 起源
}

trait 奖励 extends 灵物 {
  type Next[T] <: 灵物
  override type 守护宝物[N <: 勇者, Head] <: 起源
  type 献给胜利[N <: 勇者] <: 勇者
}

class 奖励起源 extends 奖励 {
  override type Next[T]             = 奖励物质[奖励起源, T]
  override type 守护宝物[N <: 勇者, Head] = 勇者肉体[N, Head]
  override type 献给胜利[N <: 勇者]       = N
}

class 奖励物质[Tail <: 奖励, Head](val tail: Tail, val head: Head) extends 奖励 {
  override type Next[T]             = 奖励物质[奖励物质[Tail, Head], T]
  type 添加枷锁[T]                      = 魔王的守护[奖励物质[Tail, Head], T]
  override type 守护宝物[N <: 勇者, Head] = 献给胜利[勇者肉体[N, Head]]
  override type 献给胜利[N <: 勇者]       = 勇者肉体[Tail#献给胜利[N], Head]
}

class 魔王的守护[Tail <: 灵物, Head](val tail: Tail, val head: Head) extends 灵物 {
  override type Next[T]             = 魔王的守护[魔王的守护[Tail, Head], T]
  override type 守护宝物[N <: 勇者, Head] = N#挑战[Tail]
}
