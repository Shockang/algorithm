package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode46.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯 + contains
 *
 * @author Shockang
 */
public class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		helper(list, new ArrayList<>(), nums);
		return list;
	}

	private void helper(List<List<Integer>> list, List<Integer> tmp, int[] nums) {
		if (tmp.size() == nums.length) {
			list.add(new ArrayList<>(tmp));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!tmp.contains(nums[i])) {
				tmp.add(nums[i]);
				helper(list, tmp, nums);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}