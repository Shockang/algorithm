package com.shockang.study.algorithm.scala.archive.stack

import java.util.StringJoiner

/**
 * 单链表实现的栈
 *
 * @author Shockang
 */
class LinkedListStack[E] extends Stack[E] {

  //单链表单个结点，存储值和后驱指针
  private class Node(var item: E, var next: Node)

  //单链表头结点
  private var head: Node = _

  //栈大小
  override var size: Int = 0

  //是否为空
  override def isEmpty: Boolean = size == 0

  //入栈
  override def push(e: E): Unit = {
    //注意倒序添加
    head = new Node(e, head)
    size += 1
  }

  //出栈
  override def pop(): E = {
    //判空
    if (isEmpty) throw new NoSuchElementException
    val temp = head
    head = temp.next
    size -= 1
    temp.item
  }

  //查看栈顶
  override def peek(): E = {
    //判空
    if (isEmpty) throw new NoSuchElementException
    head.item
  }

  //清空栈
  override def clear(): Unit = {
    head = null
    size = 0
  }

  //方便打印
  override def toString: String = {
    val sj: StringJoiner = new StringJoiner(",")
    var node = reverse(head)
    head = node
    while (node != null) {
      sj.add(node.item.toString)
      node = node.next
    }
    //反转之后别忘了还原，好吧，这里这么搞主要还是为了复习两种反转链表的方法
    head = reverse2(head)
    "[" + sj + "]"
  }

  //为了和数组实现打印保持一致，这里利用递归将单链表反转
  private def reverse(node: Node): Node = {
    if (node == null || node.next == null) return node
    val temp = node.next
    val newHead = reverse(node.next)
    temp.next = node
    node.next = null
    newHead
  }

  //利用迭代将单链表反转
  private def reverse2(node: Node): Node = {
    var temp: Node = null
    var pre: Node = null
    var cur: Node = node
    while (cur != null) {
      temp = cur.next
      cur.next = pre
      pre = cur
      cur = temp
    }
    pre
  }
}
