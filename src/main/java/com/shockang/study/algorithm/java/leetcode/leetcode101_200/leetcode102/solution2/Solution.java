package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode102.solution2;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 迭代
 *
 * @author Shockang
 */
public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		//返回的结果
		List<List<Integer>> res = new ArrayList<>();
		if (null == root) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		//根节点入队
		queue.add(root);
		while (!queue.isEmpty()) {
			//一层的结果
			List<Integer> level = new ArrayList<>();
			int levelCount = queue.size();
			//添加节点到一层的List中去
			for (int i = 0; i < levelCount; i++) {
				//节点出队
				TreeNode node = queue.remove();
				//节点的左子树入队
				if (node.left != null) {
					queue.add(node.left);
				}
				//节点的右子树入队
				if (node.right != null) {
					queue.add(node.right);
				}
				level.add(node.val);
			}
			res.add(level);
		}
		return res;
	}
}
