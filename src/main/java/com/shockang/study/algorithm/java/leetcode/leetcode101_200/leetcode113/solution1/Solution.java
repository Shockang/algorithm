package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode113.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * DFS
 *
 * @author Shockang
 */
public class Solution {
	List<List<Integer>> ret = new LinkedList<>();
	Deque<Integer> path = new LinkedList<>();

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		dfs(root, targetSum);
		return ret;
	}

	public void dfs(TreeNode root, int targetSum) {
		if (root == null) {
			return;
		}
		path.offerLast(root.val);
		targetSum -= root.val;
		if (root.left == null && root.right == null && targetSum == 0) {
			ret.add(new LinkedList<>(path));
		}
		dfs(root.left, targetSum);
		dfs(root.right, targetSum);
		path.pollLast();
	}
}