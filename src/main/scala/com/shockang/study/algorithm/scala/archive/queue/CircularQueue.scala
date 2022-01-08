package com.shockang.study.algorithm.scala.archive.queue

import java.util.StringJoiner

/**
 * 数组实现的循环队列
 */
class CircularQueue[E: Manifest](initSize: Int) extends Queue[E] {
  //底层存储数组
  private var array: Array[E] = new Array(initSize)
  //队列头指针
  private var head: Int = 0
  //队列尾的后继指针
  private var tail: Int = 0
  //队列大小
  override var size: Int = _

  //队列是否为空，这里有两种判断方法：1.size == 0;2.head == tail
  override def isEmpty: Boolean = size == 0

  //清空队列
  override def clear(): Unit = {
    array = new Array(initSize)
    head = 0
    tail = 0
    size = 0
  }

  //入队
  override def enqueue(e: E): Unit = {
    checkAndExpand()
    //到队尾了就从头入队，循环队列
    if (tail == array.length) tail = 0
    array(tail) = e
    tail += 1
    size += 1
  }

  //出队
  override def dequeue(): E = {
    checkAndShrink()
    val e = array(head)
    if (head == array.length - 1) head = 0
    else head += 1
    size -= 1
    e
  }

  //方便打印
  override def toString: String = {
    val sj = new StringJoiner(",")
    if (head < tail) {
      for (i <- head until tail) sj.add(array(i).toString)
    } else if (head > tail) {
      for (i <- head until array.length) sj.add(array(i).toString)
      for (i <- 0 until tail) sj.add(array(i).toString)
    }
    "[" + sj + "]"
  }

  //检查并扩容
  private def checkAndExpand(): Unit = {
    if (size + 1 > array.length) change()
  }

  //检查并缩容
  private def checkAndShrink(): Unit = {
    if (isEmpty) throw new NoSuchElementException
    if (size - 1 < 0.1 * array.length) change()
  }

  //当前数组大小变成队列长度的两倍
  private def change(): Unit = {
    val newArray: Array[E] = new Array(if (size == 0) 1 else size << 1)
    //数据迁移
    var index: Int = 0
    //这里需要分类讨论
    if (head < tail) {
      for (i <- head until tail) {
        newArray(index) = array(i)
        index += 1
      }
    } else if (head > tail) {
      //先迁移队头到数组结尾的
      for (i <- head until array.length) {
        newArray(index) = array(i)
        index += 1
      }
      //再迁移数组开头到队尾的
      for (i <- 0 until tail) {
        newArray(index) = array(i)
        index += 1
      }
    }
    head = 0
    tail = size
    array = newArray
  }
}
