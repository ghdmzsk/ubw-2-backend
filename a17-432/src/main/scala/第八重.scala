package a17

trait 嫁衣神功 {
  type Tail <: 嫁衣神功
  type Head
}

class 第八重 extends 嫁衣神功 {
  override type Tail = 开始
  override type Head = 我
  class 开始 extends 嫁衣神功 {
    override type Tail = 继续
    override type Head = 叼
    class 继续 extends 嫁衣神功 {
      override type Tail = 余根
      override type Head = 你
      class 余根 extends 嫁衣神功 {
        override type Tail = 开始辛苦
        override type Head = 老
        class 开始辛苦 extends 嫁衣神功 {
          override type Tail = 顶唔顺
          override type Head = 味
          class 顶唔顺 extends 嫁衣神功 {
            override type Tail = 每次都重构类型系统_裸命咩
            override type Head = 个
            class 每次都重构类型系统_裸命咩 extends 嫁衣神功 {
              override type Tail = 入咗恶人谷扑街
              override type Head = 西
              class 入咗恶人谷扑街 extends 嫁衣神功 {
                override type Tail = 开始辛苦
                override type Head = 啊
              }
            }
          }
        }
      }
    }
  }
}
