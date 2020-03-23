# 学习总结

## DisjointSet(并查集模板)
> 一般用在**分组某个集合**问题中，常见的如划分朋友圈，岛屿连通问题等。

```c++
class DisjointSet {
  public:
    DisjointSet(int n) : parents(n, 0) {
    }
    int find(int x) {
      return x == parents[x] ? x : find(parents[x]);
    }
    unionSet(int x, int y) {
      int p1 = find(x);
      int p2 = find(y);
      if (p1 != p2) {
        parents[p2] = p1;
      }
    }
private:
  vector<int> parents;
};
```

## Two-end BFS(双向BFS模板)
> 从两端同时进行BFS，可以将标准的BFS时间缩短一半。

```c++
class Solution {
public:
    void bfs(string start, string end, string target) {
      unordered_set<string> head, tail, *phead, *ptail, visited;
      head.insert(start);
      tail.insert(end);
      visited{start, end};
      while (!head.empty() && !tail.empty()) {
        // 总是从小的集合开始
        // 这段代码既可以放在while的最开始，也可以放在while的末尾
        if (head.size() < tail.size()) {
          phead = &head;
          ptail = &tail;
        } else {
          phead = &tail;
          ptail = &head;
        }
        // process current logic
        if (visited.find(target) == visited.end()) {
          visited.insert(target);
          head.insert(target);
        }
      }
    }
};
```

## 问题
- `A*` 搜索问题目前还不熟，需要多写点题目
- 红黑树和AVL树相关知识点目前只是初步了解，需要进一步学习