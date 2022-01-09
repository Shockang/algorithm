package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode90.solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯
 *
 * @author Shockang
 */
public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums); //排序
		backtracking(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private void backtracking(List<List<Integer>> list, List<Integer> tmp, int[] nums, int start) {
		list.add(new ArrayList<>(tmp));
		for (int i = start; i < nums.length; i++) {
			//和上个数字相等就跳过
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
			tmp.add(nums[i]);
			backtracking(list, tmp, nums, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}
}
