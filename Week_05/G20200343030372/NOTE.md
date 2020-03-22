## 学习笔记

#### 递归

##### 递归代码模版
```
public void recur(int level, int param) {
    // terminator 
    if (level > MAX_LEVEL) {
    // process result 
     return; }
    // process current logic 
     process(level, param);
    // drill down 
     recur( level: level + 1, newParam);
    // restore current status 
}
```

#### 分治 (Divide & Conquer)

一般来说动态规划的问题，它会让求一个最优解或者求一个最大值或者求一个最少方式，正是因为有所谓最优解(也就是最优子结构)，那在中间的每一步就不需要吧所有的状态保存下来，只需要保存最优的状态，并且能证明用每一步的最优解，就能推导出全局最优解。
##### 分治代码模板
```
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

##### 状态转移方程（DP 方程）

```
opt[i , j] = opt[i + 1, j] + opt[i, j + 1]
```
完整逻辑：

```
if a[i, j] = ‘空地’: 

 opt[i , j] = opt[i + 1, j] + opt[i, j + 1]

else:

 opt[i , j] = 0
```
动态规划关键点

1. 最优子结构 opt[n] = best_of(opt[n-1], opt[n-2], …)

2. 储存中间状态：opt[i]

3. 递推公式（美其名曰：状态转移方程或者 DP 方程） 
Fib: opt[i] = opt[n-1] + opt[n-2] 
二维路径：opt[i,j] = opt[i+1][j] + opt[i][j+1] (且判断a[i,j]是否空地）
---

动态规划注意：

1. 打破自己的思维惯性，形成机器思维

2. 理解复杂逻辑的关键

3. 也是职业进阶的要点要领