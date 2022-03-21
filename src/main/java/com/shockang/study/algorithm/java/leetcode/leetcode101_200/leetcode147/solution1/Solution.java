package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode147.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

/**
 * @author Shockang
 */
public class Solution {
	public ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode dummy = new ListNode(0); //new starter of the sorted list
		ListNode cur = head; //the node will be inserted
		ListNode pre = dummy; //insert node between pre and pre.next
		ListNode next = null; //the next node will be inserted
		//not the end of input list
		while (cur != null) {
			next = cur.next;
			//find the right place to insert
			while (pre.next != null && pre.next.val < cur.val) {
				pre = pre.next;
			}
			//insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			pre = dummy;
			cur = next;
		}

		return dummy.next;
	}
}