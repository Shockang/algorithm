package com.shockang.study.algorithm.scala.archive.stack

/**
 * 将栈的共同特征抽象成特质
 *
 * @author Shockang
 */
trait Stack[E] {

  // 大小
  var size: Int

  // 是否为空
  def isEmpty: Boolean

  // 入栈
  def push(e: E)

  // 出栈
  def pop(): E

  // 查看栈顶
  def peek(): E

  // 清空栈
  def clear()
}
