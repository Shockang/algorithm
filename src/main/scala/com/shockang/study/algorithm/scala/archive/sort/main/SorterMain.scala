package com.shockang.study.algorithm.scala.archive.sort.main

import com.shockang.study.algorithm.scala.archive.sort.Sorter
import com.shockang.study.algorithm.scala.archive.sort.bubble.BubbleSorter
import com.shockang.study.algorithm.scala.archive.sort.heap.HeapSorter
import com.shockang.study.algorithm.scala.archive.sort.insert.InsertSorter
import com.shockang.study.algorithm.scala.archive.sort.merge.{MergeSorter, MergeSorter2, MergeSorter3}
import com.shockang.study.algorithm.scala.archive.sort.quick.QuickSorter
import com.shockang.study.algorithm.scala.archive.sort.select.SelectSorter
import com.shockang.study.algorithm.scala.util.StringUtil.format

import scala.util.Random

object SorterMain extends App {
  assertSorter(new BubbleSorter)
  assertSorter(new InsertSorter)
  assertSorter(new SelectSorter)
  assertSorter(new MergeSorter)
  assertSorter(new MergeSorter2)
  assertSorter(new MergeSorter3)
  assertSorter(new QuickSorter)
  assertSorter(new HeapSorter)

  private def assertSorter(sorter: Sorter): Unit = {
    println(format(s"Start to assert:${sorter.getClass.getSimpleName}"))
    assertNull(sorter)
    for (_ <- Range(0, 100)) assertArray(sorter, generateRandomArray())
    println(format(s"Succeed to assert:${sorter.getClass.getSimpleName}"))
  }

  private def generateRandomArray(): Array[Int] = {
    val n = Random.nextInt(10000)
    val a = new Array[Int](n)
    for (i <- a.indices) {
      a(i) = Random.nextInt(10000)
    }
    a
  }

  private def assertNull(sorter: Sorter): Unit = {
    assertArray(sorter, null)
    assertArray(sorter, new Array[Int](0))
  }

  private def assertArray(sorter: Sorter, a: Array[Int]): Unit = {
    if (a == null) return
    val original = a.clone()
    sorter.sort(a)
    assert(checkArray(original, a))
  }

  private def checkArray(original: Array[Int], sorted: Array[Int]): Boolean = {
    sorted.mkString(",").equals(original.sorted.mkString(","))
  }

}
