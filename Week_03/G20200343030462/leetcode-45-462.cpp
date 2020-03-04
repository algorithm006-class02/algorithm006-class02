class Solution {
public:
    int jump(vector<int>& nums) {
        if(nums.empty())
            return 0;
        int iAns = 0;   //原地跳不算次数，另外题目说明里讲了一定可以到达最后一个位置
        int iEnd = 0;
        int iMaxPos = 0;    //当前能够到达的最大位置，初始位置就是0这个位置
        for(int i = 0; i < nums.size() - 1; ++i)
        {
            iMaxPos = (nums[i] + i) > iMaxPos ? (nums[i] + i) : iMaxPos; //更新你在此次迭代中所能到达的最大位置（贪心的一个最优解），因为你每次跳跃，要么跳到相邻格子上，要么以当前格子为出发点跳到能跳到的最大位置，如果当前格子的数值是0，那么久没办法继续往前跳了
            if(i == iEnd)
            {
                iEnd = iMaxPos;
                ++iAns;     //在已知一定可以到达终点的情况下，每一次都跳最大的格子数，每次都按照最大的进行跳跃
            }
        }
        return iAns;
    }
};
