package com.shockang.study.algorithm.scala.archive.linkedlist.remove

import com.shockang.study.algorithm.scala.common.Node

object Solution {
  def removeNDesc(head: Node, n: Int): Node = {
    val H: Node = head
    var first: Node = head
    var second: Node = head
    for (_ <- 0 to n) {
      first = first.next
    }
    while (first != null) {
      first = first.next
      second = second.next
    }
    second.next = second.next.next
    H
  }
}
