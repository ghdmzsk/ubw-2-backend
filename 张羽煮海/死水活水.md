在这篇文章里, 我们新建一个类型系统模型, 用它来表示池塘水升高和降低的过程.

我们来看看代码演示部分

type 测试水尺 = 初始水尺#下一重#下一重#下一重#下一重
type 池塘0  = 池塘之初#加水[Int]#加水[String]

type 舀水1 = 测试水尺#检验[池塘0]
type 池塘1 = 舀水1#目前舀水#舀[池塘0, String]
val 池塘1: 池塘之初#加水[Int]#加水[String]#加水[String] = (throw new Exception("ii")): 池塘1

type 舀水2 = 测试水尺#检验[池塘1]
type 池塘2 = 舀水2#目前舀水#舀[池塘1, Int]
val 池塘2: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int] = (throw new Exception("ii")): 池塘2

type 舀水3 = 测试水尺#检验[池塘2]
type 池塘3 = 舀水3#目前舀水#舀[池塘2, Long]
val 池塘3: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int]#加水[Long] = (throw new Exception("ii")): 池塘3

type 舀水4 = 测试水尺#检验[池塘3]
type 池塘4 = 舀水4#目前舀水#舀[池塘3, Short]
val 池塘4: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int]#加水[Short] = (throw new Exception("ii")): 池塘4

type 舀水5 = 测试水尺#检验[池塘4]
type 池塘5 = 舀水5#目前舀水#舀[池塘4, String]
val 池塘5: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int]#加水[String] = (throw new Exception("ii")): 池塘5

这是一段没有运行价值的代码，可以看到, 池塘没有满水的时候水是正常加进水中的，满水之后就没有再装进更多的水了，而什么时候满水在一开始就决定了，这也符合日常逻辑。

但这并不能完整地表示水满了的情况，水满了之后水只会在最上一层满溢掉，这与现实不符。

所以还有 version2,

在一个 70 毫升的大雨中漫步期间, 我想出了第二个实现(滑稽), 下面是效果代码:

type 测试水尺 = 初始水尺#下一重#下一重#下一重#下一重
type 池塘0  = 池塘之初#加水[Int]#加水[String]#加水[Int]#加水[String]#加水[String]#加水[String]

type 去水1 = 测试水尺#检验[池塘0]
type 池塘1 = 去水1#目前去水#去[池塘0]
val 池塘1: 池塘之初#加水[Int]#加水[String]#加水[Int]#加水[String]#加水[String] = (throw new Exception("ii")): 池塘1

type 去水2 = 测试水尺#检验[池塘1]
type 池塘2 = 去水2#目前去水#去[池塘1]
val 池塘2: 池塘之初#加水[Int]#加水[String]#加水[Int]#加水[String] = (throw new Exception("ii")): 池塘2

type 去水3 = 测试水尺#检验[池塘2]
type 池塘3 = 去水3#目前去水#去[池塘2]
val 池塘3: 池塘之初#加水[Int]#加水[String]#加水[Int]#加水[String] = (throw new Exception("ii")): 池塘3

type 去水4 = 测试水尺#检验[池塘3]
type 池塘4 = 去水4#目前去水#去[池塘3]
val 池塘4: 池塘之初#加水[Int]#加水[String]#加水[Int]#加水[String] = (throw new Exception("ii")): 池塘4

type 去水5 = 测试水尺#检验[池塘4]
type 池塘5 = 去水5#目前去水#去[池塘4]
val 池塘5: 池塘之初#加水[Int]#加水[String]#加水[Int]#加水[String] = (throw new Exception("ii")): 池塘5

可以看出, 水是先累积到超过最高的水线, 然后才流向其他地方的, 也就是雨水是先在路面累积然后才流去排水口的, 在水的高度低于满溢的高度之后, 水便不会再溢出, 除非再次重复加水和排水操作.

大家发现, 第一种情况中, 满水之后的操作已经没有了意义, 一直都不满的水在生活中对应死水.

在第二种情况中, 水只要到了水尺规定的深度之后就不会再下降, 所以只有水是一直满溢的才会有意义, 这个在生活中对应活水.

眼尖的吃瓜群众已经发现了, 死水的最终高度似乎比活水高上一层, 那有没有方法调成最终高度一样呢? 我的答案是: 无法用普通手段和谐.

最终高度高一点点这个特征, 其实可以把死水比喻成男性, 活水比喻成女性. 具体的分析我们在总集篇慢慢道来.

现在把这两段代码合二为一, 就可以比喻一个有水源, 而且有去水口的水塘加加减减的过程了:

type 舀水水尺 = 初始水尺#下一重#下一重#下一重#下一重
type 去水水尺 = 初始水尺#下一重#下一重
type 池塘0  = 池塘之初#加水[Int]#加水[String]

type 舀水1 = 舀水水尺#检验[池塘0]
type 池塘1 = 舀水1#目前舀水#舀[池塘0, String]
val 池塘1: 池塘之初#加水[Int]#加水[String]#加水[String] = (throw new Exception("ii")): 池塘1

type 舀水2 = 舀水水尺#检验[池塘1]
type 池塘2 = 舀水2#目前舀水#舀[池塘1, Int]
val 池塘2: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int] = (throw new Exception("ii")): 池塘2

type 舀水3 = 舀水水尺#检验[池塘2]
type 池塘3 = 舀水3#目前舀水#舀[池塘2, Long]
val 池塘3: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int]#加水[Long] = (throw new Exception("ii")): 池塘3

type 舀水4 = 舀水水尺#检验[池塘3]
type 池塘4 = 舀水4#目前舀水#舀[池塘3, Short]
val 池塘4: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int]#加水[Short] = (throw new Exception("ii")): 池塘4

type 去水5 = 去水水尺#检验[池塘4]
type 池塘5 = 去水5#目前去水#去[池塘4]
val 池塘5: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int] = (throw new Exception("ii")): 池塘5

type 去水6 = 去水水尺#检验[池塘5]
type 池塘6 = 去水6#目前去水#去[池塘5]
val 池塘6: 池塘之初#加水[Int]#加水[String]#加水[String] = (throw new Exception("ii")): 池塘6

type 去水7 = 去水水尺#检验[池塘6]
type 池塘7 = 去水7#目前去水#去[池塘6]
val 池塘7: 池塘之初#加水[Int]#加水[String] = (throw new Exception("ii")): 池塘7

type 去水8 = 去水水尺#检验[池塘7]
type 池塘8 = 去水8#目前去水#去[池塘7]
val 池塘8: 池塘之初#加水[Int]#加水[String] = (throw new Exception("ii")): 池塘8

被舀进来的水一般而言是清水, 对应死水(男)的模型, 流出去的水会变成浊水, 对应活水(女)的模型. 男清女浊由此而来.