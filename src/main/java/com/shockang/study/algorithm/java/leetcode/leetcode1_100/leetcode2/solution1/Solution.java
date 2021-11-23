package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode2.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

/**
 * 2. 两数相加
 * <p>
 * 递归
 *
 * @author Shockang
 */
public class Solution {
	private int carry;

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) return carry > 0 ? new ListNode(carry) : null;
		int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
		carry = sum / 10;
		int val = sum % 10;
		ListNode res = l1 == null ? l2 : l1;
		res.val = val;
		res.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next);
		return res;
	}
}
