## 作业题目

#### 哈希表
- [#1. Two Sum](./Leetcode-1-380.js)
- [#49. Group Anagrams](./Leetcode-49-380.js)
- [#242. Valid Anagram](./Leetcode-242-380.js)

#### 二叉树遍历
- [#94. Binary Tree Inorder Traversal](./Leetcode-94-380.js)
- [#144. Binary Tree Preorder Traversal](./Leetcode-144-380.js)
- [#429. N-ary Tree Level Order Traversal](./Leetcode-429-380.js)
- [#589. N-ary Tree Preorder Traversal](./Leetcode-589-380.js)
- [#590. N-ary Tree Postorder Traversal](./Leetcode-590-380.js)

### 递归、回溯
- [#22. Generate Parentheses](./Leetcode-22-380.js)
- [#46. Permutations](./Leetcode-46-380.js)
- [#47. Permutations II](./Leetcode-47-380.js)
- [#70. Climbing Stairs](./Leetcode-70-380.js)
- [#77. Combinations](./Leetcode-77-380.js)
- [#98. Validate Binary Search Tree](./Leetcode-98-380.js)
- [#104. Maximum Depth of Binary Tree](./Leetcode-104-380.js)
- [#105. Construct Binary Tree from Preorder and Inorder Traversal](./Leetcode-105-380.js)
- [#111. Minimum Depth of Binary Tree](./Leetcode-111-380.js)
- [#226. Invert Binary Tree](./Leetcode-226-380.js)
- [#236. Lowest Common Ancestor of a Binary Tree](./Leetcode-236-380.js)


## 学习笔记

#### 哈希表
- Hash Table
  - 将KeyValuePair通过哈希函数映射到数组中具体下标。存储这种KeyValuePair的数据结构

- Hash Collisions（哈希碰撞）
  - 两组KV，通过哈希函数得到了相同的下标，那么就在此下标对应的位置构建一个链表，来存储数据

#### 树的遍历
- 前序遍历  根-左-右
- 中序遍历  左-根-右
- 后续遍历  左-右-根
- 树的遍历一般都是采用递归的方式，因为树结构用循环的话会很复杂和麻烦。我们要拥抱递归

```python
// 树的遍历代码模版
def preorder(self, root):
	if root:
		self.traverse_path.append(root.val)
		self.preorder(root.left)
		self.preorder(root.right)

def inorder(self, root):
	if root:
		self.inorder(root.left)
		self.traverse_path.append(root.val)
		self.inorder(root.right)

def postorder(self, root):
	if root:
		self.postorder(root.left)
		self.postorder(root.right)
		self.traverse_path.append(root.val)
```

#### Binary Search Tree
- 动态示例Demo：[https://visualgo.net/zh/bst](https://visualgo.net/zh/bst)
- 指一棵空树或者具有下列性质的二叉树
    - 左子树上所有结点的值 < 根结点值
    - 右子树上所有结点的值 > 根结点值
- 常见操作
    - 查询 O(logn)
    - 插入 O(logn)
    - 删除 O(logn)
        - 如果删除的结点存在子结点，则先找到比该结点值大的第一个元素，将其替换后，删除该结点
- tips
  - 树和图最关键的差别，就是看有没有环
  - 链表是特殊化的树，树是特殊化的图（没有环的图就是树）


#### 递归、回溯
```python
// 递归代码模版
def recursion(level, params1, params2, ...):
	# recursion terminator 终止条件
	if level > MAX_LEVEL
		process_result
		return

	# process logic in current level 处理当前层逻辑
	process(level, data...)

	# drill down 下探到下一层
	self.recursion(level+1, p1, ...)
	
	# reverse the current level status if needed 清理当前层
```

```python
// 回溯代码模版
result = []
def backtrack(路径，选择列表):
	if 满足结束条件:
		result.add(路径)
		return
	for 选择 in 选择列表
		做选择
		backtrack(路径，选择列表)
		撤销选择
```

- Backtracking 回溯
  - 回溯法是暴力搜索法中的一种（from wikipedia）
  - 回溯法是一种可以找出所有（或一部分）解的一般性算法，尤其适用于约束满足问题
  - 回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：
      - 找到一个可能存在的正确的答案
      - 在尝试了所有可能的分步方法后宣告该问题没有答案
  - 在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。
  - 参考资料
      - [https://zh.wikipedia.org/wiki/回溯法](https://zh.wikipedia.org/wiki/%E5%9B%9E%E6%BA%AF%E6%B3%95)