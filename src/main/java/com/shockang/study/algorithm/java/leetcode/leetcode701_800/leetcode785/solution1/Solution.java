package com.shockang.study.algorithm.java.leetcode.leetcode701_800.leetcode785.solution1;

import java.util.Arrays;

/**
 * @author Shockang
 */
public class Solution {
	private static final int UNCOLORED = 0;
	private static final int RED = 1;
	private static final int GREEN = 2;
	private int[] color;
	private boolean valid;

	public boolean isBipartite(int[][] graph) {
		int n = graph.length;
		valid = true;
		color = new int[n];
		Arrays.fill(color, UNCOLORED);
		for (int i = 0; i < n && valid; ++i) {
			if (color[i] == UNCOLORED) {
				dfs(i, RED, graph);
			}
		}
		return valid;
	}

	public void dfs(int node, int c, int[][] graph) {
		color[node] = c;
		int cNei = c == RED ? GREEN : RED;
		for (int neighbor : graph[node]) {
			if (color[neighbor] == UNCOLORED) {
				dfs(neighbor, cNei, graph);
				if (!valid) {
					return;
				}
			} else if (color[neighbor] != cNei) {
				valid = false;
				return;
			}
		}
	}
}