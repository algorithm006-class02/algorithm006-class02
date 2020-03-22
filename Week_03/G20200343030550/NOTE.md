学习笔记  
1、分治算法  
- 概念：分而治之，也就是将原问题划分成 n 个规模较小，并且结构与原问题**相似的子问题**，递归地解决这些子问题，然后再**合并**其结果，就得到原问题的解。
- 一般通过递归实现：分解、解决、合并

2、回溯算法  
- 三要素：有效结果、回溯范围及答案更新、剪枝

3、深度优先、广度优先  
- 代码模板：DFS  
```
# 递归
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
  
```
# 非递归
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
```
- 广度优先代码模板：BFS  
  ```
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
  ```
4、贪心算法  
- 定义：每一步都做出当时看起来最佳的选择。（整体来说，并不一定总是最优解）
- 定义了限制值和期望值，希望从中选出几个数据，在满足限制值的情况下，期望值最大。这类问题首先考虑一下贪心算法。 
   
5、二分查找  
- log(N)