package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode109.solution1;

import com.shockang.study.algorithm.java.leetcode.common.ListNode;
import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * 递归，快慢指针找中点
 *
 * @author Shockang
 */
public class Solution {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		return helper(head, null);
	}

	private TreeNode helper(ListNode head, ListNode tail) {
		if (head == tail) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode root = new TreeNode(slow.val);
		root.left = helper(head, slow);
		root.right = helper(slow.next, tail);
		return root;
	}
}
