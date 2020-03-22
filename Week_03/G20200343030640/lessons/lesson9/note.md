
### DFS (Depth First Search)递归模板
```python
visited = set()
def dfs(node, visited):
    # terminator
    if node in visited:
        return
    visited.add(node)
    # process current node here.
    ...
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)
```

### BFS 代码
```python
def bfs(graph, start, end):
    queue = []
    queue.append([start])
    while queue:
        node = queue.pop()
        visited.add(node)
        
        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)
```