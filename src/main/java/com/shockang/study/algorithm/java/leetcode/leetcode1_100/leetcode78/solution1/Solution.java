package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode78.solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯
 *
 * @author Shockang
 */
public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tmp, int[] nums, int start) {
		list.add(new ArrayList<>(tmp));
		for (int i = start; i < nums.length; i++) {
			tmp.add(nums[i]);
			backtrack(list, tmp, nums, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}
}
