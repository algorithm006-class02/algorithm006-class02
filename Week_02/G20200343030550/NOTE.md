学习笔记  
# 1、Hash table（哈希表），也叫散列表  
- Map: key-value对，key 不重复；python中的字典；  
- Set: 不重复元素的集合；python中的set集合；
-   
# 2、树  
- 非线性表结构
- 基础概念：  
  - 根结点、父结点、子节点、兄弟结点、叶结点
  - 高度：自下而上，起点为0；深度：自上而下，起点为0；层：自上而下，起点为1；  
- 二叉树：
  - 每个节点最多有两个“叉”，也就是两个子节点，分别是左子节点和右子节点；
  - 满二叉树、完全二叉树
  - 二叉树存储：链式存储法、顺序存储发（数组来存）
  - 二叉树遍历：前序（根-->左-->右）、中序（左-->根-->右）、后序（左-->右-->根）
  - 二叉查找树：支持动态数据集合的快速插入、删除、查找操作；
  - **平衡二叉树：**
  - **红黑树：**
# 3、递归  
- 树节点的定义
- 重复性（自相似性）
- 代码模板：python
  ```
  def recursion(level, param1, param2, ...): 
    # recursion terminator 
    if level > MAX_LEVEL: 
	   process_result 
	   return 

    # process logic in current level 
    process(level, data...) 

    # drill down 
    self.recursion(level + 1, p1, ...) 

    # reverse the current level status if needed
  ```