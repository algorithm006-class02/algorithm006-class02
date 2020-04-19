// https: //leetcode-cn.com/problems/merge-intervals/

#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
      if (intervals.size() <= 1) return intervals;
      sort(intervals.begin(), intervals.end());
      vector<vector<int>> ans;
      int i = 0, j = 0;
      while (i < intervals.size()) {
        if (intervals[i][0] > intervals[j][1]) {
          ans.push_back(intervals[j]);
          j = i;
        } else if (intervals[i][1] <= intervals[j][1]) {
          i++;
        } else {
          intervals[j][1] = intervals[i][1];
          i++;
        }
      }
      ans.push_back(intervals[j]);
      return ans;
    }
};