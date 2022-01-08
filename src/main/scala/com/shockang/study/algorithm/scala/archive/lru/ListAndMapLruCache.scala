package com.shockang.study.algorithm.scala.archive.lru

import java.util.StringJoiner
import scala.collection.mutable

/**
 * 单链表+散列表实现的 LruCache，类似于 LinkedHashMap
 *
 * @author Shockang
 */
class ListAndMapLruCache[K, V](_maxSize: Int) {

  //单链表单个结点
  private class Node[T](var item: T, var next: Node[T])

  //头结点
  private var head: Node[K] = _
  //哨兵
  private var sentry: Node[K] = new Node(null.asInstanceOf[K], head)

  //缓存 最大容量
  private val maxSize: Int = if (_maxSize > 0) _maxSize else throw new IllegalArgumentException
  //缓存 当前容量
  var size: Int = 0

  //散列表存储 kv 对
  private val cacheMap: mutable.HashMap[K, V] = mutable.HashMap()

  //key 对应的结点
  private val keyMap: mutable.HashMap[K, Node[K]] = mutable.HashMap()

  //key 对应结点的前一个结点，方便进行删除操作
  private val beforeKeyMap: mutable.HashMap[K, Node[K]] = mutable.HashMap()

  //根据 key 查找 value，不存在则返回 null
  def get(k: K): V = {
    //key 不能为null
    if (k == null) throw new IllegalArgumentException("key == null")
    cacheMap(k)
  }

  //插入一个键值对，返回旧值或者 null
  def put(k: K, v: V): V = {
    if (k == null || v == null) throw new IllegalArgumentException("key == null || value == null")
    //线程安全，加锁
    this.synchronized {
      //头结点特殊处理下
      var oldValue: V = null.asInstanceOf[V]
      if (head != null && k.equals(head.item)) {
        oldValue = cacheMap(k)
      } else {
        oldValue = getAndRemove(k)
        //key添加到头部
        addHead(k)
        //容量超了，就删除末尾
        if (size > maxSize) {
          removeLast()
        }
      }
      //更新所有 map
      cacheMap += k -> v
      keyMap += k -> head
      beforeKeyMap += k -> sentry
      oldValue
    }
  }

  //根据 key 删除缓存中的k v 对，返回key 对应的 value，找不到返回 null
  def remove(k: K): V = {
    //key 不能为null
    if (k == null) throw new IllegalArgumentException("key == null")
    //线程安全，加锁
    this.synchronized {
      getAndRemove(k, isRemove = true)
    }
  }

  //在缓存中查找 key，isRemove代表命中缓存后删除对应 kv 对
  private def getAndRemove(k: K, isRemove: Boolean = false): V = {
    var oldValue: V = null.asInstanceOf[V]
    if (cacheMap.contains(k)) {
      oldValue = cacheMap(k)
      val cur: Node[K] = keyMap(k)
      val pre: Node[K] = beforeKeyMap(k)
      //删除 cur 结点
      pre.next = cur.next
      if (cur.next != null) {
        beforeKeyMap += cur.next.item -> pre
      }
      //头结点需要特殊处理下
      if (head == cur) {
        head = cur.next
        sentry.next = head
      }
      size -= 1
    }
    //不需要删除缓存的时候就没必要删除
    if (isRemove) {
      cacheMap -= k
      keyMap -= k
      beforeKeyMap -= k
    }
    oldValue
  }

  private def removeLast(): Unit = {
    //从哨兵开始
    var cur: Node[K] = sentry
    //总共走了 maxSize-1 步
    for (_ <- 0 until maxSize) {
      cur = cur.next
    }
    //这时 cur 代表倒数第二项
    val last: K = cur.next.item
    //末尾的 Map 缓存也清理一下
    cacheMap -= last
    keyMap -= last
    beforeKeyMap -= last
    cur.next = null
    size -= 1
  }

  //插入key 到头部
  private def addHead(k: K): Unit = {
    //借用哨兵来操作
    sentry = new Node(k, head)
    //需要更新一下 k 对应结点的前驱指针
    if (head != null) {
      beforeKeyMap += head.item -> sentry
    }
    head = sentry
    //新建哨兵还指向头结点
    sentry = new Node(null.asInstanceOf[K], head)
    //缓存加一
    size += 1
  }

  override def toString: String = {
    val sj: StringJoiner = new StringJoiner(",")
    var cur: Node[K] = head
    while (cur != null) {
      sj.add(cur.item + "->" + cacheMap(cur.item))
      cur = cur.next
    }
    "[" + sj + "]"
  }
}

