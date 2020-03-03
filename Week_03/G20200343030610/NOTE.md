学习笔记
深度优先搜索 在遍历的过程中持续递归下探直到最底层 ，然后再进行下一层
写不出来的问题在于 不能将逻辑与相关代码实现对应抽象出来

dfs 代码模板

def dfs(node):
    if node in visited:
        #already visted
        return

    visited.add（node)
    
    #处理当前层的时候就下探到下一层一直到结束才返回 深度优先
    dfs(node.left)
    dfs(node.right)
    
dfs 递归的写法

visited = set()
def dfs(node, visited):
    if node in visited: #退出条件 ，被访问过则退出搜索（因为在处理当前层的时候最底层也深入处理了 所以此处判断只要不在visited中则认为深度搜索结束
    visited.add(node)
    
    #process  current node
    for next_node in node.children():
        if not next_node in visited: #当前循环就已经下探到最底层
            dfs(next_node,visited)


dfs 非递归写法 ，即自己实现和维护一个递归的栈 如何将递归转换成栈？

def DFS(self, tree):
    if tree.root is None:
        return []
    visited, stack = [] , [tree.root]
    while stack:
        node = stack.pop()
        visisted.add(node)
  

        process(node)
        nodes = generate_related_nodes(node)
        stack.push(nodes)




分治 ，回溯

分治 经典思路  一串字符转换成大写

分治代码模板

divide_conquer(problem, param1, parasm2,...):
    if problem is None:
         print_result
         return
    #准备输入参数，和拆分方法
    data = prepare_data(problem)
    subproblems = split_problem(problem, data)
    
    #解决子问题 获得子问题结果
    sr1 = self.divide_concquer(subproblems[0], p1, ...)
    sr2 = self.divide_concquer(subproblems[0], p1, ...)
    sr3 = self.divide_concquer(subproblems[0], p1, ...)
    
    #合并子问题结果
    result = process_result(sr1,sr2,sr3...)

    #处理当前层的状态


回溯

