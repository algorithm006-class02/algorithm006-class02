class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if(intervals.empty())
            return {};
        
        sort(intervals.begin(),intervals.end(),[&](vector<int> &first,vector<int> &second){
            return first.front() < second.front();     //升序排序
        });
        
        std::vector<std::vector<int>> ans;
        for(int i = 0; i < intervals.size(); ++i)
        {
            auto tmp = intervals[i];
            while(i + 1 < intervals.size() && intervals[i + 1].front() <= tmp.back())
            {
                ++i;
                tmp.back() = max(intervals[i].back(),tmp.back());
            }
            ans.push_back(tmp);
        }
        return ans;
    }
};
