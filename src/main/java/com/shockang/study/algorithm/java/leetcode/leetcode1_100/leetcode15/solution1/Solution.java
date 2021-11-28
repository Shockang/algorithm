package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode15.solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * <p>
 * 排序+双指针
 *
 * @author Shockang
 */
public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		int n = nums.length;
		if (n < 3) {
			return new ArrayList<>(0);
		}
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < n - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int a = nums[i], j = i + 1, k = n - 1;
			while (j < k) {
				if (nums[j] + nums[k] + a == 0) {
					res.add(Arrays.asList(a, nums[j], nums[k]));
					while (j < k && nums[j] == nums[j + 1]) {
						j++;
					}
					j++;
					while (j < k && nums[k] == nums[k - 1]) {
						k--;
					}
					k--;
				} else if (nums[j] + nums[k] + a < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		return res;
	}
}
