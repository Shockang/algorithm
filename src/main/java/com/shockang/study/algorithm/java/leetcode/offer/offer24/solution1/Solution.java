package com.shockang.study.algorithm.java.leetcode.offer.offer24.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

/**
 * @author Shockang
 */
public class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode next = head.next;
		ListNode newHead = reverseList(next);
		next.next = head;
		head.next = null;
		return newHead;
	}
}
