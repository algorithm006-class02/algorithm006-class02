- 第一周学习心得
  主要学习了线性结构的相关算法，原来以为自己写一个链表很容易，但实践表明链表都写不对。。。日后需要对关键算法多加练习。
- 课中作业
  1. java中Queue源码分析。
  Queue作为一个接口主要定义了如下方法
  boolean add(E e); //队尾新增，抛异常
  boolean offer(E e)//队尾新增，返回特殊值
  E remove() //队头删除并返回，抛异常
  E poll()  //队头删除并返回，返回特殊值
  E element() //获取对头元素，抛异常
  E peek() //获取对头元素，返回特殊值
  
  2. java中PriorityQueue的源码分析
  PriorityQueue继承AbstractQueue 实现了Queue接口，主要作用是实现一个有优先级的队列
  
  数据存储在一个数组中
  transient Object[] queue; 
  每次poll的时候会调用 siftDownComparable() 或者siftDownUsingComparator() 对数组中的元素进行堆排序。
