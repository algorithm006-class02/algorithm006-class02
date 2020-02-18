# 学习笔记 

- 单调队列：在队列的基本操作上加以限制条件，使得队列始终保持单调递增或者递减。

- key code-snippet
```js
  // 单调递增
  // while (dequeue.length && dequeue[dequeue.length - 1] > n) {
  //   dequeue.pop()
  // }
  // 单调递减
  while (dequeue.length && dequeue[dequeue.length - 1] < n) {
    dequeue.pop()
  }
  dequeue.push(n)
```

- 应用(持续更新中。。。)

[sliding-window-maximum](https://leetcode-cn.com/problems/sliding-window-maximum/)