### description

515. 在每个树行中找最大值
您需要在二叉树的每一行中找到最大的值。

示例：

输入: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

输出: [1, 3, 9]


### solution



```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
import math
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:return []
        frontier = [root]
        res = []
        cur_max = root.val
        while frontier:
            for i in range(len(frontier)):
                node = frontier.pop(0)
                if node.val > cur_max:
                    cur_max = node.val
                if node.left:
                    frontier.append(node.left)
                if node.right:
                    frontier.append(node.right)
            res.append(cur_max)
            cur_max = - math.inf
        return res 
```


#### c++ dfs solution

```c++
class Solution{
    public :
    void inorder(TreeNode * node, int depth,vector<long long> &result){
        if(!node){
            return;
        }
        // every level will have a result
        result[deptth] = max(result,depth,node.val);
        inoder(node->left,depth+1,result);
        inoder(node->right,depth+1,result);
    }

    vector<int> largestValues(TreeNode* root){
        vector<long long> result(1000,LONG_MIN);
        ioorder(root,0,result);
        vector<int> res;
        for(auto num:result){
            if(num == LONG_MIN){
                break;
            }
            res.push(num);
        }
        return res;
    }
}

```

