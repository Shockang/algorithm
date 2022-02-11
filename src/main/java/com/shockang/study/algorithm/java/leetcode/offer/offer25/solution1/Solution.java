package com.shockang.study.algorithm.java.leetcode.offer.offer25.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

/**
 * @author Shockang
 */
public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode temp = l1.val < l2.val ? l1 : l2;
		temp.next = mergeTwoLists(temp.next, temp == l1 ? l2 : l1);
		return temp;
	}
}
