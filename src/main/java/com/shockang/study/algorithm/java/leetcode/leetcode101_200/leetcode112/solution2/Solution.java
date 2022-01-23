package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode112.solution2;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Shockang
 */
public class Solution {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		Queue<TreeNode> queNode = new LinkedList<>();
		Queue<Integer> queVal = new LinkedList<>();
		queNode.offer(root);
		queVal.offer(root.val);
		while (!queNode.isEmpty()) {
			TreeNode now = queNode.poll();
			int temp = queVal.poll();
			if (now.left == null && now.right == null) {
				if (temp == sum) {
					return true;
				}
				continue;
			}
			if (now.left != null) {
				queNode.offer(now.left);
				queVal.offer(now.left.val + temp);
			}
			if (now.right != null) {
				queNode.offer(now.right);
				queVal.offer(now.right.val + temp);
			}
		}
		return false;
	}
}