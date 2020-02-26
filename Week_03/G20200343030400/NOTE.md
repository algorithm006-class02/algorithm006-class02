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

DFS递归写法一：

    visited = set()
    
    def dfs(node, visited):
        if node in visited:  # terminator
            # already visited
            return;
            
        visited.add(node)
        
        # process current node here
        ...
        for next_node in node.children():
            if next_node not in visited:
                dfs(next_node, visited)

DFS递归写法二：

    visited = set()
    
    def dfs(node, visited):
        visited.add(node)
        
        # process current node here
        ...
        for next_node in node.children():
            if not next_node in visited:
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
        
        
