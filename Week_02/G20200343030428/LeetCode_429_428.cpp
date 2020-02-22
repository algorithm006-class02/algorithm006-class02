//429. N叉树的层序遍历
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
private:
        vector<vector<int>> result;
        queue<Node*> m_queue;
public:
        void levelTraversal(queue<Node*> &queue, vector<int> &v) {
            // 打印当前队列queue内容 返回值v
            for(int i = queue.size(); i; i--)
            {
                // 打印当前队列
                auto curr = queue.front();
                queue.pop();
                v.push_back(curr->val);
                // 把当前队列的每一个有子集都放入队列尾部准备下次打印队列
                for(auto it : curr->children)
                    queue.push(it);
            }
        }
        // 入口函数
        vector<vector<int>> levelOrder(Node* root) {
            if(!root) return {};
            m_queue.push(root);
            
            // 遍历队列，打印队列内容
            while(!m_queue.empty())
            {
                vector<int> v;
                levelTraversal(m_queue,v);
                result.push_back(v);
            }
            return result;
        }
};