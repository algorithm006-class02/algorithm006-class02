recursion with dfs:
```python
visited = set()
def dfs(node,visited):
    if node in visited:
    return

    visited.add(node)

    process(node)

    for node in next_state(node):
        dfs(node,visted)
```

dfs with stack
```python
def DFS(SELF,tree):
    if tree.root is none:
    return []
    visited,stack = [],[tree.node]
    while stack:
        node = stak.pop()
        process(node)
        nodes  = next_state(node)
        satck.push(node)

```