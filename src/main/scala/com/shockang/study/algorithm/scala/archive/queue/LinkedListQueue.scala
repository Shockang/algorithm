package com.shockang.study.algorithm.scala.archive.queue

import java.util.StringJoiner

/**
 * 单链表实现的链式队列
 *
 * @author Shockang
 */
class LinkedListQueue[E] extends Queue[E] {

  // 单链表单个结点
  private class Node(var item: E, var next: Node)

  // 单链表头结点
  private var head: Node = _

  // 单链表尾结点
  private var tail: Node = _

  // 队列大小
  override var size: Int = _

  // 队列是否为空
  override def isEmpty: Boolean = size == 0

  // 清空队列
  override def clear(): Unit = {
    head = null
    size = 0
  }

  // 入队
  override def enqueue(e: E): Unit = {
    val next = new Node(e, null)
    if (isEmpty) head = next
    else tail.next = next
    tail = next
    size += 1
  }

  // 出队
  override def dequeue(): E = {
    if (isEmpty) throw new NoSuchElementException
    val e = head.item
    head = head.next
    size -= 1
    if (isEmpty) tail = head
    e
  }

  // 方便打印
  override def toString: String = {
    val sj = new StringJoiner(",")
    var node = head
    while (node != null) {
      sj.add(node.item.toString)
      node = node.next
    }
    "[" + sj + "]"
  }
}
