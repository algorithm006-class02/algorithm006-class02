#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if(intervals.size()<=1)
            return intervals;
        vector<vector<int> > res;  
        int pre = 0;
        int cur = 0;
        sort(intervals.begin(),intervals.end());
        while(cur<intervals.size()){
            if(intervals[cur][0]>intervals[pre][1]){
                res.push_back(intervals[pre]);
                pre = cur;
            }
            else if(intervals[cur][1]<=intervals[pre][1]){
                cur++;
            }
            else{
                intervals[pre][1] = intervals[cur][1];
                cur++;
            }
        }
        res.push_back(intervals[pre]);
        return res;
        
    }