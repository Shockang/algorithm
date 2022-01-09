package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode76.solution1;

/**
 * 滑动窗口
 *
 * @author Shockang
 */
public class Solution {
	public String minWindow(String s, String t) {
		if (s == null || s.length() == 0 || t == null || t.length() == 0) {
			return "";
		}
		int[] need = new int[128];
		//记录需要的字符的个数
		for (int i = 0; i < t.length(); i++) {
			need[t.charAt(i)]++;
		}
		//l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
		int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
		//遍历所有字符
		while (r < s.length()) {
			char c = s.charAt(r);
			if (need[c] > 0) {//需要字符c
				count--;
			}
			need[c]--;//把右边的字符加入窗口
			if (count == 0) {//窗口中已经包含所有字符
				while (l < r && need[s.charAt(l)] < 0) {
					need[s.charAt(l)]++;//释放右边移动出窗口的字符
					l++;//指针右移
				}
				if (r - l + 1 < size) {//不能右移时候调整最小窗口大小，更新最小窗口开始的start
					size = r - l + 1;
					start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
				}
				//l向右移动后窗口肯定不能满足了 重新开始循环
				need[s.charAt(l)]++;
				l++;
				count++;
			}
			r++;
		}
		return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
	}
}
