package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode310.solution1;

import java.util.*;

/**
 * @author Shockang
 */
public class Solution {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> ans = new ArrayList<>();
		if (n == 1) {
			ans.add(0);
			return ans;
		}
		List<Integer>[] adj = new List[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int[] edge : edges) {
			adj[edge[0]].add(edge[1]);
			adj[edge[1]].add(edge[0]);
		}

		int[] parent = new int[n];
		Arrays.fill(parent, -1);
		/* 找到与节点 0 最远的节点 x */
		int x = findLongestNode(0, parent, adj);
		/* 找到与节点 x 最远的节点 y */
		int y = findLongestNode(x, parent, adj);
		/* 求出节点 x 到节点 y 的路径 */
		List<Integer> path = new ArrayList<>();
		parent[x] = -1;
		while (y != -1) {
			path.add(y);
			y = parent[y];
		}
		int m = path.size();
		if (m % 2 == 0) {
			ans.add(path.get(m / 2 - 1));
		}
		ans.add(path.get(m / 2));
		return ans;
	}

	public int findLongestNode(int u, int[] parent, List<Integer>[] adj) {
		int n = adj.length;
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[n];
		queue.offer(u);
		visit[u] = true;
		int node = -1;

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			node = curr;
			for (int v : adj[curr]) {
				if (!visit[v]) {
					visit[v] = true;
					parent[v] = curr;
					queue.offer(v);
				}
			}
		}
		return node;
	}
}
