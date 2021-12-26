package com.shockang.study.algorithm.scala.leetcode.leetcode201_300.leetcode300.solution1

/**
 * 贪心 + 二分查找
 *
 * @author Shockang
 */
object Solution {
  def lengthOfLIS(nums: Array[Int]): Int = {
    if (nums.isEmpty) return 0
    val n = nums.length
    //d表示长度为 len 的最长上升子序列的末尾元素的最小值
    val d = new Array[Int](n + 1)
    //初始赋值
    d(1) = nums(0)
    //len 记录目前最长上升子序列的长度
    var len = 1
    for (i <- 1 until n) {
      //如果遍历的当前项比d(len)大，最长子序列长度加1
      if (nums(i) > d(len)) {
        //把当前项放入d数组，索引index加1
        len += 1
        d(len) = nums(i)
      }
      else {
        //在 d[1 ... len]中找满足 d[i−1]<nums[j]<d[i] 的下标 i，并更新 d[i] = nums[j]
        //这是个典型的二分查找问题，即查找第一个大于目标值的索引
        //第一个大于目标值的索引设置为nums(i)，这样此时nums(i) > d(len)，结合另一个分支判断就很好理解
        var l = 1
        var r = len
        while (l <= r) {
          val mid = l + ((r - l) >> 1)
          if (d(mid) < nums(i)) l = mid + 1
          else r = mid - 1
        }
        //此时 l为第一个大于nums(i)的索引，可以证明遍历到当前，长度为l时，最长子序列末尾元素最小值就是nums(i)
        d(l) = nums(i)
      }
    }
    len
  }
}
