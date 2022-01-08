package com.shockang.study.algorithm.scala.archive.linkedlist.reverse.s1

import com.shockang.study.algorithm.scala.common.Node

object ReverseList {
  def reverse(head: Node): Node = {
    if (head == null || head.next == null) return head
    val temp: Node = head.next
    val newHead: Node = reverse(head.next)
    temp.next = head
    head.next = null
    newHead
  }
}
