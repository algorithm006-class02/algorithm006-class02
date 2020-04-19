学习笔记  
1、Trie树：
2、并查集：  
3、高级搜索：  
4、AVL：  
- 平衡二叉搜索树
- 每个节点存balance factor={-1,0,1}
- 四种旋转操作
- 不足：节点需要存储额外信息、且调整次数频繁，维护成本高； 
- 应用：读操作多，写操作少的情况下，推荐用AVL ；
  
5、红黑树：  
- 近似平衡的二叉搜索树，它能够确保任何一个结点的左右子树的**高度差小于两倍**。
- 满足以下5个条件：
  - 每个结点要么是红色，要么是黑色；
  - 根结点是黑色；
  - 每个叶结点（NIL结点，空结点）是黑色的；
  - 不能有相邻接的两个红色结点；
  - 从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点；
- 应用：如果读写都比较多的情况下，推荐用红黑树；

6、AVL树和红黑树对比：  
  - AVL trees provide **faster lookups** than Red Black Trees because they are **more strictly balanced**.  
  - Red Black Trees provide **faster insertion and removal operations**than AVLtrees as fewer rotations are done due to relatively relaxed balancing.  
  - AVL trees store balance **factors or heights** with each node, thus requiresstorage for an integer per node whereas Red Black Tree requires only 1 bitof information per node.  
  - Red Black Trees are used in most of the **language libraries** like map, multimap, multisetin C++ whereas AVL trees are usedin **databases** where faster retrievals are required.
