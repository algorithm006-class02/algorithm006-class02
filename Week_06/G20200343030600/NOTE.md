### 学习笔记
#### 代码模板总结

**前序遍历 pre-order**
```java
public void pre_order(root) { 
    // terminator 
    if (root == null) { 
      // process result 
      return; 
    } 

    // process current logic 
    _process(root); 

    // drill down 
    pre_order(root.left);
    pre_order(root.right);
    // restore current status 
}
```
**中序遍历 in-order**
```java
public void in_order(root) {
    //terminator
    if(root == null) return;

    //process
    //drill down
    in_order(root.left);
    _process(root);
    in_order(root.right);

    //reverse state
}
```
**后序遍历 post-order**
```java
public void post_order(root) {
    //terminator
    if(root == null) return;
    
    //drill down
    post_order(root.left);
    post_order(root.right);

    //process
    _process(root);

    //reverse state
}
```
**深度优先遍历 dfs**
```java
//DFS with recursion
public void dfs(node) {
    //terminator
    if(visited.contains(node)) return;

    //process
    _process(node);
    visited.add(node);

    //drill down
    dfs(node.left);
    dfs(node.right);

    //reverse state
}
```
```java
//DFS with loop & stack
public void dfs(node) {
    Stack stack = new Stack();
    stack.push(node);

    while(!stack.isEmpty()) {
        Node n = stack.pop();
        visited.add(n);

        _process(n);

        List<Node> children = _getChildren(n);
        stack.push(children);
    }
}
```
**广度优先遍历 bfs**
```java
//BFS with loop & queue
public void bfs(node) {
    Queue queue = new Queue();
    queue.add(node);

    while(!queue.isEmpty()) {
        Node n = queue.remove();
        visited.add(n);

        _process(n);

        List<Node> children = _getChildren(n);
        queue.addAll(children);
    }
}
```
**二分查找**
```java
//binary search
public int bs(int[] arr, int target) {
    Arrays.sort(arr);
    
    int left = 0;
    int right = arr.length - 1;
    while(left <= right) {
        int mid = left + (right - left) / 2;
        if(arr[mid] == target) {
            return mid;
        } else if(arr[mid] < target) {
            //should be in right area
            left = mid + 1;
        } else {
            //should be in left area
            right = mid - 1;
        }
    }
    return -1
}
```
