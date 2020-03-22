学习笔记
字典树 Trie树(多叉树) 单词查找树或键树
是一种树形结构，典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统
用于文本词频统计

优点：最大限度的减少无谓的字符串比较，查找的效率比哈希表高

1.字典树的数据结构

2.字典树的核心思想
    Trie树的核心思想是空间换时间
    利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的
3.字典树的基本性质
    1>节点本身不存完整单词
    2>从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串
    3>每个节点的所有子节点路径代表的字符不同

4.并查集 Disjoint set
makeSet(s):建立一个新的并查集，其中包含s个单元素集合
unionSet(x,y):把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并
find(x):找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将他们
各自的代表比较一下就可以了

class UnionFind{
    private int count=0;
    private int[] parent;
    public UnionFind(int n){
        count=n;
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    public int find(int p){
        while(p!=parent[p]){
            parent[p]=parent[parent[p]];
            p=parent[p];
        }
        return p;
    }
    public void union(int p,int q){
        int rootP=find(p);
        int rootQ=find(q);
        if(rootP==rootQ){
            return;
        }
        parent[rootP]=rootQ;
        count--;
    }
}

初级搜索
1.朴素搜索
2.优化方式：不重复（fibonacci）、剪枝(生成括号问题)
    剪枝就是整个状态树，这一个分治是没有必要的时候，我们就把它剪掉，不进行搜索
    这种没有必要性是来自一个是重复，也有可能是每次要找最优解
3.搜索方向:
    DFS:depth first search 深度优先搜索
    BFS:breath First search 广度优先搜索
    
    双向搜索、启发式搜索(优先队列)
    
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
        
估价函数
    启发式函数：h(n),它用来评价哪些结点最有希望的是一个我们要找的结点，h(n)会返回一个非负实数，也可以认为
    是从结点n的目标结点路径的估计成本
    启发式函数是一种告知搜索方向的方法，它提供了一种明智的方法来猜测哪个邻居结点会导向一个目标
    
前序遍历 Pre-order:根-左-右
中序遍历 In-order:左-根-右
后序遍历 Post-order:左-右-根

def preorder(self,root):
    if root:
        self.traverse_path.append(root.val)
        self.preorder(root.left)
        self.preorder(root.right)
        
def inorder(self,root):
    if root:
        self.inorder(root.left)
        self.traverse_path.append(root.val)
        self.inorder(root.right)
        
def postorder(self,root):
    if root:
        self.postorder(root.left)
        self.postorder(root.right)
        self.traverse_path.append(root.val)
AVL树
    1.平衡因子Balance factor
    是它的左子树的高度减去它的右子树的高度(有时相反) balance factor={-1.0.1}
    2.通过旋转操作来进行平衡 四种
      左旋
      右旋
      左右旋
      右左旋
      
    缺点：结点需要存储额外信息，且调整次数频繁
    
红黑树 Red-Black tree
是一种近似平衡的二叉搜索树（Binary Search Tree）,它能够确保任何一个结点的左右子树的高度差小于两倍，
具体来说，红黑树是满足如下条件的二叉搜索树：
    1.每个节点要么是黑色，要么是红色
    2.根节点是黑色
    3.每个叶节点（NIL结点，空结点）是黑色的
    4.不能有相邻接的两个红色结点
    5.从任一结点到其每个叶子结点的所有路径都包含相同数目的黑色结点
    
。AVL trees provide faster lookups than Red Black Trees because they are more strictly balanced
。Red Black Trees provide faster insertion and removal operations than AVL trees as fewer rotation
are done due to relatively relaxed balancing
。AVL trees store balance factors or heights with each node,thus requires storage for an integer per node
whereas Read Black Tree requires only 1 bit of information per node.
。Red Black Trees are used in most of the language libraries like map,multimap,
multisetin C++ whereas AVL trees are used in databases 

