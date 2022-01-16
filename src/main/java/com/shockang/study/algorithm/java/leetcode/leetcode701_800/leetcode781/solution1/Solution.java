package com.shockang.study.algorithm.java.leetcode.leetcode701_800.leetcode781.solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * 分组
 * 比如10这个数字，最多允许11个兔子都说10，如果少于11个兔子说10，那么最多11个兔子就够了，
 * 如果多于11个兔子说了10，那么就要分第二组了
 *
 * @author Shockang
 */
public class Solution {
	public int numRabbits(int[] answers) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int answer : answers) {
			if (map.getOrDefault(answer, 0) == 0) {
				res += answer + 1;
				map.put(answer, answer);
			} else {
				map.put(answer, map.get(answer) - 1);
			}
		}
		return res;
	}
}