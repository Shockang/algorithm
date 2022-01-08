package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode18.solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * sort+continue/break/continue+双指针
 *
 * @author Shockang
 */
public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		int n = nums.length;
		if (n < 4) {
			return res;
		}
		Arrays.sort(nums);
		for (int i = 0; i < n - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
				break;
			}
			if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) {
				continue;
			}
			int threeSum = target - nums[i];
			for (int j = i + 1; j < n - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				if (nums[j] + nums[j + 1] + nums[j + 2] > threeSum) {
					break;
				}
				if (nums[j] + nums[n - 1] + nums[n - 2] < threeSum) {
					continue;
				}
				int twoSum = threeSum - nums[j];
				int three = j + 1, four = n - 1;
				while (three < four) {
					int sum = nums[three] + nums[four];
					if (sum == twoSum) {
						res.add(Arrays.asList(nums[i], nums[j], nums[three], nums[four]));
					}
					if (sum < twoSum) {
						three++;
						while (three < four && nums[three] == nums[three - 1]) three++;
					} else {
						four--;
						while (three < four && nums[four] == nums[four + 1]) four--;
					}
				}
			}
		}
		return res;
	}
}