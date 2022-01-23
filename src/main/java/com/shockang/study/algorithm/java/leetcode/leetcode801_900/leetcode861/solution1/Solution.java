package com.shockang.study.algorithm.java.leetcode.leetcode801_900.leetcode861.solution1;

/**
 * 贪心
 * https://leetcode-cn.com/problems/score-after-flipping-matrix/solution/fan-zhuan-ju-zhen-hou-de-de-fen-by-leetc-cxma/
 *
 * @author Shockang
 */
public class Solution {
	public int matrixScore(int[][] A) {
		int m = A.length, n = A[0].length;
		int ret = m * (1 << (n - 1));

		for (int j = 1; j < n; j++) {
			int nOnes = 0;
			for (int i = 0; i < m; i++) {
				if (A[i][0] == 1) {
					nOnes += A[i][j];
				} else {
					nOnes += (1 - A[i][j]); // 如果这一行进行了行反转，则该元素的实际取值为 1 - A[i][j]
				}
			}
			int k = Math.max(nOnes, m - nOnes);
			ret += k * (1 << (n - j - 1));
		}
		return ret;
	}
}