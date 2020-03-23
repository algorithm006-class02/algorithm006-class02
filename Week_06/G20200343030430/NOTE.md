学习笔记

分析单词搜索 2 用 Tire 树方式实现的时间复杂度：
- 构建 Trie 树：O(n)（n表示单词列表的长度）
- 查找：O(m * n * 4^k)（m,n表示二维网格的大小，k表示平均每个单词的长度）

### 代码模板

- 并查集模板

```java
class UnionFind {
	private int count = 0;
	private int[] parent;
	public UnionFind(int n) {
		count = n;
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}
	public int find(int p) {
		while (p != parent[p]) {
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ) return;
		parent[rootP] = rootQ;
		count--;
	}
}
```

### 本周作业
掌握度 | index | level | desc | url
---|---|---|---|---
熟悉 | 208 | 中等 | 实现 Trie (前缀树) | [implement-trie-prefix-tree](https://leetcode-cn.com/problems/implement-trie-prefix-tree)
一般 | 547 | 中等 | 朋友圈 | [friend-circles](https://leetcode-cn.com/problems/friend-circles)
一般 | 130 | 中等 | 被围绕的区域 | [surrounded-regions](https://leetcode-cn.com/problems/surrounded-regions)
-- | 36 | 中等 | 有效的数独 | [valid-sudoku](https://leetcode-cn.com/problems/valid-sudoku)
一般 | 79 | 中等 | 单词搜索 | [word-search](https://leetcode-cn.com/problems/word-search)
一般 | 212 | 困难 | 单词搜索 | [word-search-ii](https://leetcode-cn.com/problems/word-search-ii)
-- | 37 | 困难 | 解数独 | [sudoku-solver](https://leetcode-cn.com/problems/sudoku-solver)

### 课后作业
掌握度 | index | level | desc | url
---|---|---|---|---
-- | 1091 | 中等 | 二进制矩阵中的最短路径 | [shortest-path-in-binary-matrix](https://leetcode-cn.com/problems/shortest-path-in-binary-matrix)
-- | 773 | 困难 | 滑动谜题 | [sliding-puzzle](https://leetcode-cn.com/problems/sliding-puzzle)

--：表示未做题目
