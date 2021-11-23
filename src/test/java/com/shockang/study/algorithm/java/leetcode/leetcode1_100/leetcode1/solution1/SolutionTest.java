package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode1.solution1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.shockang.study.algorithm.java.leetcode.util.ArrayUtil.intArrayToString;
import static com.shockang.study.algorithm.java.leetcode.util.ArrayUtil.stringToIntArray;

public class SolutionTest {

	@Test
	public void test1() {
		test("[2,7,11,15]", 9, "[0,1]");
	}

	@Test
	public void test2() {
		test("[3,2,4]", 6, "[1,2]");
	}

	@Test
	public void test3() {
		test("[3,3]", 6, "[0,1]");
	}

	private void test(String nums, int target, String resStr) {
		int[] res = new Solution().twoSum(stringToIntArray(nums), target);
		Arrays.sort(res);
		assert resStr.equals(intArrayToString(res));
	}
}
