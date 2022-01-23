package com.shockang.study.algorithm.java.leetcode.leetcode1201_1300.leetcode1237.solution1;

import com.shockang.study.algorithm.java.leetcode.leetcode1201_1300.leetcode1237.common.CustomFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
		List<List<Integer>> res = new ArrayList<>();
		int x = 1, y = 1000;
		while (x < 1001 && y > 0) {
			int v = customfunction.f(x, y);
			if (v > z) --y;
			else if (v < z) ++x;
			else res.add(Arrays.asList(x++, y--));
		}
		return res;
	}
}
