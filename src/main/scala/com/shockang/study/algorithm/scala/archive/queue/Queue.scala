package com.shockang.study.algorithm.scala.archive.queue

/**
 * 手写队列
 *
 * @author Shockang
 */
trait Queue[E] {

  //队列大小
  var size: Int

  //是否为空
  def isEmpty: Boolean

  //清空队列
  def clear()

  //入队
  def enqueue(e: E)

  //出队
  def dequeue(): E
}
