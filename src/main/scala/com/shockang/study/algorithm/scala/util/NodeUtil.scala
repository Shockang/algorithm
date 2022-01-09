package com.shockang.study.algorithm.scala.util

import com.shockang.study.algorithm.scala.common.{DoubleNode, Node}

object NodeUtil {
  def printNode(node: Node): Unit = {
    var cur: Node = node
    while (cur != null) {
      print(cur.v + " ,")
      cur = cur.next
    }
    // scalastyle:off println
    println()
    // scalastyle:on println
  }

  def printDoubleNode(node: DoubleNode): Unit = {
    var cur: DoubleNode = node
    var pre: DoubleNode = null
    while (cur != null) {
      print(cur.value + " ,")
      assert(cur.prev == pre)
      pre = cur
      cur = cur.next
    }
    // scalastyle:off println
    println()
    // scalastyle:on println
  }

  def array2Node(array: Array[Int]): Node = {
    val sentry: Node = new Node(0)
    var temp: Node = sentry
    for (a <- array) {
      temp.next = new Node(a)
      temp = temp.next
    }
    sentry.next
  }

  def array2DoubleNode(array: Array[Int]): DoubleNode = {
    val sentry: DoubleNode = new DoubleNode(0)
    var temp: DoubleNode = sentry
    for (a <- array) {
      temp.next = new DoubleNode(a)
      temp.next.prev = temp
      temp = temp.next
    }
    sentry.next.prev = null
    sentry.next
  }

  def array2Circular(array: Array[Int]): Node = {
    val sentry: Node = new Node(0)
    var temp: Node = sentry
    for (a <- array) {
      temp.next = new Node(a)
      temp = temp.next
    }
    temp.next = sentry.next
    sentry.next
  }

  def printCircular(head: Node): Unit = {
    if (head == null) println
    var cur = head
    print(cur.v + " ,")
    cur = cur.next
    while (cur != head) {
      print(cur.v + " ,")
      cur = cur.next
    }
  }
}
