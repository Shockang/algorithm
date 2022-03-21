package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode156.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * @author Shockang
 */
public class Solution {
	//记录反转后的头节点
	TreeNode head = null;

	public TreeNode upsideDownBinaryTree(TreeNode root) {
		//对于root来说，父节点为null
		dfs(root, null);
		return head;
	}

	public void dfs(TreeNode root, TreeNode pre) {
		if (root == null) return;
		//前序遍历，先往左走
		dfs(root.left, root);
		if (head == null) {
			//head置为最左边的节点
			head = root;
		}
		//记录当前节点的右节点，因为当前节点的右节点要置为其父节点，为了能正常遍历，需要先进行记录
		TreeNode r = root.right;
		if (pre != null) {
			//父节点的left置为null，不会对遍历过程造成影响，因为左边已经全部遍历完成了
			pre.left = null;
			//当前节点左节点置为父节点的右节点
			root.left = pre.right;
			//父节点的right置为null，不会对遍历过程造成影响，因为右节点已经在上层进行了记录
			pre.right = null;
			//当前节点右节点置为父节点
			root.right = pre;
		}
		//向右进行遍历
		dfs(r, root);
	}
}