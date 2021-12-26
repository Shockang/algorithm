package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode300.solution1;

/**
 * @author Shockang
 */
public class Solution {
		public int lengthOfLIS(int[] nums) {
				int len = 1, n = nums.length;
				if (n == 0) {
						return 0;
				}
				int[] d = new int[n + 1];
				d[len] = nums[0];
				for (int i = 1; i < n; ++i) {
						if (nums[i] > d[len]) {
								d[++len] = nums[i];
						} else {
								int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
								while (l <= r) {
										int mid = (l + r) >> 1;
										if (d[mid] < nums[i]) {
												pos = mid;
												l = mid + 1;
										} else {
												r = mid - 1;
										}
								}
								d[pos + 1] = nums[i];
						}
				}
				return len;
		}
}