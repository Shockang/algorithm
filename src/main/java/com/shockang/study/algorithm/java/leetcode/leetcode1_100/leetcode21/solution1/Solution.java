package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode21.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

/**
 * temp.next = 递归
 *
 * @author Shockang
 */
public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		ListNode temp = l1.val < l2.val ? l1 : l2;
		temp.next = mergeTwoLists(temp.next, temp == l1 ? l2 : l1);
		return temp;
	}
}
