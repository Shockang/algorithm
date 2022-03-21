package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode137.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int singleNumber(int[] nums) {
		//最终的结果值
		int res = 0;
		//int类型有32位，统计每一位1的个数
		for (int i = 0; i < 32; i++) {
			//统计第i位中1的个数
			int oneCount = 0;
			for (int j = 0; j < nums.length; j++) {
				oneCount += (nums[j] >>> i) & 1;
			}
			//如果1的个数不是3的倍数，说明那个只出现一次的数字
			//的二进制位中在这一位是1
			if (oneCount % 3 == 1)
				res |= 1 << i;
		}
		return res;
	}
}