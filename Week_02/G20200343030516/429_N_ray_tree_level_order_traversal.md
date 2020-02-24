### 429. N-ary Tree Level Order Traversal

Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

## solution:
python 
tree的分层遍历：
考虑采用队列，每到一层讲该层的val, 加入到 current list，并且将下一层的children node enqueue.
```python
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        res = []
        queue = collections.deque([root])
        while queue:
            cur_res = []
            for i in range(len(queue)):
                node = queue.popleft()
                cur_res.append(node.val)
                for child in node.children:
                    queue.append(child)
            res.append(cur_res)
        return res
```

本题还可以采用 递归+dfs 解法，参考大神的cpp code
```cpp
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution{
    public :
    vector<vector<int>> result;
    
    void dfs(Node* root,dep){
        if(!root) return;
        if(dep == result.size()) result.emplace_back();
        result[dep].push_back(root->val);
        auto children = root->children;
        for(auto ele:children){
            dfs(ele,dep+1);
        }
    }
    vector<vector<int>> levelOrder(Node* root){
        dfs(root,0);
        return result;
    }

}

```

## 广度优先搜索
```python
def levelOrder(self,root:'node'):
    if root is None：return []
    res = []
    pre_level = [root]
    while pre_level:
        cur_level = []
        res.append([])
        for ele in pre_level:
            res[-1].append(ele.val)
            cur_level.extends(ele.children)
        pre_level = cur_level
    return res
```