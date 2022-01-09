package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode86.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

/**
 * @author Shockang
 */
public class Solution {
	public ListNode partition(ListNode head, int x) {
		ListNode smallerHead = new ListNode(0), biggerHead = new ListNode(0);
		ListNode smaller = smallerHead, bigger = biggerHead;
		while (head != null) {
			if (head.val < x) {
				smaller = smaller.next = head;
			} else {
				bigger = bigger.next = head;
			}
			head = head.next;
		}
		smaller.next = biggerHead.next;
		bigger.next = null;
		return smallerHead.next;
	}
}
