学习笔记
本周学习的主要内容是动态规划，在学习动态规划之前，需要先理解递归的基本只是。
递归的模板：
def recursion(level, param1, param2, ...): 
    # recursion terminator 
    if level > MAX_LEVEL: 
	   process_result 
	   return 

    # process logic in current level 
    process(level, data...) 

    # drill down 
    self.recursion(level + 1, p1, ...) 
分治的模板：
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

 对于递归模板需要形成肌肉是记忆，对于递归，其基本组成部分为递归终止条件terminator，处理当前层逻辑，下探下一层，恢复当前层状态。而分治则是拆分子问题，调递归函数，合并结果，恢复当前曾状态。在设计程序时，人肉递归很低效，应该找到最近最简的方法，通过数学归纳法的思想来得到结果。
 设计算法的本质，就是寻找重复性，然后找到共同子问题。因此，与分治和递归相比，动态规划的本质仍然是寻找重复子问题，有所不懂得是动态规划是寻找最优子结构，中途可以淘汰较差的结果。
 动态规划需要找到最优子结构，并储存中间状态，然后实现所谓的“状态转移方程”，也就是递推公式，最终得到结果。
 本周的算法难度相较于期中之前有所加大，感觉确实有不小的坡度，个人感觉后面还需要多刷一些动态规划的题目，打破自己的惯性思维，通过刻意练习的方式理解动态规划的概念。