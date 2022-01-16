package com.shockang.study.algorithm.java.leetcode.leetcode701_800.leetcode771.solution2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Shockang
 */
public class Solution {
	public int numJewelsInStones(String jewels, String stones) {
		int res = 0;
		Set<Character> set = new HashSet<>();
		int jl = jewels.length(), sl = stones.length();
		for (int i = 0; i < jl; i++) {
			char jewel = jewels.charAt(i);
			set.add(jewel);
		}
		for (int i = 0; i < sl; i++) {
			char stone = stones.charAt(i);
			if (set.contains(stone)) {
				res++;
			}
		}
		return res;
	}
}
