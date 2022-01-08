package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode25.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

/**
 * 找到反转点，反转前面的，递归后面的
 *
 * @author Shockang
 */
public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		// nextHead指向链表中除去k个节点之后的头节点
		// 初始指向节点head
		ListNode nextHead = head;
		// 链表中剩余节点个数
		int remainNum = 0;
		while (remainNum < k) {
			// 根据题意如果链表剩余节点个数不足k个
			// 则不需要反转，因此直接返回head
			if (nextHead == null) {
				return head;
			}
			remainNum++;
			nextHead = nextHead.next;
		}

		// 递归反转链表中除去前k个节点的后续节点
		ListNode subList = reverseKGroup(nextHead, k);
		// 反转链表中前k个节点
		ListNode newHead = reverseTopN(head, k);
		// 前k个节点反转后，head指向的节点是反转后的链表中的最后一个节点
		// 因此head指向的节点的后继指针指向subList
		head.next = subList;
		return newHead;
	}

	private ListNode reverseTopN(ListNode head, int n) {
		ListNode prev = null;
		// 当前考察的节点
		ListNode cur = head;
		// num小于n，则表示当前节点需要反转
		for (int num = 0; num < n; num++) {
			// 当前节点的下一个节点
			ListNode next = cur.next;
			// 当前节点的后继指针指向prev
			cur.next = prev;
			// prev指向当前节点
			// 表示其是next节点反转后的前一个节点
			prev = cur;
			// cur指向下一个节点
			// 表示下一个节点是待反转节点
			cur = next;
		}
		return prev;
	}
}