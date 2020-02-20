# 【428-week 01】学习总结

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

### 成员函数

- 元素访问
	- at&emsp;访问指定元素，同时进行越界检查
	- operator[]&emsp;访问指定的元素
	- front&emsp;访问第一个元素
	- back&emsp;访问最后一个元素
	- data&emsp;返回指向内存中数组第一个元素的指针
- 迭代器
	- begin&emsp;返回容器第一个元素的迭代器
	- end&emsp;返回指向容器尾端的迭代器
	- rbegin&emsp;返回指向容器最后元素的逆向迭代器
	- rend&emsp;返回指向前端的逆向迭代器
- 容量
	- empty&emsp;检查容器是否为空
	- size&emsp;返回容纳元素数
	- max_size&emsp;返回可容纳的最大元素数
- 操作
	- fill&emsp;以指定值填充容器
	- swap&emsp;交换内容
  
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

### 成员函数

- 元素访问
	- front&emsp;访问第一个元素
	- back&emsp;访问最后一个元素
- 迭代器
	- begin&emsp;返回指向容器第一元素的迭代器
	- end&emsp;返回指向容器尾端的迭代器
	- rbegin&emsp;返回指向容器尾端的迭代器
	- rend&emsp;返回指向前端的逆向迭代器
- 容量
	- empty&emsp;检查容器是否为空
	- size&emsp;返回容纳的元素数
	- max_size&emsp;返回可容纳的最大元素数
- 修改器
	- clear&emsp;清除内容
	- insert&emsp;插入元素
	- emplace&emsp;原位构造元素
	- erase&emsp;擦除元素
	- push_back&emsp;将元素添加到容器末尾
	- emplace_back&emsp;在容器末尾就地构造元素
	- pop_back&emsp;移除末元素
	- push_front&emsp;插入元素到容器起始
	- emplace_front&emsp;在容器头部就地构造元素
	- pop_front&emsp;移除首元素
	- resize&emsp;改变容器中可存储元素的个数
	- swap&emsp;交换内容
- 操作
	- merge&emsp;合并二个已经排序列表
	- splice&emsp;从另一个list中移动元素
	- remove/remove_if&emsp;移除满足特定标准的元素
	- reverse&emsp;将该链表的所有元素的顺序反转
	- unique&emsp;删除连续的重复元素
	- sort&emsp;对元素进行排序

### 扩展

- 跳表

	- 时间复杂度
      - 跳表查询的时间复杂度分析：

	        n/2、n/4、n/8、第k级索引结点的个数就是n/(2^k) 假设索引有h级，最高级的索引有2个结点。
            n/(2^h) = 2，从而求得 h = log2(n) - 1
	  
	  - 时间复杂度 O(logn)

	- 优化
	  - 升维 ：空间换时间
	- 应用
	  - LRU Cache - Linked list: LRU 缓存机制
	  - Redis - Skip LIst

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
### 成员函数

- 元素访问
	- top&emsp;访问栈顶元素
- 容量
	- empty&emsp;检查底层的容器是否为空
	- size&emsp;返回容纳的元素数
- 修改器
	- push&emsp;向栈顶插入元素
	- emplace&emsp;于顶原位构造元素
	- pop&emsp;删除栈顶元素
	- swap&emsp;交换内容

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

### 成员函数

- 元素访问
	- front&emsp;访问第一个元素
	- back&emsp;访问最后一个元素
- 容量
	- empty&emsp;检查底层的容器是否为空
	- size&emsp;返回容纳的元素数
- 修改器
	- push&emsp;像队列尾部插入元素
	- emplace&emsp;于尾部原位构造元素
	- pop&emsp;删除栈顶元素
	- swap&emsp;交换内容

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
