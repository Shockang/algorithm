package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode203.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

/**
 * dummy,prev,head
 *
 * @author Shockang
 */
public class Solution {
		public ListNode removeElements(ListNode head, int val) {
				if (head == null) return null;
				ListNode dummy = new ListNode(), prev = dummy;
				dummy.next = head;
				while (head != null) {
						if (head.val == val) prev.next = head.next;
						else prev = head;
						head = head.next;
				}
				return dummy.next;
		}
}
