//回溯+剪纸
class Solution {
public:
    vector<vector<int>> res;
    void comb(int n, int k, int begin, vector<int>& it) {
        if (it.size()==k) {
            res.push_back(it);
            return;
        }
        for (int i=begin; i<=n-(k-it.size())+1; i++) {
            it.push_back(i);
            comb(n, k, i+1, it);
            it.pop_back();
        }
    }
    vector<vector<int>> combine(int n, int k) {
        if (n<=0 || k<=0 || n<k) return res;
        vector<int> it;
        comb(n, k, 1, it);
        return res;
    }
};