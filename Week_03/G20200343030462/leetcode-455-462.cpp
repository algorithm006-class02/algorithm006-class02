class Solution {
public:
    //使用贪心算法求解，每次用一个能够满足孩子胃口的最小饼干
    int findContentChildren(vector<int>& g, vector<int>& s) {
        std::sort(g.begin(),g.end());
        std::sort(s.begin(),s.end());
        int gi = 0,si = 0,iCount = 0;
        while(gi < g.size() && si < s.size())
        {
            if(s[si] >= g[gi])
            {
                //说明gi这个孩子已经得到了满足
                ++iCount;
                ++gi;
                ++si;
            }
            else
            {
                //如果gi这个孩子没有被满足，那么就要在s中寻找能够满足gi这个孩子胃口的小饼干
                ++si;
            }
        }
        return iCount;
    }
};
