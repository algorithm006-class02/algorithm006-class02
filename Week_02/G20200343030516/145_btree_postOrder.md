### 二叉树的后序遍历
给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1]


二叉树一些不错的题目讲解：
https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/

## solution
采用栈数据结构，参考前序遍历，后将结果反转
```python

class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:return[]
        stack1 = [root]
        ans = []
        while stack1:
            node = stack1.pop()
            ans.append(node.val)
            if node.left:
                stack1.append(node.left)
            if node.right:
                stack1.append(node.right)
        ans.reverse()
        return ans

```