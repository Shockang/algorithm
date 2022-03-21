package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode143.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Shockang
 */
public class Solution {
	public void reorderList(ListNode head) {
		Deque<ListNode> deque = new LinkedList<>();
		ListNode node = head;
		while (node != null) {
			deque.addLast(node);
			node = node.next;
		}
		node = deque.pollFirst();
		boolean flag = false;
		while (!deque.isEmpty()) {
			node.next = flag ? deque.pollFirst() : deque.pollLast();
			node = node.next;
			flag = !flag;
		}
		node.next = null;
	}
}
