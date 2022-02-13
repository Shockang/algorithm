package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode133.solution2;

import com.shockang.study.algorithm.java.leetcode.common.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Shockang
 */
public class Solution {
	public Node cloneGraph(Node node) {
		if (node == null) {
			return node;
		}
		HashMap<Node, Node> visited = new HashMap<>();
		// 将题目给定的节点添加到队列
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(node);
		// 克隆第一个节点并存储到哈希表中
		visited.put(node, new Node(node.val, new ArrayList()));
		// 广度优先搜索
		while (!queue.isEmpty()) {
			// 取出队列的头节点
			Node n = queue.remove();
			// 遍历该节点的邻居
			for (Node neighbor : n.neighbors) {
				if (!visited.containsKey(neighbor)) {
					// 如果没有被访问过，就克隆并存储在哈希表中
					visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
					// 将邻居节点加入队列中
					queue.add(neighbor);
				}
				// 更新当前节点的邻居列表
				visited.get(n).neighbors.add(visited.get(neighbor));
			}
		}
		return visited.get(node);
	}
}
