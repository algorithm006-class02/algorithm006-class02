学习笔记

1，分治递归程序模板

    递归终止条件
    将大问题分解为小问题（当前层业务逻辑）
    下探到下一层（递归调用解决小问题，注意参数变化，可能有多个调用）
    将小问题处理的结果合并
    恢复状态（清理当前层）
    
2，回溯递归程序模板

    递归终止条件
    当前层业务逻辑
    下探到下一层（递归调用，注意参数变化，可能有多个调用）
    恢复状态（清理当前层，如果修改了不同层之间传递的参数，要恢复）
    
 
3, 搜索：每个元素访问一次且仅访问一次

    广度优先
    深度优先
    优先级优先（启发式搜索，更适用于现实业务场景，需要定制估价函数；实现：AI等；实例：推荐算法、高级搜索等）
    
    
4，深度优先搜索 Depth First Search

DFS代码模板

对图来说，需要记录visited；对树不需要记录visited。

DFS递归：

    visited = set()
    
    def dfs(node, visited):
        terminator
                       
        visited.add(node)
        
        # process current node here
        ...
        for next_node in node.children():
            if next_node not in visited:
                dfs(next_node, visited)
                

DFS手动栈：

    def dfs(self, tree):
    
        if tree.root is None:
            return []
            
        visited, stack = [], [tree.root]
        
        while stack:
            node = stack.pop()
            visited.add(node)
            
            process (node)
            nodes = generate_related_nodes(node)
            stack.push(node)
            
        # other processing work
        ...
        
 5，广度优先搜素 Breadth First Search
 
 对图来说，需要记录visited；对树不需要记录visited。
 
 BFS代码模板：使用队列数据结构，具体可用数组、queue、deque
 
    def bfs(graph, start, end):
    
        visited = set()
        queue = []
        queue.append([start])   # 初始节点首先入队
        
        while queue:             # 只要队列不空，就一直扫描
            node = queue.pop()
            visited.add(node)
            
            process(node)
            nodes = generate_related_nodes(node)
            queue.push(nodes)
            
        # other processing work
        ...
        
6，贪心算法

贪心算法，greedy，每一步都选择最值。如果能够由局部的最优解推出整体的最优解，则贪心算法成立，而且高效。否则只给出近似的整体最优解。

    贪心：当下局部最优判断
    回溯：能够回退，扫描全局最优解
    动态规划：最优判断+回退
    
7，二分查找

    1，目标函数有单调性（可以放宽为半单调，移动区间边界时考虑两端边界情况）
    2，存在上下界
    3，能够通过索引访问

时间复杂度O(logN)

二分查找模板

	left, right = 0, len(array) - 1 
	# 左闭右闭区间 [left, right]
	while left <= right: 
		mid = left + (right - left) / 2 
		if array[mid] == target: 
			# find the target!! 
			break or return result 
		elif array[mid] < target: 
			left = mid + 1 
		else: 
			right = mid - 1

