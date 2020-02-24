/*
 * @lc app=leetcode.cn id=429 lang=cpp
 *
 * [429] N叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (64.44%)
 * Likes:    68
 * Dislikes: 0
 * Total Accepted:    14.1K
 * Total Submissions: 21.8K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]\r'
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其层序遍历:
 * 
 * [
 * ⁠    [1],
 * ⁠    [3,2,4],
 * ⁠    [5,6]
 * ]
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * 
 */

// @lc code=start
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
class Solution {
public:
    /*
    解法一：用队列解决,每个节点只访问一遍，时间复杂度O(n)，借助了队列，空间复杂度O(n)
    72ms 85.36%
    */
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> result ;

        if ( root == nullptr ) return result ;

        queue<Node *> q ;
        q.push( root ) ;
        
        while(!q.empty()) {
            int num = q.size();
            vector<int> one ;
            while( num > 0 ) {
                Node * root = q.front() ;
                q.pop() ;
                one.emplace_back( root -> val ) ;
                for(auto child : root->children ) {
                    if ( child != nullptr ) {
                        q.push( child ) ;
                    }
                }

                -- num ;
            }
            result . emplace_back( one ) ;

        }

        return result ;
    }

    /*
    解法二：用递归解决，判断当前处于那一层，填充该层的数据，每个节点访问一遍，复杂度O(n)
    86ms 66.34%
    */
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> result ;

        levelOrder ( root , 1 , result ) ;

        return result ;
    }

    void levelOrder(Node *root,int level , vector<vector<int>> & result) {
        if ( root == nullptr) return ;

        if ( result.size() < level ) {
            vector<int> one( { root -> val } );
            result.emplace_back( one ) ;
        }
        else {
            result[level - 1].emplace_back( root -> val ) ;
        }

        for(auto child : root->children ) {
            if ( child != nullptr ) {
                levelOrder ( child , level + 1 , result ) ;
            }
        }

    }


};
// @lc code=end

