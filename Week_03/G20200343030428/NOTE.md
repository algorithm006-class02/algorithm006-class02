# 第三周 学习笔记

## 分治、回溯

找重复性，不断重复和迭代

### 回溯

- 回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。

- 回溯法通过用最简单的递归方法来实现，在反复重复上述的步骤后可能出现俩种情况：
  - 找到一个可能存在的正确答案；
  - 在尝试了所有可能分步方法后宣告问题没有答案。
  
- 在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。

### 代码模板

``` python
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

### 泛型递归代码

```python
Python 代码模板
	def recursion(level, param1, param2, ...):
		if level > MAX_LEVEL：
			process_result
			return
		
		# process logic in current level
		process(level, data, ...)
		
		# drill down
		self.recursion(level + 1, p1, ....)

		# reverse the current level status if needed
```

## DFS、BFS 搜索

1. 深度优先：depth first search
2. 广度优先：breadth first search

- 每个节点都要访问一次
- 每个节点仅仅要访问一次
- 对于节点的访问顺序不限


### 深度优先搜索 DFS

- 代码模板
```python 
  def dfs(node):
  	if node in visited:
  		# already visited
  		return
  
  	visited.add(node)
  
  	# process current node
  	# ... # logic here
  	dfs(node.left)
  	dfs(node.right)
```
- 递归写法
  
```python
  visited = set() 
  
  def dfs(node, visited):
      if node in visited: # terminator
      	# already visited 
      	return 
  
  	visited.add(node) 
  
  	# process current node here. 
  	...
  	for next_node in node.children(): 
  		if next_node not in visited: 
  			dfs(next_node, visited)
```
- 非递归写法
```python
  def DFS(self, tree): 
  
  	if tree.root is None: 
  		return [] 
  
  	visited, stack = [], [tree.root]
  
  	while stack: 
  		node = stack.pop() 
  		visited.add(node)
  
  		process (node) 
  		nodes = generate_related_nodes(node) 
  		stack.push(nodes) 
  
  	# other processing work 
  	...
```
### 广度优先搜索 BFS

- 代码模板
```python
  def BFS(graph, start, end):
      visited = set()
  	queue = [] 
  	queue.append([start]) 
  
  	while queue: 
  		node = queue.pop() 
  		visited.add(node)
  
  		process(node) 
  		nodes = generate_related_nodes(node) 
  		queue.push(nodes)
  
  	# other processing work 
  	...
```
## 贪心算法

贪心算法 Greedy

- 贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最🈶利）的选择，从而希望导致结果是全局最好或最优的算法。

- 贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。
- 动态规划会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能

	
- 总结：
  1. 贪心：当下做局部最优判断
  2. 回溯：能够回退
  3. 动态规划：最优判断 + 回退

## 二分查找

- 前提
  - 目标函数单调性（单调递增或递减）
  - 存在上下界
  - 能够通过索引访问

### 代码模板

```python
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
```
*XMind: ZEN - Trial Version*