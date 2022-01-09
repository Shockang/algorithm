package com.shockang.study.algorithm.scala.archive.linkedlist

import java.util.{NoSuchElementException, StringJoiner}

/**
 * 手写 LinkedList
 *
 * @author Shockang
 */
class MyLinkedList[T] {

  // 单个结点，存储前驱指针，值，后驱指针
  private class Node(var prev: Node, var item: T, var next: Node)

  // 获取下标为 index 的结点
  private def node(index: Int): Node = {
    var x: Node = null
    // 那边近从那边遍历
    if (index < (size >> 1)) {
      x = first
      for (_ <- 0 until index) x = x.next
    } else {
      x = last
      for (_ <- size - 1 until index by -1) x = x.prev
    }
    x
  }

  // 列表中删除指定结点
  private def unlink(x: Node): T = {
    val t: T = x.item
    val next: Node = x.next
    val prev: Node = x.prev
    // 有助于 GC
    x.prev = null
    x.item = null.asInstanceOf[T]
    x.next = null
    // 前结点
    if (prev == null) first = next
    else prev.next = next
    // 后结点
    if (next == null) last = prev
    else next.prev = prev
    size -= 1
    t
  }

  // 首结点
  private var first: Node = _

  // 尾结点
  private var last: Node = _

  // 列表大小
  var size: Int = 0

  // 列表是否为空，注意定义为 def不能为 var，不然值初始化后不会改变
  def isEmpty: Boolean = size == 0

  // 以下方法为查询相关的=========================================================
  // 根据下标获取对应数据
  def get(index: Int): T = {
    // 检测下标是否越界
    checkRange(index)
    node(index).item
  }

  // 获取第一个元素，不存在抛异常NoSuchElementException
  def getFirst: T = {
    assert(!isEmpty, throw new NoSuchElementException)
    first.item
  }

  // 获取最后一个元素，不存在抛异常NoSuchElementException
  def getLast: T = {
    assert(!isEmpty, throw new NoSuchElementException)
    last.item
  }

  // 获取第一个元素
  def element: T = getFirst

  // 获取第一个元素，不存在返回 null
  def peek: T = if (isEmpty) null.asInstanceOf[T] else first.item

  // 获取第一个元素，不存在返回 null
  def peekFirst: T = peek

  // 获取最后一个元素，不存在返回 null
  def peekLast: T = if (isEmpty) null.asInstanceOf[T] else last.item

  // 获取第一个匹配的元素对应下标，不存在则返回-1，这里要区分是否为 null
  def indexOf(t: T): Int = {
    var index: Int = 0
    var cur: Node = first
    if (t == null) {
      while (cur != null) {
        // index = 0 的情况下可以得出第一行必定是
        if (cur.item == null) return index
        // cur 和 index 起始对应，同时变化
        cur = cur.next
        index += 1
      }
    } else {
      while (cur != null) {
        // index = 0 的情况下可以得出第一行必定是
        // 使用 equals 匹配
        if (t.equals(cur.item)) return index
        // cur 和 index 起始对应，同时变化
        cur = cur.next
        index += 1
      }
    }
    -1
  }

  // 获取最后一个匹配的元素对应下标，不存在则返回-1
  def lastIndexOf(t: T): Int = {
    var index: Int = size
    var cur: Node = last
    if (t == null) {
      while (cur != null) {
        // 起始index 比 cur 多一步，同时变化
        index -= 1
        //  index = size - 1 可以得出必定放在第二行
        if (cur.item == null) return index
        cur = cur.prev
      }
    } else {
      while (cur != null) {
        // 起始index 比 cur 多一步，同时变化
        index -= 1
        //  index = size - 1 可以得出必定放在第二行
        // 使用 equals 匹配
        if (t.equals(cur.item)) return index
        cur = cur.prev
      }
    }
    -1
  }

  // 是否包含某个元素
  def contains(t: T): Boolean = indexOf(t) != -1

  // 以下方法为新增相关的=========================================================
  // 新增一个元素到链表末尾
  def add(t: T): Boolean = {
    linkLast(t)
    true
  }

  // 下标为 index 的地方插入一个元素
  def add(index: Int, t: T): Unit = {
    checkRange(index)
    if (size == index) linkLast(t)
    else linkBefore(t, node(index))
  }

  // 头部添加一个元素
  private def linkFirst(t: T): Unit = {
    val temp: Node = first
    // 改中引用
    val newNode: Node = new Node(null, t, temp)
    first = newNode
    // 改后引用
    if (temp == null) last = newNode
    else temp.prev = newNode
    size += 1
  }

  // 末尾添加一个元素
  private def linkLast(t: T): Unit = {
    val temp: Node = last
    // 改中引用
    val newNode: Node = new Node(temp, t, null)
    last = newNode
    // 改前引用
    if (temp == null) first = newNode
    else temp.next = newNode
    size += 1
  }

  // 在后面一个结点前面插入一个新结点
  private def linkBefore(t: T, after: Node): Unit = {
    // 前，可能为 null
    val prev: Node = after.prev
    // 改中引用
    val newNode: Node = new Node(prev, t, after)
    // 改前引用，注意前可能为 null
    if (prev == null) first = newNode
    else prev.next = newNode
    // 改后引用
    after.prev = newNode
    size += 1
  }

  // 添加一个元素到链表头部
  def addFirst(t: T): Unit = {
    linkFirst(t)
  }

  // 添加一个元素到链表尾部
  def addLast(t: T): Unit = {
    linkLast(t)
  }

  // 新增一个元素到链表尾部
  def offer(t: T): Boolean = add(t)

  // 新增一个元素到链表头部
  def offerFirst(t: T): Boolean = {
    linkFirst(t)
    true
  }

  // 新增一个元素到链表尾部
  def offerLast(t: T): Boolean = add(t)

  // 入栈，这里是添加到头部
  def push(t: T): Unit = linkFirst(t)

  // 以下方法为删除相关的=========================================================
  // 删除链表头部的元素
  def remove: T = removeFirst()

  // 删除头结点，不考虑头结点不存在的情况
  private def unlinkFirst(): Unit = {
    val next: Node = first.next
    // 有助于 GC
    first.item = null.asInstanceOf[T]
    first.next = null
    first = next
    if (next == null) last = null
    else next.prev = null
    size -= 1
  }

  // 删除尾结点，不考虑尾结点不存在的情况
  private def unlinkLast(): Unit = {
    val prev: Node = last.prev
    // 有助于 GC
    last.item = null.asInstanceOf[T]
    last.next = null
    last = prev
    if (prev == null) first = null
    else prev.next = null
    size -= 1
  }

  // 删除下标为 index 的元素
  def remove(index: Int): T = {
    checkRange(index)
    unlink(node(index))
  }

  // 删除第一个匹配的元素，要区分元素是否为null
  def remove(t: T): Boolean = removeFirstOccurrence(t)

  // 删除第一个匹配的元素，要区分元素是否为null
  def removeFirstOccurrence(t: T): Boolean = {
    if (t == null) {
      var x: Node = first
      while (x != null) {
        if (x.item == null) {
          unlink(x)
          return true
        }
        x = x.next
      }
    }
    else {
      var x: Node = first
      while (x != null) {
        // equals代表匹配
        if (t.equals(x.item)) {
          unlink(x)
          return true
        }
        x = x.next
      }
    }
    false
  }

  // 删除最后一个匹配的元素，要区分元素是否为null
  def removeLastOccurrence(t: T): Boolean = {
    if (t == null) {
      var x = last
      while (x != null) {
        if (x.item == null) {
          unlink(x)
          return true
        }
        x = x.prev
      }
    }
    else {
      var x = last
      while (x != null) {
        // equals代表匹配
        if (t.equals(x.item)) {
          unlink(x)
          return true
        }
        x = x.prev
      }
    }
    false
  }

  // 删除第一个元素
  def removeFirst(): T = {
    assert(!isEmpty, throw new NoSuchElementException)
    val t: T = first.item
    unlinkFirst()
    t
  }

  // 删除最后一个元素
  def removeLast(): T = {
    assert(!isEmpty, throw new NoSuchElementException)
    val t: T = last.item
    unlinkLast()
    t
  }

  // 删除第一个元素，列表为空返回 null
  def poll: T = pollFirst

  // 删除第一个元素，列表为空返回 null
  def pollFirst: T = if (isEmpty) null.asInstanceOf[T] else removeFirst()

  // 删除最后一个元素，列表为空返回 null
  def pollLast: T = if (isEmpty) null.asInstanceOf[T] else removeLast()

  // 删除第一个元素，列表为空抛异常 NoSuchElementException
  def pop: T = removeFirst()

  // 以下为其他操作=======================================
  // 下标为 index 的替换，返回旧值
  def set(index: Int, t: T): T = {
    checkRange(index)
    val temp: Node = node(index)
    val oldValue: T = temp.item
    temp.item = t
    oldValue
  }

  // 清空列表
  def clear(): Unit = {
    var x: Node = first
    var next: Node = null
    while (x != null) {
      next = x.next
      x.prev = null
      x.item = null.asInstanceOf[T]
      x.next = null
      x = next
    }
    first = null
    last = null
    size = 0
  }

  override def toString: String = {
    val sj: StringJoiner = new StringJoiner(",")
    var node: Node = first
    while (node != null) {
      sj.add(node.item.toString)
      node = node.next
    }
    "[" + sj.toString + "]"
  }


  // 检查下标是否越界
  private def checkRange(index: Int): Unit = {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("下标越界：" + index)
    }
  }

}
