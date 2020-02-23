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
    vector<vector<int>> levelOrder(Node* root) {
        if(!root)
            return {};
        //使用队列
        queue<Node*> que;
        vector<vector<int>> va;
        que.push(root);
        while (!que.empty()){
            vector<int> temp;
            //将现在队列中的元素出队，并把他的children入队
            for (int i=que.size();i>0;i--){//不能使用for(int i = 0; i<que.size();i++)这里que.size()在变化，如果在第二个条件处就会使结果出错。
                temp.push_back(que.front()->val);
                for(Node* it : que.front()->children){
                    que.push(it);
                }
                que.pop();
            }
            va.push_back(temp);
        }
        return va;
    }
};