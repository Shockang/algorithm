package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode105.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归
 *
 * @author Shockang
 */
public class Solution {
	private Map<Integer, Integer> indexMap;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = preorder.length;
		// 构造哈希映射，帮助我们快速定位根节点
		indexMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			indexMap.put(inorder[i], i);
		}
		return buildTree(preorder, 0, n - 1, 0, n - 1);
	}

	private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
		if (preLeft > preRight || inLeft > inRight) {
			return null;
		}

		// 前序遍历中的第一个节点就是根节点
		int rootVal = preorder[preLeft];
		// 在中序遍历中定位根节点
		int pIndex = indexMap.get(rootVal);

		// 先把根节点建立出来
		TreeNode root = new TreeNode(rootVal);
		// 递归地构造左子树，并连接到根节点
		// 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
		root.left = buildTree(preorder, preLeft + 1, pIndex - inLeft + preLeft, inLeft, pIndex - 1);
		// 递归地构造右子树，并连接到根节点
		// 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
		root.right = buildTree(preorder, pIndex - inLeft + preLeft + 1, preRight, pIndex + 1, inRight);
		return root;
	}
}