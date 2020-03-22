/*
 * @lc app=leetcode.cn id=70 lang=cpp
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
public:
int climbStairs(int n) 
{
    if(n<=2) return n;
    int one_step=2;
    int two_step=1;
//one_step和two_step代表数组中的i-1项和i-2项
    int all_wags=0;
    for(int i=2;i<n;++i)
    {
        all_wags=one_step+two_step;
        two_step=one_step;
        one_step=all_wags;
    }
    return all_wags;
}
};
// @lc code=end

