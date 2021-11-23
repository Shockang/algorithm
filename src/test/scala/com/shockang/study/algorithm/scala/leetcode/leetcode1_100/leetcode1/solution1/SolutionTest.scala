package com.shockang.study.algorithm.scala.leetcode.leetcode1_100.leetcode1.solution1

import com.shockang.study.algorithm.scala.leetcode.util.ArrayUtil._
import org.junit.jupiter.api.Test

class SolutionTest {

  @Test def test1(): Unit = {
    test("[2,7,11,15]", 9, "[0,1]")
  }

  @Test def test2(): Unit = {
    test("[3,2,4]", 6, "[1,2]")
  }

  @Test def test3(): Unit = {
    test("[3,3]", 6, "[0,1]")
  }

  private def test(nums: String, target: Int, resStr: String): Unit = {
    // 隐式转换
    val res = Solution.twoSum(nums, target)
    val r: String = res.sorted
    assert(resStr == r)
  }
}
