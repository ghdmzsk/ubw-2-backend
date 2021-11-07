package a19.step9

class 类型匹配[T]

object 类型匹配 {
  def apply[T]                                              = new 类型匹配[T]
  def apply[T](i: 类型匹配[T], ii: 类型匹配[T]): (类型匹配[T], 类型匹配[T]) = (i, ii)
}

class Item1
class Item2
class Item3
class Item4
class Item5
class Item6
class Item7
class Item8
class Item9
class Item10
class Item11
class Item12
class Item13
class Item14
class Item15
class Item16
class Item17
class Item18
class Item19
class Item20
class Item21
class Item22
class Item23
class Item24
class Item25
class Item26
class Item27
class Item28
class Item29
class Item30
class Item31
class Item32
class Item33
class Item34
class Item35
class Item36
class Item37
class Item38
class Item39
class Item40
class Item41
class Item42
class Item43
class Item44
class Item45
class Item46
class Item47
class Item48
class Item49
class Item50
class Item51
class Item52
class Item53
class Item54
class Item55
class Item56
class Item57
class Item58
class Item59
class Item60
class Item61
class Item62
class Item63
class Item64
class Item65
class Item66
class Item67
class Item68
class Item69
class Item70
class Item71
class Item72
class Item73
class Item74
class Item75
class Item76
class Item77
class Item78
class Item79
class Item80
class Item81
class Item82
class Item83

object 测试 {

  type r6  = 上层_2[Item1, Item2, 底层_2[Item3, Item4, Item5], 底层_0[Item6]]
  type r11 = r6#Next[Item7]#Next[Item8]#Next[Item9]#Next[Item10]#Next[Item11]
  type r18 = r11#Next[Item12]#Next[Item13]#Next[Item14]#Next[Item15]#Next[Item16]#Next[Item17]#Next[Item18]
  type r27 = r18#Next[Item19]#Next[Item20]#Next[Item21]#Next[Item22]#Next[Item23]#Next[Item24]#Next[Item25]#Next[Item26]
  type r36 =
    r27#Next[Item27]#Next[Item28]#Next[Item29]#Next[Item30]#Next[Item31]#Next[Item32]#Next[Item33]#Next[Item34]#Next[Item35]#Next[Item36]

  type r44 = r36#Next[Item37]#Next[Item38]#Next[Item39]#Next[Item40]#Next[Item41]#Next[Item42]#Next[Item43]#Next[Item44]
  type r50 = r44#Next[Item45]#Next[Item46]#Next[Item47]#Next[Item48]#Next[Item49]#Next[Item50]

  type r60 =
    r50#Next[Item51]#Next[Item52]#Next[Item53]#Next[Item54]#Next[Item55]#Next[Item56]#Next[Item57]#Next[Item58]#Next[Item59]#Next[Item60]
  type r70 =
    r60#Next[Item61]#Next[Item62]#Next[Item63]#Next[Item64]#Next[Item65]#Next[Item66]#Next[Item67]#Next[Item68]#Next[Item69]#Next[Item70]
  type r80 =
    r70#Next[Item71]#Next[Item72]#Next[Item73]#Next[Item74]#Next[Item75]#Next[Item76]#Next[Item77]#Next[Item78]#Next[Item79]#Next[Item80]
  type r83 = r80#Next[Item81]#Next[Item82]#Next[Item83]

  类型匹配(类型匹配[r11#_2_th], 类型匹配[Item2])

  类型匹配(类型匹配[r11#_1#_2_th], 类型匹配[Item5])
  类型匹配(类型匹配[r18#_2#_1_th], 类型匹配[Item7])
  类型匹配(类型匹配[r18#_1#_2#_1_th], 类型匹配[Item16])
  类型匹配(类型匹配[r36#_1#_0#_2#_1_th], 类型匹配[Item34])
  类型匹配(类型匹配[r50#_1#_2#_1#_2_th], 类型匹配[Item50])
  类型匹配(类型匹配[r60#_2#_0#_2#_0_th], 类型匹配[Item60])
  类型匹配(类型匹配[r70#_2#_1#_2#_1_th], 类型匹配[Item70])
  类型匹配(类型匹配[r80#_2#_2#_2#_2_th], 类型匹配[Item80])
  类型匹配(类型匹配[r83#_1#_0#_0#_0#_0_th], 类型匹配[Item81])
  类型匹配(类型匹配[r83#_1#_0#_0#_0#_1_th], 类型匹配[Item82])
  类型匹配(类型匹配[r83#_1#_0#_0#_0#_2_th], 类型匹配[Item83])
  类型匹配(类型匹配[r83#_2#_0#_2#_0_th], 类型匹配[Item60])
  类型匹配(类型匹配[r83#_2#_0#_2#_1_th], 类型匹配[Item61])

  def main(arr: Array[String]): Unit = {
    println("222")
  }
}
