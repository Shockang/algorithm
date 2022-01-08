package com.shockang.study.algorithm.java.leetcode.leetcode401_500.leetcode445.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Shockang
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Deque<Integer> stack1 = new LinkedList<>();
		Deque<Integer> stack2 = new LinkedList<>();
		while (l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}
		int carry = 0;
		ListNode ans = null;
		while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
			int a = stack1.isEmpty() ? 0 : stack1.pop();
			int b = stack2.isEmpty() ? 0 : stack2.pop();
			int cur = a + b + carry;
			carry = cur / 10;
			cur %= 10;
			ListNode node = new ListNode(cur);
			node.next = ans;
			ans = node;
		}
		return ans;
	}
}