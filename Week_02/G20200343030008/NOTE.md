# 学习总结

## 哈希表、映射、集合

哈希表（Hash table），也叫散列表，是根据关键码值（Key-value）而直接进行访问的数据结构。它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。

其底层数据结构是数组，散列表借用了数组支持按照下标随机访问的特性，时间复杂度是O(1),

这个映射函数叫作散列函数（Hash Function），存放记录的数组叫作哈希表（或散列表）。

### 哈希冲突

哈希算法产生的哈希值的长度是固定且有限的，因此要找到一个不同的key对应的散列值不一样的哈希函数，几乎不可能，且因为底层数组的存储空间有限，也会加大散列冲突的概率

### 哈希冲突解决方案

解决哈希冲突的方法一般有：开放定址法、链地址法（拉链法）、再哈希法、建立公共溢出区等方法。

详细内容可以查看 [解决哈希冲突的常用方法分析](https://www.jianshu.com/p/4d3cb99d7580)

## 二叉树

链表的二维结构就是树。

二叉搜索树，也称二叉搜索树、有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree），是指一棵空树或者具有下列性质的

- 1. 左子树上所有结点的值均小于它的根结点的值；
- 2. 右子树上所有结点的值均大于它的根结点的值；
- 3. 以此类推：左、右子树也分别为二叉查找树。 （这就是 重复性！）

图就是树中存在环的一种结构。

## 二叉树遍历 Pre-order/In-order/Post-order

- 1.前序（Pre-order）：根-左-右  
- 2.中序（In-order）：左-根-右   （升序排列）
- 3.后序（Post-order）：左-右-根

> 回顾二叉树遍历，重新理解前序、后续遍历的特点，如题 [105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) 就是根据遍历特点解题。

## 泛型递归、树的递归解题方法

- 1、递归退出条件
- 2、处理当前层
- 3、处理下一层
- 4、清理当前层

## 解题模板

```go
func recursion(level, param1, param2, ...) {
  // recursion terminator
  if level > MAX_LEVEL:
    process_result
    return
  // process logic in current level
  process(level, data...)
  // drill down
  recursion(level + 1, p1, ...)
  // restore current status
  // ...
}
```


## 困境

> 这周题目明显困难，遇到这些题知道用什么方法（递归、迭代），但是自己去解题仍然找不准切入点，思路会陷入一层层的循环里面(人肉递归)，break不出来。需要`五毒神掌`继续磨练

