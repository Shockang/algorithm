package com.shockang.study.algorithm.java.leetcode.offer.offer38.solution1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Shockang
 */
public class Solution {
	private List<String> res = new ArrayList<>();
	private char[] c;
	private int n;

	public String[] permutation(String s) {
		c = s.toCharArray();
		n = s.length();
		dfs(0);
		return res.toArray(new String[0]);
	}

	void dfs(int x) {
		if (x == n - 1) {
			res.add(new String(c));      // 添加排列方案
			return;
		}
		Set<Character> set = new HashSet<>();
		for (int i = x; i < n; i++) {
			if (set.contains(c[i])) continue; // 重复，因此剪枝
			set.add(c[i]);
			swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
			dfs(x + 1);                      // 开启固定第 x + 1 位字符
			swap(i, x);                      // 恢复交换
		}
	}

	void swap(int a, int b) {
		char tmp = c[a];
		c[a] = c[b];
		c[b] = tmp;
	}
}