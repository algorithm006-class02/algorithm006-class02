学习笔记

首先，用java12版本下 add first 或 add last API 改写 Deque 的代码：
```bash
Deque deque = new LinkedList();
try{
deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);
} catch(Exception e){
System.out.println(e);
}
String str = deque.peekFirst();
System.out.println(str);
System.out.println(deque);
while (deque.size() > 0) {
System.out.println(deque.pollFirst());
}
System.out.println(deque);
```


其次，总结下第一周学习内容：

“五毒神掌” -> 五遍刷题法；此方法虽然耗时，若坚持下来，收货颇多；同一道题，不同的解法，加上使用不同语言实现，确实能学到很多东西；

数据结构：
```json
数组：查询时间复杂度O(1), Insert、delete: 时间复杂度O(n)
链表List：单链表、双链表、跳表
单链表：查询O(n), Insert、delete：O(1)
双链表：查询O(n), Insert、delete：O(1)
跳表：查询O(logn), Insert、delete：O(n)
栈Stack: FILO
Priority Queue：具体实现有heap、bst等，Insert：O(1), 查询：O(logn)
Deque： 同时具备栈和队列的特性，两端都可以push和pop，可以维护两个指针，一个front指向对头元素，另一个rear指针指向队尾下一个元素的位置；底层借助数组保存元素，所以查询时间复杂度O(n)。
总之，坚持刷题，多练习才能掌握。

```
