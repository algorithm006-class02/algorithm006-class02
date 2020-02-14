学习笔记

# 使用新的 API 改写 Deque 示例代码

P.S. 基于 [jdk 13](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/Deque.html)

```java
Deque<String> deque = new LinkedList<String>();
deque.offerFirst("a");
deque.offerFirst("b");
deque.offerFirst("c");
System.out.println(deque);
String str = deque.peekFirst();
System.out.println(str);
System.out.println(deque);
while (deque.size() > 0) {
    System.out.println(deque.pollLast());
}
System.out.println(deque);
```

# Java Queue 及 Priority Queue 源码浅析

记录在[个人博客](https://cosmosning.github.io/2020/02/14/Queue及PriorityQueue源码浅析-Java/)中，随时更新。