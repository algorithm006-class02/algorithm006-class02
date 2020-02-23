学习笔记
方法论： 
￥￥￥最大误区: 只刷一遍（刷五遍最少）：
　　　　　第一遍：　不会的话看答案背诵
　　　　　第二遍：　马上再做一遍
　　　　　第三遍：　２４小时后
　　　　　第四遍：　一周后
　　　　　第五遍：　考试前
￥￥￥两个核心思路：　１：维度变换（待理解）２：空间换时间　（平时经常用到）
￥￥根据不舒服的方面刻意练习才是最佳方法。

数据结构和算法：
**Java Priority queue:**
*PriorityQueue doesn’t permit null.
*We can’t create PriorityQueue of Objects that are non-comparable
*PriorityQueue use array to build it

boolean add(E element): This method inserts the specified element into this priority queue.
public remove(): This method removes a single instance of the specified element from this queue, if it is present
public poll(): This method retrieves and removes the head of this queue, or returns null if this queue is empty.
public peek(): This method retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
Iterator iterator(): Returns an iterator over the elements in this queue.
boolean contains(Object o): This method returns true if this queue contains the specified element
void clear(): This method is used to remove all of the contents of the priority queue.
boolean offer(E e): This method is used to insert a specific element into the priority queue.

*The head of this queue is the least element with respect to the specified ordering.
If you want to put max value order can do this:
PriorityQueue<Integer> pQueue =  new PriorityQueue<Integer>(Collections.reverseOrder()); 

private static final int DEFAULT_INITIAL_CAPACITY = 11;
    /**
     * Priority queue represented as a balanced binary heap: the two
     * children of queue[n] are queue[2*n+1] and queue[2*(n+1)].  The
     * priority queue is ordered by comparator, or by the elements'
     * natural ordering, if comparator is null: For each node n in the
     * heap and each descendant d of n, n <= d.  The element with the
     * lowest value is in queue[0], assuming the queue is nonempty.
     */
    transient Object[] queue; // understand why and when need transient



**stack and queue problems usually can resolve by two stacks or two queues.**
**The best way to learn linked list is practice**
**Array need to familiar with mutiple index move in different directions**


　　　　　