/*
 * @lc app=leetcode.cn id=56 lang=cpp
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if (!intervals.size()) return {};
        sort(intervals.begin(), intervals.end(), less<vector<int>>());
        int pos = 0;
        for (int i = 1; i < intervals.size(); ++i) {
            if (intervals[pos][1] >= intervals[i][0]) {
                intervals[pos][1] = max(intervals[pos][1], intervals[i][1]);
            } else {
                intervals[++pos] = intervals[i];
            }
        }
        intervals.resize(pos+1);
        return intervals;
    }
};

// @lc code=end

