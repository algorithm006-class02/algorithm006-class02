学习笔记

字典树，也叫前缀树，该数据结构由René de la Briandais于1959年发明。Edward Fredkin截取了英语单词retrieval（检索）的中间几个字母，将其命名为Trie。

与二叉查找树不同，键不是直接保存在字典树的节点中，而是由根节点到所在节点的路径决定，节点本身可以存储其它额外信息，比如词频。

字典树的优点是最大限度地减少无谓的字符串比较，查询效率比散列表高，所以常被搜素引擎用于文本词频统计。

字典树是用空间换时间，利用字符串的公共前缀来提高查询效率。

单词搜索2用字典树的时间复杂度是O(N * m * n * k)，DFS的时间复杂度也是O(N * m * n * k)，这里N是单词数，m、n是边长，k是单词平均长度。

并查集
 
    def _init(self, p):
        p = [i for i in range(m)]
    
    def _union(self, p, i, j):
        pi = self._parent(p, i)
        pj = self._parent(p, j)
        p[pi] = pj

    def _parent(self, p, i):
        root = i
        while p[root] != root:
            root = p[root]
        while p[i] != i:
            x = i; i = p[i]; p[x] = root
        return root


双向BFS

    def BDBFS(graph, begin, end):
        begin_queue = {begin}
        end_queue = {end} 
        visited = {begin, end}

        while begin_queue: 
            node = begin_queue.pop() 
            visited.add(node)
            next_queue = {}

            process(node) 
            nodes = generate_related_nodes(node) 
            if nodes in end_queue:
                return result
            next_queue.push(nodes)

            begin_queue = next_queue
            if len(begin_queue) > len(end_queue):
                swap(begin_queue, end_queue)
                
