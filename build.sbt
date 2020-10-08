UbwSettings.scalaVersionSettings

val rootDir = file(".")

val file_a01 = rootDir / "a01-整数加法"
val a01_1    = project in (file_a01 / "错误代码1")
val a01_2    = project in (file_a01 / "正确代码1")
val a01_3    = project in (file_a01 / "改进代码1")
val a02      = project in (rootDir / "a02-二进制后继")

val file_a03   = rootDir / "a03-十进制后继"
val a03Codegen = project in (file_a03 / "a03-codegen")
val a03        = project in (file_a03 / "a03-core")

val file_a04   = rootDir / "a04-进制后续"
val a04Codegen = project in (file_a04 / "a04-codegen")
val a04Core01  = project in (file_a04 / "a04-core-01")

val a05 = project in (rootDir / "a05-后悔药")

val file_a06 = rootDir / "a06-倾诉"
val a06_1    = project in (file_a06 / "错误代码1")
val a06_2    = project in (file_a06 / "正确代码1")
val a06_3    = project in (file_a06 / "更正代码1")

val file_a07 = rootDir / "a07-消融"
val a07_1    = project in (file_a07 / "错误代码1")
val a07_2    = project in (file_a07 / "修正代码1")

val a08 = project in (rootDir / "a08-整数加法")
val a09 = project in (rootDir / "a09-改变")
val a10 = project in (rootDir / "a10-自然数乘法")
val a11 = project in (rootDir / "a11-自然数提取")
val a12 = project in (rootDir / "a12-进制提取")
val a13 = project in (rootDir / "a13-加减乘除")
val a14 = project in (rootDir / "a14-魔王勇者")
