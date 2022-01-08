package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode19.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

/**
 * 双指针
 *
 * @author Shockang
 */
public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode slow = head, fast = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		if (fast == null) {
			return head.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return head;
	}
}