package com.shockang.study.algorithm.java.leetcode.leetcode901_1000.leetcode917.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public String reverseOnlyLetters(String S) {
		StringBuilder ans = new StringBuilder();
		int j = S.length() - 1;
		for (int i = 0; i < S.length(); ++i) {
			if (Character.isLetter(S.charAt(i))) {
				while (!Character.isLetter(S.charAt(j)))
					j--;
				ans.append(S.charAt(j--));
			} else {
				ans.append(S.charAt(i));
			}
		}

		return ans.toString();
	}
}