package com.shockang.study.algorithm.java.leetcode.offer.offer24.solution2;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

/**
 * @author Shockang
 */
public class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode pre = null, cur = head, next;
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}
