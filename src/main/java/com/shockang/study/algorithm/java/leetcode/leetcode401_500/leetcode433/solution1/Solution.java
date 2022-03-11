package com.shockang.study.algorithm.java.leetcode.leetcode401_500.leetcode433.solution1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Shockang
 */
public class Solution {
	char[] mode = {'A', 'C', 'G', 'T'};

	public int minMutation(String start, String end, String[] bank) {
		// 定义三个集合，分别是合法基因集合，起始基因集合，目标基因集合，起始基因记忆集，目标基因记忆集
		Set<String> dict = new HashSet<>(), st = new HashSet<>(), ed = new HashSet<>(), menSt = new HashSet<>(), menEd = new HashSet<>();
		for (String s : bank) dict.add(s);
		// 基因库中不包含目标，则无法转换
		if (!dict.contains(end)) return -1;

		st.add(start);
		ed.add(end);
		// 宽搜
		return bfs(st, ed, menSt, menEd, dict, 0);
	}

	// 宽搜
	private int bfs(Set<String> st, Set<String> ed, Set<String> menSt, Set<String> menEd, Set<String> dict, int len) {
		// 起始集合为空，那么就无法到达目标
		if (st.size() == 0) return -1;
		// 优先从数量少的一端开始搜索，减少搜索量
		if (st.size() > ed.size()) return bfs(ed, st, menEd, menSt, dict, len);
		Set<String> next = new HashSet<>();
		// 枚举起始集合可以一步转换的所有基因序列
		for (String s : st) {
			StringBuilder temp = new StringBuilder(s);
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 4; j++) {
					temp.setCharAt(i, mode[j]);
					String cur = temp.toString();
					// 终点集合中包含了当前字符，那么直接返回步数
					if (ed.contains(cur)) return len + 1;
					// 如果搜过了该种情况，就不能重复遍历
					if (menSt.contains(cur)) continue;

					// 如果是合法序列，则加入下一个搜索集合中
					if (dict.contains(cur)) {
						next.add(cur);
						menSt.add(cur);
					}
					temp.setCharAt(i, s.charAt(i));
				}
			}
		}
		// 搜索下一层
		return bfs(next, ed, menSt, menEd, dict, len + 1);
	}
}
