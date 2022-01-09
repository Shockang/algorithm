package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode105.solution2;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 迭代
 *
 * @author Shockang
 */
public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		int inorderIndex = 0;
		for (int i = 1; i < preorder.length; i++) {
			int preorderVal = preorder[i];
			TreeNode node = stack.peek();
			if (node.val != inorder[inorderIndex]) {
				node.left = new TreeNode(preorderVal);
				stack.push(node.left);
			} else {
				while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
					node = stack.pop();
					inorderIndex++;
				}
				node.right = new TreeNode(preorderVal);
				stack.push(node.right);
			}
		}
		return root;
	}
}