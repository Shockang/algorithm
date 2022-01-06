package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode315.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * 暴力解法 超时
 *
 * @author Shockang
 */
public class Solution {
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = i + 1; j < n; j++) {
				if (nums[j] < nums[i]) {
					count++;
				}
			}
			res.add(count);
		}
		return res;
	}
}