package com.shockang.study.algorithm.java.leetcode.offer.offer22.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

/**
 * @author Shockang
 */
public class Solution {
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode node = head;
		while (k > 0) {
			head = head.next;
			k--;
		}
		while (head != null) {
			head = head.next;
			node = node.next;
		}
		return node;
	}
}