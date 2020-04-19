// https://leetcode-cn.com/problems/relative-sort-array/

#include <vector>

using namespace std;

class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
      vector<int> bucket(1001, 0);
      for (int i : arr1) bucket[i]++; 
      vector<int> ans;
      for (int i : arr2) {
        while (bucket[i]) {
          ans.push_back(i);
          bucket[i]--;
        }
      }
      for (int i = 0; i <= 1000; ++i) {
        while (bucket[i]) {
          ans.push_back(i);
          bucket[i]--;
        }
      }
      return ans;
    }
};