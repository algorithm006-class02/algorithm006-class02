**字符串算法**
- [#387. First Unique Character in a String](./Leetcode-387-380.js)
- [#541. Reverse String II](./Leetcode-541-380.js)
- [#151. Reverse Words in a String](./Leetcode-151-380.js)
- [#557. Reverse Words in a String III](./Leetcode-557-380.js)
- [#917. Reverse Only Letters](./Leetcode-917-380.js)
- [#205. Isomorphic Strings](./Leetcode-205-380.js)
- [#680. Valid Palindrome II](./Leetcode-680-380.js)
- [#8. String to Integer (atoi)](./Leetcode-8-380.js)

**高级动态规划**
- [#300. Longest Increasing Subsequence](./Leetcode-300-380.js)
- [#91. Decode Ways](./Leetcode-91-380.js)


#### 高级动态规划

**不同路径2的状态转移方程**
```javascript
if (dp[i][j] is obstacle) dp[i][j] = 0
else dp[i][j] = dp[i][j-1] + dp[i-1][j]
```

**知识回顾**

- 动态规划、递归、分治 没有根本上的区别（关键看有无最优子结构）
- 拥有共性：找到重复子问题

**典型动态规划题目**

- 爬楼梯问题
```javascript
  // 就是斐波那契数列
  // 暴力解法，直接递归 O(2^n)
  const fn = (n) => {
    if (n <= 1) return 1
    return f(n-1) + f(n-2)
  }
  // 优化1: 递归 + 记忆化搜索  O(n)
  const fn = (n) => {
    if (n <= 1) return 1
    if (!mem.has(n)) mem.set(n, f(n-1) + f(n-2))
    return mem.get(n)
  }
  // 优化2: 将递归转换为顺推的形式，通过状态转移方程来求解 O(n)
  const fn = (n) => {
    for (let i = 2; i < n + 1; i++) {
      dp[i] = dp[i-1] + dp[i-2]
    }
    return dp[n]
  }
  // 优化3: 进行空间复杂度优化，去掉dp数组，使用两个变量来处理 O(n) O(1)
  const fn = (n) => {
    for (let i = 1; i < n; i++) {
      curr, prev = prev + curr, curr
    }
  }
```
- 路径问题
```javascript
  dp[i][j] = dp[i-1][j] + dp[j][i-1]
```
- 打家劫舍问题
```javascript
// 第一种状态方程的定义 dp[i] 表示打劫第0-i个房子的总收益是多少
dp[i] = max(dp[i-2] + nums[i], dp[i-1])

//第二种状态方程的定义
// 二维DP  
// dp[i][0] 表示 打劫第0-i个房子且第i个房子没偷时的收益
// dp[i][1] 表示 打劫第0-i个房子且第i个房子偷了时的收益
dp[i][0] = max(dp[i-1][0], dp[i-1][1])
dp[i][1] = dp[i-1][0] + nums[i]
```
- 最小路径和
```javascript
  dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + A[i][j]
```
- 股票买卖
```javascript
// i 为天数；k 为最多交易次数；[0,1] 为是否持有股票
// 初始状态
dp[-1][k][0] = dp[i][0][0] = 0
dp[-1][k][1] = dp[i][0][1] = -infinity
// 状态转移方程
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
```

**高阶DP解读**

- 状态拥有更多维度（二维、三维、或者更多、甚至需要压缩）
- 能通过面试题定义出维度，对逻辑思维能力要求高
- 状态方程更加复杂
- 本质：内功、逻辑思维、数学
- 训练：多练多思考

#### 字符串算法

- Javascript, Java, C#, Python, Go 中，string 是 immutable 不可变的
- Ruby, PHP 中，string 是 mutable 可变的
- Swift 中，string 是 mutable 可变的，但可以使用 let 来让它变成 immutable

**字符串匹配算法**

- Rabin-Karp 算法
    - 假设子串的长度为M（pat），目标字符串的长度为 N （txt）
    - 计算子串的 hash 值 hash_pat
    - 计算目标字符串 txt 中每个长度为 M 的子串的 hash 值（共需要计算 N-M+1 次）
    - 比较 hash 值：如果 hash 值不同，字符串必然不匹配；如果 hash 值相同，还需要使用朴素算法再次确认一下
- KMP 算法
    - 写出 pat 子串的所有前缀字符串(prefixStr)，不包含自身
    - 计算出每个前缀字符串(prefixStr)的最长公共前后缀字符数是多少（数字）
    - 将上面的数字组合成 prefixTable，并设置 prefixTable[0] = -1