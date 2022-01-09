package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode77.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯
 *
 * @author Shockang
 */
public class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<>();
		pick(list, new ArrayList<>(k), n, k, 1);
		return list;
	}

	private void pick(List<List<Integer>> list, List<Integer> tmp, int n, int k, int start) {
		if (k <= 0) {
			list.add(new ArrayList<>(tmp));
			return;
		}
		for (int i = start; i <= n - k + 1; i++) {
			tmp.add(i);
			pick(list, tmp, n, k - 1, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}
}
