package com.shockang.study.algorithm.scala.archive.linkedlist.reverse.s2

import com.shockang.study.algorithm.scala.common.Node

object ReverseList {
  def reverse(head: Node): Node = {
    var pre: Node = null
    var next: Node = null
    var node: Node = head
    while (node != null) {
      next = node.next
      node.next = pre
      pre = node
      node = next
    }
    pre
  }
}
