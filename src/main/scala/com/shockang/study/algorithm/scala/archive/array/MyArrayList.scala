package com.shockang.study.algorithm.scala.archive.array


import java.util
import java.util._
import java.util.function.{Consumer, Predicate, UnaryOperator}

class MyArrayList[T: Manifest](initialCapacity: Int = 10) extends RandomAccess with Cloneable {

  //默认容量为 10
  private val DEFAULT_CAPACITY: Int = 10

  //空数组
  private val EMPTY_ELEMENTDATA: Array[T] = Array()

  private val DEFAULTCAPACITY_EMPTY_ELEMENTDATA: Array[T] = Array()

  //底层数组
  @transient private var elementData: Array[T] = new Array[T](initialCapacity)

  //list的大小
  var size: Int = 0

  val isEmpty: Boolean = size == 0

  //列表结构改变的次数，和快速失败的迭代器有关
  @transient protected var modCount: Int = 0;

  private val MAX_ARRAY_SIZE: Int = Int.MaxValue - 8

  //数组最大长度
  private var max: Int = initialCapacity

  //负载因子
  private val factor: Double = 0.75

  //空间不够时，使用这个方法来释放多余空间
  def trimToSize(): Unit = {
    modCount += 1
    if (size < elementData.length) elementData = if (size == 0) EMPTY_ELEMENTDATA
    else util.Arrays.copyOf(elementData, size)
  }

  //是否包含
  def contains(t: T): Unit = {
    indexOf(t) > 0
  }

  //索引，没有返回-1
  def indexOf(t: T): Int = {
    if (t == null) for (i <- 0 until size) {
      if (elementData(i) == null) return i
    }
    else for (i <- 0 until size) {
      if (t == elementData(i)) return i
    }
    -1
  }

  //反向索引，没有返回-1
  def lastIndexOf(t: T): Int = {
    if (t == null) for (i <- size - 1 to 0 by -1) {
      if (elementData(i) == null) return i
    }
    else for (i <- size - 1 to 0 by -1) {
      if (t == elementData(i)) return i
    }
    -1
  }

  //转化成数组
  def toArray: Array[AnyRef] = util.Arrays.copyOf(elementData, size)

  //转化成数组
  def toArray(a: Array[T]): Array[T] = {
    if (a.length < size) return util.Arrays.copyOf(elementData, size, a.getClass)
    System.arraycopy(elementData, 0, a, 0, size)
    if (a.length > size) a(size) = null.asInstanceOf[T]
    a
  }

  def get(index: Int): T = {
    rangeCheck(index)
    elementData(index)
  }

  def forEach(action: Consumer[_ >: T]): Unit = {
    Objects.requireNonNull(action)
    val expectedModCount = modCount
    @SuppressWarnings(Array("unchecked")) val elementData = this.elementData.asInstanceOf[Array[T]]
    val size = this.size
    var i = 0
    while ( {
      modCount == expectedModCount && i < size
    }) {
      action.accept(elementData(i))
      i += 1
    }
    if (modCount != expectedModCount) throw new ConcurrentModificationException
  }

  def removeIf(filter: Predicate[_ >: T]): Boolean = {
    Objects.requireNonNull(filter)
    // figure out which elements are to be removed
    // any exception thrown from the filter predicate at this stage
    // will leave the collection unmodified
    var removeCount = 0
    val size = this.size
    val removeSet = new util.BitSet(size)
    val expectedModCount = modCount
    var i = 0
    while ( {
      modCount == expectedModCount && i < size
    }) {
      val element = elementData(i)
      if (filter.test(element)) {
        removeSet.set(i)
        removeCount += 1
      }

      i += 1
    }
    if (modCount != expectedModCount) throw new ConcurrentModificationException
    val anyToRemove = removeCount > 0
    if (anyToRemove) {
      val newSize = size - removeCount
      var i = 0
      var j = 0
      while ( {
        (i < size) && (j < newSize)
      }) {
        i = removeSet.nextClearBit(i)
        elementData(j) = elementData(i)

        i += 1
        j += 1
      }
      for (k <- newSize until size) {
        elementData(k) = null.asInstanceOf[T]
      }
      this.size = newSize
      if (modCount != expectedModCount) throw new ConcurrentModificationException
      modCount += 1
    }
    anyToRemove
  }

  def replaceAll(operator: UnaryOperator[T]): Unit = {
    Objects.requireNonNull(operator)
    val expectedModCount = modCount
    val size = this.size
    var i = 0
    while ( {
      modCount == expectedModCount && i < size
    }) {
      elementData(i) = operator.apply(elementData(i))
      i += 1
    }
    if (modCount != expectedModCount) throw new ConcurrentModificationException
    modCount += 1
  }

  def sort(c: Comparator[_ >: T]): Unit = {
    val expectedModCount = modCount
    util.Arrays.sort(elementData, 0, size, c)
    if (modCount != expectedModCount) throw new ConcurrentModificationException
    modCount += 1
  }

  //克隆
  override def clone: Any = try {
    val v = super.clone.asInstanceOf[MyArrayList[T]]
    v.elementData = util.Arrays.copyOf(elementData, size)
    v.modCount = 0
    v
  } catch {
    case e: CloneNotSupportedException =>
      throw new InternalError(e)
  }

  //子列表越界检查
  private[util] def subListRangeCheck(fromIndex: Int, toIndex: Int, size: Int): Unit = {
    if (fromIndex < 0) throw new IndexOutOfBoundsException("fromIndex = " + fromIndex)
    if (toIndex > size) throw new IndexOutOfBoundsException("toIndex = " + toIndex)
    if (fromIndex > toIndex) throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")")
  }

  //判断索引是否越界
  private def rangeCheck(index: Int): Unit = {
    if (index >= size) throw new IndexOutOfBoundsException(outOfBoundsMsg(index))
  }

  private def outOfBoundsMsg(index: Int) = "Index: " + index + ", Size: " + size


  //判断是否需要扩容
  private def ensureCapacity(minCapacity: Int): Unit = {
    val minExpand = if (elementData ne DEFAULTCAPACITY_EMPTY_ELEMENTDATA) 0 else DEFAULT_CAPACITY
    if (minCapacity > minExpand) ensureExplicitCapacity(minCapacity)
  }

  private def ensureExplicitCapacity(minCapacity: Int): Unit = {
    modCount += 1
    if (minCapacity - elementData.length > 0) grow(minCapacity)
  }

  private def grow(minCapacity: Int): Unit = {
    val oldCapacity = elementData.length
    var newCapacity = oldCapacity + (oldCapacity >> 1)
    if (newCapacity - minCapacity < 0) newCapacity = minCapacity
    if (newCapacity - MAX_ARRAY_SIZE > 0) newCapacity = hugeCapacity(minCapacity)
    elementData = util.Arrays.copyOf(elementData, newCapacity)
  }

  private def hugeCapacity(minCapacity: Int) = {
    if (minCapacity < 0) { // overflow
      throw new OutOfMemoryError
    }
    if (minCapacity > MAX_ARRAY_SIZE) Integer.MAX_VALUE
    else MAX_ARRAY_SIZE
  }


  private def calculateCapacity(elementData: Array[T], minCapacity: Int): Int = {
    if (elementData eq DEFAULTCAPACITY_EMPTY_ELEMENTDATA) return Math.max(DEFAULT_CAPACITY, minCapacity)
    minCapacity
  }

  private def ensureCapacityInternal(minCapacity: Int): Unit = {
    ensureExplicitCapacity(calculateCapacity(elementData, minCapacity))
  }


  //链表末尾添加元素
  def add(t: T): Unit = {
    //检查并扩容
    check()
    elementData(size) = t
    size += 1
  }

  //下标 k 插入元素
  def insert(t: T, k: Int): Unit = {
    //检查并扩容
    check()
    //倒序遍历插入
    var index: Int = size
    while (index > k) {
      elementData(index) = elementData(index - 1)
      index -= 1
    }
    //第 k 项覆盖
    elementData(k) = t
    //大小增加
    size += 1
  }

  //删除下标为 k的元素
  def delete(k: Int): Unit = {
    //正序遍历删除
    var index: Int = k
    while (index < size - 1) {
      elementData(index) = elementData(index + 1)
      index += 1
    }
    size -= 1
  }

  //方便打印
  override def toString: String = {
    val sj: StringJoiner = new StringJoiner(",")
    for (i <- 0 until size) {
      sj.add(elementData(i).toString)
    }
    "[" + sj.toString + "]"
  }

  //检查
  private def check(): Unit = {
    if ((size + 1) > max * factor) {
      expand()
    }
  }

  //数组扩容
  private def expand(): Unit = {
    val temp = elementData
    max *= 2
    elementData = new Array[T](max)
    System.arraycopy(temp, 0, elementData, 0, size)
  }
}
