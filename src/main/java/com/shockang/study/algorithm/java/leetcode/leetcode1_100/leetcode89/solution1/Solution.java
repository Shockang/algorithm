package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode89.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * 镜像反射法
 *
 * @author Shockang
 */
public class Solution {
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>() {{
			add(0);
		}};
		int head = 1;
		for (int i = 0; i < n; i++) {
			for (int j = res.size() - 1; j >= 0; j--)
				res.add(head + res.get(j));
			head <<= 1;
		}
		return res;
	}
}
