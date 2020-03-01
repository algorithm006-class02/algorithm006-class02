#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>

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
    //recursion
    vector<int> postorder(Node* root) {
        if(root == NULL)
            return {};
        vector<int> res;
        post(root, res);
        return res;
    }
    void post(Node* root, vector<int>& res){
        if(root == NULL)
            return;
        for(auto node:root->children){
            post(node, res);
        }
        res.push_back(root->val);
    }

    //iterator
    vector<int> postorder(Node* root){
        if(root == NULL)
            return {};
        vector<int> res;
        stack<Node*> s;
        s.push(root);
        while(!s.empty()){
            Node *rt = s.top();
            s.pop();
            if(rt){
                res.push_back(rt->val);
                for(auto node:rt->children){
                    if(node){
                        s.push(node);
                    }
                }
            }
        }
        reverse(res.begin(), res.end());
        return res;
    }
};