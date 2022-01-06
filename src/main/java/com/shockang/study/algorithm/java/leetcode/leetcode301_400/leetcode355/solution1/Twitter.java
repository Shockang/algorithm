package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode355.solution1;

import java.util.*;

/**
 * @author Shockang
 */
public class Twitter {

	private Map<Integer, List<Integer>> userMap;
	private Map<Integer, Integer> twitterMap;
	private Map<Integer, List<Integer>> followMap;
	private Set<Integer> set;
	private int timestamp;

	/**
	 * Initialize your data structure here.
	 */
	public Twitter() {
		userMap = new HashMap<>();
		twitterMap = new HashMap<>();
		followMap = new HashMap<>();
		set = new TreeSet<>((x1, x2) -> -Integer.compare(twitterMap.get(x1), twitterMap.get(x2)));
		timestamp = 0;
	}

	/**
	 * Compose a new tweet.
	 */
	public void postTweet(int userId, int tweetId) {
		if (userMap.containsKey(userId)) {
			userMap.get(userId).add(tweetId);
		} else {
			List<Integer> twitterIds = new LinkedList<>();
			twitterIds.add(tweetId);
			userMap.put(userId, twitterIds);
		}
		twitterMap.put(tweetId, timestamp++);
		if (!followMap.containsKey(userId)) {
			List<Integer> followees = new LinkedList<>();
			followees.add(userId);
			followMap.put(userId, followees);
		}
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> followees = followMap.get(userId);
		if (followees == null || followees.isEmpty()) {
			return new ArrayList<>(0);
		}
		set.clear();
		for (int followee : followees) {
			if (userMap.containsKey(followee)) {
				List<Integer> list = userMap.get(followee);
				if (list == null || list.isEmpty()) {
					continue;
				}
				set.addAll(list);
			}
		}
		List<Integer> res = new ArrayList<>(set);
		if (res.size() <= 10) {
			return res;
		}
		return res.subList(0, 10);
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a no-op.
	 */
	public void follow(int followerId, int followeeId) {
		if (followerId == followeeId) {
			return;
		}
		if (followMap.containsKey(followerId)) {
			followMap.get(followerId).add(followeeId);
		} else {
			List<Integer> followees = new LinkedList<>();
			followees.add(followeeId);
			followees.add(followerId);
			followMap.put(followerId, followees);
		}
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		if (followerId == followeeId) {
			return;
		}
		if (followMap.containsKey(followerId)) {
			List<Integer> list = followMap.get(followerId);
			list.removeIf(x -> x == followeeId);
		}
	}

}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */