# 学习总结

## 深度优先(DFS)，广度优先(BFS)，回溯(backtrace)，递归

> 之前对深度优先，回溯，递归有点迷惑，现在基本可以了解到，其实这 3 个东西就是一个东西，在不同场景下的不同叫法而已。在编程实现的时候，都是使用递归。

## 再说递归

> 上一节被递归搞得有些头晕，经过这周的继续刷题只有，对于递归有了一个总体上的认识：

- 不要人脑递归，如果想要更清楚的知道递归的执行过程，最好就是画出递归树。一旦画出递归树，整个执行过程基本就清晰了。
- 递归的题目很多时候也是一个设计题。因为在递归的过程中，设计到很多中间状态。要涉及好状态再层与层之间的传递与恢复。
- 剪枝是加速递归的一个常用技巧。明显不合理的分支，直接跳过。
- 有时候状态的传递，既可以通过参数传递，也可以通过函数的返回值。比如[二叉树的公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)这个题目，可以通过返回值来解答。
- 处理当前层逻辑与递归代码的先后顺序。有些时候，当前层逻辑放在递归前后没有什么影响，有些时候就有影响了。比如二叉树的前中后序遍历，放在不一样的位置，可以打印不同的结果。又比如讲一个字符串倒序打印：

```c++
string reverse_str(const string &s, int i) {
  if (i == s.size()) {
    return "";
  }
  char c = s[i];
  string new_str = reverse_str(s, i + 1) + c;
  return new_str;
}
```

```cpp
string reverse_str(const string &s, int i) {
  if (i == s.size()) {
    return "";
  }
  string next_level_str = reverse_str(s, i + 1);
  char c = s[i];
  return next_level_str + c;
}
```

在这种情况下，2 种写法得到的结果是一样的，具体要看情况。

## 看国际站

> 在[岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)这类题目中，经常会涉及到一些坐标在各个方向的移动问题。

在最开始的写法中，可能就写多个分支：

```c++
if (i + 1 < rows && grid[i + 1][j] == '1')
{
  sink(grid, i + 1, j);
}
if (i - 1 >= 0 && grid[i - 1][j] == '1')
{
  sink(grid, i - 1, j);
}
if (j + 1 < cols && grid[i][j + 1] == '1')
{
  sink(grid, i, j + 1);
}
if (j - 1 >= 0 && grid[i][j - 1] == '1')
{
  sink(grid, i, j - 1);
}
```

这样也只能在分支很多的时候，可以这样写，如果分支多了的时候，这样写肯定就不合适了。所以一般可能这样写：

```cpp
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};
for (int k = 0; i < 4; ++k) {
  sink(grid, i + dx[k], j + dy[k]);
}
```

也可以这样写：

```cpp
int ds[4][4] = {
  {0, 1},
  {0, -1},
  {1, 0},
  {-1, 0}
}
for (int k = 0; k < 4; ++k) {
  sink(grid, i + ds[k][0], j + ds[k][1]);
}
```

光头哥这个就比较牛逼了：

```cpp
int ds[5] = {0, -1, 0, 1, 0};
for (int k = 0; k < 4; ++k) {
  sink(grid, i + ds[k], j + ds[k + 1]);
}
```
