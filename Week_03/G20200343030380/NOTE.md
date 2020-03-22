## 作业题目

#### 分治
- [#17. Letter Combinations of a Phone Number](./Leetcode-17-380.js)
- [#50. Pow(x, n)](./Leetcode-50-380.js)
- [#51. N-Queens](./Leetcode-51-380.js)
- [#78. SubSets](./Leetcode-78-380.js)
- [#169. Majority Element](./Leetcode-169-380.js)

#### 广度优先搜索 / 深度优先搜索
- [#22. Generate Parentheses](./Leetcode-22-380.js)
- [#102. Binary Tree Level Order Traversal](./Leetcode-102-380.js)
- [#515. Find Largest Value in Each Tree Row](./Leetcode-515-380.js)
- [#200. Number of Islands](./Leetcode-200-380.js)
- [#529. Minesweeper](./Leetcode-529-380.js)

#### 字符转换题
- [#433. Minimum Genetic Mutation](./Leetcode-433-380.js)
- [#127. Word Ladder](./Leetcode-127-380.js)

#### 贪心算法
- [#860. Lemonade Change](./Leetcode-860-380.js)
- [#122. Best Time to Buy and Sell Stock II](./Leetcode-122-380.js)
- [#455. Assign Cookies](./Leetcode-455-380.js)
- [#874. Walking Robot Simulation](./Leetcode-874-380.js)
- [#55. Jump Game](./Leetcode-55-380.js)
- [#45. Jump Game II](./Leetcode-45-380.js)

#### 二分查找
- [#69. Sqrt(x)](./Leetcode-69-380.js)
- [#367. Valid Perfect Square](./Leetcode-367-380.js)
- [#33. Search in Rotated Sorted Array](./Leetcode-33-380.js)
- [#74. Search a 2D Matrix](./Leetcode-74-380.js)
- [随堂作业：二分查找找有序数组断点](./binary-search.js)

## 学习笔记

#### 分治、回溯的实现和特性

- 分治和回溯都是递归而已
- 分治（Divide & Conquer）：将一个大问题分成若干小问题，解决掉这些小问题，Merge回去，就解决了大问题
    ```javascript
    // 递归
    const recursion = (level, params) => {
    	// recursion terminator
    	if (level > MAX_LEVEL) {
    		process_result
    		return
    	}
    	// process current level
    	process(level, params)
    	// drill down
    	recursion(level + 1, params)
    	// clean current level status if needed	
    }
    
    // 分治
    const divide_conquer = (problem, params) => {
    	// recursion terminator
    	if (problem == null) {
    		process_result
    		return
    	} 
    	// process current problem
    	subproblems = split_problem(problem, data)
    	subresult1 = divide_conquer(subproblem[0], p1)
    	subresult2 = divide_conquer(subproblem[1], p1)
    	subresult3 = divide_conquer(subproblem[2], p1)
    	...
    	// merge
    	result = process_result(subresult1, subresult2, subresult3)
    	// revert the current level status
    }

#### 深度优先搜索 DFS

- 递归、栈来实现
    ```python
    def dfs(node):
    	if node in visited:
    		return
    	visited.add(node)
    	dfs(node.left)
    	dfs(node.right)

#### 广度优先搜索 BFS

- 队列实现
    ```python
    def bfs(graph, start, end):
      queue = []
      queue.append([start])
      visited.add(start)

      while queue:
        node = queue.pop()
        visited.add(node)
        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)

    // BFS
    const BFS = (root) => {
      if (!root) return []
      let result = [], queue = [root]
      while (queue.length > 0) {
        let level = [], n = queue.length
        for (let i = 0; i < n; i++) {
          let node = queue.pop()
          level.push(node.val) 
          if (node.left) queue.unshift(node.left)
          if (node.right) queue.unshift(node.right)
        }
        result.push(level)
      }
      return result
    };

#### 贪心算法

- 是一种在每一步选择中都采取在当前状态下最好或最优的选择，不能回退，从而希望导致结果是全局最好或最优的算法
- 解决一些最优问题，如：求图中的最小生成树、哈夫曼编码。然而对于工程和生活上的问题，贪心算法一般不能得到我们所要求的答案
- 那为什么还会有这个算法呢？因为一旦一个问题通过贪心算法来解决，那么贪心算法一般是解决这个问题的最好办法。由于贪心算法的高效性以及其所求得的答案比较接近最优结果。

#### 贪心算法、回溯算法、动态规划

- 贪心算法：只会当下做局部最优判断且不能回退
- 回溯算法：能够回退
- 动态规划：会保存之前的运算结果，根据以前的结果对当前进行选择，可以回退

#### 二分查找

- 使用二分查找的条件
    - 有序
    - 存在上下界
    - 能够通过索引访问
    ```python
    # 代码模版
    left, right = 0, len(array) - 1
    while left <= right:
      mid = (left + right) / 2
      if array[mid] == target:
        # find the target
        return
      elsif array[mid] < target:
        left = mid + 1
      else
        right = mid - 1

