### 学习笔记
1. 分治、回溯
  - 分治思想：分而治之，本质上是递归，但最后要将子问题结果合并
  - 典型案例：Fibonacci数列，阶乘，二分法搜索、MapReduce
  - 回溯思想：试错，不满足回退
  - 典型案例：正则表达式、八皇后问题
  
  [分治代码模板](https://shimo.im/docs/3xvghYh3JJPKwdvt/read) 


2. 深度、广度优先搜索：
  - DFS可以用递归或者栈的方式实现，BFS一般用队列来实现
  - 对于遍历过的节点，应该将它标记，防止重复遍历
  
  [DFS代码模板](https://shimo.im/docs/ddgwCccJQKxkrcTq/read)

  [BFS代码模板](https://shimo.im/docs/P8TqKHGKt3ytkYYd/read)

3. 贪心算法：
  - 应用场景：问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解
  - 与回溯、动态规划对比：
    + 贪心：当下做局部最优判断
    + 回溯：能够回退
    + 动态规划：最优判断+回退

4. 二分查找：
  - 基于有序、可通过索引直接访问的数据，可以利用二分法加快搜索速度
  
  [二分查找代码模板](https://shimo.im/docs/hjQqRQkGgwd9g36J/read)

