package com.shockang.study.algorithm.java.leetcode.leetcode1201_1300.leetcode1259.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int numberOfWays(int num_people) {

		int MOD = (int) 1e9 + 7;
		long[] dp = new long[num_people + 1];
		dp[0] = 0L;
		dp[2] = 1L;
		for (int i = 4; i <= num_people; i += 2) {
			dp[i] = 2 * dp[i - 2]; // 握手的人就在左边和右边
			for (int j = 2; j < i - 2; j += 2) { // 每隔2个人选一个握手，以此为线将左右划分为2个圈
				dp[i] += (dp[j] * dp[i - j - 2]) % MOD;
			}
			dp[i] %= MOD;
		}

		return (int) dp[num_people];
	}
}