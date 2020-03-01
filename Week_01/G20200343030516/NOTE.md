学习笔记


## 学习内容
按照超哥的教学分类，本周的内容属于 一维数据结构。具体包含以下内容：

## 数组
+ 查找 O（1） 复杂度，尾插入 O（1）删除数据 O(n)； 根据index 查找 O(1) ;根据值查找平均 O(n)复杂度。
+ 数据结构连续，对内存容量有要求

## 链表
+ 查找 O（n） 复杂度，尾插入 O（1）,删除数据 O(n)； 根据index 查找 O(n) ;根据值查找平均 O(n)复杂度。
+ 数据结构对地址无连续要求，对内存容量友好
## 栈
特性：
FILO
复杂度分析（动态数组实现）：
+ void push(E): O(1) 均摊
+ E pop(): O(1) 均摊
+ E peek(): O(1)
+ int getSize(): O(1)
+ boolean isEmpty(): O(1）
## 队列
特性：
FIFO
+ void enqueue(E): O(1) 均摊
+ E dequeue(): O(n)
+ E front(): O(1)
+ int getSize(): O(1)
+ boolean isEmpty(): O(1)

## 优先队列

时间复杂度：

| 入队        | 出队      |  （拿出最大元素） |
| --------    | -----:    | :----:          |
| 普通线性结构 | O(1)      |   O(n)          |
| 顺序线性结构 | O(n)      |   O(1)         |
|堆           | O(logn)   | O(logn)        |



### 重点
各类数据的时间复杂度。
需要掌握：数组 双指针，链表，栈，双链表，跳表的数据结构以及工程应用


### 阅读 Cpython source code
https://github.com/python/cpython/blob/3.8/Lib/queue.py

### Array 实战题目
 + https://leetcode-cn.com/problems/container-with-most-water/
+ https://leetcode-cn.com/problems/move-zeroes/
+ https://leetcode.com/problems/climbing-stairs/
+ https://leetcode-cn.com/problems/3sum/ (高频老题）
### Linked List 实战题目
+ https://leetcode.com/problems/reverse-linked-list/
+ https://leetcode.com/problems/swap-nodes-in-pairs
+ https://leetcode.com/problems/linked-list-cycle
+ https://leetcode.com/problems/linked-list-cycle-ii
+ https://leetcode.com/problems/reverse-nodes-in-k-group/
### 课后作业
+ https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
+ https://leetcode-cn.com/problems/rotate-array/
+ https://leetcode-cn.com/problems/merge-two-sorted-lists/
+ https://leetcode-cn.com/problems/merge-sorted-array/
+ https://leetcode-cn.com/problems/two-sum/
+ https://leetcode-cn.com/problems/move-zeroes/
+ https://leetcode-cn.com/problems/plus-one/



### 递归问题
要点： 
+ 递归算法必须具备基本结束条件
+ 递归算法要减小规模，改变状态，向基本的结束条件进行演进
+ 递归算法必须要调用自己



