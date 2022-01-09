package com.shockang.study.algorithm.scala.leetcode.leetcode201_300.leetcode205.solution2

import com.shockang.study.algorithm.scala.leetcode.common.ListNode

/**
 * 递归
 *
 * @author Shockang
 */
object Solution {
  def reverseList(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head
    val next = head.next
    val newHead = reverseList(next)
    next.next = head
    head.next = null
    newHead
  }
}
