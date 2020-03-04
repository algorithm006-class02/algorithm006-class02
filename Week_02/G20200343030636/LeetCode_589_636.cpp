/*
 * @lc app=leetcode.cn id=589 lang=cpp
 *
 * [589] N叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (71.92%)
 * Likes:    65
 * Dislikes: 0
 * Total Accepted:    17.8K
 * Total Submissions: 24.7K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
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
private :
    
public:
    /*
    解法一：递归，DFS遍历，每个节点遍历一次，复杂度为O(n)
    */
    vector<int> preorder(Node* root) {
        vector<int> vals;

        preorder(root ,vals) ;
        return vals ;
        
    }

    void preorder(Node* root,vector<int> &vals) {
        if ( root == nullptr ) return ;
        
        //先访问根
        vals.emplace_back(root->val);
        //逐个访问孩子节点
        for(auto one : root->children) {
            if ( one != nullptr ) {
                preorder(one,vals) ; //递归以one为root的子树
            }
        }
    }


    /*
    解法二：迭代，BFS遍历，借助栈，每个节点遍历一次，复杂度为O(n)，想套用二叉树迭代的模版，逻辑反而太啰嗦了
    76ms , 79.13%
    */
    vector<int> preorder(Node* root) {
        vector<int> vals;

        stack<Node*> s;     
        while(!s.empty() || root != nullptr) {
            if(root != nullptr) {
                vals.emplace_back(root->val) ;

                if (root->children.size() > 0) {
                    Node *p = root->children[0] ;
                    root->children.erase(root->children.begin()) ;//始终保持第一个节点是未访问的子节点
                    s.push(root) ;            //入栈
                    root = p ;
                }
                else {
                    root = nullptr ;
                }

                
            }
            else {
                root = s.top() ;  
                 
                if (root->children.size() > 0) {
                    Node *p = root->children[0] ;
                    root->children.erase(root->children.begin()) ;//始终保持第一个节点是未访问的子节点
                    root = p ;                    
                }
                else { //孩子全部遍历完毕才弹出根
                    root = nullptr ;
                    s.pop() ;
                }                
            }
        }

        return vals ;

    }  

    /*
    解法三：高赞答案，迭代，BFS遍历，上面迭代的写法太啰嗦
    60ms , 98.27%
    */
    vector<int> preorder(Node* root) {
        vector<int> result;
        if (root == nullptr) {
            return result;
        }
        
        stack<Node*> stk;
        stk.push(root);          //先让根入栈，会简单很多
        while (!stk.empty()) {
            Node* cur = stk.top();
            stk.pop();
            result.push_back(cur -> val);
            //后面的节点先入栈，则后出栈
            for (int i = cur -> children.size() - 1; i >= 0; i--) {
                if (cur -> children[i] != nullptr) {
                    stk.push(cur -> children[i]);
                }
            }
        }
        return result;
    }

};
// @lc code=end

