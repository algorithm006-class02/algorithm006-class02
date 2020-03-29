学习笔记

位运算

- 位运算符
  - 左移 <<
  - 右移 >>
  - 按位或 |
  - 按位与 &
  - 按位取反 ~
  - 按位异或 ^ （相同为零不同为一）
- 常用技巧
  - 异或
    - x ^ 0 = x
    - x ^ 1s = ~x // 注意 1s = ~0
    - x ^ (~x) = 1s
    - x ^ x = 0
    - c = a ^ b => a ^ c = b, b ^ c = a // 交换两个数
    - a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c // associative
  - 将 x 最右边的 n 位清零：x & (~0 << n)
  - 将 x 最右边的 n 位清零：x & (~0 << n)
  - 将 x 最右边的 n 位清零：x & (~0 << n)
  - 仅将第 n 位置为 1：x | (1 << n)
  - 仅将第 n 位置为 0：x & (~ (1 << n))
  - 仅将第 n 位置为 0：x & (~ (1 << n))
  - 将第 n 位至第 0 位（含）清零：x & (~ ((1 << (n + 1)) - 1))
  - 判断奇偶：
    - x % 2 == 1 —> (x & 1) == 1
    - x % 2 == 0 —> (x & 1) == 0
  - x >> 1 —> x / 2
  - X = X & (X-1) 清零最低位的 1
  - X & -X => 得到最低位的 1
  - X & ~X => 0

布隆过滤器

- 一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于**检索一个元素是否在一个集合**中。
- 特性
  - 如果布隆过滤器**判定不存在**，那么**一定不存在**
  - 如果布隆过滤器**判定存在**，那么可能**不存在**
- 优点
  - 空间效率和查询时间都远远超过一般的算法
- 缺点
  - 有一定的误识别率和删除困难
- 应用
  - 比特币网络
  - 分布式系统（Map-Reduce） — Hadoop、search engine
  - Redis 缓存
  - 垃圾邮件、评论等的过滤
  - https://www.cnblogs.com/cpselvis/p/6265825.html
  - https://blog.csdn.net/tianyaleixiaowu/article/details/74721877
- 实现
  - https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java
  - https://github.com/Baqend/Orestes-Bloomfilter

LRU Cache

- 操作及时间复杂度
  - 查询
    - O(1)
  - 修改
    - O(1)
- 缓存替换算法总览
  - https://en.wikipedia.org/wiki/Cache_replacement_policies

排序

- 比较类排序
  - 交换排序
    - 冒泡排序
    - 快速排序
  - 插入排序
    - 简单插入排序
    - 希尔排序
  - 选择排序
    - 简单选择排序
    - 堆排序
  - 归并排序
    - 二路归并排序
    - 多路归并排序
- 非比较类排序
  - 计数排序
  - 桶排序
  - 基数排序