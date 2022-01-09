package com.shockang.study.algorithm.scala.archive.binarysearch.main

import com.shockang.study.algorithm.scala.archive.binarysearch.BinarySearch
import com.shockang.study.algorithm.scala.archive.binarysearch.simple.SimpleBSearch
import com.shockang.study.algorithm.scala.archive.sort.main.SorterMain.generateRandomArray
import com.shockang.study.algorithm.scala.archive.sort.quick.QuickSorter
import com.shockang.study.algorithm.scala.util.StringUtil.format

import scala.util.Random

object BinarySearchMain extends App {

  assertBinarySearch(new SimpleBSearch)

  def assertBinarySearch(search: BinarySearch) {
    // scalastyle:off println
    println(format(s"start to assert:${search.getClass.getSimpleName}"))
    assertNull(search)
    for (_ <- Range(0, 100)) {
      val a = generateRandomSortedArray()
      val (elem, index) = getRandomElementAndIndex(a)
      assert(a(search.search(a, elem)) == a(index))
    }
    println(format(s"succeed to assert:${search.getClass.getSimpleName}"))
    // scalastyle:on println
  }

  def assertNull(search: BinarySearch): Unit = {
    assert(search.search(null, 0) == -1)
    assert(search.search(new Array[Int](0), 0) == -1)
  }

  def generateRandomSortedArray(): Array[Int] = {
    val a = generateRandomArray()
    new QuickSorter().sort(a)
    a
  }

  def getRandomElementAndIndex(a: Array[Int]): (Int, Int) = {
    val index = Random.nextInt(a.length)
    (a(index), index)
  }
}
