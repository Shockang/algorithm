package com.shockang.study.algorithm.scala.archive.linkedlist.mid

import com.shockang.study.algorithm.scala.common.Node

object Solution {
  def midOfListNode(head: Node): Node = {
    var slow: Node = head
    var fast: Node = head
    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
    }
    slow
  }
}
