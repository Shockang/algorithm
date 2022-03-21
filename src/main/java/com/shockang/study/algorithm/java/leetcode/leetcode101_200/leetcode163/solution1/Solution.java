package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode163.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<>();
		long pre = (long) lower - 1; // prevent 'int' overflow
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] - pre == 2) res.add(String.valueOf(pre + 1));
			else if (nums[i] - pre > 2) res.add((pre + 1) + "->" + (nums[i] - 1));
			pre = nums[i]; // 'int' to 'long'
		}
		if (upper - pre == 1) res.add(String.valueOf(pre + 1));
		else if (upper - pre > 1) res.add((pre + 1) + "->" + upper);
		return res;
	}
}