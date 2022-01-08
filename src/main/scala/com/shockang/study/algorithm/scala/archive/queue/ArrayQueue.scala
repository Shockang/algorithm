package com.shockang.study.algorithm.scala.archive.queue

import java.util.StringJoiner

/**
 * 数组实现的顺序队列
 *
 * @author Shockang
 */
class ArrayQueue[E: Manifest](initSize: Int) extends Queue[E] {

  //底层存储数组
  private var array: Array[E] = new Array(initSize)

  //队列开头的指针，这样可以避免每次出队的数组迁移，会导致开头的存储空间浪费，但是在动态扩容/缩容的时候可以填充满开头，以空间换时间
  private var start: Int = _

  //队列大小
  override var size: Int = _

  //队列是否为空
  override def isEmpty: Boolean = size == 0

  //清空队列
  override def clear(): Unit = {
    array = new Array(initSize)
    size = 0
    start = 0
  }

  //入队
  override def enqueue(e: E): Unit = {
    checkAndExpand()
    array(start + size) = e
    size += 1
  }

  //出队
  override def dequeue(): E = {
    checkAndShrink()
    val e = array(start)
    //有助于 GC
    array(start) = null.asInstanceOf[E]
    size -= 1
    start += 1
    e
  }

  //方便打印
  override def toString: String = {
    val sj = new StringJoiner(",")
    for (i <- start until start + size) sj.add(array(i).toString)
    "[" + sj + "]"
  }

  //检查并扩容
  private def checkAndExpand(): Unit = {
    if (start + size + 1 > array.length) change()
  }

  //检查并缩容
  private def checkAndShrink(): Unit = {
    if (isEmpty) throw new NoSuchElementException
    if (size - 1 < 0.1 * array.length) change()
  }

  //将数组长度变为当前队列长度的两倍
  private def change(): Unit = {
    val newSize = size << 1
    val newArray: Array[E] = new Array(newSize)
    //注意从 start 开始复制数组
    System.arraycopy(array, start, newArray, 0, size)
    array = newArray
    start = 0
  }

}
