package com.shockang.study.algorithm.scala.archive.linkedlist.merge.s1

import com.shockang.study.algorithm.scala.common.Node

object MergeList {
  def merge(node1: Node, node2: Node): Node = {
    if (node1 == null && node2 == null) return null
    if (node1 == null) return node2
    if (node2 == null) return node1
    var head: Node = null
    if (node1.v > node2.v) {
      head = node2
      head.next = merge(node1, node2.next)
    } else {
      head = node1
      head.next = merge(node1.next, node2)
    }
    head
  }
}
