# 学习总结 428 Week_01

## 数组
Array | -
-------- | ---
Java,C++ | int a[100]
Python | list = []
JavaScript | let x = [1,2,3]


### 时间复杂度
方法 | 复杂度
-------- | ---
prepend	| O(n)
append | O(1)
lookup | O(1)
insert | O(n)
delete | O(n)

## 链表
``` cpp
class LinkedList {
	Node head; //head of list
	/* Linked list Node*/
	class Node {
		int data;
		Node next;
		Node (int d) { data = d;}
	}
}
```
### 时间复杂度
方法 | 复杂度
-------- | ---
prepend | O(1)
append | O(1)
lookup | O(n)
insert | O(1)
delete | O(1)

### 扩展

- 跳表

	- 时间复杂度

      跳表查询的时间复杂度分析：

	        n/2、n/4、n/8、第k级索引结点的个数就是n/(2^k)
            假设索引有h级，最高级的索引有2个结点。
            n/(2^h) = 2，从而求得 h = log2(n) - 1
	  
	  时间复杂度 O(logn)

	- 优化

	  升维 ：空间换时间

	- 应用

	  LRU Cache - Linked list: LRU 缓存机制
	  Redis - Skip LIst

## 栈
1.Stack：先入后出；添加、删除皆为O(1)

2.查询为 O(n)

### 时间复杂度
方法 | 复杂度
-------- | ---
Access | O(n)
Search | O(n)
Insertion | O(1)
Deletion | O(1)

## 队列
1.Queue：先入先出；添加、删除皆为O(1)

2.查询为 O(n)

### 时间复杂度
方法 | 复杂度
-------- | ---
Access | O(n)
Search | O(n)
Insertion | O(1)
Deletion | O(1)

### 扩展

- 双端队列

  - 简单理解：两端可以进出的
  - 插入和删除都是O(1)操作
  - QueueDeque - double ended queue

- 优先队列

  - 插入操作：O(1)
  - 取出操作：O(logN) - 按照元素的优先级取出
  - 底层具体实现的数据结构较为多样和复杂：heap、bst(二叉搜索树etc)、treap

*XMind: ZEN - Trial Version*