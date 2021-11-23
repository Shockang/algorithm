package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode2.solution2;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

/**
 * 2. 两数相加
 * <p>
 * 迭代
 *
 * @author Shockang
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0), node = dummy, cur;
		int carry = 0, sum;
		while (l1 != null || l2 != null || carry != 0) {
			cur = (l1 != null ? l1 : (l2 != null ? l2 : new ListNode(0)));
			sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
			cur.val = sum % 10;
			carry = sum / 10;
			node.next = cur;
			node = cur;
			l1 = l1 == null ? l1 : l1.next;
			l2 = l2 == null ? l2 : l2.next;
		}
		return dummy.next;
	}
}
