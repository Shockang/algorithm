package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode297.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 递归，sb，deque
 *
 * @author Shockang
 */
public class Codec {
		private static final String SPLITTER = ",";
		private static final String X = "X";

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
				StringBuilder sb = new StringBuilder();
				buildString(root, sb);
				return sb.toString();
		}

		private void buildString(TreeNode node, StringBuilder sb) {
				if (node == null) {
						sb.append(X).append(SPLITTER);
				} else {
						sb.append(node.val).append(SPLITTER);
						buildString(node.left, sb);
						buildString(node.right, sb);
				}
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
				return buildTree(new LinkedList<>(Arrays.asList(data.split(SPLITTER))));
		}

		private TreeNode buildTree(Deque<String> nodes) {
				String val = nodes.remove();
				if (val.equals(X)) return null;
				else {
						TreeNode node = new TreeNode(Integer.parseInt(val));
						node.left = buildTree(nodes);
						node.right = buildTree(nodes);
						return node;
				}
		}
}
