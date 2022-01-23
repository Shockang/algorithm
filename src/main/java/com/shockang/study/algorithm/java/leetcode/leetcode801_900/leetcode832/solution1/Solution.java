package com.shockang.study.algorithm.java.leetcode.leetcode801_900.leetcode832.solution1;

/**
 * 模拟优化 + 双指针
 *
 * @author Shockang
 */
public class Solution {
	public int[][] flipAndInvertImage(int[][] image) {
		int n = image.length;
		for (int i = 0; i < n; i++) {
			int left = 0, right = n - 1;
			while (left < right) {
				if (image[i][left] == image[i][right]) {
					// [0，0] => [1,1]
					// [1,1] => [0,0]
					// [0,1] => [0,1]
					// [1,0] => [1,0]
					image[i][left] ^= 1;
					image[i][right] ^= 1;
				}
				left++;
				right--;
			}
			// 奇数中间元素反转
			if (left == right) {
				image[i][left] ^= 1;
			}
		}
		return image;
	}
}
