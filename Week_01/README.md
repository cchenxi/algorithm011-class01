# 第一周homework

## 1. 学习总结

本周的课程主要学习了数组，链表，栈，队列等数据结构，学习了这些数据结构的特性、常见操作的复杂度、以及一些常见的算法应用。

### 数组

数组在内存中是连续的。

数组常见操作的时间复杂度：

随机访问：O(1)

增加元素：O(n)

删除元素：O(n)

### 链表

链表在内存空间上就可以不是连续的。

单链表的节点中除了一个属性（value）存储值之外，还有一个属性（next）存储下一个节点的地址。

如果是双向链表的话，除了单链表中包含的属性之外，还会增加一个属性（previous）存储上一个节点的地址。

链表常见操作的复杂度：

随机访问：O(n)

增加元素：O(1)

删除元素：O(1)

### 栈

栈的特点是元素的先进后出（FILO）

常见操作的时间复杂度：

添加元素：O(1)

删除元素：O(1)

栈在Java中的实现为`java.util.Stack`，但是在工程中并不建议使用，建议使用双端队列`java.util.Deque`代替。

### 队列

队列的特点是元素的先进先出（FIFO）

常见操作的时间复杂度：

添加元素：O(1)

删除元素：O(1)

队列在Java中的实现为接口`java.util.Queue`，具体实现包括常见的`java.util.LinkedList`、`java.util.concurrent.ArrayBlockingQueue`等。


## 2. 第4课 课后作业

### 2.1 使用新的api改写Deque demo代码

```java
package com.cchenxi.w1.homework;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 使用Deque Api改写demo代码
 * Date: 2020-06-27
 *
 * @author chenxi
 */
public class DequeDemo {
    public void useOldApi() {
        Deque<String> deque = new LinkedList<>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }

    public void useNewApi() {
        Deque<String> deque = new LinkedList<>();

        //代替push
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }

    public static void main(String[] args) {
        DequeDemo dequeDemo = new DequeDemo();
        dequeDemo.useOldApi();
        dequeDemo.useNewApi();
    }
}
```

### 2.2 分析Queue和Priority Queue源代码

> java 源代码版本: 1.8.0_172

#### Queue

java.util.Queue` 是一种线性表，允许在尾部（tail）进行插入操作，在头部（head）进行删除操作。它的特性是元素的先进先出（FIFO）。

复杂度分析：

查询：O(n)

插入、删除：O(1)

`java.util.Queue`是一个接口，提供了下列方法

1. 队列插入操作 add(e)与offer(e)
2. 队列删除操作 remove()与poll()
3. 队列检查操作 element()与peek()

####Priority Queue

常量

`private static final int DEFAULT_INITIAL_CAPACITY = 11;` 队列初始容量。

属性：

1. `transient Object[] queue;` 用于存储队列中的数据，Priority Queue的底层数据结构为数组。
2. `private int size = 0;`用于记录队列中元素的个数。
3. `private final Comparator<? super E> comparator;`比较器，可以在构造队列时指定。
4. `transient int modCount = 0;`记录队列结构变动的次数。

构造函数：

```java
//类型一，默认或直接指定initialCapacity和comparator
public PriorityQueue() {
  this(DEFAULT_INITIAL_CAPACITY, null);
}

public PriorityQueue(int initialCapacity) {
  this(initialCapacity, null);
}

public PriorityQueue(Comparator<? super E> comparator) {
  this(DEFAULT_INITIAL_CAPACITY, comparator);
}

public PriorityQueue(int initialCapacity,
                     Comparator<? super E> comparator) {
  // Note: This restriction of at least one is not actually needed,
  // but continues for 1.5 compatibility
  if (initialCapacity < 1)
    throw new IllegalArgumentException();
  this.queue = new Object[initialCapacity];
  this.comparator = comparator;
}


//类型二，从集合或者优先队列中构造
@SuppressWarnings("unchecked")
public PriorityQueue(Collection<? extends E> c) {
  if (c instanceof SortedSet<?>) {
    SortedSet<? extends E> ss = (SortedSet<? extends E>) c;
    this.comparator = (Comparator<? super E>) ss.comparator();
    initElementsFromCollection(ss);
  }
  else if (c instanceof PriorityQueue<?>) {
    PriorityQueue<? extends E> pq = (PriorityQueue<? extends E>) c;
    this.comparator = (Comparator<? super E>) pq.comparator();
    initFromPriorityQueue(pq);
  }
  else {
    this.comparator = null;
    initFromCollection(c);
  }
}

@SuppressWarnings("unchecked")
public PriorityQueue(PriorityQueue<? extends E> c) {
  this.comparator = (Comparator<? super E>) c.comparator();
  initFromPriorityQueue(c);
}

@SuppressWarnings("unchecked")
public PriorityQueue(SortedSet<? extends E> c) {
  this.comparator = (Comparator<? super E>) c.comparator();
  initElementsFromCollection(c);
}
```



操作：

1. 入队 offer(e)

   ```java
   public boolean offer(E e) {
     //不支持null
     if (e == null)
       throw new NullPointerException();
     modCount++;
     int i = size;
     //扩容
     if (i >= queue.length)
       grow(i + 1);
     size = i + 1;
     if (i == 0)
       queue[0] = e;
     else
       siftUp(i, e);
     return true;
   }
   ```

   

2. 出队 poll

   ```java
   public E poll() {
     if (size == 0)
       return null;
     int s = --size;
     modCount++;
     E result = (E) queue[0];
     E x = (E) queue[s];
     queue[s] = null;
     if (s != 0)
       siftDown(0, x);
     return result;
   }
   ```

   