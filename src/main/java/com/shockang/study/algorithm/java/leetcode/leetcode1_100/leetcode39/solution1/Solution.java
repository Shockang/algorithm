package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode39.solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯
 *
 * @author Shockang
 */
public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), candidates, target, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
		if (remain < 0) return;
		if (remain == 0) {
			list.add(new ArrayList<>(tempList));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, remain - nums[i], i);
			tempList.remove(tempList.size() - 1);
		}
	}
}