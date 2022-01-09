package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode92.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

/**
 * dummy,pre,start,then
 *
 * @author Shockang
 */
public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) return null;
		ListNode dummy = new ListNode(0), pre = dummy;
		dummy.next = head;
		for (int i = 0; i < m - 1; i++) pre = pre.next;

		ListNode start = pre.next;
		ListNode then = start.next;

		// 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
		// dummy-> 1 -> 2 -> 3 -> 4 -> 5

		for (int i = m; i < n; i++) {
			start.next = then.next;
			then.next = pre.next;
			pre.next = then;
			then = start.next;
		}

		// first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
		// second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

		return dummy.next;

	}
}
