# 【428-week 02】学习总结

## 哈希表 Hash

- 哈希表(Hash table) ，也叫散列表，是根据关键码值（Key value）而直接进行访问的数据结构。
- 它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。
- 这个映射函数叫作散列函数（Hash Function）,存放记录的数组叫作哈希表（或散列表）

### 应用

- HashMap

  key-value对，key不重复

- HashSet

  不重复元素集合

- Redis

### 复杂度
|  method   | 复杂度  |
|  ----  | ----  |
Search | O(1)
Insertion | O(1)
Deletion | O(1)

## 树 Tree

- Linked List 是特殊化的 Tree
- Tree 是特殊化的 Graph

- 树的面试题一般都是递归的：
  1. 节点的定义
  2. 重复性

### 应用

- 二叉树
- 二叉搜索树 Binary Search Tree
  - 二叉搜索树，也称有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree），是指一颗空树或者具有下列性质的二叉树：
    1. 左子树上所有结点的值均小于它的根结点值。
    2. 右子树上所有结点的值均大于它的根结点值。
    3. 以此类推：左、右子树也分别为二叉搜索树
  中序遍历：升序排列

### 示例代码

```python
# Pyshon 模板
class TreeNode：
	def __init__(self, val):
		self.val = val;
		self.left, self.right = None,None
```
```c++
// C++模板
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x): val(x), left(NULL), right(NULL){}
}
```
## 递归 Recursion

- 递归 - 循环
- 通过函数体来进行的循环

### 模板
```python
#Python 代码模板
def recurdion(level, param1, param2, ...):
	# 递归终结条件
	if level > MAX_LEVEL:
		process_result
		return
	# 处理当前层递归
	process(level, data, ...)
	# 下探到下一层
	selt.recursion(level + 1,  p1, ...)
```
```C++
//C++ 代码模板
postorderTraversal(TreeNode* root) {
    if (!root) return TraversalVal;  // 递归终结条件
	// 处理当前层递归
	TraversalVal.push_back(root->val);
	// 下探到下一层
    postorderTraversal(root->left);
    postorderTraversal(root->right);
    return TraversalVal;
    }
```
### 思维要点

1. 不要人肉进行递归（最大误区）
2. 找到最近最简单方法，将其拆解成可重复解决的问题（重复子问题）
3. 数学归纳法思维

*XMind: ZEN - Trial Version*