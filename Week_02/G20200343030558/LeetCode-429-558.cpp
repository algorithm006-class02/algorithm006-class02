#include<iostream>
#include<vector>
#include<queue>

using namespace std;

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

class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        //use queue
        if(root == NULL)
            return {};
        vector<vector<int>> res;
        queue<Node*> q;
        q.push(root);
        Node* cur = NULL; //if define in the circle,may spend much time
        while(!q.empty()){
            vector<int> value;
            int n = q.size();
            for(int i=0;i<n;i++){
                cur = q.front();
                value.push_back(cur->val);
                q.pop();
                for(auto node:cur->children){
                        q.push(node);
                }
                
            }
            res.push_back(value);
        }
        return res;
    }
};