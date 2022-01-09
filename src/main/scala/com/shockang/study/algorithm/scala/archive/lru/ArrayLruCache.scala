package com.shockang.study.algorithm.scala.archive.lru

import java.util.StringJoiner
import scala.util.control.Breaks._

/**
 * 数组实现的 LruCache
 *
 * @author Shockang
 */
class ArrayLruCache[K, V](_maxSize: Int) {
  // 底层用数组存储数据
  private val array: Array[(K, V)] = new Array(_maxSize)

  // 已缓存大小
  private var size: Int = 0

  // 最大缓存值
  private val maxSize: Int = _maxSize

  // 遍历数组根据 key 查找 value，不存在则返回 null
  def get(k: K): V = {
    if (k == null) throw new IllegalArgumentException("key == null")
    // 线程安全，加锁
    this.synchronized {
      for (a <- array if (k.equals(a._1))) return a._2
      null.asInstanceOf[V]
    }
  }

  // 插入一个键值对，返回旧值或者 null
  def put(k: K, v: V): V = {
    if (k == null || v == null) throw new IllegalArgumentException("key == null || value == null")
    // 线程安全，加锁
    this.synchronized {
      // 旧值
      var oldValue: V = null.asInstanceOf[V]
      // 判断缓存实际大小是否增加
      var flag: Boolean = true
      var i: Int = 0
      breakable(
        while (i < size) {
          if (k.equals(array(i)._1)) {
            oldValue = array(i)._2
            // 替换，缓存大小不增加
            flag = false
            break
          }
          i += 1
        }
      )
      // 超出最大容量，则将尾部删除
      if (i >= maxSize) {
        // 尾部删除了，缓存大小不增加
        flag = false
        i -= 1
      }
      // i 前面的所有元素的全部往后挪一位，这里要逆序操作
      for (j <- i until 0 by -1) array(j) = array(j - 1)
      // 插入头部
      array(0) = (k, v)
      if (flag) size += 1
      oldValue
    }
  }

  // 根据 key 删除缓存中的k v 对，返回key 对应的 value，找不到返回 null
  def remove(k: K): V = {
    if (k == null) throw new IllegalArgumentException("key == null")
    this.synchronized {
      // 是否存在对应的 KV 对
      var flag: Boolean = false
      var i: Int = 0
      var value: V = null.asInstanceOf[V]
      breakable(
        while (i < size) {
          if (k.equals(array(i)._1)) {
            value = array(i)._2
            flag = true
            break
          }
          i += 1
        }
      )
      // 正序
      for (j <- i until size - 1) array(j) = array(j + 1)
      // 最后一项设置为 null，方便垃圾回收
      if (flag) {
        array(size - 1) = null
        size -= 1
      }
      value
    }
  }

  // 方便打印
  override def toString: String = {
    val sj: StringJoiner = new StringJoiner(",")
    for (i <- 0 until size) {
      sj.add(array(i)._1 + "->" + array(i)._2)
    }
    "[" + sj.toString + "]"
  }
}
