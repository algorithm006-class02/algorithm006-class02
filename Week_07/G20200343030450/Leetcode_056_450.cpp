class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if(intervals.size()<=1)
            return intervals;
        sort(intervals.begin(), intervals.end());
        vector<vector<int>> ans;
        int left = intervals[0][0], right = intervals[0][1];
        for(int i=1;i<intervals.size();i++){
            if(intervals[i][0]<=right){
                right = max(intervals[i][1], right);
            }
            else{
                ans.push_back({left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        ans.push_back({left, right});
        return ans;
    }
};