package com.shockang.study.algorithm.scala.archive.lru

import java.util.StringJoiner
import scala.util.control.Breaks._

/**
 * 单链表实现的 LruCache
 *
 * @author Shockang
 */
class LinkedListLruCache[K, V](_maxSize: Int) {

  // 单链表单个结点
  private class Node[T](var item: T, var next: Node[T])

  // 头结点
  private var head: Node[(K, V)] = _
  // 哨兵
  private var sentry: Node[(K, V)] = new Node(null, head)

  // 缓存 最大容量
  private val maxSize: Int = if (_maxSize >= 0) _maxSize else throw new IllegalArgumentException
  // 缓存 当前容量
  var size: Int = 0

  // 根据 key 查找 value，不存在则返回 null
  def get(k: K): V = {
    // key 不能为null
    if (k == null) throw new IllegalArgumentException("key == null")
    var cur: Node[(K, V)] = head
    while (cur != null) {
      // 使用 equals 匹配
      if (k.equals(cur.item._1)) return cur.item._2
      cur = cur.next
    }
    null.asInstanceOf[V]
  }

  // 插入一个键值对，返回旧值或者 null
  def put(k: K, v: V): V = {
    if (k == null || v == null) throw new IllegalArgumentException("key == null || value == null")
    // 线程安全，加锁
    this.synchronized {
      var oldValue: V = null.asInstanceOf[V]
      // 头结点特殊处理下，防止先删除再新增
      if (head != null && k.equals(head.item._1)) {
        oldValue = head.item._2
        head.item = (k, v)
      } else {
        oldValue = getAndRemove(k)
        // kv 对添加到头部
        addHead(k, v)
        // 缓存数量加一
        size += 1
        // 容量超了，就删除末尾
        if (size > maxSize) {
          removeLast()
        }
      }
      oldValue
    }
  }

  // 根据 key 删除缓存中的k v 对，返回key 对应的 value，找不到返回 null
  def remove(k: K): V = {
    // key 不能为null
    if (k == null) throw new IllegalArgumentException("key == null")
    // 线程安全，加锁
    this.synchronized {
      getAndRemove(k)
    }
  }

  // 在缓存中查找 key，命中缓存后删除对应 kv 对
  private def getAndRemove(k: K): V = {
    // 遍历的当前结点
    var cur: Node[(K, V)] = head
    // 遍历的前结点
    var pre: Node[(K, V)] = sentry
    var oldValue: V = null.asInstanceOf[V]
    breakable(
      while (cur != null) {
        // equals 表示匹配
        if (k.equals(cur.item._1)) {
          // 旧值
          oldValue = cur.item._2
          // 删除当前结点
          pre.next = cur.next
          // 如果删除的是头结点，需要重新设置下 head
          if (head == cur) {
            head = cur.next
            sentry = new Node(null, head)
          }
          // 缓存数量减一
          size -= 1
          break
        }
        pre = cur
        cur = cur.next
      }
    )
    oldValue
  }

  // 插入一个键值对到头部
  private def addHead(k: K, v: V): Unit = {
    // 借用哨兵来搞定指针指向的问题
    sentry = new Node((k, v), head)
    head = sentry
    // 新建哨兵还指向头结点
    sentry = new Node(null, head)
  }

  // 删除最后一项
  private def removeLast(): Unit = {
    // 从哨兵开始
    var cur: Node[(K, V)] = sentry
    // 总共走了 maxSize-1 步
    for (_ <- 0 until maxSize) {
      cur = cur.next
    }
    // 这时 cur 代表倒数第二项
    cur.next = null
  }

  override def toString: String = {
    val sj: StringJoiner = new StringJoiner(",")
    var cur: Node[(K, V)] = head
    while (cur != null) {
      sj.add(cur.item._1 + "->" + cur.item._2)
      cur = cur.next
    }
    "[" + sj + "]"
  }
}

