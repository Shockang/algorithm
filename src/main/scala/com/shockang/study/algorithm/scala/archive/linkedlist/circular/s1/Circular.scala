package com.shockang.study.algorithm.scala.archive.linkedlist.circular.s1

import com.shockang.study.algorithm.scala.common.Node

import scala.util.control.Breaks._

object Circular {
  def isCircular(head: Node): Boolean = {
    if (head == null || head.next == null) return false
    var slow: Node = head
    var fast: Node = head
    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
      if (slow == fast) return true
    }
    false
  }

  def getCircularEntry(head: Node): Node = {
    if (head == null || head.next == null) return null
    var slow: Node = head
    var fast: Node = head
    breakable(
      while (fast != null && fast.next != null) {
        slow = slow.next
        fast = fast.next.next
        if (slow == fast) break
      }
    )
    if (fast == null || fast.next == null) return null
    while (slow != fast) {
      slow = slow.next
      fast = fast.next
    }
    slow
  }
}
