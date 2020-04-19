class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        vector<int> va;
        int res=0;
        for (int i=0;i<M.size();i++){
            va.push_back(i);
        }
        for (int i=0;i<M.size();i++){
            for(int j=0;j<M.size();j++){
                if(M[i][j]==1){
                    merge(i,j,va);
                }
            }
        }
        for (int i=0;i<M.size();i++){
            if(va[i]==i){
                res++;
            }
        }
        return res;
    }
    int find(int x,vector<int>& va){
        while(va[x]!=x){
            int temp =va[x];
            va[x]=va[temp];
            x=temp;
        }
        return va[x];
    }
    void merge(int x,int y,vector<int>& va){
        int a=find(x,va);
        int b=find(y,va);
        va[b]=a;
    }
};