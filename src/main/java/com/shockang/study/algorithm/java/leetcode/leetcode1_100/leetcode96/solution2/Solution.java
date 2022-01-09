package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode96.solution2;

/**
 * 卡特兰数
 *
 * @author Shockang
 */
public class Solution {
	public int numTrees(int n) {
		// 提示：我们在这里需要用 long 类型防止计算过程中的溢出
		long C = 1;
		for (int i = 0; i < n; ++i) {
			C = C * 2 * (2 * i + 1) / (i + 2);
		}
		return (int) C;
	}
}