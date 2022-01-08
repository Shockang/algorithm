package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode40.solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public List<List<Integer>> combinationSum2(int[] cand, int target) {
		Arrays.sort(cand);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		dfs(cand, 0, target, path, res);
		return res;
	}

	void dfs(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList<>(path));
			return;
		}
		if (target < 0) return;
		for (int i = cur; i < cand.length; i++) {
			if (i > cur && cand[i] == cand[i - 1]) continue;
			path.add(path.size(), cand[i]);
			dfs(cand, i + 1, target - cand[i], path, res);
			path.remove(path.size() - 1);
		}
	}
}
