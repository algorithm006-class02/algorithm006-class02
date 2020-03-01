class Solution {
public:
    vector<int> postorder(Node* root) 
    {
        vector<int> ans;
        if(root==NULL) return ans;
        stack<Node*> s;
        s.push(root);
        Node* temp=NULL;
        int k=0;
        while(!s.empty())
        {
            temp=s.top();
            s.pop();
            ans.push_back(temp->val);
            k=temp->children.size();
            for(int i=0;i<k;i++)
            {
                s.push(temp->children[i]);
            }
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};