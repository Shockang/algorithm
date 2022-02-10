package com.shockang.study.algorithm.java.leetcode.leetcode1601_1700.leetcode1610.solution2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 滑动窗口
 *
 * @author Shockang
 */
public class Solution {
	public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
		int sameCnt = 0;
		List<Double> polarDegrees = new ArrayList<>();
		int locationX = location.get(0);
		int locationY = location.get(1);
		for (int i = 0; i < points.size(); ++i) {
			int x = points.get(i).get(0);
			int y = points.get(i).get(1);
			if (x == locationX && y == locationY) {
				sameCnt++;
				continue;
			}
			Double degree = Math.atan2(y - locationY, x - locationX);
			polarDegrees.add(degree);
		}
		Collections.sort(polarDegrees);

		int m = polarDegrees.size();
		for (int i = 0; i < m; ++i) {
			polarDegrees.add(polarDegrees.get(i) + 2 * Math.PI);
		}

		int maxCnt = 0;
		int right = 0;
		double toDegree = angle * Math.PI / 180;
		for (int i = 0; i < m; ++i) {
			Double curr = polarDegrees.get(i) + toDegree;
			while (right < polarDegrees.size() && polarDegrees.get(right) <= curr) {
				right++;
			}
			maxCnt = Math.max(maxCnt, right - i);
		}
		return maxCnt + sameCnt;
	}
}