package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode116.solution2;

import com.shockang.study.algorithm.java.leetcode.common.Node;

/**
 * @author Shockang
 */
public class Solution {
	public Node connect(Node root) {
		if (root == null) {
			return root;
		}
		if (root.left != null) {
			root.left.next = root.right;
			root.right.next = root.next != null ? root.next.left : null;
			connect(root.left);
			connect(root.right);
		}
		return root;
	}
}