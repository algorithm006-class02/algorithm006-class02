### 589. N-ary Tree Preorder Traversal

Given an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

## solution

采用iter solution
```python
    def preorder(self, root: 'Node') -> List[int]:
        if not root:
            return []
        stack = [root]
        res = []
        while stack:
            cur = stack.pop()
            for child in cur.children[::-1]:
                stack.append(child)
            res.append(cur.val)
        return res 
```
recursion 
```python
    def preorder(self, root: 'Node') -> List[int]:
        res = []
        def helper(res,root):
            if not root:return
            res.append(root.val)
            for child in root.children:
                helper(res,child)
        helper(res,root)
        return res
```

附带学习一下 java 语法：
```java
public List<Interger> preoder(order root){
    LinkedList<Node> stack  = new LinkedList<>();
    LinkedList<Interger> output  = new LinkedList<>();
    if(root == null ){
        return output;
    }
    stack.add(root);
    while(!stack.isEmpty()){
        Node node = stack.pollLast();
        output.add(node.val);
        Collection.reverse(node.children);
        for(Node item: node.children){
            stack.add(item);
        }
    }
    return output;
}

```

 