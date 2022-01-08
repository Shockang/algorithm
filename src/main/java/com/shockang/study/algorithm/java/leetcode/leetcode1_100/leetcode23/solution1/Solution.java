package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode23.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Shockang
 */
public class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;

		// 优先队列
		PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,
				Comparator.comparingInt(node -> node.val));

		// 单链表中常见的哨兵
		ListNode dummy = new ListNode(0), cur = dummy;

		for (ListNode node : lists)
			if (node != null) queue.add(node);

		while (!queue.isEmpty()) {
			cur.next = queue.poll();
			cur = cur.next;
			if (cur.next != null) queue.add(cur.next);
		}
		return dummy.next;
	}
}