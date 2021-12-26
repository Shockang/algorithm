package com.shockang.study.algorithm.scala.leetcode.leetcode201_300.leetcode205.solution1

import com.shockang.study.algorithm.scala.leetcode.common.ListNode

/**
 * 迭代
 *
 * @author Shockang
 */
object Solution {
  def reverseList(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head
    var pre, next: ListNode = null
    var cur = head
    while (cur != null) {
      next = cur.next
      cur.next = pre
      pre = cur
      cur = next
    }
    pre
  }
}
