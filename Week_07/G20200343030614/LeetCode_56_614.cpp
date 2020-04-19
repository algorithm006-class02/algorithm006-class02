class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if (intervals.size() == 0 || intervals.size() == 1) return intervals;
        int u = 0, v = 0;
        vector<vector<int>> ans;
        std::sort(intervals.begin(), intervals.end());
        
        while (v < intervals.size()) { 
            if (intervals[v][0] > intervals[u][1]) {
                ans.emplace_back(intervals[u]);
                u = v;
            } else if (intervals[v][1] <= intervals[u][1]) {
                ++ v;
            } else {
                intervals[u][1] = intervals[v][1];
                ++ v;
            }
        }
        
        ans.emplace_back(intervals[u]);
        return ans;
    }
};