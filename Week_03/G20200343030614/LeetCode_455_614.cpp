//分发饼干，从胃口最小的孩子开始满足，贪心算法
class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        int res=0;
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        for (int i=0,j=0; i<g.size()&&j<s.size(); j++) {
            if (s[j]>=g[i]) {
                res++;
                i++;
            }
        }
        return res;
    }
};