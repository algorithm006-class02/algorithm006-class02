学习笔记

## DFS 递归写法
def dfs(node):
	if node in visited:
		#already visited
		return
	visited.add(node)
	
	#process current node
	#... #logic here
	dfs(node.left)
	dfs(node.right)

分治代码模板
1.recursion  terminator
2.prepare data
3.conquer subproblems
4.process and generate the final result

DFS 多叉树代码模板
def dfs(node,visited):
    visited.add(node)
	#process current node here.
	...
	for next_node in node.children():
	    if not next_node in visited:
			dfs(next_node,visited)
			
升级版
visited = set()
def dfs(node,visited):
	if node in visited: #terminator
		# already visited
		return
	
	visited.add(node)
	
	#process current node here
	...
	for next_node in node.children():
		if not next_node in visited:
			dfs(next_node,visited)
			
##非递归的写法
def dfs(self,tree):
	if tree.node is Node:
		return []
	
	visited,stack = [],[tree.node]
	
	while stack:
		node=stack.pop{}
		visited.add(node)
		
		process (node)
		node = generate_relater_nodes(node)
		stack.push(nodes)
		
	# other processing work
	...
	
def bfs(graph,start,end):
	queue = []
	queue.append([start])
	visited.add(start)
	
	while queue:
		node = queue.pop()
		visited.add(node)
		
		process(node)
		nodes = generate_relater_nodes(node)
		queue.push(nodes)
		
	# other processing work
	...
		
		
贪心算法Greedy
贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法
贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

贪心：当下做局部最优判断
回溯：能够回退
动态规划：最优判断+回退

适用贪心算法的场景
简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。

##回溯算法模板
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
        
回溯算法做题心得：
  重要的是理清楚选择列表与可选择的路径，撤销回溯后的逻辑路径，多debug走几遍，自然会好理解很多

##二分查找法模板
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
		    
关于使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方：
类似于：搜索旋转排序数组
可以利用旋转后，有一边是符合升序的，另一边不符合升序的逻辑特点，
可以先选择mid点后，将首尾与mid比较，得出左边升序排序还是右边升序排序，再判断目标值是不是在相应范围内
一步步缩小left和right指针位置


    public int search(int[] nums, int target) {
        // 左下标
        int left = 0;
        // 右下标
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 需要判断一波截断的位置，左边升序
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    // 在左边范围内
                    right = mid - 1;
                } else {
                    // 只能从右边找
                    left = mid + 1;
                }
            } else {
                // 右边升序
                if (target >= nums[mid] && target <= nums[right]) {
                    // 只能从右边找
                    left = mid + 1;
                } else {
                    // 在左边范围内
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

