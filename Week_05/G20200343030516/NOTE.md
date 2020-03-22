学习笔记

## dynamic programming

### 递归到动态规划的一般转化方法：
递归函数具有N个参数，就定义一个n维数组，数组的下标是递归函数参数的取值范围，数值元素的值是递归函数的返回值，这样就可以从边界值开始，逐步填充数组，相当于计算递归函数值的逆过程。

### 动态规划问题的一般思路
1. 将原问题分解为子问题
   + 讲原问题分解为若干个子问题，子问题和原问题形式的解类似或者相同，但是规模变小。 子问题都解决的话，原问题就可以得到解。
   + 子问题的解一旦求出就会保存，所以每个子问题只需求解一次。
2. 确定状态
   +  使用动态规划结题的时候，我们往往将子问题和相关问题的各个变量一组取值，称之为一个状态。
   + 一个 "状态",对应一个或者多个子问题，所谓某个状态下的值，就是这个状态下所对应的子问题的解。
   + 整个问题的时间复杂度是状态数目乘以计算每所需时间。

3.  寻找边界条件

    以"数字三角形" 为例，初始状态是底边数字， 值为底边数字值

4.  确定状态转移方程
    定义出什么是“状态”，以及在该 “状态”下的值后，找出不同的状态之间如何迁移即如何从一个或多“值”已知的求出另一个“状态” 的值(“人为我”递推型 )。状态的迁移可以用递推公式表示此也被称作“状转方程”。


###  能够使用动态规划结题问题的特点  

1） **问题具有最优子结构的性质**。
如果问题最优解包含子结构的解也是最优的，我们称该问题具有最优子结构。
2） **无后效性**。当前的若干个状态值一旦确定，则此后的演变就只和这个状态值有关，和之前采取哪种手段，如何到到这个状态的，没有任何关系。

### 动态规划的两种形式
 1. 递归
 直观，容易编写
 递归层数太深，容易爆栈，函数调用也会带来额外开销

 2. 递推
 效率高，有可能使用滚动数组节省空间
 （人人为我型递推，我为人人型）


### 递归模板
```python
def recursion(level,param1):
# recursion terminator 
    if level > MAX_LEVEL: 
	   process_result 
	   return 

    # process logic in current level 
    process(level, data...) 

    # drill down 
    self.recursion(level + 1, p1, ...) 

    # reverse the current level status if needed
```

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

### 分治代码模板
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



