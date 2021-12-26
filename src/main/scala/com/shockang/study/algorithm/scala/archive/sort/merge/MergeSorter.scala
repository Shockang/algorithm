package com.shockang.study.algorithm.scala.archive.sort.merge

import com.shockang.study.algorithm.scala.archive.sort.Sorter

/**
 * 归并排序
 *
 * @author Shockang
 */
class MergeSorter extends Sorter {
  override def sort(a: Array[Int]): Unit = {
    if (a == null || a.length < 2) return
    mergeSort(a, 0, a.length - 1)
  }

  /**
   * 归并排序
   *
   * @param a    待排序数组
   * @param low  左边界
   * @param high 右边界
   */
  def mergeSort(a: Array[Int], low: Int, high: Int): Unit = {
    if (low < high) {
      // 取中间元素的下标
      val mid = low + ((high - low) >> 1)
      mergeSort(a, low, mid)
      mergeSort(a, mid + 1, high)
      merge(a, low, mid, high)
    }
  }

  /**
   * 合并
   *
   * @param a    待排序数组
   * @param low  左边界
   * @param mid  中间元素的下标
   * @param high 右边界
   */
  def merge(a: Array[Int], low: Int, mid: Int, high: Int) = {
    // a 中 low ~ mid 的元素挪到一个新数组中，新数组最后一个元素放置一个哨兵
    val a1 = new Array[Int](mid - low + 2)
    for (i <- 0 to a1.length - 2) {
      a1(i) = a(low + i)
    }
    a1(a1.length - 1) = Int.MaxValue
    // a 中 mid+1 ~ high 的元素挪到一个新数组中，新数组最后一个元素放置一个哨兵
    val a2 = new Array[Int](high - mid + 1)
    for (i <- 0 to a2.length - 2) {
      a2(i) = a(mid + 1 + i)
    }
    a2(a2.length - 1) = Int.MaxValue
    // 两个新数组的元素比较并放入原数组，因为哨兵的存在，减少了比较
    var i, j = 0
    for (k <- low to high) {
      if (a1(i) <= a2(j)) {
        a(k) = a1(i)
        i += 1
      } else {
        a(k) = a2(j)
        j += 1
      }
    }
  }
}
