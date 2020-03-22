第二周学习笔记

HashMap
1、有四个构造方法：
HashMap()
HashMap(int initialCapacity)
HashMap(int initialCapacity，float loadFactor)
HashMap(Map<? extends K，? extends V> m)

2、线程不安全：
put的时候导致多线程数据不一致；
resize而引起死循环

3、HashMap与HashTable的区别
线程安全性、同步和异步。
HashMap线程不安全，hashtable线程安全


2、 HashMap是怎么解决哈希冲突的？
通过链表来解决hash碰撞问题：
 如果当前bucketIndex处的key和插入的key相同则直接覆盖oldValue；
 通过遍历链表来保存需要插入的值。

Linked List是特殊化的Tree；
Tree是特殊化的graph；

二叉树的遍历：前序【根-左-右】、中序【左-根-右】、后序【左-右-根】

树的面试题的解法一般都是递归为什么？
1、节点的定义
2、重复性（自相似性）

【它的节点和树本身，它数据结构的定义就是用递归的方式来进行的
第二不仅是树本身，二叉树以及搜索二叉树，它在定义它数据结构和算法特性的时候，也是又所谓的重复性】


栈：特点：后进先出？
pop：返回栈顶的元素，并且将该栈顶元素出栈。
push：插入stack的顶端【最后拼接】
peek： 返回栈顶的元素，但不弹出该栈顶元素。