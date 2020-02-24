/*
 * @lc app=leetcode.cn id=590 lang=cpp
 *
 * [590] N叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (72.01%)
 * Likes:    50
 * Dislikes: 0
 * Total Accepted:    15.5K
 * Total Submissions: 21.5K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]\r'
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其后序遍历: [5,6,3,2,4,1].
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
public:
    /*
    解法一：递归，DFS遍历，每个节点遍历一次，复杂度为O(n)
    64ms 66.34%
    */
    vector<int> postorder(Node* root) {
        vector<int> vals;

        postorder(root ,vals) ;
        return vals ;       
    }

    void postorder(Node* root,vector<int> &vals) {
        if ( root == nullptr ) return ;
        
        //逐个访问孩子节点
        for(auto one : root->children) {
            if ( one != nullptr ) {
                postorder(one,vals) ; //递归以one为root的子树
            }
        }

        //最后访问根
        vals.emplace_back(root->val);
    }
    /*
    解法二：迭代，BFS遍历，借助栈，每个节点遍历一次，复杂度为O(n)
    76 ms 79.3%
    */  
    vector<int> postorder(Node* root) {
      vector<int> vals;

        stack<Node*> s;     
        while(!s.empty() || root != nullptr) {
            if(root != nullptr) {
                vals.insert(vals.begin(),root->val) ;

                if (root->children.size() > 0) {
                    Node *p = root->children.back() ;
                    root->children.erase(--root->children.end()) ;//始终保持最后一个节点是未访问的子节点
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
                    Node *p = root->children.back() ;
                    root->children.erase(--root->children.end()) ;//始终保持最后一个节点是未访问的子节点
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
    76 ms 79.3%
    */  
    vector<int> postorder(Node* root) {
        vector<int> result;
        if (root == nullptr) {
            return result;
        }
        
        stack<Node*> stk;
        stk.push(root);          //先让根入栈，会简单很多
        while (!stk.empty()) {
            Node* cur = stk.top();
            stk.pop();
            //始终在头部增加数据，这样根会在序列的最后
            result.insert(result.begin() , cur -> val);
            //前面的节点先入栈，则后出栈，因为数据值是往头部插入的。所以和先序不同，子节点从0开始入栈。
            for (int i = 0 ; i < cur -> children.size() ; i++) {
                if (cur -> children[i] != nullptr) {
                    stk.push(cur -> children[i]);
                }
            }
        }
        return result;       
    }      
      
};
// @lc code=end

