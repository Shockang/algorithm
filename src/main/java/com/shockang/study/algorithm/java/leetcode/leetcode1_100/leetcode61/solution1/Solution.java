package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode61.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

/**
 * @author Shockang
 */
public class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) return null;
		int listNum = 1;
		ListNode tail = head;

		while (tail.next != null) {
			listNum++;
			tail = tail.next;
		}
		tail.next = head;
		int newHeadIndex = listNum - k % listNum;
		for (int i = 0; i < newHeadIndex; i++) {
			tail = tail.next;
		}
		head = tail.next;
		tail.next = null;
		return head;
	}
}
