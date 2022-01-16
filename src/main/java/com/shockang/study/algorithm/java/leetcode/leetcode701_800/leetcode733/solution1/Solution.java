package com.shockang.study.algorithm.java.leetcode.leetcode701_800.leetcode733.solution1;

/**
 * @author Shockang
 */
public class Solution {
	int[] dx = {1, 0, 0, -1};
	int[] dy = {0, 1, -1, 0};

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int currColor = image[sr][sc];
		if (currColor != newColor) {
			dfs(image, sr, sc, currColor, newColor);
		}
		return image;
	}

	public void dfs(int[][] image, int x, int y, int color, int newColor) {
		if (image[x][y] == color) {
			image[x][y] = newColor;
			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i], my = y + dy[i];
				if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
					dfs(image, mx, my, color, newColor);
				}
			}
		}
	}
}