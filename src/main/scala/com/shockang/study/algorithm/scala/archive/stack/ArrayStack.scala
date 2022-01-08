package com.shockang.study.algorithm.scala.archive.stack

import java.util.StringJoiner

/**
 * 数组实现的栈
 *
 * @author Shockang
 */
class ArrayStack[E: Manifest](initSize: Int) extends Stack[E] {
  //底层用数组存储
  private var array: Array[E] = if (initSize > 0) new Array(initSize) else throw new IllegalArgumentException

  //当前数组最大容量
  private var maxSize: Int = initSize

  //当前栈大小
  override var size: Int = 0

  //是否为空
  override def isEmpty: Boolean = size == 0

  //入栈
  override def push(e: E): Unit = {
    //检查是否需要扩容
    checkAndExpand()
    array(size) = e
    size += 1
  }

  //出栈
  override def pop(): E = {
    //此时栈不能为空
    if (isEmpty) throw new NoSuchElementException
    val e: E = array(size - 1)
    array(size - 1) = null.asInstanceOf[E]
    size -= 1
    e
  }

  //查看栈顶
  override def peek(): E = {
    //此时栈不能为空
    if (isEmpty) throw new NoSuchElementException
    array(size - 1)
  }

  //清空栈
  override def clear(): Unit = {
    array = new Array(initSize)
    maxSize = initSize
    size = 0
  }

  //方便打印
  override def toString: String = {
    val sj: StringJoiner = new StringJoiner(",")
    for (i <- 0 until size) {
      sj.add(array(i).toString)
    }
    "[" + sj + "]"
  }

  //检查是否需要扩容
  private def checkAndExpand(): Unit = {
    if (size + 1 > maxSize) {
      //两倍扩容
      maxSize <<= 1
      var oldArray: Array[E] = array
      array = new Array(maxSize)
      //通过System.arraycopy迁移数据到新数组
      System.arraycopy(oldArray, 0, array, 0, size)
      //有助于 GC
      oldArray = null
    }
  }

}
