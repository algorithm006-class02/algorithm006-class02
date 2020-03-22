学习笔记
动态规划 dynamic programming
simplifying a complicated problem by breaking it down into simpler subproblems
dynamic programming=Divide & Conquer + Optimal substructive 分治+最优子结构

动态规划和递归或分治没有根本上的区别（关键看有无最优子结构）
共性：找到重复子问题
差异性；最优子结构、中途可以淘汰次优解

状态转移方程（dynamic programming DP方程）
opt[i,j]=opt[i+1,j]+opt[i,j+1]
完整逻辑：
if a[i,j]='空地':
    opt[i,j]=opt[i+1,j]+opt[i,j+1]
else:
    opt[i,j]=0
    
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