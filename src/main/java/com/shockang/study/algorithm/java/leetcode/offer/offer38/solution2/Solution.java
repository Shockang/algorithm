package com.shockang.study.algorithm.java.leetcode.offer.offer38.solution2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Shockang
 */
public class Solution {
	private char[] S;
	private int n;

	public String[] permutation(String s) {
		S = s.toCharArray();
		n = s.length();
		Set<String> set = new HashSet<>();
		backtracking(set, new StringBuilder());
		return set.toArray(new String[0]);
	}

	private void backtracking(Set<String> set, StringBuilder sb) {
		if (sb.length() == n) {
			set.add(sb.toString());
			return;
		}
		for (int i = 0; i < n; i++) {
			if (S[i] != '\u0000') {
				char c = S[i];
				sb.append(S[i]);
				S[i] = '\u0000';
				backtracking(set, sb);
				sb.deleteCharAt(sb.length() - 1);
				S[i] = c;
			}
		}
	}
}