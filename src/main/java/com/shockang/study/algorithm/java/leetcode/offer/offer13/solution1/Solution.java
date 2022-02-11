package com.shockang.study.algorithm.java.leetcode.offer.offer13.solution1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Shockang
 */
public class Solution {
	private int K, M, N;
	private Set<String> set = new HashSet<>();

	public int movingCount(int m, int n, int k) {
		K = k;
		M = m;
		N = n;
		dfs(0, 0);
		return set.size();
	}

	private void dfs(int x, int y) {
		if (x < 0 || y < 0 || x > M - 1 || y > N - 1 || checkSum(x, y) || set.contains(x + "," + y))
			return;
		set.add(x + "," + y);
		dfs(x + 1, y);
		dfs(x - 1, y);
		dfs(x, y + 1);
		dfs(x, y - 1);
	}

	private boolean checkSum(int x, int y) {
		return (x % 10 + x / 10 + y % 10 + y / 10) > K;
	}
}