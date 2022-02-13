package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode128.solution1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Shockang
 */
public class Solution {
	public int longestConsecutive(int[] nums) {
		Set<Integer> numSet = new HashSet<>();
		for (int num : nums) {
			numSet.add(num);
		}

		int res = 0;

		for (int num : numSet) {
			if (!numSet.contains(num - 1)) {
				int currentNum = num;
				int cur = 1;

				while (numSet.contains(currentNum + 1)) {
					currentNum += 1;
					cur += 1;
				}

				res = Math.max(res, cur);
			}
		}

		return res;
	}
}