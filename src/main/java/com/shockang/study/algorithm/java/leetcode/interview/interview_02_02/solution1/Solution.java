package com.shockang.study.algorithm.java.leetcode.interview.interview_02_02.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

/**
 * @author Shockang
 */
public class Solution {
	public int kthToLast(ListNode head, int k) {
		ListNode node = head;
		while (k > 1) {
			node = node.next;
			--k;
		}
		while (node.next != null) {
			node = node.next;
			head = head.next;
		}
		return head.val;
	}
}