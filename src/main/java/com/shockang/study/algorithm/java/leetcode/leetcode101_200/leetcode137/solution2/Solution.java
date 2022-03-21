package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode137.solution2;

/**
 * @author Shockang
 */
public class Solution {
	public int singleNumber(int[] nums) {
		int ones = 0, twos = 0;
		for (int x : nums) {
			// 之前出现过两次的，这次再出现就是出现了三次
			int threes = twos & x;

			// 之前出现过两次，这次没出现，是出现了两次。
			// 之前出现过一次的，这次再出现，也是出现了两次。
			twos = (twos & ~x) | (ones & x);

			// 统计记录出现了奇数次的，并从其中清除出现三次的。
			// 这样ones里面始终只会记录出现了一次的。
			ones = ones ^ x;
			ones &= ~threes;
		}
		return ones;
	}
}