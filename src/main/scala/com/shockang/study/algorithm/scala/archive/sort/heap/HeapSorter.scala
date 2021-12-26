package com.shockang.study.algorithm.scala.archive.sort.heap

import com.shockang.study.algorithm.scala.archive.sort.Sorter

import scala.util.control.Breaks._

/**
 * 堆排序
 *
 * @author Shockang
 */
class HeapSorter extends Sorter {
  override def sort(a: Array[Int]): Unit = {
    if (a == null || a.length < 2) return
    //从第一个非叶子结点从下至上，从右至左调整结构
    for (i <- (a.length - 1) / 2 to 0 by -1) {
      adjustHeap(a, i, a.length)
    }
    //调整堆结构+交换堆顶元素与末尾元素
    for (i <- a.length - 1 until 0 by -1) {
      //将堆顶元素与末尾元素进行交换
      swap(a, 0, i)
      //重新对堆进行调整
      adjustHeap(a, 0, i)
    }
  }

  /**
   * 调整堆
   *
   * @param a      待排序列
   * @param parent 父节点
   * @param length 待排序列尾元素索引
   */
  private def adjustHeap(a: Array[Int], parent: Int, length: Int): Unit = {
    //将temp作为父节点
    val temp = a(parent)
    //左孩子
    var lChild = 2 * parent + 1
    var p = parent
    breakable(while (lChild < length) {
      //右孩子
      val rChild = lChild + 1
      // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
      if (rChild < length && a(lChild) < a(rChild)) lChild += 1
      // 如果父结点的值已经大于孩子结点的值，则直接结束
      if (temp >= a(lChild)) break
      // 把孩子结点的值赋给父结点
      a(p) = a(lChild)
      //选取孩子结点的左孩子结点,继续向下筛选
      p = lChild
      lChild = 2 * lChild + 1
    })
    a(p) = temp
  }
}
