package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode82.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

/**
 * 哨兵,pre+cur
 *
 * @author Shockang
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		while (cur != null) {
			while (cur.next != null && cur.val == cur.next.val) {
				cur = cur.next;
			}
			if (pre.next == cur) {
				pre = pre.next;
			} else {
				pre.next = cur.next;
			}
			cur = cur.next;
		}
		return dummy.next;
	}
}