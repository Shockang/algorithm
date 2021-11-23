package com.shockang.study.algorithm.java.leetcode.common;

/**
 * LeetCode 中常见的单链表定义
 */
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
