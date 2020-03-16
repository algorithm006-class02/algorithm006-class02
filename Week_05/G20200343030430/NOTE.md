学习笔记

### 代码模板

- 递归模板

```java
public void recur(int level, int param) {

  // terminator
  if (level > MAX_LEVEL) {
    // process result
    return;
  }

  // process current logic
  process(level, param);

  // drill down
  recur( level: level + 1, newParam);

  // restore current status

}
```

- 分治模板

```python
def divide_conquer(problem, param1, param2, ...):
  # recursion terminator
  if problem is None:
	print_result
	return

  # prepare data
  data = prepare_data(problem)
  subproblems = split_problem(problem, data)

  # conquer subproblems
  subresult1 = self.divide_conquer(subproblems[0], p1, ...)
  subresult2 = self.divide_conquer(subproblems[1], p1, ...)
  subresult3 = self.divide_conquer(subproblems[2], p1, ...)
  …

  # process and generate the final result
  result = process_result(subresult1, subresult2, subresult3, …)

  # revert the current level states
```

### 本周作业
掌握度 | index | level | desc | url
---|---|---|---|---
-- | 64 | 中等 | 最小路径和 | [minimum-path-sum](https://leetcode-cn.com/problems/minimum-path-sum)
-- | 91 | 中等 | 解码方法 | [decode-ways](https://leetcode-cn.com/problems/decode-ways)
-- | 221 | 中等 | 最大正方形 | [maximal-square](https://leetcode-cn.com/problems/maximal-square)
-- | 621 | 中等 | 任务调度器 | [task-scheduler](https://leetcode-cn.com/problems/task-scheduler)
-- | 647 | 中等 | 回文子串 | [palindromic-substrings](https://leetcode-cn.com/problems/palindromic-substrings)
-- | 32 | 困难 | 最长有效括号 | [longest-valid-parentheses/](https://leetcode-cn.com/problems/longest-valid-parentheses/)
-- | 72 | 困难 | 编辑距离 | [edit-distance](https://leetcode-cn.com/problems/edit-distance)
-- | 363 | 困难 | 矩形区域不超过 K 的最大数值和 | [max-sum-of-rectangle-no-larger-than-k](https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k)
-- | 403 | 困难 | 青蛙过河 | [frog-jump](https://leetcode-cn.com/problems/frog-jump)
-- | 410 | 困难 | 分割数组的最大值 | [split-array-largest-sum](https://leetcode-cn.com/problems/split-array-largest-sum)
-- | 552 | 困难 | 学生出勤记录 II | [student-attendance-record-ii](https://leetcode-cn.com/problems/student-attendance-record-ii)
-- | 76 | 困难 | 最小覆盖子串 | [minimum-window-substring](https://leetcode-cn.com/problems/minimum-window-substring)
-- | 312 | 困难 | 戳气球 | [burst-balloons](https://leetcode-cn.com/problems/burst-balloons)

### 课后作业
章节 | 掌握度 | index | level | desc | url
---|---|---|---|---|---
12.4 | 一般 | 120 | 中等 | 三角形最小路径和 | [triangle](https://leetcode-cn.com/problems/triangle)
12.4 | 一般 | 322 518 | 中等 | 零钱兑换 | [coin-change](https://leetcode-cn.com/problems/coin-change)
12.4 | 一般 | 53 | 简单 | 最大子序和 | [maximum-subarray](https://leetcode-cn.com/problems/maximum-subarray)
12.4 | 一般 | 152 | 中等 | 乘积最大子序列 | [maximum-product-subarray](https://leetcode-cn.com/problems/maximum-product-subarray)
12.6 | -- | 121 122 123 188 309 714 | --| 买卖股票的最佳时机 x6| [best-time-to-buy-and-sell-stock](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3)
12.6 | 一般 | 198 213 | 简单 | 打家劫舍 | [house-robber](https://leetcode-cn.com/problems/house-robber)
12.6 | 一般 | 62 63 980 | 中等 | 不同路径 | [unique-paths](https://leetcode-cn.com/problems/unique-paths)
12.6 | -- | 279 | 困难 | 完全平方数 | [perfect-squares](https://leetcode-cn.com/problems/perfect-squares)

--：表示未做题目
