# 学习笔记

## 常用代码模板:
- 分治代码
```
    def divide_conquer(problem, param1, param2, ...):
        # recursion terminate
        if problem is None:
            print result
            return
        # prepare data
        data = prepare_data(problem)
        subproblem = split_problem(problem, data)

        # conquer subproblem
        subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
        subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
        subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
        ...

        # process and generate the final result
        result = process_result(subresult1, subresult2, subresult3, …)

        # revert the current level states
```
- 深度优先DFS(递归)
```
    visited = set()
    def dfs(node, visited):
        # recursion terminate
        if node in visited:
            return 
        
        visited.add(node)

        # process current node here.
        for next_node in node.children():
            if next_node not in visited:
                dfs(next_node, visited)

```
- 深度优先DFS(非递归)
```
    def dfs(self, tree):
        if tree.root is None:
            return []
        visited, stack = [], [tree.root]
        while stack:
            node = stack.pop()
            visited.append(node)

            process(node)
            nodes = generate_related_nodes(node)
            stack.push(nodes)

```
- 广度优先BFS
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

	    # other processing work 
	...

```
- 二分查找
```
    left, right = 0, len(arr) - 1
    while left <= right:
        mid = left + (right - left) / 2 # 防止下标越界
        if arr[mid] == target:
            # find
            return or break
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
        
```
