package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode47.solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯+boolean数组
 *
 * @author Shockang
 */
public class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<>();
		backtracking(list, new ArrayList<>(), nums, new boolean[nums.length]);
		return list;
	}

	private void backtracking(List<List<Integer>> list, List<Integer> tmp, int[] nums, boolean[] used) {
		if (nums.length == tmp.size()) {
			list.add(new ArrayList<>(tmp));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
				continue;
			}
			used[i] = true;
			tmp.add(nums[i]);
			backtracking(list, tmp, nums, used);
			used[i] = false;
			tmp.remove(tmp.size() - 1);
		}
	}
}
