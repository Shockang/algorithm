package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode46.solution2;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯 + X
 *
 * @author Shockang
 */
public class Solution {
	private int[] nums;
	private int n;
	private static final int X = 11;

	public List<List<Integer>> permute(int[] nums) {
		this.nums = nums;
		n = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		backtracking(res, new ArrayList<>(n));
		return res;
	}

	private void backtracking(List<List<Integer>> res, List<Integer> tmp) {
		if (tmp.size() == n) {
			res.add(new ArrayList<>(tmp));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (nums[i] != X) {
				int cur = nums[i];
				tmp.add(cur);
				nums[i] = X;
				backtracking(res, tmp);
				nums[i] = cur;
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
