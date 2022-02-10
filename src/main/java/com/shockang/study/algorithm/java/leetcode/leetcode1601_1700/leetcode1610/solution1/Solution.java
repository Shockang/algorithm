package com.shockang.study.algorithm.java.leetcode.leetcode1601_1700.leetcode1610.solution1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
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
		Double toDegree = angle * Math.PI / 180;
		for (int i = 0; i < m; ++i) {
			int iteration = binarySearch(polarDegrees, polarDegrees.get(i) + toDegree, false);
			maxCnt = Math.max(maxCnt, iteration - i);
		}
		return maxCnt + sameCnt;
	}

	public int binarySearch(List<Double> nums, Double target, boolean lower) {
		int left = 0, right = nums.size() - 1;
		int ans = nums.size();
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums.get(mid) > target || (lower && nums.get(mid) >= target)) {
				right = mid - 1;
				ans = mid;
			} else {
				left = mid + 1;
			}
		}
		return ans;
	}
}