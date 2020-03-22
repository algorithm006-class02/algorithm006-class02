# 学习总结

本周学习难度，比前几周要高，学得很吃力。很多题目看着题解也要想好几遍才行。

## 深度优先搜索（DFS）

递归代码模板

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
    if not next_node in visited:
      dfs(next node, visited)
```

非递归代码模板

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

## 广度优先搜索（BFS）

递归代码模板

```python
def BFS(graph, start, end):
  queue = []
  queue.append([start])
  visited.add(start)

  while queue:
    node = queue.pop()
    visited.add(node)

    process(node)
    nodes = generate_related_nodes(node)
    queue.push(nodes)
```

## 总结

- 广度优先搜索，通俗的理解就是，从起始顶层开始，一层层遍历，类似`洋葱`的结构。层层记录一般会用到`queue`。用于解决最短路径类的问题。
- 深度优先搜索，一般可以很方便地使用递归来解决，一般会用到`stack`

