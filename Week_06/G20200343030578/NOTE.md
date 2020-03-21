学习笔记

- 字典树 Tire
  - 基本性质
    - 结点本身不存完整单词
    - 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串
    - 每个结点的所有子结点路径代表的字符都不相同
  - 核心思想
    - 空间换时间
      - 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的
  - 典型应用
    - 统计和排序大量的字符串（如**搜索引擎系统用于文本词频统计**【搜索提示】）
  - 代码模板
    - https://shimo.im/docs/Pk6vPY3HJ9hKkh33/read
- 并查集 Disjoint Set
  - 使用场景
    - 组团、配对问题
  - 基本操作
    - makeSet(s)：建立一个新的并查集，其中包含 s 个单元素集合
    - unionSet(x, y)：把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在的集合不相交，如果相交则不合并
    - find(x)：找到元素 x 所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。
  - 代码模板
    - https://shimo.im/docs/ydPCH33xDhK9YwWR/read

* 高级搜索
  * 初级搜索
    - 见 搜索与查找
    - 优化思路
      - 不重复（斐波那契数列）、剪枝（括号生成）
      - 搜索方向：DPS、BFS、双向搜索、启发式搜索
  * 高级搜索
    - 剪枝
      - 减去状态不可能导致最优的子树
    - A *
      - 按优先级搜索（用优先队列实现，其中优先级依据**启发式函数**确定）
    - 双向 BFS
      - 起点和终点，同时向中间搜索
* AVL 树和红黑树
  - AVL 树
    - 结点带有平衡因子，保证二叉搜索树的平衡
    - 若插入或删除时，导致平衡因子过大，则需要**旋转调整**
      - 左旋
      - 右旋
      - 左右旋
      - 右左旋
  - 红黑树
    - 红黑树是一种近似平衡的二叉搜索树（Binary Search Tree），它能够确保任何一个结点的左右子树的高度差小于两倍。具体来说，红黑树是满足如下条件的二叉搜索树
      - 每个结点要么是红色，要么是黑色
      - 根节点是黑色
      - 每个叶节点（NIL节点，空节点）是黑色的
      - 不能有相邻接的两个红色节点
      - 不能有相邻接的两个红色节点
  - AVL 树和红黑树对比
    - AVL trees provide **faster lookups** than Red Black Trees because they are **more strictly balanced**.
    - Red Black Trees provide **faster insertion and removal operations**than AVLtrees as fewer rotations are done due to relatively relaxed balancing.
    - AVL trees store balance **factors or heights** with each node, thus requiresstorage for an integer per node whereas Red Black Tree requires only 1 bitof information per node.
    - Red Black Trees are used in most of the **language libraries** like map, multimap, multisetin C++ whereas AVL trees are usedin **databases** where faster retrievals are required.