## description

103. 二叉树的锯齿形层次遍历
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]

## solution

##
```python
class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        
        if not root: return []
        res = []
        stack = [root]
        needReverse = -1
        while stack:
            cur_level = []
            needReverse *=-1 
            for i in range(len(stack)):
                node = stack.pop(0)
                cur_level.append(node.val)
                if node.left:
                    stack.append(node.left)
                if node.right:
                    stack.append(node.right)
            if needReverse== -1:
                res.append(cur_level[::-1])
                continue
            res.append(cur_level)
        return res
```

使用deque的
front(), back();
push_front(), push_back();
pop_front(), pop_back().
前取后放，后取前放。

```c++
class Solution{
    public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root){
        vector<vector<int>> ans;
        if(!root)return ans;
        deque<TreeNode*> que;
        que.push_back(root);
        bool zigzag = true;
        while(!que.empty()) {
            int size = que.size();
            vector<int> tmp_vec;
            while (size){
                if(zigzag){
                    tmp = que.front();
                    que.pop_front();
                    if(tmp->left) que.push_back(tmp->left);
                    if(tmp->right)que.push_back(tmp->right);
                }else{
                    tmp = que.back();
                    que.pop_back();
                    if(tmp->right)que.push_back(tmp->right);
                    if(tmp->left) que.push_back(tmp->left);
                }
                tmp_vec.push_bcak(tmp->val);
                --size;
            }
            zigzag = !zigzag;
            ans.push_back(tmp_vec);
        }
        return ans;
    }     
}
```