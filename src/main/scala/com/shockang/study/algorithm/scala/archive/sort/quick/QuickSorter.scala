package com.shockang.study.algorithm.scala.archive.sort.quick

import com.shockang.study.algorithm.scala.archive.sort.Sorter

/**
 * 快速排序
 *
 * @author Shockang
 */
class QuickSorter extends Sorter {
  override def sort(a: Array[Int]): Unit = {
    if (a == null || a.length < 2) return
    quickSort(a, 0, a.length - 1)
  }

  /**
   * 快速排序
   *
   * @param a    待排序数组
   * @param low  左边界
   * @param high 右边界
   */
  def quickSort(a: Array[Int], low: Int, high: Int): Unit = {
    if (low < high) {
      val curPoint = getCutPoint(a, low, high)
      quickSort(a, low, curPoint)
      quickSort(a, curPoint + 1, high)
    }
  }

  /**
   * 获取切分点，切分点后面的都比它大，切分点前面的都比它小
   *
   * @param a    待排序数组
   * @param low  左边界
   * @param high 右边界
   * @return
   */
  def getCutPoint(a: Array[Int], low: Int, high: Int): Int = {
    val m = a(low)
    var l = low
    var r = high
    while (l < r) {
      // 从右往左找第一个比切分点小的元素下标
      while (l < r && a(r) >= m) r -= 1
      // 从左往右找第一个比切分点大的元素下标
      while (l < r && a(l) <= m) l += 1
      if (l < r) swap(a, l, r)
    }
    swap(a, low, l)
    l
  }
}
