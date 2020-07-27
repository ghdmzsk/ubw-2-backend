UbwSettings.scalaVersionSettings

val file_a01   = file(".") / "a01-整数加法"
val a01_error1 = project in (file_a01 / "错误代码1")
val a01_right1 = project in (file_a01 / "正确代码1")
val a01_right2 = project in (file_a01 / "改进代码1")
val a02        = project in (file(".") / "a02-二进制后继")

val file_a03   = file(".") / "a03-十进制后继"
val a03Codegen = project in (file_a03 / "a03-codegen")
val a03        = project in (file_a03 / "a03-core")

val file_a04   = file(".") / "a04-进制后续"
val a04Codegen = project in (file_a04 / "a04-codegen")
val a04Core01  = project in (file_a04 / "a04-core-01")

val a05 = project in (file(".") / "a05-后悔药")
val a06 = project in (file(".") / "a06-倾诉")

