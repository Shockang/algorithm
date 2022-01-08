package com.shockang.study.algorithm.java.leetcode.leetcode401_500.leetcode491.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {

	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		dfs(ans, new ArrayList<>(), nums, 0, Integer.MIN_VALUE);
		return ans;
	}

	public void dfs(List<List<Integer>> ans, List<Integer> temp, int[] nums, int index, int last) {
		if (index == nums.length) {
			if (temp.size() >= 2) {
				ans.add(new ArrayList<>(temp));
			}
			return;
		}
		if (nums[index] >= last) {
			temp.add(nums[index]);
			dfs(ans, temp, nums, index + 1, nums[index]);
			temp.remove(temp.size() - 1);
		}
		// 当当前的元素等于上一个选择的元素的时候，一定选择当前元素
		if (nums[index] != last) {
			dfs(ans, temp, nums, index + 1, last);
		}
	}
}
