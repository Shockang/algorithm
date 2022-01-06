package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode389.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public char findTheDifference(String s, String t) {
		int n = s.length();
		int[] array = new int[26];
		for (int i = 0; i < n; i++) {
			array[s.charAt(i) - 'a']++;
			array[t.charAt(i) - 'a']--;
		}
		array[t.charAt(n) - 'a']--;
		for (int i = 0; i < 26; i++) {
			if (array[i] != 0) return (char) (i + 'a');
		}
		return ' ';
	}
}