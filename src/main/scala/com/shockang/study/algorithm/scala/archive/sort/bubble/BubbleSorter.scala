package com.shockang.study.algorithm.scala.archive.sort.bubble

import com.shockang.study.algorithm.scala.archive.sort.Sorter

/**
 * 冒泡排序
 *
 * @author Shockang
 */
class BubbleSorter extends Sorter {
  override def sort(a: Array[Int]): Unit = {
    if (a == null || a.length < 2) return
    // i 从左到右遍历每一个数组元素， j 从右到左进行冒泡
    for (i <- a.indices; j <- i - 1 to 0 by -1) {
      if (a(j) > a(j + 1)) swap(a, j, j + 1)
    }
  }
}
