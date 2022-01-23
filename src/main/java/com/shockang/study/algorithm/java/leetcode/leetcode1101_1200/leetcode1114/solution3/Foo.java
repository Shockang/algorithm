package com.shockang.study.algorithm.java.leetcode.leetcode1101_1200.leetcode1114.solution3;

import java.util.concurrent.Semaphore;

/**
 * @author Shockang
 */
public class Foo {

	Semaphore s12 = new Semaphore(0);
	Semaphore s23 = new Semaphore(0);

	public Foo() {

	}

	public void first(Runnable printFirst) throws InterruptedException {
		printFirst.run();
		s12.release();//释放后s12的值会变成1
	}

	public void second(Runnable printSecond) throws InterruptedException {
		s12.acquire();//没有会阻塞  当为1的时候，说明线程2可以拿到s12了
		printSecond.run();
		s23.release();//释放后s23的值会变成1
	}

	public void third(Runnable printThird) throws InterruptedException {
		s23.acquire();//0的时候拿不到，1的时候可以拿到
		printThird.run();
	}
}