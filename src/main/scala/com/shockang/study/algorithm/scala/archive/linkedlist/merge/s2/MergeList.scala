package com.shockang.study.algorithm.scala.archive.linkedlist.merge.s2

import com.shockang.study.algorithm.scala.common.Node

object MergeList {
  def merge(node1: Node, node2: Node): Node = {
    if (node1 == null && node2 == null) return null
    if (node1 == null) return node2
    if (node2 == null) return node1
    val flag: Boolean = node1.v < node2.v
    val head: Node = if (flag) node1 else node2
    var cur1: Node = if (flag) node1 else node2
    var cur2: Node = if (flag) node2 else node1
    var pre: Node = null
    var next: Node = null
    while (cur1 != null && cur2 != null) {
      if (cur1.v < cur2.v) {
        pre = cur1
        cur1 = cur1.next
      } else {
        next = cur2.next
        pre.next = cur2
        cur2.next = cur1
        pre = cur2
        cur2 = next
      }
    }
    pre.next = if (cur1 == null) cur2 else cur1
    head
  }
}
