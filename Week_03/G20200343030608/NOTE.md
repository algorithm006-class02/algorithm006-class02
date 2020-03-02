搜索二维矩阵的基本思路：

①先查找目标元素在哪一行
②二分查找判断元素是否在矩阵中。

柠檬水找零：(无思路，直接看的题解)
①遇到20，用掉10
②省5越多越好


学习笔记
分治算法的核心思想是分而治之。
首先将问题划分成n个规模较小并且结构与原问题相似的子问题。
递归地解决这些子问题。
合并其结果。

分治算法能解决的问题，一般需要满足以下几个条件：
1、原问题与分解成的子问题具有相同的模式。
2、原问题分解成的子问题可以独立求解。子问题之间没有相关性。
3、具有分解终止条件。
4、可将子问题合并成原问题。

分治算法是一种处理问题的思想，递归是一种编程技巧。

分治代码模板
def divide_conquer(problem, param1, param2, ...): 
# recursion terminator 
if problem is None: 
 print_result 
 return 
# prepare data 
 data = prepare_data(problem) 
 subproblems = split_problem(problem, data) 
# conquer subproblems 
 subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
 subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
 subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
...
# process and generate the final result 
 result = process_result(subresult1, subresult2, subresult3, …) 
 
 # revert the current level states

回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种
情况：

• 找到一个可能存在的正确的答案；

• 在尝试了所有可能的分步方法后宣告该问题没有答案。

在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算

贪心算法：当下问题的局部最优解。贪心算法的难点在于如何证明问题可以用贪心法来解决，有些时候贪心的角度稍微巧妙一些，可能是从后往前贪心，也有可能是从某一个局部切入进行贪心。
回溯：能够回退。
动态规划：最优判断+回退。

二分查找算法能够有效的前提：
1、目标函数的单调性（单调递增或者递减）
2、存在上下界
3、能够通过索引访问
left, right = 0, len(array) - 1 
while left <= right: 
 mid = (left + right) / 2 
 if array[mid] == target: 
 # find the target!! 
 break or return result 
 elif array[mid] < target: 
 left = mid + 1 
 else: 
 right = mid - 1
Python
class TreeNode: 
def __init__(self, val): 
 self.val = val 
 self.left, self.right = None, None

 搜索 - 遍历
• 每个节点都要访问一次

• 每个节点仅仅要访问一次

• 对于节点的访问顺序不限 
- 深度优先：depth first search 
- 广度优先：breadth first search

def dfs(node): 
 
if node in visited: 
# already visited 
return
 visited.add(node) 
 # process current node 
# ... # logic here 
 dfs(node.left) 
 dfs(node.right)

 DFS 代码 - 递归写法
visited = set() 
def dfs(node, visited): 
if node in visited: # terminator 
# already visited 
return 
 visited.add(node) 
# process current node here. 
...
for next_node in node.children(): 
 if not next_node in visited: 
 dfs(next node, visited)

 BFS 代码
def BFS(graph, start, end): 
 queue = [] 
 queue.append([start]) 
 visited.add(start) 
while queue: 
 node = queue.pop() 
 visited.add(node) 
 process(node) 
 nodes = generate_related_nodes(node) 
 queue.push(nodes) 
# other processing work

贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有
利）的选择，从而希望导致结果是全局最好或最优的算法。 
贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不
能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行
选择，有回退功能。
贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，
不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前
进行选择，有回退功能

本周学习的主要内容是几个算法，分治、回溯、深度优先搜索、广度优先搜索、贪心算法和二分查找。其中分治和回溯掌握的最不好，下周需要继续加强分治和回溯的理解。