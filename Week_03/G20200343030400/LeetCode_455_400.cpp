//455
//https://leetcode-cn.com/problems/assign-cookies

class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int gId = 0, sId = 0, count = 0;
        while (gId < g.size() && sId < s.size()) {
            if (s[sId] >= g[gId]) {
                count++;
                sId++;
                gId++;
            } else {
                sId++;
            }
        }
        return count;
    }
};
