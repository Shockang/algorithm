package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode398.solution1;

import java.util.Random;

/**
 * @author Shockang
 */
public class Solution {
	int[] nums;
	Random random;

	public Solution(int[] nums) {
		this.nums = nums;
		random = new Random();
	}

	public int pick(int target) {
		int ans = 0;
		for (int i = 0, cnt = 0; i < nums.length; ++i) {
			if (nums[i] == target) {
				++cnt; // 第 cnt 次遇到 target
				if (random.nextInt(cnt) == 0) {
					ans = i;
				}
			}
		}
		return ans;
	}
}