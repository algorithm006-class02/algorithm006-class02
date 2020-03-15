学习笔记

动态规划 (dynamic programming) 分治+最优子结构

关键点：
1.动态规划和递归或者分治没有根本上的区别 (关键看有无最优的子结构)、
2.共性，找到重复子问题
3.差异性：最优子结构，中途可以淘汰次优解

动态规划关键点
1.最优子结构opt[n]=best_of(opt[n-1],opt[n-2]...)
2.储存中间状态：opt[i]
3.递推公式（美其名曰：状态转移方程或者DP方程）
Fib:opt[i]=opt[i-1]+opt[i-2]
二维路径：opt[i,j]=opt[i+1,j]+opt[i,j+1] (且判断a[i,j]是否为空地)

MIT 5 easy step to DP
1,define subproblems
2,guess part of solution
3,relate subproblem solutions
4,recurse & memorize or bulid DP table bottom-up 构建DP表，自底向上
5,solve original problem


dp思想：
1.数组类题目可以使用自顶向下，也可以自底向上的思想编写。dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 变成 dp[i][j] = dp[i + 1][j] 
+ dp[i][j + 1]

2.二维dp记录的问题都可以用一维来解决，比如 dp[i][j] = dp[i - 1][j] + dp[i][j - 1] ，按照公式来看，每一次计算只需要上面和左边的
信息，所以只需要记录两个信息就可以计算出当前的需要的正确值，dp[j] = dp[j - 1] + dp[j]，有时候要从历史值中比较出大小，加上自己本
身成为最终的结果。

3.当题目遇到一维的dp不能记录全部信息的时候可以升维来记录信息。
比如股票问题：
设 i 存储的是交易时间，也就是数组的下标。
设 k 是可以交易多少次。
设 j 是否持有股票。
dp[i][k][j]


