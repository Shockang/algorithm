package com.shockang.study.algorithm.scala.archive.array

import java.util.StringJoiner

// 注意Manifest要加上，不然会出现编译错误
class MySimpleArrayList[T: Manifest](initSize: Int = 10) {

  // 底层数组
  private var array: Array[T] = new Array[T](initSize)

  // 数组最大容量
  private var capacity: Int = initSize

  // list的大小
  var size: Int = 0

  // 链表末尾添加元素
  def add(t: T): Unit = {
    // 检查并扩容
    checkAndExpand()
    array(size) = t
    size += 1
  }

  // 下标 k 插入元素
  def insert(t: T, k: Int): Unit = {
    checkRange(k)
    // 检查并扩容
    checkAndExpand()
    // 倒序遍历插入
    var index: Int = size
    while (index > k) {
      array(index) = array(index - 1)
      index -= 1
    }
    // 第 k 项覆盖
    array(k) = t
    // 大小增加
    size += 1
  }

  // 删除下标为 k的元素
  def delete(k: Int): Unit = {
    checkRange(k)
    // 正序遍历删除
    var index: Int = k
    while (index < size - 1) {
      array(index) = array(index + 1)
      index += 1
    }
    size -= 1
  }

  // 获取下标为 k 的元素
  def get(k: Int): T = {
    checkRange(k)
    array(k)
  }

  // 方便打印
  override def toString: String = {
    val sj: StringJoiner = new StringJoiner(",")
    for (i <- 0 until size) {
      sj.add(array(i).toString)
    }
    "[" + sj.toString + "]"
  }

  // 检查是否越界
  private def checkRange(k: Int): Unit = {
    if (k >= size || k < 0) {
      throw new ArrayIndexOutOfBoundsException("数组下标越界：" + k)
    }
  }

  // 检查
  private def checkAndExpand(): Unit = {
    if ((size + 1) > capacity) {
      expand()
    }
  }

  // 数组扩容
  private def expand(): Unit = {
    val temp = array
    capacity = capacity + (capacity >> 2)
    array = new Array[T](capacity)
    System.arraycopy(temp, 0, array, 0, size)
  }
}
