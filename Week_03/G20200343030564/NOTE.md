学习笔记-Week03总结

本周学习：深度优先、广度优先、贪心算法、回溯思想、分治思想、二分查找

二分查找：二分查找针对的是一个有序的数据集合，查找思想有点类似分治思想。每次都通过跟区间的中间元素对比，将待查找的区间缩小为之前的一半，
直到找到要查找的元素，或者区间被缩小为0。

贪心算法：针对一组数据，我们定义了限制值和期望值，希望从中选出几个数据，在满足限制值的情况下，期望值最大。贪心算法是一种在每一步选择中
都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法选择，不能回退。

分治思想：分治算法（divide and conquer）的核心思想其实就是四个字，分而治之 ，也就是将原问题划分成 n 个规模较小，并且结构与原问题相似
的子问题，递归地解决这些子问题，然后再合并其结果，就得到原问题的解。

每一层递归都会涉及这样三个操作：
分解：将原问题分解成一系列子问题；
解决：递归地求解各个子问题，若子问题足够小，则直接求解；
合并：将子问题的结果合并成原问题。

回溯思想：回溯的处理思想，有点类似枚举搜索。我们枚举所有的解，找到满足期望的解。为了有规律地枚举所有可能的解，避免遗漏和重复，我们把问
题求解的过程分为多个阶段。每个阶段，我们都会面对一个岔路口，我们先随意选一条路走，当发现这条路走不通的时候（不符合期望的解），就回退到
上一个岔路口，另选一种走法继续走。

深度和广度优先：
广度优先搜索（Breadth-First-Search），我们平常都把简称为 BFS。直观地讲，它其实就是一种“地毯式”层层推进的搜索策略，即先查找离起始顶点
最近的，然后是次近的，依次往外搜索。

深度优先搜索（Depth-First-Search），简称 DFS。深度优先搜索用的是一种比较著名的算法思想，回溯思想。这种思想解决问题的过程，非常适合用
递归来实现。

模板：
## 1.循环

```java
int[] nums = {1,2,3,4,5,6,7,8,9};
for (int i = 0; i < nums.length - 1; i++) {
    for (int j = i + 1 ; j < nums.length; j++) {
        System.out.println("i=" + i +","+ "j=" +j);
    }
}
```

## 2.递归

```java
public void recur(int level, int param) { 

  // terminator (终止条件)
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  } 

  // process current logic (处理逻辑)
  process(level, param); 

  // drill down (到达下一层)
  recur( level: level + 1, newParam); 

  // restore current status(处理递归后的数据) 
 
}
```

## 3.深度优先

```java
    /**
     * 递归写法
     *
     * @param node    节点
     * @param visited 已经被访问的节点
     */
    public void dfs(Node node, Set<Node> visited) {
        // terminator
        if (visited.contains(node)) {
            // already visited
            return;
        }

        visited.add(node);

        // process current node here

        if (node.children != null) {
            for (Node nextNode : node.children) {
                if (visited.contains(nextNode)) {
                    dfs(nextNode, visited);
                }
            }
        }
    }
```

```java
   /**
     * 非递归写法
     * @param node    节点
     */
    public List<Node> dfs(Node root){
        ArrayList<Node> visited = new ArrayList<Node>();
        Stack<Node> stack = new Stack<Node>();

         // terminator
        if (root == null) {
            return visited;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            visited.add(node);

            // process current node here
            process(node);

            // 找出关联的Node
            List<Node> nodes = generate_related_node(node);

            if (nodes != null) {
                for (Node nextNode : nodes) {
                    stack.push(nextNode);
                }
            }
            
            // other processing work
        }
        
        return visited;
    }
```



## 4.广度优先

```java
   /**
     * 非递归
     *
     * @param root  节点
     */
    public List<Node> bfs(Node root) {
        Set<Node> visited = new HashSet<Node>();
        Queue<Node> queue = new LinkedList<Node>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited.add(node);

            // process current node here
            process(node);

            // 找出关联的Node
            List<Node> nodes = generate_related_node(node);

            if (nodes != null) {
                for (Node nextNode : nodes) {
                    queue.add(nextNode);
                }
            }

            // other processing work
        }
        
        return visited;
    }
```

## 5.分治模板

```python
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
  …

  # process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
	
  # revert the current level states
```

## 6.二分查找的模板

```java
public int search(int[] nums, int target) {
    int low = 0;
    int hight = nums.length - 1;

    while (low <= hight) {
        // 计算区间中间值
        int mid = low + ((hight - low) >> 1);
        if (nums[mid] > target) {
            hight = mid - 1;
        } else if(nums[mid] < target){
            low = mid + 1;
        }else {
            // 相等的情况
            return nums[mid];
        }
    }
    return -1;
}
```

思考题：
使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方？
思路：用二分查找找到中间位置，然后判断前半部有序还是后半部有序，然后在无序的一边，判断前一个，本身和后一个值是否是连续的，如果不是，
那这个中间值就是无序开始的位置，在这个过程中循环前面的二分查找。





