package com.shockang.study.algorithm.java.leetcode.leetcode701_800.leetcode771.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int numJewelsInStones(String J, String S) {
		if (J == null || J.isEmpty() || S == null || S.isEmpty()) {
			return 0;
		}
		int count = 0;
		boolean[] ascii = new boolean[128];
		for (char c : J.toCharArray()) {
			ascii[c] = true;
		}
		for (char c : S.toCharArray()) {
			if (ascii[c]) {
				count++;
			}
		}
		return count;
	}
}
