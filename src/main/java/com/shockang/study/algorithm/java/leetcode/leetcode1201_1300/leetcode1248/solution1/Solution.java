package com.shockang.study.algorithm.java.leetcode.leetcode1201_1300.leetcode1248.solution1;

/**
 * 前缀和
 *
 * @author Shockang
 */
public class Solution {
	public int numberOfSubarrays(int[] nums, int k) {
		// 这里的前缀和指的是从0开始到当前元素这个区间的奇数的个数，所以两个前缀和的差就是两个元素之间的奇数的个数，我们要找的就是奇数个数为k的区间
		// prefixCnt数组是用来统计的是前缀和的个数，数组下标是前缀和，值是个数。
		// 如果当的前缀数组的奇数个数为s2，那我们需要看有多少个前缀数组的奇数个数为 s1 = s2 - k 的，那么这些区间的奇数个数都是k，就累加到res中
		int[] prefixCnt = new int[nums.length + 1];
		prefixCnt[0] = 1;
		// 遍历原数组，计算当前的前缀和，统计到 prefixCnt 数组中，
		// 并且在 res 中累加上与当前前缀和差值为 k 的前缀和的个数。
		int res = 0, sum = 0;
		for (int num : nums) {
			sum += num & 1;
			prefixCnt[sum]++;
			if (sum >= k) {
				res += prefixCnt[sum - k];
			}
		}
		return res;
	}
}