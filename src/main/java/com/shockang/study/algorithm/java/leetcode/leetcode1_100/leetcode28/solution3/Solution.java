package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode28.solution3;

/**
 * BM 算法
 *
 * @author Shockang
 */
public class Solution {
	public int strStr(String haystack, String needle) {
		if (needle.isEmpty()) {
			return 0;
		}
		return bm(haystack.toCharArray(), haystack.length(), needle.toCharArray(), needle.length());
	}

	// a,b表示主串和模式串；n，m表示主串和模式串的长度。
	public int bm(char[] a, int n, char[] b, int m) {
		int[] bc = new int[256]; // 记录模式串中每个字符最后出现的位置
		generateBC(b, m, bc); // 构建坏字符哈希表
		int[] suffix = new int[m];
		boolean[] prefix = new boolean[m];
		generateGS(b, m, suffix, prefix);//好后缀
		int i = 0; // j表示主串与模式串匹配的第一个字符
		while (i <= n - m) {
			int j;
			for (j = m - 1; j >= 0; --j) { // 模式串从后往前匹配
				if (a[i + j] != b[j]) break; // 坏字符对应模式串中的下标是j
			}
			if (j < 0) {
				return i; // 匹配成功，返回主串与模式串第一个匹配的字符的位置
			}
			int x = j - bc[a[i + j]];
			int y = 0;
			if (j < m - 1) { // 如果有好后缀的话
				y = moveByGS(j, m, suffix, prefix);
			}
			i = i + Math.max(x, y);
		}
		return -1;
	}

	private void generateBC(char[] b, int m, int[] bc) {
		for (int i = 0; i < 256; ++i) {
			bc[i] = -1; // 初始化bc
		}
		for (int i = 0; i < m; ++i) {
			int ascii = b[i]; // 计算b[i]的ASCII值
			bc[ascii] = i;
		}
	}

	// b表示模式串，m表示长度，suffix，prefix数组事先申请好了
	private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
		for (int i = 0; i < m; ++i) { // 初始化
			suffix[i] = -1;
			prefix[i] = false;
		}
		for (int i = 0; i < m - 1; ++i) { // b[0, i]
			int j = i;
			int k = 0; // 公共后缀子串长度
			while (j >= 0 && b[j] == b[m - 1 - k]) { // 与b[0, m-1]求公共后缀子串
				--j;
				++k;
				suffix[k] = j + 1; //j+1表示公共后缀子串在b[0, i]中的起始下标
			}
			if (j == -1) prefix[k] = true; //如果公共后缀子串也是模式串的前缀子串
		}
	}

	// j表示坏字符对应的模式串中的字符下标; m表示模式串长度
	private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
		int k = m - 1 - j; // 好后缀长度
		if (suffix[k] != -1) return j - suffix[k] + 1;
		for (int r = j + 2; r <= m - 1; ++r) {
			if (prefix[m - r]) {
				return r;
			}
		}
		return m;
	}
}

