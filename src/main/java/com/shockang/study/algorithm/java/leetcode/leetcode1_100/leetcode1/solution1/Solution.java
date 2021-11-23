package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode1.solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * <p>
 * 哈希表
 *
 * @author Shockang
 */
public class Solution {
	public int[] twoSum(int[] nums, int target) {
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>(n);
		for (int i = 0; i < n; i++) {
			if (map.containsKey(nums[i])) {
				return new int[]{i, map.get(nums[i])};
			} else {
				map.put(target - nums[i], i);
			}
		}
		return null;
	}
}
