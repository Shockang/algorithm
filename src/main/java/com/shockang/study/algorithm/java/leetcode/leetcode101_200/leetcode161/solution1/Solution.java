package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode161.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public boolean isOneEditDistance(String s, String t) {
		int ns = s.length(), nt = t.length();

		// Ensure that s is shorter than t.
		if (ns > nt)
			return isOneEditDistance(t, s);

		// The strings are NOT one edit away distance
		// if the length diff is more than 1.
		if (nt - ns > 1)
			return false;

		for (int i = 0; i < ns; i++)
			if (s.charAt(i) != t.charAt(i))
				// if strings have the same length
				if (ns == nt)
					return s.substring(i + 1).equals(t.substring(i + 1));
					// if strings have different lengths
				else
					return s.substring(i).equals(t.substring(i + 1));

		// If there is no diffs on ns distance
		// the strings are one edit away only if
		// t has one more character.
		return ns + 1 == nt;
	}
}