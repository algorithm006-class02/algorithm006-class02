/*
 * @lc app=leetcode.cn id=236 lang=cpp
 *
 * [236] 二叉树的最近公共祖先
 *
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (59.66%)
 * Likes:    374
 * Dislikes: 0
 * Total Accepted:    44.1K
 * Total Submissions: 73.8K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n1'
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x
 * 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    /*
    解法一：递归：最近公共祖先有可能有2种情况
    1:其中一个是另一个的子树节点，那么最近公共祖先就是其中的那个父节点；
    2:两个节点分属于某个节点的左右子树，那么最近公共祖先就是高度最低的这个根；
    16ms 96.04%
    */
   
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if ( root == nullptr || root == q || root == p ) return root ;

        TreeNode * left = nullptr , * right = nullptr ;
        if ( root -> left ) left = lowestCommonAncestor ( root->left ,p , q ) ;
        if ( root -> right ) right = lowestCommonAncestor ( root->right ,p , q ) ;

        // 属于情况2 ，在左右子树都找到了节点，那么root一定是最近的祖先
        if ( left && right ) return root ;
        //属于情况1，左右子树中有一个找到了2个节点，返回那个父节点即可
        return left == nullptr ? right : left ;
    }
    
   
    /*
    解法二：迭代的解法，用先序遍历方节点，存储每一个节点的父节点到hash中，
    从hash中构建从q开始到根到路径。然后在构建从p到根到路径时判断父节点or祖先节点是否已经在q到路径中，
    找到到第一个就是最近公共祖先；因为都是从节点到根到逆序查找
    28ms 39.29%
    */
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        unordered_map<TreeNode *, TreeNode* > hash ;
        queue<TreeNode *> qq;
        qq.push( root ) ;
        hash.emplace( root , nullptr ) ;
        //无需把整棵树遍历完，迭代停止条件是hash中已经包含p 和 q 即可。
        //while ( !q.empty() )
        while ( hash.find( p ) == hash.end() ||  hash.find(q) == hash.end() ) {
            TreeNode * cur = qq.front();
            qq.pop();
            if ( cur -> left != nullptr ) {
                hash.emplace( cur -> left , cur ) ;
                qq.push ( cur-> left ) ;
            }

            if ( cur -> right != nullptr ) {
                hash.emplace( cur -> right , cur ) ;
                qq.push ( cur-> right ) ;
            }            
        }

        unordered_set<TreeNode *> path_p ;
        while ( p != nullptr ) {
            path_p.emplace(p);
            p = hash[p] ;    //指向父节点，构建路径
        }

        while ( q != nullptr ) {
            if ( path_p.find(q) != path_p.end() )  
            {
                break;
            }
            q = hash[q] ;
        }

        return q ;


    }


};
// @lc code=end

