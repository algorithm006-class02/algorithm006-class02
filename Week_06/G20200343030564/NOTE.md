学习笔记

本周学习：
字典树：
优点：最大限度的减少无谓的字符串比较，查找的效率比哈希表高

1.字典树的数据结构

2.字典树的核心思想
    Trie树的核心思想是空间换时间
    利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的
3.字典树的基本性质
    1>节点本身不存完整单词
    2>从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串
    3>每个节点的所有子节点路径代表的字符不同
    
并查集 Disjoint set
1.makeSet(s):建立一个新的并查集，其中包含s个单元素集合
2.unionSet(x,y):把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并
3.find(x):找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将他们
各自的代表比较一下就可以了
4.模板
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

启发式搜索 Heuristic Search (A*) 
模板
def AStarSearch(graph,start,end):
    pq=collections.priority_queue() #优先级-->估价函数
    pq.append([start])
    visited.add(start)
    while pq:
        node=pq.pop();
        visited.add(node)
        process(node)
        nodes=generate_related_nodes(node)
        unvisited=[node for node in nodes if node not in visited]
        pq.push(unvisited)
        
        
AVL树
1.平衡二叉搜索树
2.每个节点存balance factor = {-1， 0， 1}
3.四种旋转操作(记得旋转的时候， 有些子节点要转换父节点)
左旋
右旋
左右旋
右做旋
不足：结点需要存储额外的信息、且调整次数频繁

红黑树 Red-Black tree
红黑树是一种近似平衡的二叉搜索树(Binary Search Tree) , 它能够确保任何一个节点的左右子树的高度差小于两倍。具体来说，红黑树是满足如下条件的二叉搜索树：

1.每个结点要么是红色，要么是黑色。

2.根结点是黑色。

3.每个结点（NIL结点，空结点）是黑色的

4.不能有相邻接的两个红色节点

5.从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点

AVL和红黑树对比
AVL trees provide faster lookups than Red Black Trees because they are more strictly balanced.

Red Black Trees provide faster insertion and removal operations than AVL trees as fewer rotations are done dur to relatively relaxed balancing.
