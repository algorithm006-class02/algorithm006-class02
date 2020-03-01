## 课后作业
#### 简单：
- [#26 remove-duplicates-from-sorted-array](./Leetcode-26-380.js)
- [#189 rotate-array](./Leetcode-189-380.js)
- [#21 merge-two-sorted-lists](./Leetcode-21-380.js)
- [#88 merge-sorted-array](./Leetcode-88-380.js)
- [#1 two-sum](./Leetcode-1-380.js)
- [#283 move-zeroes](./Leetcode-283-380.js)
- [#66 plus-one](./Leetcode-66-380.js)
- [用 add first 或 add last 这套新的 API 改写 Deque 的代码](./DequeDemo.java)
- 分析 Queue 和 Priority Queue 的源码
#### 中等：
- https://leetcode.com/problems/design-circular-deque
#### 困难：
- https://leetcode.com/problems/trapping-rain-water/

### 数组实战题目

- [container-with-most-water/](https://leetcode-cn.com/problems/container-with-most-water/)
- [move-zeroes/](https://leetcode-cn.com/problems/move-zeroes/)
- [climbing-stairs/](https://leetcode.com/problems/climbing-stairs/)
- [3sum/](https://leetcode-cn.com/problems/3sum/) (高频老题）

### 链表实战题目

- [reverse-linked-list/](https://leetcode.com/problems/reverse-linked-list/)
- [swap-nodes-in-pairs](https://leetcode.com/problems/swap-nodes-in-pairs)
- [linked-list-cycle](https://leetcode.com/problems/linked-list-cycle)
- [linked-list-cycle-ii](https://leetcode.com/problems/linked-list-cycle-ii)
- [reverse-nodes-in-k-group/](https://leetcode.com/problems/reverse-nodes-in-k-group/)

## 学习笔记

- Array 数组
  - 是一种线性表结构，它用一组连续的存储空间，来存储一组具有相同类型的数据
  - 线性表是指数据排列像一条线一样的数据结构，数组，链表，队列，栈，都是线性表结构
- LinkedList 链表
  - 是一种线性表结构，它通过指针将一组零散的内存块串联在一起，这些内存块中除了存储数据外，还会记录下一个内存块的地址
  - 链表是一种物理存储单元上非连续、非顺序的存储结构，数据元素的逻辑顺序是通过链表中的指针链接次序实现的
  - 链表存在多种形式
    - 单链表
      - 只有一个后继指针的链表
    - 双链表
      - 一个后继指针，一个前驱指针
      - 占用更多空间，插入和删除效率更高
      - 空间换时间的思想
      - 实际使用例子：Java 的 LinkedHashMap
    - 循环链表
      - 尾节点指针指向头节点的链表
      - 可以是单链表，也可以是双链表
      - 约瑟夫问题
    - 静态链表
      - 用二维数组描述的链表称为静态链表
- SkipList 跳表
  ![https://redisbook.readthedocs.io/en/latest/_images/skiplist.png](https://redisbook.readthedocs.io/en/latest/_images/skiplist.png)
  - 出现背景：为了弥补链表在查询中的缺陷而设计
  - 工程应用：Redis中应用广泛
  - 掌握范畴：以理解它的工作原理为主，一般不会在面试中出题
  - 设计思想：
    - 以空间换时间
    - 增加多级索引（指针）来达到跨越查询，以此来提高查询效率
    - 每个节点除了存储本身的 Next指针外，还需要存储多个跳级的指针，占用了更多的内存空间，提高了效率，此之谓空间换时间
  - 缺点：
    - 在工程中，一旦涉及到节点的增加和删除，索引就要重新更新，进而导致各个节点的跨级不一致，导致维护成本高，导致插入和删除操作的时间复杂度也会达到O(logn)而不是O(1)了
  - 复杂度分析：
    - 时间复杂度：O(logn)
    - 空间复杂度：O(n)
- Stack 栈
  - 是一种“操作受限”的线性表，只允许在一端插入和删除数据，先进后出
  - 栈既可以用数组来实现，也可以用链表来实现
  - 用数组实现的栈，叫做顺序栈
  - 用链表实现的栈，叫做链式栈
- Queue 队列
  - 是一种“操作受限”的线性表，只支持入队和出队操作，先进先出
  - 队列既可以用数组来实现，也可以用链表来实现
  - 用数组实现的队列，叫做顺序队列
  - 用链表实现的队列，叫做链式队列
  - Priority Queue 优先队列
    - 插入操作：O(1)
    - 取出操作：O(logn) -- 按照元素的优先级取出
    - 底层实现的数据结构较为复杂和多样：heap, BST, 红黑树, AVL, treap
- HashTable 散列表
  - 是数组的一种扩展，由数组演化而来
  - 用的是数组支持下标随机访问数据的特性

## 学习经验总结

总结一下我对覃超老师学习方法的理解

- 如何使用Leetcode进行算法学习
  - 不在于AC的题数量，而是针对每道题，要多练（五遍）
    - 第一遍：
      - 计时五分钟思考，写出自己能想到的可能的解法的伪代码，一般五分钟内能想到2-3个解法就是极好的
      - 如果完全没有思路，熬五分钟后直接去官网+中文网站看题解，选出3个题解，背下来
    - 第二遍：
      - 自己重新看这道题，从思路整理到代码AC，看自己是否能一遍过，如果不行，重复此操作
      - 考虑是否将此题加入到后续练习题目中
    - 第三遍：
      - 三天后，重新做自己记录的练习题目
    - 第四遍：
      - 一周后，重新做自己记录的练习题目
      - 考虑是否此题已完全掌握，移出练习题目
    - 第五遍：
      - 面试前, 重新做