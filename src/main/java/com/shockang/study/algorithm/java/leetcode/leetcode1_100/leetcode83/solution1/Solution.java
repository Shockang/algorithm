package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode83.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

/**
 * 递归
 *
 * @author Shockang
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) return head;
		head.next = deleteDuplicates(head.next);
		return head.val == head.next.val ? head.next : head;
	}
}
