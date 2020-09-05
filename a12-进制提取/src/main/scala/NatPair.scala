package a10

trait 自然数对 {
  type 负数部分 <: 自然数标记
  type 正数部分 <: 自然数
  def 负数部分: 负数部分
  def 正数部分: 正数部分
}

class 正整数自然数对[Tail <: 自然数, Head](val 负数部分: 自然数标记零, val 正数部分: 正整数[Tail, Head]) extends 自然数对 {
  self =>
  override type 负数部分 = 自然数标记零
  override type 正数部分 = 正整数[Tail, Head]
  type GET           = Head
  def get: GET                  = 正数部分.head
  override def toString: String = s"正整数(负数部分 = ${负数部分}, 正数部分 = ${正数部分})"
}

class 非正整数自然数对[H <: 自然数标记](val 负数部分: H, val 正数部分: 自然数零) extends 自然数对 {
  self =>
  override type 负数部分 = H
  override type 正数部分 = 自然数零
  override def toString: String = s"非负整数(负数部分 = ${负数部分}, 正数部分 = ${正数部分})"
}
