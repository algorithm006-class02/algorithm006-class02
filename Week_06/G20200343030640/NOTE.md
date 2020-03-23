学习笔记

https://leetcode-cn.com/problems/word-search-ii/submissions/

单词搜索II 时间复杂度总结

```python
# 构造字典树
trie = {}  
for word in words:
    node = trie
    for char in word:
        node = node.setdefault(char, {})
    node['#'] = True

首先构造字典树，words数组长度N, 则时间复杂度O(N*length(word))

# 遍历二维数组board
res, r, c = set(), len(board), len(board[0])
for i in range(r):
    for j in range(c):
        if board[i][j] in trie:
            search(i, j, trie[board[i][j]], board[i][j], {(i, j)})
return list(res)

假设行数R, 列数C，遍历整个数组的时间复杂度为: O(R*C)

# search函数
def search(i, j, node, pre, visited):
    if '#' in node:
        res.add(pre)
    for (di, dj) in ((-1, 0), (1, 0), (0, -1), (0, 1)):
        _i, _j = i+di, j+dj
        if -1 < _i < h and -1 < _j < w and board[_i][_j] in node and (_i, _j) not in visited:
            search(_i, _j, node[board[_i][_j]], pre+board[_i][_j], visited | {(_i, _j)})

但，对于每个字符都会进行四联通DFS遍历，DFS遍历深度是单词长度，平均长度计为K，
所以每个单词搜索时间复杂度: O(4^K)
整个二维数据时间复杂度: O(R*C*4^K)

所以，整个时间复杂度为: O(N*length(word)) + O(R*C*4^K)
```