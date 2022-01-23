package com.shockang.study.algorithm.java.leetcode.leetcode1101_1200.leetcode1114.solution1;

import java.util.concurrent.CountDownLatch;

/**
 * @author Shockang
 */
public class Foo {

	private CountDownLatch firstLatch;
	private CountDownLatch secondLatch;

	public Foo() {
		firstLatch = new CountDownLatch(1);
		secondLatch = new CountDownLatch(1);
	}

	public void first(Runnable printFirst) throws InterruptedException {
		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		firstLatch.countDown();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		// printSecond.run() outputs "second". Do not change or remove this line.
		firstLatch.await();
		printSecond.run();
		secondLatch.countDown();
	}

	public void third(Runnable printThird) throws InterruptedException {
		// printThird.run() outputs "third". Do not change or remove this line.
		secondLatch.await();
		printThird.run();
	}
}