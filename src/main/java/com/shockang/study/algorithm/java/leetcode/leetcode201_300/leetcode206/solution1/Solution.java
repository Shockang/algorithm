package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode206.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

/**
 * 迭代
 *
 * @author Shockang
 */
public class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode pre = null, next;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
}

